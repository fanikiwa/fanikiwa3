var ROOT ='https://1-dot-fanikiwaweb.appspot.com/_ah/api';
 //var ROOT ='http://localhost:8888/_ah/api';

$(document).ready(function () {
	
	$('#lnkloggedinuser').text(localStorage.getItem('loggedinuser'));

});
  	
function LogOff() { 
	localStorage.removeItem("loggedinuser");
	window.location.href = "/Views/Account/Login.html";  
}
	
function ManageProfile() { 
	window.location.href = "/Views/Account/EditProfile.html";  
}

function LogIn() {  
	window.location.href = "/Views/Account/Login.html";  
}


 
 

