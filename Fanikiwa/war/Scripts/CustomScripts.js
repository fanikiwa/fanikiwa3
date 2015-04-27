
$(document).ready(function() {
	if (sessionStorage.getItem("loggedinuser") === null) {
		window.location.href = "/Views/Account/Login.html";
	}
	$('#lnkloggedinuser').text(sessionStorage.getItem('loggedinuser'));
});
 