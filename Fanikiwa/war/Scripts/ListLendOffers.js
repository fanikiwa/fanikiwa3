/**
 * @fileoverview
 * Provides methods for the  Endpoints UI and interaction with the
 * Endpoints API.
 */

/** global namespace for projects. */
var fanikiwa = fanikiwa || {};
fanikiwa.offerendpoint = fanikiwa.offerendpoint || {};
fanikiwa.offerendpoint.listlendoffers = fanikiwa.offerendpoint.listlendoffers
		|| {};

fanikiwa.offerendpoint.listlendoffers.LoadOffers = function() {

	$('#listOffersResult').html('loading...');

	var email = sessionStorage.getItem('loggedinuser');

	gapi.client.offerendpoint.retrieveLendOffers({
		'email' : email
	}).execute(function(resp) {
		console.log('response =>> ' + resp);
		if (!resp.code) {
			if (resp.result.items == undefined || resp.result.items == null) {
				$('#listOffersResult').html('You have no Offers...');
			} else {
				buildTable(resp);
			}
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
fanikiwa.offerendpoint.listlendoffers.init = function(apiRoot) {
	// Loads the APIs asynchronously, and triggers callback
	// when they have completed.
	var apisToLoad;
	var callback = function() {
		if (--apisToLoad == 0) {
			fanikiwa.offerendpoint.listlendoffers.LoadOffers();
		}
	}

	apisToLoad = 1; // must match number of calls to gapi.client.load()
	gapi.client.load('offerendpoint', 'v1', callback, apiRoot);

};

var offerTable = '';
function buildTable(response) {

	offerTable = '';

	populateOffers(response);

	$("#listOffersResult").html(offerTable);
}

function populateOffers(resp) {

	if (!resp.code) {
		resp.items = resp.items || [];

		offerTable += '<table id="listOffersTable">';
		offerTable += "<thead>";
		offerTable += "<tr>";
		offerTable += "<th>Description</th>";
		offerTable += "<th>Amount</th>";
		offerTable += "<th>Term</th>";
		offerTable += "<th>Interest</th>";
		offerTable += "<th>Public Offer</th>";
		offerTable += "<th>Partial Pay</th>";
		offerTable += "<th>Status</th>";
		offerTable += "<th></th>";
		offerTable += "</tr>";
		offerTable += "</thead>";
		offerTable += "<tbody>";

		for (var i = 0; i < resp.result.items.length; i++) {
			offerTable += '<tr>';
			offerTable += '<td>' + resp.result.items[i].description + '</td>';
			offerTable += '<td>' + resp.result.items[i].amount.formatMoney(2) + '</td>';
			offerTable += '<td>' + resp.result.items[i].term + '</td>';
			offerTable += '<td>' + resp.result.items[i].interest + '</td>';
			offerTable += '<td>' + resp.result.items[i].publicOffer + '</td>';
			offerTable += '<td>' + resp.result.items[i].partialPay + '</td>';
			offerTable += '<td>' + resp.result.items[i].status + '</td>';
			offerTable += '<td><a href="#" onclick="Accept('
					+ resp.result.items[i].id + ')">Accept</a> </td>';
			offerTable += "</tr>";
		}

		offerTable += "</tbody>";
		offerTable += "</table>";

	}
}

function Accept(id) {
	$('#apiResults').html('processing...');
	var email = sessionStorage.getItem('loggedinuser');
	gapi.client.offerendpoint
			.acceptOffer({
				'id' : id,
				'email' : email
			})
			.execute(
					function(resp) {
						if (!resp.code) {
							if (resp.result.result == false) {
								$('#apiResults').html(
										'operation failed! Error...<br/>'
												+ resp.result.resultMessage
														.toString());
							} else {
								$('#apiResults').html(
										'operation successful... <br/>'
												+ resp.result.resultMessage
														.toString());
								sessionStorage.acceptlendofferId = resp.result.id;
								window
										.setTimeout(
												'window.location.href = "/Views/Offers/ListLendOffers.html";',
												3000);
							}
						} else {
							$('#apiResults').html(
									'operation failed! Please try again');
						}
					});
}
