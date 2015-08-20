/**
 * @fileoverview
 * Provides methods for the Hello Endpoints sample UI and interaction with the
 * Hello Endpoints API.
 */

/** google global namespace for Google projects. */
var fanikiwa = fanikiwa || {};
fanikiwa.userprofileendpoint = fanikiwa.userprofileendpoint || {};
fanikiwa.userprofileendpoint.changePassword = fanikiwa.userprofileendpoint.changePassword
		|| {};

var errormsg = '';
errormsg += '<ul id="errorList">';
fanikiwa.userprofileendpoint.requesttoken = function() {

	errormsg = '';
	ClearException();
	errormsg += '<ul id="errorList">';
	var error_free = true;
	$('#apiResults').html('');
	$('#successmessage').html('');
	$('#errormessage').html('');

	// Validate the entries
	var _email = JSON.parse(sessionStorage.getItem('loggedinuser')).userId;
	var _telno = JSON.parse(sessionStorage.getItem('loggedinuser')).telephone;

	$('#apiResults').html('generating new token...');
	$('#successmessage').html('');
	$('#errormessage').html('');

	// Build the Request Object
	var changePasswordDTO = {};
	changePasswordDTO.activatedDate = new Date();
	changePasswordDTO.email = _email;
	changePasswordDTO.telno = _telno;
	changePasswordDTO.activationMethod = 'Web';

	gapi.client.userprofileendpoint.changePasswordRequestToken(
			changePasswordDTO)
			.execute(
					function(resp) {
						console.log('response =>> ' + resp);
						if (!resp.code) {
							if (resp.result.success == false) {
								$('#errormessage').html(
										'operation failed! Error...<br/>'
												+ resp.result.resultMessage
														.toString());
								$('#successmessage').html('');
								$('#apiResults').html('');
							} else {
								$('#successmessage').html(
										'operation successful... <br/>'
												+ resp.result.resultMessage
														.toString());
								$('#errormessage').html('');
								$('#apiResults').html('');
							}
						} else {
							$('#errormessage').html(
									'operation failed! Error...<br/>'
											+ resp.result.resultMessage
													.toString());
							$('#successmessage').html('');
							$('#apiResults').html('');
						}

					},
					function(reason) {
						console.log('Error: ' + reason.result.error.message);
						$('#errormessage').html(
								'operation failed! Error...<br/>'
										+ reason.result.error.message);
						$('#successmessage').html('');
						$('#apiResults').html('');
					});

}

fanikiwa.userprofileendpoint.changePassword = function() {

	errormsg = '';
	ClearException();
	errormsg += '<ul id="errorList">';
	var error_free = true;

	$('#apiResults').html('');
	$('#successmessage').html('');
	$('#errormessage').html('');

	// Validate the entries
	var email = JSON.parse(sessionStorage.getItem('loggedinuser')).userId;
	var _newpassword = document.getElementById('txtnewpassword').value;
	var _confirmpassword = document.getElementById('txtconfirmpassword').value;
	var _changepasswordtoken = document
			.getElementById('txtchangepasswordtoken').value;

	if (_newpassword.length == 0) {
		errormsg += '<li>' + " New Password cannot be null " + '</li>';
		error_free = false;
	}
	if (_confirmpassword.length == 0) {
		errormsg += '<li>' + " Confirm Password cannot be null " + '</li>';
		error_free = false;
	}
	if (_newpassword != _confirmpassword) {
		errormsg += '<li>' + " Confirm Password does not match New Password "
				+ '</li>';
		error_free = false;
	}
	if (_changepasswordtoken.length == 0) {
		errormsg += '<li>' + " Change Password Token cannot be null " + '</li>';
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

	$('#apiResults').html('processing...');
	$('#successmessage').html('');
	$('#errormessage').html('');

	gapi.client.userprofileendpoint
			.changePassword({
				'userId' : email,
				'pwd' : _newpassword
			})
			.execute(
					function(resp) {
						console.log('response =>> ' + resp);
						if (!resp.code) {
							if (resp.result.success == false) {
								$('#errormessage').html(
										'operation failed! Error...<br/>'
												+ resp.result.resultMessage
														.toString());
								$('#successmessage').html('');
								$('#apiResults').html('');
							} else {
								$('#successmessage').html(
										'operation successful... <br/>'
												+ resp.result.resultMessage
														.toString());
								$('#errormessage').html('');
								$('#apiResults').html('');
								sessionStorage.clear();
								window
										.setTimeout(
												'window.location.href = "/Views/Account/Login.html";',
												1000);
							}
						} else {
							$('#errormessage').html(
									'operation failed! Error...<br/>'
											+ resp.result.resultMessage
													.toString());
							$('#successmessage').html('');
							$('#apiResults').html('');
						}

					},
					function(reason) {
						console.log('Error: ' + reason.result.error.message);
						$('#errormessage').html(
								'operation failed! Error...<br/>'
										+ reason.result.error.message);
						$('#successmessage').html('');
						$('#apiResults').html('');
					});

};

/**
 * Enables the button callbacks in the UI.
 */
fanikiwa.userprofileendpoint.changePassword.enableButtons = function() {
	$("#btnSubmit").removeAttr('style');
	$("#btnSubmit").removeAttr('disabled');
	$("#btnSubmit").val('Change Password');
	var btnSubmit = document.querySelector('#btnSubmit');
	btnSubmit.addEventListener('click', function() {
		fanikiwa.userprofileendpoint.changePassword();
	});

	$("#btnRequest").removeAttr('style');
	$("#btnRequest").removeAttr('disabled');
	$("#btnRequest").val('Request for a new Token');
	var btnRequest = document.querySelector('#btnRequest');
	btnRequest.addEventListener('click', function() {
		fanikiwa.userprofileendpoint.requesttoken();
	});

};

/**
 * Initializes the application.
 * 
 * @param {string}
 *            apiRoot Root of the API's path.
 */
fanikiwa.userprofileendpoint.changePassword.init = function(apiRoot) {
	// Loads the APIs asynchronously, and triggers callback
	// when they have completed.
	var apisToLoad;
	var callback = function() {
		if (--apisToLoad == 0) {
			fanikiwa.userprofileendpoint.changePassword.enableButtons();
		}
	}

	apisToLoad = 1; // must match number of calls to gapi.client.load()
	gapi.client.load('userprofileendpoint', 'v1', callback, apiRoot);

};

function ClearException() {
	$('#errorList').remove();
	$('#error-display-div').empty();
}

function CreateSubMenu() {
	var SubMenu = [];
	SubMenu.push('<div class="nav"><ul class="menu">');
	SubMenu
			.push('<li><div class="floatleft"><div><a href="/Views/LendingGroups/List.html" style="cursor: pointer;">My groups</a></div></div></li>');
	SubMenu
			.push('<li><div class="floatleft"><div><a href="/Views/Account/ChangePassword.html" style="cursor: pointer;">Change Password</a></div></div></li>');
	SubMenu
			.push('<li><div class="floatleft"><div><a href="/Views/Account/DeRegister.html" style="cursor: pointer;">Deregister</a></div></div></li>');
	SubMenu.push('</ul></div>');

	$("#SubMenu").html(SubMenu.join(" "));
}

$(document).ready(function() {
	CreateSubMenu();
});
