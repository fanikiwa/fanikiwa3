/**
 * @fileoverview
 * Provides methods for the  Endpoints UI and interaction with the
 * Endpoints API.
 */

/** global namespace for projects. */
var fanikiwa = fanikiwa || {};
fanikiwa.loanendpoint = fanikiwa.loanendpoint || {};
fanikiwa.loanendpoint.myinvestments = fanikiwa.loanendpoint.myinvestments || {};

fanikiwa.loanendpoint.myinvestments.LoadLoans = function() {

	$('#listLoansResult').html('loading...');

	var email = sessionStorage.getItem('loggedinuser');

	gapi.client.loanendpoint.selectMyInvestments({
		'email' : email
	}).execute(function(resp) {
		console.log('response =>> ' + resp);
		if (!resp.code) {
			if (resp.result.items == undefined || resp.result.items == null) {
				$('#listLoansResult').html('You have no Investments...');
			} else {
				buildTable(resp);
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
fanikiwa.loanendpoint.myinvestments.init = function(apiRoot) {
	// Loads the APIs asynchronously, and triggers callback
	// when they have completed.
	var apisToLoad;
	var callback = function() {
		if (--apisToLoad == 0) {
			fanikiwa.loanendpoint.myinvestments.LoadLoans();
		}
	}

	apisToLoad = 1; // must match number of calls to gapi.client.load()
	gapi.client.load('loanendpoint', 'v1', callback, apiRoot);

};

var loanTable = '';
function buildTable(response) {

	loanTable = '';

	populateLoans(response);

	$("#listLoansResult").html(loanTable);
}

function populateLoans(resp) {

	if (!resp.code) {
		resp.items = resp.items || [];

		loanTable += '<table id="listLoansTable">';
		loanTable += "<thead>";
		loanTable += "<tr>";
		loanTable += "<th>Amount</th>";
		loanTable += "<th>Term</th>";
		loanTable += "<th>Interest Rate</th>";
		loanTable += "<th>Accrued Interest</th>";
		loanTable += "<th>Maturity Date</th>";
		loanTable += "<th></th>";
		loanTable += "</tr>";
		loanTable += "</thead>";
		loanTable += "<tbody>";

		for (var i = 0; i < resp.result.items.length; i++) {
			loanTable += '<tr>';
			loanTable += '<td>' + resp.result.items[i].amount.formatMoney(2) + '</td>';
			loanTable += '<td>' + resp.result.items[i].term + '</td>';
			loanTable += '<td>' + resp.result.items[i].interestRate + '</td>';
			loanTable += '<td>' + resp.result.items[i].accruedInterest
					+ '</td>';
			loanTable += '<td>' + resp.result.items[i].maturityDate + '</td>';
			loanTable += '<td><a href="#" onclick="LoanDetails('
					+ resp.result.items[i].id + ')">Details</a> </td>';
			loanTable += "</tr>";
		}

		loanTable += "</tbody>";
		loanTable += "</table>";

	}
}

function LoanDetails(id) {
	sessionStorage.myinvestmentdetailsid = id;
	window.location.href = "/Views/Loans/MyInvestmentDetails.html";
}