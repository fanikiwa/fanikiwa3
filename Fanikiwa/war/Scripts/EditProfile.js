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
	var _Surname = document.getElementById('txtSurname').value;
	var _OtherNames = document.getElementById('txtOtherNames').value;
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
	$('#successmessage').html('');
	$('#errormessage').html('');

	// Build the Request Object
	var member = {};
	member.memberId = sessionStorage.getItem("profilememberId");
	member.surname = _Surname;
	member.otherNames = _OtherNames;
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
								window
										.setTimeout(
												'window.location.href = "/Views/Account/EditProfile.html";',
												5000);
							}

						} else {
							console.log('Error: ' + resp.error.message);
							$('#errormessage').html(
									'operation failed! Error...<br/>'
											+ resp.error.message.toString());
							$('#successmessage').html('');
							$('#apiResults').html('');
						}

					},
					function(reason) {
						console.log('Error: ' + reason.result.error.message);
						$('#errormessage').html(
								'operation failed! Error...<br/>'
										+ reason.result.error.message
												.toString());
						$('#successmessage').html('');
						$('#apiResults').html('');
					});
};

/**
 * Enables the button callbacks in the UI.
 */
fanikiwa.memberendpoint.profile.enableButtons = function() {
	$("#btnUpdate").removeAttr('style');
	$("#btnUpdate").removeAttr('disabled');
	$("#btnUpdate").val('Update');
	var btnRegister = document.querySelector('#btnUpdate');
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
	})
			.execute(
					function(resp) {
						console.log(resp);
						if (!resp.code) {
							if (resp.result.result == false) {
								$('#errormessage').html(
										'operation failed! Error...<br/>'
												+ resp.result.resultMessage
														.toString());
								$('#successmessage').html('');
								$('#apiResults').html('');
							} else {
								fanikiwa.memberendpoint.profile
										.populateControls(resp);
								$('#successmessage').html('');
								$('#errormessage').html('');
								$('#apiResults').html('');
							}
						} else {
							console.log('Error: ' + resp.error.message);
							$('#errormessage').html(
									'operation failed! Error...<br/>'
											+ resp.error.message.toString());
							$('#successmessage').html('');
							$('#apiResults').html('');
						}
					},
					function(reason) {
						console.log('Error: ' + reason.result.error.message);
						$('#errormessage').html(
								'operation failed! Error...<br/>'
										+ reason.result.error.message
												.toString());
						$('#successmessage').html('');
						$('#apiResults').html('');
					});
}

fanikiwa.memberendpoint.profile.populateControls = function(member) {
	sessionStorage.profilememberId = member.memberId;

	if (member.email != undefined)
		document.getElementById('txtEmail').value = member.email;
	else {
		document.getElementById('txtEmail').value = "";
	}
	if (member.surname != undefined)
		document.getElementById('txtSurname').value = member.surname;
	else {
		document.getElementById('txtSurname').value = "";
	}
	if (member.otherNames != undefined)
		document.getElementById('txtOtherNames').value = member.otherNames;
	else {
		document.getElementById('txtOtherNames').value = "";
	}
	if (member.telephone != undefined)
		document.getElementById('txtTelephone').value = member.telephone;
	else {
		document.getElementById('txtTelephone').value = "";
	}
	if (member.nationalID != undefined)
		document.getElementById('txtNationalID').value = member.nationalID;
	else {
		document.getElementById('txtNationalID').value = "";
	}
	if (member.dateOfBirth != undefined)
		document.getElementById('dtpDateOfBirth').value = formatDateForControl(member.dateOfBirth);
	else {
		document.getElementById('dtpDateOfBirth').value = decrementDateByYear(
				new Date(), -18, 'y');
	}
	document.getElementById('txtRefferedBy').value = member.refferedBy;
	document.getElementById('txtMaxRecordsToDisplay').value = member.maxRecordsToDisplay;
	document.getElementById('cboGender').value = member.gender;
	if (member.result.informBy != undefined)
		document.getElementById('cboInformBy').value = member.informBy;
	else
		document.getElementById('cboInformBy').value = "EMAIL";
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
