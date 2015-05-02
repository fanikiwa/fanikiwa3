/**
 * @fileoverview
 * Provides methods for the  Endpoints UI and interaction with the
 * Endpoints API.
 */

/** global namespace for projects. */
var fanikiwa = fanikiwa || {};
fanikiwa.lendinggroupendpoint = fanikiwa.lendinggroupendpoint || {};
fanikiwa.lendinggroupendpoint.lendinggroups = fanikiwa.lendinggroupendpoint.lendinggroups
		|| {};

fanikiwa.lendinggroupendpoint.lendinggroups.LoadLendingGroups = function() {

	$('#listLendingGroupsResult').html('loading...');

	var email = sessionStorage.getItem('loggedinuser');

	gapi.client.lendinggroupendpoint.retrieveLendinggroupsByCreator({
		'email' : email
	}).execute(function(resp) {
		console.log('response =>> ' + resp);
		if (!resp.code) {
			if (resp.result.items == undefined || resp.result.items == null) {
				$('#listLendingGroupsResult').html('You have no LendingGroups...');
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
fanikiwa.lendinggroupendpoint.lendinggroups.init = function(apiRoot) {
	// Loads the APIs asynchronously, and triggers callback
	// when they have completed.
	var apisToLoad;
	var callback = function() {
		if (--apisToLoad == 0) {
			fanikiwa.lendinggroupendpoint.lendinggroups.LoadLendingGroups();
		}
	}

	apisToLoad = 1; // must match number of calls to gapi.client.load()
	gapi.client.load('lendinggroupendpoint', 'v1', callback, apiRoot);

};

var lendinggroupTable = '';
function buildTable(response) {

	lendinggroupTable = '';

	populateLendingGroups(response);

	$("#listLendingGroupsResult").html(lendinggroupTable);
}

function populateLendingGroups(resp) {

	if (!resp.code) {
		resp.items = resp.items || [];

		lendinggroupTable += '<table id="listLendingGroupsTable">';
		lendinggroupTable += "<thead>";
		lendinggroupTable += "<tr>";
		lendinggroupTable += "<th>Amount</th>";
		lendinggroupTable += "<th>Term</th>";
		lendinggroupTable += "<th>Interest Rate</th>";
		lendinggroupTable += "<th>Accrued Interest</th>";
		lendinggroupTable += "<th>Maturity Date</th>";
		lendinggroupTable += "<th></th>";
		lendinggroupTable += "</tr>";
		lendinggroupTable += "</thead>";
		lendinggroupTable += "<tbody>";

		for (var i = 0; i < resp.result.items.length; i++) {
			lendinggroupTable += '<tr>';
			lendinggroupTable += '<td>' + resp.result.items[i].amount + '</td>';
			lendinggroupTable += '<td>' + resp.result.items[i].term + '</td>';
			lendinggroupTable += '<td>' + resp.result.items[i].interestRate + '</td>';
			lendinggroupTable += '<td>' + resp.result.items[i].accruedInterest
					+ '</td>';
			lendinggroupTable += '<td>' + resp.result.items[i].maturityDate + '</td>';
			lendinggroupTable += '<td><a href="#" onclick="LendingGroupDetails('
					+ resp.result.items[i].id + ')">Details</a> </td>';
			lendinggroupTable += "</tr>";
		}

		lendinggroupTable += "</tbody>";
		lendinggroupTable += "</table>";

	}
}

function LendingGroupDetails(id) {
	sessionStorage.mylendinggroupdetailsid = id;
	console.log(sessionStorage.getItem('mylendinggroupdetailsid = ' + mylendinggroupdetailsid));
	window.location.href = "/Views/LendingGroups/Details.html";
}
