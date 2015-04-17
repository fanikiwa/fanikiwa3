///reference path="_reference.js" />



$(document).ajaxStart(function () {
    $("#progress").removeClass('displaynone');
    $("#progress").addClass('displayblock');
    $("#progress").show();


}).ajaxStop(function () {
    $("#progress").removeClass('displayblock');
    $("#progress").addClass('displaynone');
    $("#progress").hide();
});
 

$(document).ready(function () {

      

});

 

