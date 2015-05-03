var fanikiwa = fanikiwa || {};

function GETROOT() {
	var ROOT = 'https://1-dot-fanikiwaweb.appspot.com/_ah/api';
	if (window.location.hostname == 'localhost')
		ROOT = 'http://localhost:8888/_ah/api';
	return ROOT;
}

$(document).ready(function() {
	CreateMainMenu();
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

Number.prototype.formatMoney = function(c, d, t) {
	var n = this, c = isNaN(c = Math.abs(c)) ? 2 : c, d = d == undefined ? "."
			: d, t = t == undefined ? "," : t, s = n < 0 ? "-" : "", i = parseInt(n = Math
			.abs(+n || 0).toFixed(c))
			+ "", j = (j = i.length) > 3 ? j % 3 : 0;
	return s + (j ? i.substr(0, j) + t : "")
			+ i.substr(j).replace(/(\d{3})(?=\d)/g, "$1" + t)
			+ (c ? d + Math.abs(n - i).toFixed(c).slice(2) : "");
};

function formatDate(date) {
	var d = new Date(date), month = '' + (d.getMonth() + 1), day = ''
			+ d.getDate(), year = d.getFullYear();

	if (month.length < 2)
		month = '0' + month;
	if (day.length < 2)
		day = '0' + day;

	return [ day, month, year ].join('-');
}
function formatDateForControl(date) {
	var d = new Date(date), month = '' + (d.getMonth() + 1), day = ''
			+ d.getDate(), year = d.getFullYear();

	if (month.length < 2)
		month = '0' + month;
	if (day.length < 2)
		day = '0' + day;

	return [ year, month, day ].join('-');
}
function incrementDateByYear(date_str, count) {
	var date = new Date(date_str);
	date.setDate(date.getFullYear() - count);
	return formatDateForControl(date);
}