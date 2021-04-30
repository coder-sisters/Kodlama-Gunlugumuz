$(document).ready(function() {

	getArticles();

	setInterval(function() { getArticles(); }, 3000);

});

function getArticles() {

	$.ajax({
		type: "POST",
		url: 'getArticles',
		success: function(data) {
			var list = "";
			$(data).each(function(i, val) {

				list = list
					+'<p>'+val.title+'</p>'
					

			});
			$("#list").html(list);
		},
		error: function(data) {
			alert(data);
		}
	});
}
