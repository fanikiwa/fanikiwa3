/**
 * @fileoverview
 * Provides methods for the Hello Endpoints sample UI and interaction with the
 * Hello Endpoints API.
 */

/** google global namespace for Google projects. */
var fanikiwa = fanikiwa || {};
// fanikiwa.appengine = com.sp.fanikiwa.api || {};
fanikiwa.userprofile = fanikiwa.userprofile || {};
fanikiwa.userprofile.changePassword = fanikiwa.userprofile.changePassword || {};

var errormsg = '';
errormsg += '<ul id="errorList">';

fanikiwa.userprofile.changePassword = function() {

	errormsg = '';
	ClearException();
	errormsg += '<ul id="errorList">';
	var error_free = true;
	$('#apiResults').html('');

	var email = sessionStorage.getItem('loggedinuser');

	// Validate the entries
	var _OldPassword = document.getElementById('txtOldPassword').value;
	var _NewPassword = document.getElementById('txtNewPassword').value;
	var _ConfirmPassword = document.getElementById('txtConfirmPassword').value;

	var AuthenticatedUser = gapi.client.userprofileendpoint
			.login({
				'userId' : email,
				'pwd' : _OldPassword
			})
			.execute(
					function(resp) {
						if (!resp.code) {
							if (resp = false || resp.result.userId == undefined
									|| resp.result.userId == null) {
								sessionStorage.isuserauthenticatedinchangepassword = false;
							} else {
								sessionStorage.isuserauthenticatedinchangepassword = true;
							}
						} else {
							sessionStorage.isuserauthenticatedinchangepassword = false;
						}
					}, function(reason) {
						console.log('Error: ' + reason.result.error.message);
					});

	if (_OldPassword.length == 0) {
		errormsg += '<li>' + " Old Password cannot be null " + '</li>';
		error_free = false;
	}
	if (sessionStorage.isuserauthenticatedinchangepassword == "false") {
		errormsg += '<li>'
				+ " Authentication failed! Please check Old Password "
				+ '</li>';
		error_free = false;
	}
	if (_NewPassword.length == 0) {
		errormsg += '<li>' + " New Password cannot be null " + '</li>';
		error_free = false;
	}
	if (_ConfirmPassword.length == 0) {
		errormsg += '<li>' + " Confirm Password cannot be null " + '</li>';
		error_free = false;
	}
	if (_NewPassword != _ConfirmPassword) {
		errormsg += '<li>' + " Confirm Password does not match New Password "
				+ '</li>';
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
				'pwd' : _NewPassword
			})
			.execute(
					function(resp) {
						console.log('response =>> ' + resp);
						if (!resp.code) {
							if (resp.result.result == false) {
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
							$('#errormessage')
									.html(
											'operation failed! Please check your password and try again.');
							$('#successmessage').html('');
							$('#apiResults').html('');
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
fanikiwa.userprofile.changePassword.init = function(apiRoot) {
	// Loads the APIs asynchronously, and triggers callback
	// when they have completed.
	var apisToLoad;
	var callback = function() {
		if (--apisToLoad == 0) {
			fanikiwa.userprofile.changePassword.enableButtons();
		}
	}

	apisToLoad = 1; // must match number of calls to gapi.client.load()
	gapi.client.load('userprofileendpoint', 'v1', callback, apiRoot);

};

/**
 * Enables the button callbacks in the UI.
 */
fanikiwa.userprofile.changePassword.enableButtons = function() {
	$("#btnChangePassword").removeAttr('style');
	$("#btnChangePassword").removeAttr('disabled');
	$("#btnChangePassword").val('Change Password');
	var getLogin = document.querySelector('#btnChangePassword');
	getLogin.addEventListener('click', function() {
		fanikiwa.userprofile.changePassword();
	});
	var txtOldPassword = document.querySelector('#txtOldPassword');
	txtOldPassword.addEventListener('change', function() {
		fanikiwa.userprofile.login();
	});
};

fanikiwa.userprofile.login = function() {

	$('#apiResults').html('authenticating old password...');
	var email = sessionStorage.getItem('loggedinuser');
	var pwd = document.getElementById('txtOldPassword').value;

	gapi.client.userprofileendpoint
			.login({
				'userId' : email,
				'pwd' : pwd
			})
			.execute(
					function(resp) {
						console.log('response =>> ' + resp);
						if (!resp.code) {
							if (resp.result.userId == undefined
									|| resp.result.userId == null) {
								$('#apiResults')
										.html(
												'authentication failed! Please check your password');
								sessionStorage.isuserauthenticatedinchangepassword = false;
							} else {
								$('#apiResults').html(
										'authentication successful... <br/>'
												+ 'userid id = '
												+ resp.result.userId);
								sessionStorage.isuserauthenticatedinchangepassword = true;
								window.setTimeout('$("#apiResults").html("");',
										1000);
							}

						} else {
							$('#apiResults')
									.html(
											'authentication failed! Please check your password');
							sessionStorage.isuserauthenticatedinchangepassword = false;
						}

					},
					function(reason) {
						console.log('Error: ' + reason.result.error.message);
						$('#apiResults').html(
								'Error: ' + reason.result.error.message);
					});

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
