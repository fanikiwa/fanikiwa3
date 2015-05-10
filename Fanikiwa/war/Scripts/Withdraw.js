/**
 * @fileoverview
 * Provides methods for the  Endpoints UI and interaction with the
 * Endpoints API.
 */

/** global namespace for projects. */
var fanikiwa = fanikiwa || {};
fanikiwa.accountendpoint = fanikiwa.accountendpoint || {};
fanikiwa.accountendpoint.withdraw = fanikiwa.accountendpoint.withdraw || {};

fanikiwa.accountendpoint.withdraw.enableButtons = function() {
	$("#btnWithdraw").removeAttr('style');
	$("#btnWithdraw").removeAttr('disabled');
	$("#btnWithdraw").val('Earn my Money Back');
	var btnWithdraw = document.querySelector('#btnWithdraw');
	btnWithdraw.addEventListener('click', function() {
		fanikiwa.accountendpoint.withdraw.memberWithdraw();
	}); 
};

var errormsg = '';
errormsg += '<ul id="errorList">';

fanikiwa.accountendpoint.withdraw.memberWithdraw = function() {

	errormsg = '';
	$('#errorList').remove();
	$('#error-display-div').empty();
	errormsg += '<ul id="errorList">';
	var error_free = true;

	var amount = document.getElementById('txtAmount').value; 
	var email = sessionStorage.getItem('loggedinuser');

	if (amount.length == 0) {
		errormsg += '<li>' + " Amount cannot be null " + '</li>';
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
		$('#errorList').remove();
		$('#error-display-div').empty();
	}

	$('#apiResults').html('processing...');

	gapi.client.accountendpoint.memberWithdraw({
		'email' : email,
		'amount' : amount 
	}).execute(
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
										'$('#successmessage').html('');',
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
 * Initializes the application.
 * 
 * @param {string}
 *            apiRoot Root of the API's path.
 */
fanikiwa.accountendpoint.withdraw.init = function(apiRoot) {
	// Loads the APIs asynchronously, and triggers callback
	// when they have completed.
	var apisToLoad;
	var callback = function() {
		if (--apisToLoad == 0) {
			fanikiwa.accountendpoint.withdraw.enableButtons(); 
		}
	}

	apisToLoad = 1; // must match number of calls to gapi.client.load()
	gapi.client.load('accountendpoint', 'v1', callback, apiRoot); 

};