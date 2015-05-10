package com.sp.fanikiwa.api;

import static com.sp.fanikiwa.api.OfyService.ofy;

import com.sp.fanikiwa.business.WithdrawalComponent;
import com.sp.fanikiwa.entity.Account;
import com.sp.fanikiwa.Enums.AccountLimitStatus;
import com.sp.fanikiwa.Enums.PostingCheckFlag;
import com.sp.fanikiwa.entity.BatchSimulateStatus;
import com.sp.fanikiwa.entity.DoubleEntry;
import com.sp.fanikiwa.entity.MultiEntry;
import com.sp.fanikiwa.Enums.PassFlag;
import com.sp.fanikiwa.entity.Member;
import com.sp.fanikiwa.entity.RequestResult;
import com.sp.fanikiwa.entity.STO;
import com.sp.fanikiwa.entity.SimulatePostStatus;
import com.sp.fanikiwa.entity.StatementModel;
import com.sp.fanikiwa.entity.Transaction;
import com.sp.fanikiwa.entity.TransactionType;
import com.sp.fanikiwa.entity.ValueDatedTransaction;
import com.sp.utils.Config;
import com.sp.utils.DateExtension;
import com.sp.utils.GLUtil;
import com.sp.utils.Utils;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Nullable;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.api.server.spi.response.ConflictException;
import com.google.api.server.spi.response.NotFoundException;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.api.datastore.QueryResultIterator;
import com.googlecode.objectify.VoidWork;
import com.googlecode.objectify.Work;
import com.googlecode.objectify.cmd.Query;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

import javax.inject.Named;

@Api(name = "accountendpoint", namespace = @ApiNamespace(ownerDomain = "sp.com", ownerName = "sp.com", packagePath = "fanikiwa.entity"))
public class AccountEndpoint {

	final int GAE_TRANSACTION_LIMIT = 5;

	/**
	 * This method lists all the entities inserted in datastore. It uses HTTP
	 * GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 *         persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listAccount")
	public CollectionResponse<Account> listAccount(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("count") Integer count) {

		Query<Account> query = ofy().load().type(Account.class);
		return listAccountByQuery(query, cursorString, count);
	}

	private CollectionResponse<Account> listAccountByQuery(
			Query<Account> query,
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("count") Integer count) {
		if (count != null)
			query.limit(count);
		if (cursorString != null && cursorString != "") {
			query = query.startAt(Cursor.fromWebSafeString(cursorString));
		}

		List<Account> records = new ArrayList<Account>();
		QueryResultIterator<Account> iterator = query.iterator();
		int num = 0;
		while (iterator.hasNext()) {
			records.add(iterator.next());
			if (count != null) {
				num++;
				if (num == count)
					break;
			}
		}

		// Find the next cursor
		if (cursorString != null && cursorString != "") {
			Cursor cursor = iterator.getCursor();
			if (cursor != null) {
				cursorString = cursor.toWebSafeString();
			}
		}
		return CollectionResponse.<Account> builder().setItems(records)
				.setNextPageToken(cursorString).build();
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET
	 * method.
	 *
	 * @param id
	 *            the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getAccount")
	public Account getAccount(@Named("id") Long id) {
		return findRecord(id);
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity
	 * already exists in the datastore, an exception is thrown. It uses HTTP
	 * POST method.
	 *
	 * @param Account
	 *            the entity to be inserted.
	 * @return The inserted entity.
	 * @throws ConflictException
	 */
	@ApiMethod(name = "insertAccount")
	public Account insertAccount(Account Account) throws ConflictException {
		if (Account.getAccountID() != null) {
			if (findRecord(Account.getAccountID()) != null) {
				throw new ConflictException("Object already exists");
			}
		}
		ofy().save().entities(Account).now();
		return Account;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does
	 * not exist in the datastore, an exception is thrown. It uses HTTP PUT
	 * method.
	 *
	 * @param Account
	 *            the entity to be updated.
	 * @return The updated entity.
	 * @throws NotFoundException
	 */
	@ApiMethod(name = "updateAccount")
	public Account updateAccount(Account Account) throws NotFoundException {
		Account record = findRecord(Account.getAccountID());
		if (record == null) {
			throw new NotFoundException("Record does not exist");
		}
		ofy().save().entities(Account).now();
		return Account;
	}

	/**
	 * This method removes the entity with primary key id. It uses HTTP DELETE
	 * method.
	 *
	 * @param id
	 *            the primary key of the entity to be deleted.
	 * @throws NotFoundException
	 */
	@ApiMethod(name = "removeAccount")
	public void removeAccount(@Named("id") Long id) throws NotFoundException {
		Account record = findRecord(id);
		if (record == null) {
			throw new NotFoundException("Record does not exist");
		}
		ofy().delete().entity(record).now();
	}

	private Account findRecord(Long id) {
		return ofy().load().type(Account.class).id(id).now();
	}

	@ApiMethod(name = "BlockFunds")
	public void BlockFunds(Account account, @Named("blockamount") double amount)
			throws NotFoundException {
		Account acc = findRecord(account.getAccountID());
		this.MarkLimit(acc, amount);
	}

	@ApiMethod(name = "ClearEffects")
	public void ClearEffects(Account account, @Named("amount") double amount)
			throws NotFoundException {
		Account acc = findRecord(account.getAccountID());
		acc.setClearedBalance(account.getClearedBalance() + amount);
		this.updateAccount(acc);
	}

	public void ClearDaysEffects(@Named("date") Date date)
			throws NotFoundException {

		for (ValueDatedTransaction txn : GetValueDatedTransactionByDate(date)) {
			ClearEffects(txn.getAccount(), txn.getAmount());
		}
	}

	private Collection<ValueDatedTransaction> GetValueDatedTransactionByDate(
			Date date) {
		ValueDatedTransactionEndpoint vDac = new ValueDatedTransactionEndpoint();
		return vDac.SelectByValueDate(date);
	}

	@ApiMethod(name = "CloseAccount")
	public RequestResult CloseAccount(@Named("id") Long id) {
		RequestResult re = new RequestResult();
		re.setResult(true);
		re.setResultMessage("Success");

		try {

			Account acc = findRecord(id);

			if (acc.getClearedBalance() > 0) {
				re.setResultMessage("Cannot close an Account with a balance."
						+ "<br/>BookBalance = " + acc.getBookBalance()
						+ "<br/>ClearedBalance = " + acc.getClearedBalance()
						+ "<br/>Limit = " + acc.getLimit());
			}
			acc.setClosed(true);
			this.updateAccount(acc);

		} catch (Exception e) {
			e.printStackTrace();
			re.setResult(false);
			re.setResultMessage(e.getMessage().toString());
		}
		return re;
	}

	@ApiMethod(name = "SetAccountLimitStatus")
	public void SetAccountLimitStatus(Account account,
			@Named("status") AccountLimitStatus status)
			throws NotFoundException {
		Account acc = findRecord(account.getAccountID());
		acc.setLimitFlag(status.name());
		this.updateAccount(acc);
	}

	@ApiMethod(name = "SetAccountLockStatus")
	public void SetAccountLockStatus(Account account,
			@Named("status") PassFlag status) throws NotFoundException {
		Account acc = findRecord(account.getAccountID());
		acc.setPassFlag(status.name());
		this.updateAccount(acc);
	}

	@ApiMethod(name = "NextIntAccrualAccountsByDate")
	public CollectionResponse<Account> NextIntAccrualAccountsByDate(
			@Named("date") Date date) {
		Query<Account> query = ofy().load().type(Account.class)
				.filter("nextIntAccrualDate", date);
		return listAccountByQuery(query, null, null);
	}

	@ApiMethod(name = "NextIntAppAccountsByDate")
	public CollectionResponse<Account> NextIntAppAccountsByDate(
			@Named("date") Date date) {
		Query<Account> query = ofy().load().type(Account.class)
				.filter("nextIntAppDate", date);
		return listAccountByQuery(query, null, null);
	}

	@ApiMethod(name = "UnBlockFunds")
	public void UnBlockFunds(Account account, @Named("amount") double amount)
			throws NotFoundException {
		Account acc = findRecord(account.getAccountID());
		this.MarkLimit(acc, amount * -1);
	}

	@ApiMethod(name = "SimulatePost")
	public void SimulatePost(final MultiEntry multiEntry,
			@Named("flags") final PostingCheckFlag flags) {
		ofy().transact(new VoidWork() {
			public void vrun() {
				Simulate(multiEntry, flags);
			}
		});
	}

	@ApiMethod(name = "BatchPost")
	public RequestResult BatchPost(final MultiEntry multiEntry,
			@Named("flags") final PostingCheckFlag flags) {
		List<List<Transaction>> choppedtxns = Utils.chopped(
				multiEntry.getTransactions(), GAE_TRANSACTION_LIMIT);

		RequestResult res2 = new RequestResult();
		for (final List<Transaction> txns : choppedtxns) {

			res2 = ofy().transact(new Work<RequestResult>() {
				public RequestResult run() {
					RequestResult res = new RequestResult();
					res.setResultMessage("Successful");
					for (Transaction transaction : txns) {
						res = Post(transaction, flags);
						if (!res.isResult())
							return res; // get out if you ever get a false
										// situation
					}

					return res;
				}
			});
			if (!res2.isResult())
				return res2; // get out if you ever get a false situation
		}

		return res2;
	}

	@ApiMethod(name = "DoubleEntryPost")
	public RequestResult DoubleEntryPost(final DoubleEntry doubleEntry,
			@Named("flags") final PostingCheckFlag flags) {
		RequestResult res2 = new RequestResult();
		res2 = ofy().transact(new Work<RequestResult>() {
			public RequestResult run() {

				RequestResult res = new RequestResult();
				res.setResultMessage("Successful");
				res.setResult(true);

				res = Post(doubleEntry.getDr(), flags);
				if (!res.isResult())
					return res;
				res = Post(doubleEntry.getCr(), flags);
				if (!res.isResult())
					return res;

				return res;
			}
		});
		return res2;
	}

	@ApiMethod(name = "Post")
	public RequestResult Post(final Transaction transaction,
			@Named("flags") final PostingCheckFlag flags) {
		RequestResult res = ofy().transact(new Work<RequestResult>() {
			public RequestResult run() {
				RequestResult res = new RequestResult();
				res.setResultMessage("Successful");
				try {
					postAtomic(transaction, flags);
					res.setResult(true);
					return res;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					res.setResultMessage(e.getStackTrace().toString());
					res.setResult(false);
					return res;
				}
			}
		});

		return res;
	}

	@ApiMethod(name = "miniStatement")
	public CollectionResponse<StatementModel> GetMiniStatement(
			@Named("accountID") Long accountID,
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("count") Integer count) {

		TransactionEndpoint tep = new TransactionEndpoint();
		List<StatementModel> records = new ArrayList<StatementModel>();

		Account account = findRecord(accountID);
		CollectionResponse<Transaction> txnCB = tep.GetMiniStatement(accountID,
				cursorString, count);

		// go through the transactins and compute running balance

		StatementModel first = new StatementModel();
		first.setPostDate(new Date());
		first.setTransactionID(-1L);
		first.setNarrative("BALANCE B/F");
		double amt = account.getBookBalance();
		double bal = 0;
		if (amt > 0) {
			first.setCredit(amt);
			first.setDebit(0);
			bal = amt;
		} else {
			first.setCredit(0);
			first.setDebit(amt);
			bal = amt;
		}
		first.setBalance(bal);

		records.add(first);

		for (Transaction txn : txnCB.getItems()) {
			StatementModel txnv = new StatementModel();
			txnv.setPostDate(txn.getPostDate());
			txnv.setTransactionID(txn.getTransactionID());
			txnv.setNarrative(txn.getNarrative());
			txnv.setAmount(txn.getAmount());
			txnv.setContraReference(txn.getContraReference());

			if (txn.getAmount() > 0) {
				txnv.setCredit(txn.getAmount());
				txnv.setDebit(0);
			} else {
				txnv.setCredit(0);
				txnv.setDebit(txn.getAmount());
			}

			bal -= txn.getAmount();
			txnv.setBalance(bal);

			// add to viewxn
			records.add(txnv);

		}

		return CollectionResponse.<StatementModel> builder().setItems(records)
				.setNextPageToken(txnCB.getNextPageToken()).build();
	}

	@ApiMethod(name = "statement")
	public CollectionResponse<StatementModel> GetStatement(
			@Named("accountID") Long accountID,
			@Nullable @Named("sdate") Date sdate,
			@Nullable @Named("edate") Date edate,
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("count") Integer count) {

		int months = Config.GetInt("STATEMENTMONTHS", 2);
		if (sdate == null) {
			sdate = new Date();
		}
		if (edate == null) {
			edate = DateExtension.addMonths(sdate, (months * -1));
		}

		TransactionEndpoint tep = new TransactionEndpoint();
		List<StatementModel> records = new ArrayList<StatementModel>();

		Account account = findRecord(accountID);
		CollectionResponse<Transaction> txnCB = tep.GetStatement(sdate, edate,
				account, cursorString, count);

		StatementModel first = new StatementModel();
		first.setPostDate(sdate);
		first.setTransactionID(-1L);
		first.setNarrative("BALANCE B/F");

		double amount = SumTransactionsBeforeDate(tep
				.GetTransactionsBeforeDate(sdate, account, cursorString, count)
				.getItems());
		if (amount > 0) {
			first.setCredit(amount);
			first.setDebit(0);
		} else {
			first.setCredit(0);
			first.setDebit(amount);
		}
		first.setBalance(amount);

		// add to view
		records.add(first);

		// go through the transactins and compute running balance
		double bal = amount;
		for (Transaction txn : txnCB.getItems()) {
			StatementModel txnv = new StatementModel();
			txnv.setPostDate(txn.getPostDate());
			txnv.setTransactionID(txn.getTransactionID());
			txnv.setNarrative(txn.getNarrative());
			txnv.setAmount(txn.getAmount());
			txnv.setContraReference(txn.getContraReference());

			if (txn.getAmount() > 0) {
				txnv.setCredit(txn.getAmount());
				txnv.setDebit(0);
			} else {
				txnv.setCredit(0);
				txnv.setDebit(txn.getAmount());
			}

			bal += txn.getAmount();
			txnv.setBalance(bal);

			// add to viewxn
			records.add(txnv);

		}

		return CollectionResponse.<StatementModel> builder().setItems(records)
				.setNextPageToken(txnCB.getNextPageToken()).build();
	}

	private double SumTransactionsBeforeDate(Collection<Transaction> collection) {
		double total = 0;
		for (Transaction t : collection) {
			total += t.getAmount();
		}
		return total;
	}

	public BatchSimulateStatus Simulate(final MultiEntry multiEntry,
			@Named("flags") PostingCheckFlag flags) {
		List<SimulatePostStatus> SimulateStatus = new ArrayList<SimulatePostStatus>();
		for (Transaction tx : multiEntry.getTransactions()) {
			SimulateStatus.add(ValidatePost(tx.getAccount(), tx, flags));
		}

		return new BatchSimulateStatus(SimulateStatus);

	}

	private void postAtomic(Transaction transaction) throws Exception {
		postAtomic(transaction, PostingCheckFlag.CheckLimitAndPassFlag);
	}

	private void postAtomic(Transaction transaction, PostingCheckFlag checkflags)
			throws Exception {

		Account account = transaction.getAccount();
		// Step 1: Validate
		SimulatePostStatus status = ValidatePost(account, transaction,
				checkflags);
		if (!status.isCanPost()) {
			String msg = "";
			for (Exception e : status.Errors) {
				msg += e.getMessage() + "\n";
			}
			throw new Exception("Simulation Error \n" + msg);
		}

		// Step 2 - Insert new transaction.
		// /TODO Confirm this is legal/best practice
		TransactionEndpoint txn = new TransactionEndpoint();
		txn.insertTransaction(transaction);

		// Step 3 - Update balance and value date.
		// On Before Book Balance Changed
		account.setBookBalance(account.getBookBalance()
				+ transaction.getAmount());

		// If postdate == valuedate clear the funds immediately
		if (transaction.getValueDate() == transaction.getPostDate()) {
			// On Before Cleared Balance Changed
			// StaticPostingComponent.ClearEffects(Account account, decimal
			// amount)
			account.setClearedBalance(account.getClearedBalance()
					+ transaction.getAmount());
		} else if (transaction.getValueDate().after(transaction.getPostDate())) {
			// this is a value dated transaction,
			// enter a valuedated diary record if a diary

			ValueDatedTransaction vt = new ValueDatedTransaction();
			vt.setAccount(transaction.getAccount());
			vt.setAmount(transaction.getAmount());
			vt.setAuthorizer(transaction.getAuthorizer());
			vt.setForcePostFlag(transaction.getForcePostFlag());
			vt.setNarrative(transaction.getNarrative());
			vt.setPostDate(transaction.getPostDate());
			vt.setRecordDate(transaction.getRecordDate());
			vt.setStatementFlag(transaction.getStatementFlag());
			vt.setTransactionID(transaction.getTransactionID());
			vt.setTransactionType(transaction.getTransactionType());
			vt.setUserID(transaction.getUserID());
			vt.setValueDate(transaction.getValueDate());

			// persist vt
			ValueDatedTransactionEndpoint vtxn = new ValueDatedTransactionEndpoint();
			vtxn.insertValueDatedTransaction(vt);
		} else {
			throw new NotFoundException(
					"Back dated transaction posting not supported");
		}

		// Step 4 - Persist.
		updateAccount(account);

	}

	private SimulatePostStatus ValidatePost(Account account,
			Transaction transaction, PostingCheckFlag limitCheck) {
		SimulatePostStatus result = new SimulatePostStatus();

		if (transaction == null) {
			result.Errors.add(new NotFoundException("transaction is null"));
			return result;
		}
		// Step 1 - See if we can post into this account by looking at lock and
		// limit flags.
		double AmountAvailableOnUncleared = account.getBookBalance()
				- account.getLimit();
		double AmountAvailableAfterTxn = account.getClearedBalance()
				+ transaction.getAmount();

		// get account status
		AccountLimitStatus limistatus = AccountLimitStatus.valueOf(account
				.getLimitFlag());

		// transaction type
		TransactionType _TransactionType = transaction.getTransactionType();

		// populate status object
		result.AccountID = account.getAccountID();
		result.BlockedStatus = PassFlag.valueOf(account.getPassFlag());
		result.BookBalanceBeforePosting = account.getBookBalance();
		result.ClearedBalanceBeforePosting = account.getClearedBalance();
		result.Limit = account.getLimit();
		result.LimitStatus = AccountLimitStatus.valueOf(account.getLimitFlag());
		result.TransactionAmount = transaction.getAmount();
		result.TransactionTypeId = transaction.getTransactionType()
				.getTransactionTypeID();

		// start checking
		if (account.getClosed()) {
			result.Errors.add(new NotFoundException("Account closed"));
			return result;
		}

		// Do account status tests only if the transaction is not a force post
		if (transaction.getForcePostFlag()
				|| limitCheck == PostingCheckFlag.ForcePost)
			return result;

		PassFlag lockstatus = PassFlag.valueOf(account.getPassFlag());
		switch (limitCheck) {
		case CheckPassFlagOnly:// does not check limit but checks PassFlag
			if (!CheckPassFlag(lockstatus, account, _TransactionType)) {
				result.Errors
						.add(new IllegalArgumentException(
								MessageFormat
										.format("Account [{0}] posting prohibited.\nAccount lock status =[{2}]",
												account.getAccountID(),
												_TransactionType
														.getTransactionTypeID(),
												lockstatus.toString())));
			}
			return result;

		case CheckLimitFlagOnly:// Checks account limit status and not PassFlag
			if (!CheckLimitFlag(limistatus, AmountAvailableAfterTxn,
					AmountAvailableOnUncleared)) {

				result.Errors
						.add(new IllegalArgumentException(
								MessageFormat
										.format("Account [{0}] overdraw prohibited, limit status =[{2}]",
												account.getAccountID(),
												_TransactionType
														.getTransactionTypeID(),
												limistatus.toString()// Enum.GetName(typeof(AccountStatus),
																		// limistatus))
										)));
			}
			return result;

		case CheckLimitAndPassFlag:// Checks account limit status and PassFlag
			if (!CheckPassFlag(lockstatus, account, _TransactionType)) {
				result.Errors
						.add(new IllegalArgumentException(
								MessageFormat
										.format("Account [{0}] posting prohibited.\nAccount lock status =[{2}]",
												account.getAccountID(),
												_TransactionType
														.getTransactionTypeID(),
												lockstatus.toString())));
			}

			if (!CheckLimitFlag(limistatus, AmountAvailableAfterTxn,
					AmountAvailableOnUncleared)) {

				result.Errors
						.add(new IllegalArgumentException(
								MessageFormat
										.format("Account [{0}] overdraw prohibited, limit status =[{2}]",
												account.getAccountID(),
												_TransactionType
														.getTransactionTypeID(),
												limistatus.toString()// Enum.GetName(typeof(AccountStatus),
																		// limistatus))
										)));
			}
		}
		return result;
	}

	private boolean CheckLimitFlag(AccountLimitStatus limistatus,
			double AmountAvailableAfterTxn, double AmountAvailableOnUncleared) {
		if (limistatus == AccountLimitStatus.PostingOverDrawingProhibited
				&& AmountAvailableAfterTxn < 0) {
			return false;
		}
		if (limistatus == AccountLimitStatus.PostingDrawingOnUnclearedEffectsAllowed
				&& AmountAvailableOnUncleared < 0) {
			return false;
		}
		return true;
	}

	private boolean CheckPassFlag(PassFlag lockstatus, Account account,
			TransactionType _TransactionType) {
		if (lockstatus == PassFlag.Locked)
			return false;
		if (lockstatus == PassFlag.AllPostingProhibited)
			return false;
		if (lockstatus == PassFlag.CreditPostingProhibited
				&& _TransactionType.getDebitCredit().equals("C"))
			return false;
		if (lockstatus == PassFlag.DebitPostingProhibited
				&& _TransactionType.getDebitCredit().equals("D")) {

			return false;
		}
		return true;
	}

	private void ValidateLimit(Account account, double amount)
			throws NotFoundException {
		if (account.getClosed())
			throw new NotFoundException("Account closed");

		// check that funds are available after limiting
		AccountLimitStatus limistatus = AccountLimitStatus.valueOf(account
				.getLimitFlag());
		PassFlag lockstatus = PassFlag.valueOf(account.getPassFlag());

		double AmountAvailable = account.getClearedBalance()
				- account.getLimit();
		double AvailableBalanceAfterApplyingLimit = AmountAvailable - amount;
		double limit = account.getLimit() + amount;

		// check 1 - Lock status
		if ((lockstatus == PassFlag.Locked))
			throw new NotFoundException(
					MessageFormat
							.format("Cannot mark limit to account [{0}].\nAccount lock status =[{1}]",
									account.getAccountID(), lockstatus));

		// check 2 - Limit status
		if ((limistatus == AccountLimitStatus.AllLimitsProhibited)
				|| (limistatus == AccountLimitStatus.LimitForBlockingProhibited && limit > 0)
				|| (limistatus == AccountLimitStatus.LimitForAdvanceProhibited && limit < 0))
			throw new NotFoundException(
					MessageFormat
							.format("Cannot mark limit to account [{0}].\nMarking limits prohibited, limit status =[{1}]",
									account.getAccountID(), limistatus));

		if (limistatus == AccountLimitStatus.LimitsAllowed
				&& AvailableBalanceAfterApplyingLimit < 0)
			throw new NotFoundException(
					MessageFormat
							.format("Cannot block funds[{0}] on Acount[{1}]. There are not enough funds to block. Available balance[{2}] is below zero. ",
									amount, account.getAccountID(),
									AvailableBalanceAfterApplyingLimit));

	}

	private void MarkLimit(Account account, double amount)
			throws NotFoundException

	{
		// Step 1 - Block funds mean making funds unavailable
		// funds are made unavailable by increasing the limit.

		// Handle as ACID
		// validate
		ValidateLimit(account, amount);

		// Data access component declarations.
		account.setLimit(account.getLimit() + amount);

		// updateAccount( account);
		updateAccount(account);

	}

	private boolean ZeroProof(List<Transaction> Trans) {
		boolean isProofed = false;

		double total = 0;

		// loop through all the items in the list
		for (Transaction t : Trans)
			total += t.getAmount();

		isProofed = (total == 0);

		return isProofed;
	}

	@ApiMethod(name = "memberWithdraw")
	public RequestResult MemberWithdraw(@Named("email") String email,
			@Named("amount") double amount) {

		RequestResult re = new RequestResult();
		re.setResult(true);
		re.setResultMessage("Success");
		try {

			Member member = ofy().transactionless().load().type(Member.class)
					.filter("email", email).first().now();

			// 1.does member current account contain enough money to complete
			// the transaction.
			double availablebalance = GLUtil.GetAvailableBalance(member
					.getCurrentAccount());
			double commission = 100.0;
			double neededbalance = availablebalance + commission;
			if (availablebalance < neededbalance) {
				re.setResult(false);
				re.setResultMessage(MessageFormat
						.format("You do not have enough money to make a withdaw of {0}.<br/> Available balance is {1}",
								amount, availablebalance));
				return re;
			}
			WithdrawalComponent wc = new WithdrawalComponent();
			re.setResultMessage(wc.MemberWithdraw(member, amount));

		} catch (Exception e) {
			re.setResult(false);
			re.setResultMessage(e.getMessage().toString());
		}
		return re;
	}
}
