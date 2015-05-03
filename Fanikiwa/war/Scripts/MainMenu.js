function CreateMainMenu() {
	var MainMenu = [];
	MainMenu.push('<div class="nav"><ul class="menu">');
	MainMenu
			.push('<li><div class="floatleft"><div><a id="btnSubmitIndexForm" href="/Views/Home/Index.html" style="cursor: pointer;" >Home</a></div></div></li>');
	MainMenu
			.push('<li><div class="floatleft"><div><a id="btnSubmitListLendOffersForm" href="/Views/Offers/ListLendOffers.html" style="cursor: pointer;" >Get a loan</a></div></div></li>');
	MainMenu
			.push('<li><div class="floatleft"><div><a id="btnSubmitListBorrowOffersForm" href="/Views/Offers/ListBorrowOffers.html" style="cursor: pointer;" >Make an investment</a></div></div></li>');
	MainMenu
			.push('<li><div class="floatleft"><div><a id="btnSubmitListMyOffersForm" href="/Views/Offers/ListMyOffers.html" style="cursor: pointer;" >MyOffers</a></div></div></li>');
	MainMenu
			.push('<li><div class="floatleft"><div><a id="btnSubmitEditProfileForm" href="/Views/Account/EditProfile.html" style="cursor: pointer;" >My profile</a></div></div></li>');
	MainMenu
			.push('<li><div class="floatleft"><div><a id="btnSubmitMyAccountsForm" href="/Views/Account/MyAccounts.html" style="cursor: pointer;" >My accounts</a></div></div></li>');
	MainMenu.push('</ul></div>');

	$("#MainMenu").html(MainMenu.join(" "));
}
 