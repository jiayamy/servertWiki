var ComponentsIonSliders = function () {

    return {
        //main function to initiate the module
        init: function () {

            $("#servert-level-range").ionRangeSlider({
                type: "single",
                step: 1,
                postfix: " level",
                from: 55000,
                hideText: true,
                onChange: function(data){
                	$('#servantLevel').val(data.fromNumber);
                	$('#servantLevel').trigger('input'); // Use for Chrome/Firefox/Edge
                    $('#servantLevel').trigger('change'); // Use for Chrome/Firefox/Edge + IE11
//                	var servert = new Object();
//                	servert.servertId = $('#servantInfo').val();
//                	servert.level = data.fromNumber;
//                	$.ajax({
//                		url: "api/getLevelInfo",
//                		type: "POST",
//                		data: servert,
//                		dataType: "json",
//                		success: function(result){
//                			console.log(result);
//                		}
//                	});
                }
            });
            
        }

    };

}();