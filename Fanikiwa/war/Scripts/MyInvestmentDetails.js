/**
 * @fileoverview
 * Provides methods for the  Endpoints UI and interaction with the
 * Endpoints API.
 */

/** global namespace for projects. */
var fanikiwa = fanikiwa || {};
fanikiwa.loanendpoint = fanikiwa.loanendpoint || {};
fanikiwa.loanendpoint.loandetail = fanikiwa.loanendpoint.loandetail || {};

fanikiwa.loanendpoint.loandetail.LoadLoanDetails = function() {
	$('#apiResults').html('loading...');
	var id = sessionStorage.getItem('myinvestmentdetailsid');
	gapi.client.loanendpoint.getLoanByID({
		'id' : id
	}).execute(function(resp) {
		console.log('response =>> ' + resp);
		if (!resp.code) {
			if (resp == false || resp.result.id == undefined) {
				$('#apiResults').html('failed to load loan details...');
			} else {
				fanikiwa.loanendpoint.loandetail.populateLoanDetails(resp);
				$('#apiResults').html('');
			}
		}

	}, function(reason) {
		console.log('Error: ' + reason.result.error.message);
	});
};

/**
 * Initializes the application.
 * 
 * @param {string}
 *            apiRoot Root of the API's path.
 */
fanikiwa.loanendpoint.loandetail.init = function(apiRoot) {
	// Loads the APIs asynchronously, and triggers callback
	// when they have completed.
	var apisToLoad;
	var callback = function() {
		if (--apisToLoad == 0) {
			fanikiwa.loanendpoint.loandetail.LoadLoanDetails();
		}
	}

	apisToLoad = 1; // must match number of calls to gapi.client.load()
	gapi.client.load('loanendpoint', 'v1', callback, apiRoot);

};

fanikiwa.loanendpoint.loandetail.populateLoanDetails = function(resp) {
	$("#txtamount").val(resp.result.amount);
	$("#dtpcreatedDate").val(resp.result.createdDate);
	$("#dtpmaturityDate").val(resp.result.maturityDate);
	$("#txtborrowerId").val(resp.result.borrowerId);
	$("#txtlenderId").val(resp.result.lenderId);
	$("#txtofferId").val(resp.result.offerId);
	$("#chkpartialPay").val(resp.result.partialPay);
	$("#txtterm").val(resp.result.term);
	$("#txtAccruedInterest").val(resp.AccruedInterest);
	$("#txtinterestRate").val(resp.result.interestRate);
	$("#txtinterestRateSusp").val(resp.result.interestRateSusp);
	$("#txtaccruedIntInSusp").val(resp.result.accruedIntInSusp);
	$("#txtinterestAccrualInterval").val(resp.result.interestAccrualInterval);
	$("#txtlastIntAccrualDate").val(resp.result.lastIntAccrualDate);
	$("#txtnextIntAccrualDate").val(resp.result.nextIntAccrualDate);
	$("#txtaccrueInSusp").val(resp.result.accrueInSusp);
	$("#txtinterestComputationMethod").val(
			resp.result.interestComputationMethod);
	$("#txtinterestComputationTerm").val(resp.result.interestComputationTerm);
	$("#txtinterestApplicationMethod").val(
			resp.result.interestApplicationMethod);
	$("#txtlastIntAppDate").val(resp.result.lastIntAppDate);
	$("#txtnextIntAppDate").val(resp.result.nextIntAppDate);
	$("#txtintPayingAccount").val(resp.result.intPayingAccount);
	$("#txtintPaidAccount").val(resp.result.intPaidAccount);
}
