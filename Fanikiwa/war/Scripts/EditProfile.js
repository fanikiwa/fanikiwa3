/**
 * @fileoverview
 * Provides methods for the Endpoints UI and interaction with the
 * Endpoints API.
 */

/** global namespace for projects. */
var fanikiwa = fanikiwa || {};
fanikiwa.memberendpoint = fanikiwa.memberendpoint || {};
fanikiwa.memberendpoint.profile = fanikiwa.memberendpoint.profile || {};

var errormsg = '';
errormsg += '<ul id="errorList">';

fanikiwa.memberendpoint.updateprofile = function() {

	errormsg = '';
	ClearException();
	errormsg += '<ul id="errorList">';
	var error_free = true;

	// Validate the entries
	var _Email = document.getElementById('txtEmail').value;
	var _Surname = document.getElementById('txtSurname').value;
	var _OtherNames = document.getElementById('txtOtherNames').value;
	var _Telephone = document.getElementById('txtTelephone').value;
	var _NationalID = document.getElementById('txtNationalID').value;
	var _DateOfBirth = document.getElementById('dtpDateOfBirth').value;
	var _RefferedBy = document.getElementById('txtRefferedBy').value;
	var _MaxRecordsToDisplay = document
			.getElementById('txtMaxRecordsToDisplay').value;
	var _Gender = document.getElementById('cboGender').value;
	var _InformBy = document.getElementById('cboInformBy').value;

	if (_Surname.length == 0) {
		errormsg += '<li>' + " Surname cannot be null " + '</li>';
		error_free = false;
	}
	if (_OtherNames.length == 0) {
		errormsg += '<li>' + " OtherNames cannot be null " + '</li>';
		error_free = false;
	}
	if (_Telephone.length == 0) {
		errormsg += '<li>' + " Telephone cannot be null " + '</li>';
		error_free = false;
	}
	if (_NationalID.length == 0) {
		errormsg += '<li>' + " NationalID cannot be null " + '</li>';
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

	$('#apiResults').html('updating profile...');

	// Build the Request Object
	var member = {};
	member.email = _Email;
	member.surname = _Surname;
	member.otherNames = _OtherNames;
	member.telephone = _Telephone;
	member.nationalID = _NationalID;
	member.dateOfBirth = _DateOfBirth;
	member.refferedBy = _RefferedBy;
	member.maxRecordsToDisplay = _MaxRecordsToDisplay;
	member.gender = _Gender;
	member.informBy = _InformBy;

	gapi.client.memberendpoint
			.updateMember(member)
			.execute(
					function(resp) {
						console.log('response =>> ' + resp);
						if (!resp.code) {
							$('#apiResults').html('operation successful...');
							sessionStorage.memberId = resp.result.memberId;
							window
									.setTimeout(
											'window.location.href = "/Views/Account/EditProfile.html";',
											3000);

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
fanikiwa.memberendpoint.profile.enableButtons = function() {
	var btnRegister = document.querySelector('#btnUpdate');
	$('#btnUpdate').removeClass('disabled');
	btnRegister.addEventListener('click', function() {
		fanikiwa.memberendpoint.updateprofile();
	});
};

/**
 * Initializes the application.
 * 
 * @param {string}
 *            apiRoot Root of the API's path.
 */
fanikiwa.memberendpoint.profile.init = function(apiRoot) {
	// Loads the APIs asynchronously, and triggers callback
	// when they have completed.
	var apisToLoad;
	var callback = function() {
		if (--apisToLoad == 0) {
			fanikiwa.memberendpoint.profile.enableButtons();
			fanikiwa.memberendpoint.profile.initializeControls();
		}
	}

	apisToLoad = 1; // must match number of calls to gapi.client.load()
	gapi.client.load('memberendpoint', 'v1', callback, apiRoot);

};

fanikiwa.memberendpoint.profile.initializeControls = function() {

	var email = sessionStorage.getItem('loggedinuser');
	gapi.client.memberendpoint.getMemberByEmail({
		'email' : email
	}).execute(function(response) {
		console.log(response);
		if (!response.code) {
			fanikiwa.memberendpoint.profile.printLogin(response);
		} else {
			alert('Error retrieving member info! Try refreshing...');
		}
	}, function(reason) {
		console.log('Error: ' + reason.result.error.message);
	});
}

fanikiwa.memberendpoint.profile.printLogin = function(response) {
	if (response.result.memberId == undefined
			|| response.result.memberId == null) {
		$('#apiResults')
				.html('Error retrieving member info! Try refreshing...');
	} else {
		sessionStorage.profilesurname = response.result.surname;
		sessionStorage.profilememberId = response.result.memberId;
		console.log('response = ' + response.toString());
		fanikiwa.memberendpoint.profile.populateControls(response);
	}
};

fanikiwa.memberendpoint.profile.populateControls = function(member) {
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

function Clear() {
	$("#txtEmail").val("");
	$("#txtSurname").val("");
	$("#txtOtherNames").val("");
	$("#txtTelephone").val("");
	$("#txtNationalID").val("");
	$("#dtpDateOfBirth").val("");
	$("#txtRefferedBy").val("");
	$("#txtMaxRecordsToDisplay").val("");
	$("#cboGender").val("-1");
	$("#cboInformBy").val("-1");
}

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
