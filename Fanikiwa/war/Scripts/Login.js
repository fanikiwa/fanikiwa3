/**
 * @fileoverview
 * Provides methods for the Hello Endpoints sample UI and interaction with the
 * Hello Endpoints API.
 */

/** google global namespace for Google projects. */
var fanikiwa = fanikiwa || {};
// fanikiwa.appengine = com.sp.fanikiwa.api || {};
fanikiwa.userprofile = fanikiwa.userprofile || {};
fanikiwa.userprofile.ui = fanikiwa.userprofile.ui || {};

/**
 * Prints a greeting to the greeting log. param {Object} greeting Greeting to
 * print.
 */
fanikiwa.userprofile.ui.printLogin = function(loginResponse) {

	if (loginResponse.result.userId == undefined
			|| loginResponse.result.userId == null) {
		$('#apiResults').html(
				'Login failed! Please check your username and password');
	} else {
		$('#apiResults').html('Login successful...');
		sessionStorage.loggedinuser = loginResponse.result.userId;
		console.log('response = ' + loginResponse.toString());
		window.setTimeout(
				'window.location.href = "/Views/Offers/ListMyOffers.html";',
				1000);
	}
};

/**
 * call login via the API.
 * 
 * @param {string}
 *            userId, {string} pwd email of registerd member. password of
 *            registerd member.
 */

var errormsg = '';
errormsg += '<ul id="errorList">';

fanikiwa.userprofile.ui.login = function() {

	errormsg = '';
	ClearException();
	errormsg += '<ul id="errorList">';
	var error_free = true;
	$('#apiResults').html('');

	// Validate the entries
	var email = document.querySelector('#txtEmail').value;
	var pwd = document.querySelector('#txtPassword').value;

	if (email.length == 0) {
		errormsg += '<li>' + " Email cannot be null " + '</li>';
		error_free = false;
	}
	if (pwd.length == 0) {
		errormsg += '<li>' + " Password cannot be null " + '</li>';
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

	$('#apiResults').html('authenticating...');

	gapi.client.userprofileendpoint
			.login({
				'userId' : email,
				'pwd' : pwd
			})
			.execute(
					function(resp) {
						console.log('response =>> ' + resp);
						if (!resp.code) {
							fanikiwa.userprofile.ui.printLogin(resp);
						} else {
							$('#apiResults')
									.html(
											'Login failed! Please check your username and password');
						}

					}, function(reason) {
						console.log('Error: ' + reason.result.error.message);
					});

};

/**
 * Enables the button callbacks in the UI.
 */
fanikiwa.userprofile.ui.enableButtons = function() {
	$("#btnLogin").removeAttr('style');
	$("#btnLogin").removeAttr('disabled');
	$("#btnLogin").val('Login');
	var btnLogin = document.querySelector('#btnLogin');
	btnLogin.addEventListener('click', function() {
		fanikiwa.userprofile.ui.login();
	});
};

/**
 * Initializes the application.
 * 
 * @param {string}
 *            apiRoot Root of the API's path.
 */
fanikiwa.userprofile.ui.init = function(apiRoot) {
	// Loads the APIs asynchronously, and triggers callback
	// when they have completed.
	var apisToLoad;
	var callback = function() {
		if (--apisToLoad == 0) {
			fanikiwa.userprofile.ui.enableButtons();
		}
	}

	apisToLoad = 1; // must match number of calls to gapi.client.load()
	gapi.client.load('userprofileendpoint', 'v1', callback, apiRoot);

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
