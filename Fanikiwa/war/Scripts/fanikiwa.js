//var ROOT ='https://1-dot-fanikiwaweb.appspot.com/_ah/api';
var ROOT = 'http://localhost:8888/_ah/api';
 
$(document).ready(function() { 
	$('#lnkloggedinuser').text(sessionStorage.getItem('loggedinuser'));
});

function LogOff() {
	sessionStorage.removeItem("loggedinuser");
	window.location.href = "/Views/Account/Login.html";
}

function ManageProfile() {
	window.location.href = "/Views/Account/EditProfile.html";
}

function LogIn() {
	window.location.href = "/Views/Account/Login.html";
}

function Register() {
	window.location.href = "/Views/Account/Register.html";
}
 
/**
 * @fileoverview
 * Provides methods for the Hello Endpoints sample UI and interaction with the
 * Hello Endpoints API.
 */

/** google global namespace for Google projects. */
var fanikiwa = fanikiwa || {}; 
fanikiwa.memberendpoint = fanikiwa.memberendpoint || {};
fanikiwa.memberendpoint.ui = fanikiwa.memberendpoint.ui || {};


fanikiwa.memberendpoint.ui.init = function(apiRoot) {
	// Loads the OAuth and helloworld APIs asynchronously, and triggers login
	// when they have completed.
	var apisToLoad;
	var callback = function() {
		if (--apisToLoad == 0) {
			$('document').ready(function(){				
				fanikiwa.memberendpoint.ui.initializeControls();	
			});
		}
	}

	apisToLoad = 1; // must match number of calls to gapi.client.load()
	gapi.client.load('memberendpoint', 'v1', callback, apiRoot);

};

fanikiwa.memberendpoint.ui.initializeControls = function() {

	var email = sessionStorage.getItem('loggedinuser');
	gapi.client.memberendpoint.getMemberByEmail({
		'email' : email
	}).execute(function(response) {
		console.log(response);
		if (!response.code) {
			fanikiwa.memberendpoint.ui.printLogin(response);
		} else {
			alert('Login failed! Please check your username and password');
		}  
	}, function(reason) {
		console.log('Error: ' + reason.result.error.message);
	});
}

fanikiwa.memberendpoint.ui.printLogin = function(response) {

	sessionStorage.surname = response.result.surname;
	console.log('response = ' + response.toString());
	fanikiwa.memberendpoint.ui.populateControls(response);

};

fanikiwa.memberendpoint.ui.populateControls = function(member) {
	document.getElementById('txtEmail').value = member.result.email;
	document.getElementById('txtSurname').value = member.result.surname;
	document.getElementById('txtOtherNames').value = member.result.otherNames;
	document.getElementById('txtTelephone').value = member.result.telephone;
	document.getElementById('txtNationalID').value = member.result.nationalID;
	document.getElementById('dtpDateOfBirth').value = member.result.dateOfBirth;
	document.getElementById('txtRefferedBy').value = member.result.refferedBy;
	document.getElementById('txtMaxRecordsToDisplay').value = member.result.maxRecordsToDisplay;
	document.getElementById('cboGender').value = member.result.gender;
	document.getElementById('cboInformBy').value = member.result.informBy;
};







