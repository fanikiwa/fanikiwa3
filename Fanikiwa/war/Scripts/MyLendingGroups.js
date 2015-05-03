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
		lendinggroupTable += "<th>Name</th>";
		lendinggroupTable += "<th>Created On</th>";
		lendinggroupTable += "<th>Last Modified</th>"; 
		lendinggroupTable += "<th></th>";
		lendinggroupTable += "<th></th>";
		lendinggroupTable += "</tr>";
		lendinggroupTable += "</thead>";
		lendinggroupTable += "<tbody>";

		for (var i = 0; i < resp.result.items.length; i++) {
			lendinggroupTable += '<tr>';
			lendinggroupTable += '<td>' + resp.result.items[i].groupName + '</td>';
			lendinggroupTable += '<td>' + resp.result.items[i].createdOn + '</td>';
			lendinggroupTable += '<td>' + resp.result.items[i].lastModified + '</td>';			 
			lendinggroupTable += '<td><a href="#" onclick="Create('
					+ resp.result.items[i].id + ')">Create</a> </td>';
			lendinggroupTable += '<td><a href="#" onclick="Delete('
				+ resp.result.items[i].id + ')">Delete</a> </td>';
			lendinggroupTable += "</tr>";
		}

		lendinggroupTable += "</tbody>";
		lendinggroupTable += "</table>";

	}
}

function Create(id) {
	sessionStorage.lendinggroupparentid = id;
	window.location.href = "/Views/LendingGroups/Create.html";
}

function Delete(id) {
	sessionStorage.mylendinggroupdetailsid = id;
	console.log(sessionStorage.getItem('mylendinggroupdetailsid = ' + mylendinggroupdetailsid));
	window.location.href = "/Views/LendingGroups/Details.html";
}
