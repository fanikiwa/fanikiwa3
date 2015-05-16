$(document).ready(
		function() {
			var loggedinuser = JSON.parse(sessionStorage
					.getItem('loggedinuser')).userId;
			if (loggedinuser === null || loggedinuser === undefined) {
				window.location.href = "/Views/Account/Login.html";
			}
		});
