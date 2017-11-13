
function unavailable(date) {
    dmy = date.getDate() + "-" + (date.getMonth() + 1) + "-" + date.getFullYear();
    if ($.inArray(dmy, params) == -1) {
        return [true, ""];
    } else {
        return [false, "", "Unavailable"];
    }
}

$( function() {
    $( "#datepicker" ).datepicker({
    	dateFormat : 'dd-mm-yy',
    	minDate: 0,
    	maxDate: "+2Y",
    	beforeShowDay: unavailable
	});
  });