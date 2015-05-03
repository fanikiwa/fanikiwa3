/**
 * @fileoverview
 * Provides methods for the Endpoints UI and interaction with the
 * Endpoints API.
 */

/** global namespace for projects. */
var fanikiwa = fanikiwa || {};
fanikiwa.lendinggroupendpoint = fanikiwa.lendinggroupendpoint || {};
fanikiwa.lendinggroupendpoint.createlendinggroup = fanikiwa.lendinggroupendpoint.createlendinggroup
		|| {};

var errormsg = '';
errormsg += '<ul id="errorList">';

fanikiwa.lendinggroupendpoint.createlendinggroup = function() {

	errormsg = '';
	ClearException();
	errormsg += '<ul id="errorList">';
	var error_free = true;
	$('#apiResults').html('');

	// Validate the entries
	var _groupName = document.getElementById('txtgroupName').value; 

	if (_groupName.length == 0) {
		errormsg += '<li>' + " Group Name cannot be null " + '</li>';
		error_free = false;
	} 

	if (!error_free) {
		errormsg += "</ul>";
		$("#error-display-div").html(errormsg);
		$("#error-display-div").removeClass('displaynone');
		$("#error-display-div").addClass('displayblock');
		$("#error-display-div").show();
		return;
	} else {
		ClearException();
	}

	$('#apiResults').html('creating offer...');

	var email = sessionStorage.getItem('loggedinuser');
	var parentGroupId = sessionStorage.getItem('lendinggroupparentid');

	// Build the Request Object
	var lendingGroupDTO = {};
	lendingGroupDTO.groupName = _groupName;
	lendingGroupDTO.creatorEmail = email;
	lendingGroupDTO.parentGroupId = parentGroupId;

	gapi.client.lendinggroupendpoint
			.saveLendinggroup(lendingGroupDTO)
			.execute(
					function(resp) {
						console.log('response =>> ' + resp);
						if (!resp.code) {
							if (resp.result.id == undefined
									|| resp.result.id == null) {
								$('#apiResults').html(
										'operation failed! Please try again');
							} else {
								$('#apiResults').html(
										'operation successful... <br/>');
								window
										.setTimeout(
												'window.location.href = "/Views/LendingGroups/List.html";',
												1000);
							}
						} else {
							$('#apiResults').html(
									'operation failed! Please try again');
						}

					}, function(reason) {
						console.log('Error: ' + reason.result.error.message);
					});
};

/**
 * Enables the button callbacks in the UI.
 */
fanikiwa.lendinggroupendpoint.createlendinggroup.enableButtons = function() {
	$("#btnCreate").removeAttr('style');
	$("#btnCreate").removeAttr('disabled');
	$("#btnCreate").val('Create');
	var btnCreate = document.querySelector('#btnCreate');
	btnCreate.addEventListener('click', function() {
		fanikiwa.lendinggroupendpoint.createlendinggroup();
	});
};

/**
 * Initializes the application.
 * 
 * @param {string}
 *            apiRoot Root of the API's path.
 */
fanikiwa.lendinggroupendpoint.createlendinggroup.init = function(apiRoot) {
	// Loads the APIs asynchronously, and triggers callback
	// when they have completed.
	var apisToLoad;
	var callback = function() {
		if (--apisToLoad == 0) {
			fanikiwa.lendinggroupendpoint.createlendinggroup.enableButtons();
		}
	}

	apisToLoad = 1; // must match number of calls to gapi.client.load()
	gapi.client.load('lendinggroupendpoint', 'v1', callback, apiRoot);

};

function DisplayException(errormsg) {

	errormsg += "</ul>";

	$("#error-display-div").html(errormsg);
	$("#error-display-div").removeClass('displaynone');
	$("#error-display-div").addClass('displayblock');
	$("#error-display-div").show();
}

function ClearException() {
	$('#errorList').remove();
	$('#error-display-div').empty();
}