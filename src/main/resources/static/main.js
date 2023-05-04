$(document).ready(function() {
	$("#shortenbutton").click(function() {
		$.ajax({
			type : 'POST',
			url : 'https://snip.up.railway.app/shorten',
			data : JSON.stringify({
				"originalURL" : $("#urlinput").val()
			}),
			contentType : "application/json; charset=utf-8",
			success : function(data) {
                $("#shorturltext").val(data.shortURL);

			},
			    error : function() {
            		alert("Please enter a valid URL");
            	}

		});
	});
});

function copyToClipboard() {
  /* Get the text field */
  var copyText = document.getElementById("shorturltext");

  /* Select the text field */
  copyText.select();
  copyText.setSelectionRange(0, 99999); /* For mobile devices */

  /* Copy the text inside the text field */
  document.execCommand("copy");
}