package com.sp.fanikiwa.api;

import static com.sp.fanikiwa.api.OfyService.ofy;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Nullable;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.api.server.spi.response.ConflictException;
import com.google.api.server.spi.response.NotFoundException;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.api.datastore.QueryResultIterator;
import com.googlecode.objectify.cmd.Query;
import com.sp.fanikiwa.Enums.AccountLimitStatus;
import com.sp.fanikiwa.Enums.PassFlag;
import com.sp.fanikiwa.Enums.UserType;
import com.sp.fanikiwa.business.WithdrawalComponent;
import com.sp.fanikiwa.entity.Account;
import com.sp.fanikiwa.entity.AccountType;
import com.sp.fanikiwa.entity.Coadet;
import com.sp.fanikiwa.entity.Customer;
import com.sp.fanikiwa.entity.Member;
import com.sp.fanikiwa.entity.UserDTO;
import com.sp.fanikiwa.entity.Offer;
import com.sp.fanikiwa.entity.Organization;
import com.sp.fanikiwa.entity.RequestResult;
import com.sp.fanikiwa.entity.Userprofile;
import com.sp.utils.Config;
import com.sp.utils.MailUtil;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Named;

@Api(name = "memberendpoint", namespace = @ApiNamespace(ownerDomain = "sp.com", ownerName = "sp.com", packagePath = "fanikiwa.entity"))
public class MemberEndpoint {

	/**
	 * This method lists all the entities inserted in datastore. It uses HTTP
	 * GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 *         persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listMember")
	public CollectionResponse<Member> listMember(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("count") Integer count) {

		Query<Member> query = ofy().load().type(Member.class);
		return listMemberByQuery(query, cursorString, count);
	}

	private CollectionResponse<Member> listMemberByQuery(Query<Member> query,
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("count") Integer count) {
		if (count != null)
			query.limit(count);
		if (cursorString != null && cursorString != "") {
			query = query.startAt(Cursor.fromWebSafeString(cursorString));
		}

		List<Member> records = new ArrayList<Member>();
		QueryResultIterator<Member> iterator = query.iterator();
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
		return CollectionResponse.<Member> builder().setItems(records)
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
	@ApiMethod(name = "getMemberByID")
	public Member getMemberByID(@Named("id") Long id) {
		return findRecord(id);
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity
	 * already exists in the datastore, an exception is thrown. It uses HTTP
	 * POST method.
	 *
	 * @param Member
	 *            the entity to be inserted.
	 * @return The inserted entity.
	 * @throws ConflictException
	 */
	// @ApiMethod(name = "insertMember")

	/**
	 * This method is used for updating an existing entity. If the entity does
	 * not exist in the datastore, an exception is thrown. It uses HTTP PUT
	 * method.
	 *
	 * @param Member
	 *            the entity to be updated.
	 * @return The updated entity.
	 * @throws NotFoundException
	 */
	@ApiMethod(name = "updateMember")
	public RequestResult updateMember(Member member) {
		RequestResult re = new RequestResult();
		re.setResult(true);
		re.setResultMessage("Success");
		try {

			Member existingmember = findRecord(member.getMemberId());
			if (existingmember == null) {
				throw new NotFoundException("Record does not exist");
			}
			existingmember
					.setCurrentAccount(existingmember.getCurrentAccount());
			existingmember.setCustomer(existingmember.getCustomer());
			existingmember.setDateActivated(existingmember.getDateActivated());
			existingmember.setDateJoined(existingmember.getDateJoined());
			existingmember.setDateOfBirth(member.getDateOfBirth());
			existingmember.setEmail(existingmember.getEmail());
			existingmember.setGender(member.getGender());
			existingmember.setInformBy(member.getInformBy());
			existingmember.setinterestExpAccount(existingmember
					.getinterestExpAccount());
			existingmember.setinterestIncAccount(existingmember
					.getinterestIncAccount());
			existingmember.setInvestmentAccount(existingmember
					.getInvestmentAccount());
			existingmember.setLoanAccount(existingmember.getLoanAccount());
			existingmember.setMaxRecordsToDisplay(member
					.getMaxRecordsToDisplay());
			existingmember.setMemberId(existingmember.getMemberId());
			existingmember.setNationalID(member.getNationalID());
			existingmember.setOtherNames(member.getOtherNames());
			existingmember.setPhoto(existingmember.getPhoto());
			existingmember.setPwd(existingmember.getPwd());
			existingmember.setRefferedBy(member.getRefferedBy());
			existingmember.setStatus(existingmember.getStatus());
			existingmember.setSurname(member.getSurname());
			existingmember.setTelephone(existingmember.getTelephone());

			ofy().save().entities(existingmember).now();
			re.setResultMessage(MessageFormat
					.format("Details:<br/>Member Id: {0}, <br/>Current Account Id: {1}, <br/>Loan Account Id: {2}, <br/>Investment Account Id: {3}, <br/>Interest Income Account Id: {4}, <br/>Interest Expense Account Id: {5}",
							existingmember.getMemberId().toString(),
							existingmember.getCurrentAccount().getAccountID()
									.toString(),
							existingmember.getLoanAccount().getAccountID()
									.toString(), existingmember
									.getInvestmentAccount().getAccountID()
									.toString(), existingmember
									.getinterestIncAccount().getAccountID()
									.toString(), existingmember
									.getinterestExpAccount().getAccountID()
									.toString()));

		} catch (Exception e) {
			re.setResult(false);
			re.setResultMessage(e.getMessage().toString());
		}
		return re;
	}

	/**
	 * This method removes the entity with primary key id. It uses HTTP DELETE
	 * method.
	 *
	 * @param id
	 *            the primary key of the entity to be deleted.
	 * @throws NotFoundException
	 */
	@ApiMethod(name = "removeMember")
	public void removeMember(@Named("id") Long id) throws NotFoundException {
		Member record = findRecord(id);
		if (record == null) {
			throw new NotFoundException("Record does not exist");
		}
		ofy().delete().entity(record).now();
	}

	private Member findRecord(Long id) {
		return ofy().load().type(Member.class).id(id).now();
	}

	private Member insertMember(Member member) throws ConflictException {
		if (member.getMemberId() != null) {
			if (findRecord(member.getMemberId()) != null) {
				throw new ConflictException("Object already exists");
			}
		}
		ofy().save().entities(member).now();
		return member;
	}

	// Non CRUD
	@ApiMethod(name = "getMemberByEmailWeb")
	public RequestResult GetMemberByEmailWeb(@Named("email") String email) {
		RequestResult re = new RequestResult();
		re.setResult(true);
		re.setResultMessage("Success");
		try {
			Member member = ofy().load().type(Member.class)
					.filter("email", email).first().now();
			if (member == null) {
				re.setResult(false);
				re.setResultMessage("Could not find Member Info");
				return re;
			}
			re.setClientToken(member);
		} catch (Exception e) {
			re.setResult(false);
			re.setResultMessage(e.getMessage().toString());
		}
		return re;
	}

	@ApiMethod(name = "getMemberByEmail")
	public Member GetMemberByEmail(@Named("email") String email) {
		return ofy().load().type(Member.class).filter("email", email).first()
				.now();
	}

	@ApiMethod(name = "txnlessGetMemberByEmail")
	public Member txnlessGetMemberByEmail(@Named("email") String email) {
		return ofy().transactionless().load().type(Member.class)
				.filter("email", email).first().now();
	}

	@ApiMethod(name = "Register")
	public RequestResult Register(UserDTO memberDTO) {
		String userType = memberDTO.getUserType();

		RequestResult re = new RequestResult();
		re.setResult(true);
		re.setResultMessage("Success");

		// STEP 1: Create the user
		UserprofileEndpoint upep = new UserprofileEndpoint();
		if (!upep.UserExists(memberDTO.getEmail()).isResult()) {
			Userprofile user = new Userprofile();
			user.setCreateDate(new Date());
			user.setPwd(memberDTO.getPwd()); // think of encrypting
			user.setUserId(memberDTO.getEmail());
			user.setTelephone(memberDTO.getTelephone());
			user.setUserType(userType);

			Userprofile userReturned;

				try {
					userReturned = upep.insertUserprofile(user);
					if (userReturned == null) {
						re.setResult(false);
						re.setResultMessage("Error Creating User!");
						return re;
					}
				} catch (NotFoundException | ConflictException e) {
					re.setResult(false);
					re.setResultMessage(e.getMessage());
					return re;
				}
		}
		//Continue only if you are creating a member user
		if(!userType.equals(UserType.Member))
			return re;
		
		//Create a member user
		try {

			Member emailexists = ofy().load().type(Member.class)
					.filter("email", memberDTO.getEmail()).first().now();
			if (emailexists != null) {
				re.setResult(false);
				re.setResultMessage("Email is already Registered in Fanikiwa!");
				return re;
			}
			Member telephoneexists = ofy().load().type(Member.class)
					.filter("telephone", memberDTO.getTelephone()).first()
					.now();
			if (telephoneexists != null) {
				re.setResult(false);
				re.setResultMessage("Telephone is already Registered in Fanikiwa!");
				return re;
			}

			Customer customer = new Customer();
			// at this point, fill the customer with the details from the UI
			customer.setName(memberDTO.getSurname());
			customer.setEmail(memberDTO.getEmail());
			customer.setTelephone(memberDTO.getTelephone());
			customer.setCreatedDate(new Date());
			customer.setOrganization(new Organization(Config
					.GetLong("CURRENT_ORG")));
			customer.setBillToEmail(memberDTO.getEmail());
			customer.setBillToTelephone(memberDTO.getTelephone());

			CustomerEndpoint cep = new CustomerEndpoint();
			Customer customerReturned = cep.insertCustomer(customer);
			if (customerReturned == null) {
				re.setResult(false);
				re.setResultMessage("Error Creating Customer!");
				return re;
			}

			// Step 3. Create 3 accounts. Currentaccount, loanaccount and
			// invesmentaccount using the customerReturned
			Account currentAccount = new Account();
			currentAccount.setAccountName(customerReturned.getName()
					+ " Curr A/c");
			currentAccount.setCustomer(customerReturned);
			currentAccount.setCoadet(new Coadet(Config
					.GetLong("CURRENT_ACC_COA_ID")));
			currentAccount.setAccounttype(new AccountType(Config
					.GetLong("CURRENT_ACC_TYPE_ID")));
			currentAccount.setBookBalance(0.00);
			currentAccount.setClearedBalance(0.00);
			currentAccount.setLimit(0.00);
			currentAccount.setInterestRate(0.00);
			currentAccount.setAccruedInt(0.00);
			currentAccount
					.setLimitFlag(AccountLimitStatus.PostingOverDrawingProhibited
							.name());
			currentAccount.setPassFlag(PassFlag.Ok.name());

			Account loanaccount = new Account();
			loanaccount
					.setAccountName(customerReturned.getName() + " Loan A/c");
			loanaccount.setCustomer(customerReturned);
			loanaccount
					.setCoadet(new Coadet(Config.GetLong("LOAN_ACC_COA_ID")));
			loanaccount.setAccounttype(new AccountType(Config
					.GetLong("LOAN_ACC_COA_ID")));
			loanaccount.setBookBalance(0.00);
			loanaccount.setClearedBalance(0.00);
			loanaccount.setLimit(0.00);
			loanaccount.setInterestRate(0.00);
			loanaccount.setAccruedInt(0.00);
			loanaccount.setLimitFlag(AccountLimitStatus.PostingNoLimitChecking
					.name());
			loanaccount.setPassFlag(PassFlag.Ok.name());

			Account interestexpenseaccount = new Account();
			interestexpenseaccount.setAccountName(customerReturned.getName()
					+ " Interest Exp A/c");
			interestexpenseaccount.setCustomer(customerReturned);
			interestexpenseaccount.setCoadet(new Coadet(Config
					.GetLong("INTEREST_EXP_ACC_COA_ID")));
			interestexpenseaccount.setAccounttype(new AccountType(Config
					.GetLong("INTEREST_EXP_ACC_TYPE_ID")));
			interestexpenseaccount.setBookBalance(0.00);
			interestexpenseaccount.setClearedBalance(0.00);
			interestexpenseaccount.setLimit(0.00);
			interestexpenseaccount.setInterestRate(0.00);
			interestexpenseaccount.setAccruedInt(0.00);
			interestexpenseaccount
					.setLimitFlag(AccountLimitStatus.PostingNoLimitChecking
							.name());
			interestexpenseaccount.setPassFlag(PassFlag.Ok.name());

			Account invesmentaccount = new Account();
			invesmentaccount.setAccountName(customerReturned.getName()
					+ " Investment A/c");
			invesmentaccount.setCustomer(customerReturned);
			invesmentaccount.setCoadet(new Coadet(Config
					.GetLong("INVESTMENT_ACC_COA_ID")));
			invesmentaccount.setAccounttype(new AccountType(Config
					.GetLong("INVESTMENT_ACC_TYPE_ID")));
			invesmentaccount.setBookBalance(0.00);
			invesmentaccount.setClearedBalance(0.00);
			invesmentaccount.setLimit(0.00);
			invesmentaccount.setInterestRate(0.00);
			invesmentaccount.setAccruedInt(0.00);
			invesmentaccount
					.setLimitFlag(AccountLimitStatus.PostingOverDrawingProhibited
							.name());
			invesmentaccount.setPassFlag(PassFlag.Ok.name());

			Account interestincomeaccount = new Account();
			interestincomeaccount.setAccountName(customerReturned.getName()
					+ " Interest Inc A/c");
			interestincomeaccount.setCustomer(customerReturned);
			interestincomeaccount.setCoadet(new Coadet(Config
					.GetLong("INTEREST_INC_ACC_COA_ID")));
			interestincomeaccount.setAccounttype(new AccountType(Config
					.GetLong("INTEREST_INC_ACC_TYPE_ID")));
			interestincomeaccount.setBookBalance(0.00);
			interestincomeaccount.setClearedBalance(0.00);
			interestincomeaccount.setLimit(0.00);
			interestincomeaccount.setInterestRate(0.00);
			interestincomeaccount.setAccruedInt(0.00);
			interestincomeaccount.setLimitFlag(AccountLimitStatus.Ok.name());
			interestincomeaccount.setPassFlag(PassFlag.Ok.name());

			AccountEndpoint aep = new AccountEndpoint();
			Account currentAccountReturned = aep.insertAccount(currentAccount);
			Account loanAccountReturned = aep.insertAccount(loanaccount);
			Account investmentAccountReturned = aep
					.insertAccount(invesmentaccount);

			Account intexpAccountReturned = aep
					.insertAccount(interestexpenseaccount);
			Account intincAccountReturned = aep
					.insertAccount(interestincomeaccount);

			if (currentAccountReturned == null) {
				re.setResult(false);
				re.setResultMessage("Error Creating Current Account!");
				return re;
			}
			if (loanAccountReturned == null) {
				re.setResult(false);
				re.setResultMessage("Error Creating Loan Account!");
				return re;
			}
			if (intexpAccountReturned == null) {
				re.setResult(false);
				re.setResultMessage("Error Creating Interest Expense Account!");
				return re;
			}
			if (investmentAccountReturned == null) {
				re.setResult(false);
				re.setResultMessage("Error Creating Investment Account!");
				return re;
			}
			if (intincAccountReturned == null) {
				re.setResult(false);
				re.setResultMessage("Error Creating Interet Income Account!");
				return re;
			}

			// Step 4. create the member with the three accounts created in
			// step1
			Member member = new Member();
			member.setEmail(memberDTO.getEmail());
			member.setPwd(memberDTO.getPwd());
			member.setTelephone(memberDTO.getTelephone());
			member.setSurname(memberDTO.getSurname());
			member.setDateJoined(new Date());
			member.setStatus("A");
			member.setMaxRecordsToDisplay(5);
			member.setCurrentAccount(currentAccountReturned);
			member.setLoanAccount(loanAccountReturned);
			member.setInvestmentAccount(investmentAccountReturned);
			member.setinterestExpAccount(intexpAccountReturned);
			member.setinterestIncAccount(intincAccountReturned);
			member.setCustomer(customerReturned);
			Member newMember = insertMember(member);
			if (newMember == null) {
				re.setResult(false);
				re.setResultMessage("Error Creating Member!");
				return re;
			}

			// Step 5. Update the customer with memberid
			customerReturned.setMemberId(newMember.getMemberId());
			cep.updateCustomer(customerReturned);

			// Step 6. Create ROOT Mailing Group for member
			LendingGroupEndpoint mc = new LendingGroupEndpoint();
			mc.CreateRootMailingGroup(newMember);

			re.setResult(true);
			re.setResultMessage(MessageFormat
					.format("Registration Details:<br/>Member Id: {0}, <br/>Current Account Id: {1}, <br/>Loan Account Id: {2}, <br/>Investment Account Id: {3}, <br/>Interest Income Account Id: {4}, <br/>Interest Expense Account Id: {5}",
							newMember.getMemberId().toString(), newMember
									.getCurrentAccount().getAccountID()
									.toString(), newMember.getLoanAccount()
									.getAccountID().toString(), newMember
									.getInvestmentAccount().getAccountID()
									.toString(), newMember
									.getinterestIncAccount().getAccountID()
									.toString(), newMember
									.getinterestExpAccount().getAccountID()
									.toString()));
		} catch (Exception e) {
			re.setResult(false);
			re.setResultMessage(e.getMessage().toString());
		}
		return re;
	}

	@ApiMethod(name = "DeRegister")
	public void DeRegister(Member member) {
	}

	@ApiMethod(name = "getMemberByTelephone")
	public Member GetMemberByTelephone(@Named("telephone") String telephone) {
		return ofy().load().type(Member.class).filter("telephone", telephone)
				.first().now();
	}

	@ApiMethod(name = "getMemberByNationalID", path = "member/nationalid")
	public Member getMemberByNationalID(@Named("nationalId") String nationalId) {
		return ofy().load().type(Member.class).filter("nationalID", nationalId)
				.first().now();
	}

	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "selectMemberAccounts")
	public CollectionResponse<Account> listMemberAccountMobile(Member member,
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("count") Integer count) {

		return listAccountByQuery(member, cursorString, count);
	}

	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listMemberAccountWeb")
	public CollectionResponse<Account> listMemberAccountWeb(
			@Named("email") String email,
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("count") Integer count) {

		Member member = GetMemberByEmail(email);
		return listAccountByQuery(member, cursorString, count);
	}

	private CollectionResponse<Account> listAccountByQuery(Member member,
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("count") Integer count) {

		List<Account> memberAccounts = new ArrayList<Account>();
		memberAccounts.add(member.getCurrentAccount());
		memberAccounts.add(member.getinterestExpAccount());
		memberAccounts.add(member.getinterestIncAccount());
		memberAccounts.add(member.getInvestmentAccount());
		memberAccounts.add(member.getLoanAccount());

		return CollectionResponse.<Account> builder().setItems(memberAccounts)
				.setNextPageToken(cursorString).build();
	}

	@ApiMethod(name = "isEmailValid")
	public RequestResult isEmailValid(@Named("email") String email) {

		RequestResult re = new RequestResult();
		re.setResult(true);
		re.setResultMessage("Success");

		try {

			String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
			Boolean isemailvalid = email.matches(EMAIL_REGEX);
			if (isemailvalid) {
				re.setResult(isemailvalid);
				re.setResultMessage("email validation successful...");
				return re;
			} else {
				re.setResult(isemailvalid);
				re.setResultMessage("Validation failed! Please check Email.<br/>Valid format is user@domain.com");
				return re;
			}

		} catch (Exception e) {
			re.setResult(false);
			re.setResultMessage(e.getMessage().toString());
		}
		return re;
	}
}