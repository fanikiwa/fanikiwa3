/**
 * @fileoverview
 * Provides methods for the  Endpoints UI and interaction with the
 * Endpoints API.
 */

/** global namespace for projects. */
var fanikiwa = fanikiwa || {};
fanikiwa.memberendpoint = fanikiwa.memberendpoint || {};
fanikiwa.memberendpoint.myaccounts = fanikiwa.memberendpoint.myaccounts || {};

fanikiwa.memberendpoint.myaccounts.LoadAccounts = function() {

	$('#listAccountsResult').html('loading...');

	var email = JSON.parse(sessionStorage.getItem('loggedinuser')).userId;

	gapi.client.memberendpoint.listMemberAccountWeb({
		'email' : email
	}).execute(function(resp) {
		console.log('response =>> ' + resp);
		if (!resp.code) {
			if (resp.result.items == undefined || resp.result.items == null) {
				$('#listAccountsResult').html('You have no Accounts...');
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
fanikiwa.memberendpoint.myaccounts.init = function(apiRoot) {
	// Loads the APIs asynchronously, and triggers callback
	// when they have completed.
	var apisToLoad;
	var callback = function() {
		if (--apisToLoad == 0) {
			fanikiwa.memberendpoint.myaccounts.LoadAccounts();
		}
	}

	apisToLoad = 1; // must match number of calls to gapi.client.load()
	gapi.client.load('memberendpoint', 'v1', callback, apiRoot);

};

var accountsTable = '';
function buildTable(response) {

	accountsTable = '';

	populateAccounts(response);

	$("#listAccountsResult").html(accountsTable);

}

function populateAccounts(resp) {

	if (!resp.code) {
		resp.items = resp.items || [];

		accountsTable += '<table id="listAccountsTable">';
		accountsTable += "<thead>";
		accountsTable += "<tr>";
		accountsTable += "<th>Account ID</th>";
		accountsTable += "<th>Account Name</th>";
		accountsTable += "<th>Book Balance</th>";
		accountsTable += "<th>Cleared Balance</th>";
		accountsTable += "<th>limit</th>";
		accountsTable += "<th>Available Balance</th>";
		accountsTable += "<th></th>";
		accountsTable += "</tr>";
		accountsTable += "</thead>";
		accountsTable += "<tbody>";

		for (var i = 0; i < resp.result.items.length; i++) {
			var availbal = resp.result.items[i].clearedBalance
					- resp.result.items[i].limit;
			accountsTable += '<tr>';
			accountsTable += '<td style="text-align:right">'
					+ resp.result.items[i].accountID + '</td>';
			accountsTable += '<td>' + resp.result.items[i].accountName
					+ '</td>';
			accountsTable += '<td style="text-align:right">'
					+ resp.result.items[i].bookBalance.formatMoney(2) + '</td>';
			accountsTable += '<td style="text-align:right">'
					+ resp.result.items[i].clearedBalance.formatMoney(2)
					+ '</td>';
			accountsTable += '<td style="text-align:right">'
					+ resp.result.items[i].limit.formatMoney(2) + '</td>';
			accountsTable += '<td style="text-align:right">'
					+ availbal.formatMoney(2) + '</td>';

			accountsTable += '<td><a href="#" onclick="MiniStatement('
					+ resp.result.items[i].accountID
					+ ')">Mini Statement</a> </td>';
			accountsTable += "</tr>";
		}

		accountsTable += "</tbody>";
		accountsTable += "</table>";

	}
}

function MiniStatement(id) {
	sessionStorage.ministatementaccountid = id;
	window.location.href = "/Views/Account/MiniStatement.html";
}

function CreateSubMenu() {
	var SubMenu = [];
	SubMenu.push('<div class="nav"><ul class="menu">');
	SubMenu
			.push('<li><div class="floatleft"><div><a href="/Views/Account/Statement.html" style="cursor: pointer;">Statement</a></div></div></li>');
	SubMenu
			.push('<li><div class="floatleft"><div><a href="/Views/Account/Withdraw.html" style="cursor: pointer;">Withdraw</a></div></div></li>');
	SubMenu
			.push('<li><div class="floatleft"><div><a href="/Views/Loans/ListMyLoans.html" style="cursor: pointer;">My loans</a></div></div></li>');
	SubMenu
			.push('<li><div class="floatleft"><div><a href="/Views/Loans/ListMyInvestments.html" style="cursor: pointer;">My investments</a></div></div></li>');
	SubMenu.push('</ul></div>');

	$("#SubMenu").html(SubMenu.join(" "));
}

$(document).ready(function() {
	CreateSubMenu();
});
