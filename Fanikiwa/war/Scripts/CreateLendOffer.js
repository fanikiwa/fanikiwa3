/**
 * @fileoverview
 * Provides methods for the Endpoints UI and interaction with the
 * Endpoints API.
 */

/** global namespace for projects. */
var fanikiwa = fanikiwa || {};
fanikiwa.offerendpoint = fanikiwa.offerendpoint || {};
fanikiwa.offerendpoint.createlendoffer = fanikiwa.offerendpoint.createlendoffer
		|| {};

var errormsg = '';
errormsg += '<ul id="errorList">';

fanikiwa.offerendpoint.createlendoffer = function() {

	errormsg = '';
	ClearException();
	errormsg += '<ul id="errorList">';
	var error_free = true;
	$('#apiResults').html('');

	// Validate the entries
	var _Description = document.getElementById('txtDescription').value;
	var _Amount = document.getElementById('txtAmount').value;
	var _Interest = document.getElementById('txtInterest').value;
	var _Term = document.getElementById('txtTerm').value;
	var _OfferType = document.getElementById('cboOfferType').value;
	var _PublicOffer = Boolean(document.getElementById('chkPublicOffer').checked); 
	var _offerees = document.getElementById('txtofferees').value;

	if (_Description.length == 0) {
		errormsg += '<li>' + " Description cannot be null " + '</li>';
		error_free = false;
	}
	if (_Amount.length == 0) {
		errormsg += '<li>' + " Amount cannot be null " + '</li>';
		error_free = false;
	}
	if (_Interest.length == 0) {
		errormsg += '<li>' + " Interest Rate(%) cannot be null " + '</li>';
		error_free = false;
	}
	if (_Term.length == 0) {
		errormsg += '<li>' + " Term in Month cannot be null " + '</li>';
		error_free = false;
	}
	if (_PublicOffer == true && _offerees.length == 0) {
		errormsg += '<li>' + " Offerees cannot be null for a private offer"
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

	$('#apiResults').html('creating offer...');
	$('#successmessage').html('');
	$('#errormessage').html('');

	var email = sessionStorage.getItem('loggedinuser');

	// Build the Request Object
	var OfferDTO = {};
	OfferDTO.description = _Description;
	OfferDTO.amount = _Amount;
	OfferDTO.interest = _Interest;
	OfferDTO.term = _Term;
	OfferDTO.privateOffer = _PublicOffer;
	OfferDTO.offerType = _OfferType;
	OfferDTO.partialPay = false;
	OfferDTO.status = "Open";
	OfferDTO.email = email;
	OfferDTO.offerees = _offerees;

	gapi.client.offerendpoint
			.saveOffer(OfferDTO)
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
												'window.location.href = "/Views/Offers/ListBorrowOffers.html";',
												1000);
							}
						} else {
							$('#errormessage').html(
									'operation failed! Please try again.');
							$('#successmessage').html('');
							$('#apiResults').html('');
						}

					}, function(reason) {
						console.log('Error: ' + reason.result.error.message);
					});
};

/**
 * Enables the button callbacks in the UI.
 */
fanikiwa.offerendpoint.createlendoffer.enableButtons = function() {
	$("#btnCreate").removeAttr('style');
	$("#btnCreate").removeAttr('disabled');
	$("#btnCreate").val('Create');
	var btnRegister = document.querySelector('#btnCreate');
	btnRegister.addEventListener('click', function() {
		fanikiwa.offerendpoint.createlendoffer();
	});
	$("#chkPublicOffer").attr('checked', false);
};

/**
 * Initializes the application.
 * 
 * @param {string}
 *            apiRoot Root of the API's path.
 */
fanikiwa.offerendpoint.createlendoffer.init = function(apiRoot) {
	// Loads the APIs asynchronously, and triggers callback
	// when they have completed.
	var apisToLoad;
	var callback = function() {
		if (--apisToLoad == 0) {
			fanikiwa.offerendpoint.createlendoffer.enableButtons();
		}
	}

	apisToLoad = 1; // must match number of calls to gapi.client.load()
	gapi.client.load('offerendpoint', 'v1', callback, apiRoot);

};

function Clear() {
	$("#txtDescription").val("");
	$("#txtAmount").val("");
	$("#txtInterest").val("");
	$("#txtTerm").val("");
	$("#txtofferees").val("");
	$("#cboOfferType").val("L");
	$("#chkPublicOffer").attr('checked', false); 
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