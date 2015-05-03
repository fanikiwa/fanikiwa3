/**
 * @fileoverview
 * Provides methods for the Endpoints UI and interaction with the
 * Endpoints API.
 */

/** global namespace for projects. */
var fanikiwa = fanikiwa || {};
fanikiwa.memberendpoint = fanikiwa.memberendpoint || {};
fanikiwa.memberendpoint.register = fanikiwa.memberendpoint.register || {};

var errormsg = '';
errormsg += '<ul id="errorList">';

fanikiwa.memberendpoint.register = function() {

	errormsg = '';
	ClearException();
	errormsg += '<ul id="errorList">';
	var error_free = true;
	$('#apiResults').html('');

	// Validate the entries
	var _Email = document.getElementById('txtEmail').value;
	var _Pwd = document.getElementById('txtPassword').value;
	var _Surname = document.getElementById('txtSurname').value;
	var _Telephone = document.getElementById('txtTelephone').value;

	if (_Email.length != 0) {
		var validatedemail = gapi.client.memberendpoint.isEmailValid({
			'email' : _Email
		}).execute(function(resp) {
			if (!resp.code) {
				if (resp == false || resp.result.result == false) {
					sessionStorage.isemailvalidinregister = false;
				} else {
					sessionStorage.isemailvalidinregister = true;
				}
			} else {
				sessionStorage.isemailvalidinregister = false;
			}
		}, function(reason) {
			console.log('Error: ' + reason.result.error.message);
		});
	}

	if (_Email.length == 0) {
		errormsg += '<li>' + " Email cannot be null " + '</li>';
		error_free = false;
	}
	if (_Email.length != 0 && sessionStorage.isemailvalidinregister === "false") {
		errormsg += '<li>' + " Validation failed! Please check Email.<br/> "
		+ "Valid format is user@domain.com"
				+ '</li>';
		error_free = false;
	}
	if (_Pwd.length == 0) {
		errormsg += '<li>' + " Password cannot be null " + '</li>';
		error_free = false;
	}
	if (_Surname.length == 0) {
		errormsg += '<li>' + " Surname cannot be null " + '</li>';
		error_free = false;
	}
	if (_Telephone.length == 0) {
		errormsg += '<li>' + " Telephone cannot be null " + '</li>';
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

	$('#apiResults').html('registering...');

	// Build the Request Object
	var memberDTO = {};
	memberDTO.email = _Email;
	memberDTO.pwd = _Pwd;
	memberDTO.surname = _Surname;
	memberDTO.telephone = _Telephone;

	gapi.client.memberendpoint
			.register(memberDTO)
			.execute(
					function(resp) {
						console.log('response =>> ' + resp);
						if (!resp.code) {
							if (resp.result.memberId == undefined
									|| resp.result.memberId == null) {
								$('#apiResults')
										.html(
												'Registration failed! Please try again');
							} else {
								$('#apiResults')
										.html(
												'Registration successful... <br/>'
														+ 'Member id = '
														+ resp.result.memberId
														+ '<br/>redirecting to login...');
								sessionStorage.registermemberId = resp.result.memberId;
								window
										.setTimeout(
												'window.location.href = "/Views/Account/Login.html";',
												1000);
							}

						} else {
							$('#apiResults').html(
									'Registration failed! Please try again');
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
fanikiwa.memberendpoint.register.init = function(apiRoot) {
	// Loads the APIs asynchronously, and triggers callback
	// when they have completed.
	var apisToLoad;
	var callback = function() {
		if (--apisToLoad == 0) {
			fanikiwa.memberendpoint.register.enableButtons();
		}
	}

	apisToLoad = 1; // must match number of calls to gapi.client.load()
	gapi.client.load('memberendpoint', 'v1', callback, apiRoot);

};

/**
 * Enables the button callbacks in the UI.
 */
fanikiwa.memberendpoint.register.enableButtons = function() {
	$("#btnRegister").removeAttr('style');
	$("#btnRegister").removeAttr('disabled');
	$("#btnRegister").val('Register');
	var btnRegister = document.querySelector('#btnRegister');
	btnRegister.addEventListener('click', function() {
		fanikiwa.memberendpoint.register();
	});
	var txtEmail = document.querySelector('#txtEmail');
	txtEmail.addEventListener('change', function() {
		var email = document.getElementById('txtEmail').value;
		fanikiwa.memberendpoint.isEmailValid(email);
	});
};

fanikiwa.memberendpoint.isEmailValid = function(email) {
	$('#apiResults').html('authenticating email...');
	gapi.client.memberendpoint
			.isEmailValid({
				'email' : email
			})
			.execute(
					function(resp) {
						console.log('response =>> ' + resp);
						if (!resp.code) {
							if (resp.result.result == false) {
								$('#apiResults')
										.html(
												'Validation failed! Please check Email.<br/>'
												+ 'Valid format is user@domain.com');
								sessionStorage.isemailvalidinregister = false;
							} else {

								sessionStorage.isemailvalidinregister = true;
								$('#apiResults').html(
										'email validation successful...');
								window.setTimeout('$("#apiResults").html("");',
										1000);
							}
						} else {
							$('#apiResults')
									.html(
											'Validation failed! Please check Email.<br/>'
											+ 'Valid format is user@domain.com');
							sessionStorage.isemailvalidinregister = false;
						}

					},
					function(reason) {
						console.log('Error: ' + reason.result.error.message);
						$('#apiResults').html(
								'Error: ' + reason.result.error.message);
						sessionStorage.isemailvalidinregister = false;
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
