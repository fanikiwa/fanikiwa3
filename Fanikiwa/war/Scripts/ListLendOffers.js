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

	$('.page-title').html('Private Lend Offers');
	$('#listOffersResult').html('loading...');
	$('#apiResults').html('');
	$('#successmessage').html('');
	$('#errormessage').html('');

	var email = JSON.parse(sessionStorage.getItem('loggedinuser')).userId;

	gapi.client.offerendpoint.retrieveLendOffers({
		'email' : email
	}).execute(
			function(resp) {
				console.log('response =>> ' + resp);
				if (!resp.code) {
					if (resp.result.items == undefined
							|| resp.result.items == null) {
						$('#listOffersResult').html(
								'You have no private lend Offers...');
					} else {
						buildTable(resp);
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
								+ reason.result.error.message);
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

	$('#listOffersTable').DataTable(
			{
				"aLengthMenu" : [ [ 5, 10, 20, 50, 100, -1 ],
						[ 5, 10, 20, 50, 100, "All" ] ],
				"iDisplayLength" : 5
			});

}

function populateOffers(resp) {

	if (!resp.code) {
		resp.items = resp.items || [];
		var recordscount = 0;

		offerTable += '<table id="listOffersTable">';
		offerTable += "<thead>";
		offerTable += "<tr>";
		offerTable += "<th>Description</th>";
		offerTable += "<th>Amount</th>";
		offerTable += "<th>Term</th>";
		offerTable += "<th>Interest</th>";
		offerTable += "<th>Private Offer</th>";
		offerTable += "<th>Partial Pay</th>";
		offerTable += "<th>Expiry Date</th>";
		offerTable += "<th></th>";
		offerTable += "<th></th>";
		offerTable += "</tr>";
		offerTable += "</thead>";
		offerTable += "<tbody>";

		for (var i = 0; i < resp.result.items.length; i++) {
			var expiryDate = new Date(resp.result.items[i].expiryDate);
			var today = new Date();
			if (resp.result.items[i].status == 'Open' && expiryDate > today) {
				offerTable += '<tr>';
				offerTable += '<td>' + resp.result.items[i].description
						+ '</td>';
				offerTable += '<td>'
						+ resp.result.items[i].amount.formatMoney(2) + '</td>';
				offerTable += '<td>' + resp.result.items[i].term + '</td>';
				offerTable += '<td>' + resp.result.items[i].interest + '</td>';
				offerTable += '<td>' + resp.result.items[i].privateOffer
						+ '</td>';
				offerTable += '<td>' + resp.result.items[i].partialPay
						+ '</td>';
				offerTable += '<td>'
						+ formatDate(resp.result.items[i].expiryDate) + '</td>';
				offerTable += '<td><a href="#" onclick="Accept('
						+ resp.result.items[i].id + ')">Accept</a> </td>';
				offerTable += '<td><a href="#" onclick="OfferDetails('
						+ resp.result.items[i].id + ')">Details</a> </td>';
				offerTable += "</tr>";
				recordscount += 1;
			}
		}

		offerTable += "</tbody>";
		offerTable += "</table>";
		$(".page-title").append("  [" + recordscount + "] ");
	}
}

function OfferDetails(id) {
	sessionStorage.offerdetailsid = id;
	window.location.href = "/Views/Offers/Details.html";
}

function Accept(id) {

	$('#apiResults').html('processing...');
	$('#successmessage').html('');
	$('#errormessage').html('');

	var email = JSON.parse(sessionStorage.getItem('loggedinuser')).userId;
	gapi.client.offerendpoint
			.acceptOffer({
				'id' : id,
				'email' : email
			})
			.execute(
					function(resp) {
						if (!resp.code) {
							if (resp.result.success == false) {
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
								sessionStorage.acceptlendofferId = resp.result.id;
								window
										.setTimeout(
												'window.location.href = "/Views/Offers/ListLendOffers.html";',
												1000);
							}
						} else {
							console.log('Error: ' + resp.error.message);
							$('#errormessage').html(
									'operation failed! Error...<br/>'
											+ resp.error.message.toString());
							$('#successmessage').html('');
							$('#apiResults').html('');
						}
					});
}

function CreateSubMenu() {
	var SubMenu = [];
	SubMenu.push('<div class="nav"><ul class="menu">');
	SubMenu
			.push('<li><div class="floatleft"><div><a style="cursor: pointer;" href="/Views/Offers/CreateBorrowOffer.html">I want to borrow money</a></div></div></li>');
	SubMenu
			.push('<li><div class="floatleft"><div><a style="cursor: pointer;" onclick="PopulatePublicOffers()">Show public Offers</a></div></div></li>');
	SubMenu.push('</ul></div>');

	$("#SubMenu").html(SubMenu.join(" "));
}

$(document).ready(function() {
	CreateSubMenu();
});

function PopulatePublicOffers() {
	fanikiwa.offerendpoint.listlendoffers.LoadPublicLendOffers();
}
fanikiwa.offerendpoint.listlendoffers.LoadPublicLendOffers = function() {

	$('.page-title').html('Public Lend Offers');
	$('#listOffersResult').html('loading...');

	var email = JSON.parse(sessionStorage.getItem('loggedinuser')).userId;

	gapi.client.offerendpoint.retrievePublicOffers({
		'email' : email,
		'offerType' : 'L'
	}).execute(
			function(resp) {
				console.log('response =>> ' + resp);
				if (!resp.code) {
					if (resp.result.items == undefined
							|| resp.result.items == null) {
						$('#listOffersResult').html(
								'You have no public lend Offers...');
					} else {
						buildTable(resp);
					}
				}

			},
			function(reason) {
				console.log('Error: ' + reason.result.error.message);
				$('#errormessage').html(
						'operation failed! Error...<br/>'
								+ reason.result.error.message);
				$('#successmessage').html('');
				$('#apiResults').html('');
			});
};