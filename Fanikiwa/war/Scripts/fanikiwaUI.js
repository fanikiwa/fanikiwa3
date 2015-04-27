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

	sessionStorage.loggedinuser = loginResponse.result.userId;
	console.log('response = ' + loginResponse.toString());
	window.location.href = "/Views/Home/Index.html";

};

/**
 * Gets a numbered greeting via the API.
 * 
 * @param {string}
 *            id ID of the greeting.
 */
fanikiwa.userprofile.ui.login = function() {
	var email = document.querySelector('#txtEmail').value;
	var pwd = document.querySelector('#txtPassword').value;
	gapi.client.userprofileendpoint.login({
		'userId' : email,
		'pwd' : pwd
	}).execute(function(resp) {
		console.log('response =>> ' + resp);
		if (!resp.code) {
			fanikiwa.userprofile.ui.printLogin(resp);
		} else {
			alert('Login failed! Please check your username and password');
		}

	}, function(reason) {
		console.log('Error: ' + reason.result.error.message);
	});

	//	
	// .execute(function(resp) {
	// if (!resp.code) {
	// fanikiwa.userprofile.ui.printLogin(resp);
	// }
	// });
};

/**
 * Enables the button callbacks in the UI.
 */
fanikiwa.userprofile.ui.enableButtons = function() {
	var getLogin = document.querySelector('#btnLogin');
	getLogin.addEventListener('click', function() {
		fanikiwa.userprofile.ui.login();
	});
	// getLogin.value = 'Login Enabled';
};

/**
 * Initializes the application.
 * 
 * @param {string}
 *            apiRoot Root of the API's path.
 */
fanikiwa.userprofile.ui.init = function(apiRoot) {
	// Loads the OAuth and helloworld APIs asynchronously, and triggers login
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
