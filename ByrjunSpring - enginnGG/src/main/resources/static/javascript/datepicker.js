/**
 *
 * @author Pétur Logi Pétursson
 * @date september 2017
 * HBV501G Hugbúnaðarverkefni 1
 * Háskóli Íslands
 * 
 * Tekur vid breytunni params frá jsp skrá og framkvæmir datepicker 
 * aðgerðina.
 */

/*
 * Ákvarðar hvaða dagsetningar er nú þegar búið að bóka og kemur í veg fyrir
 * að hægt sé að smella á þær.
 * 
 * @param date	Dagsetning
 * @param params String Array af dagsetningum sem eru bókaðar
 * @return	Skilar hvort að dagsetningin sé bókuð
 */
function unavailable(date) {
    dmy = date.getDate() + "-" + (date.getMonth() + 1) + "-" + date.getFullYear();
    if ($.inArray(dmy, params) == -1) {
        return [true, ""];
    } else {
        return [false, "", "Unavailable"];
    }
}

/*
 * Birtir dagatal á forminu dd--mm--yy, sem hægt er að bóka 2 ár fram í tímann
 * og kallar á unavailable aðferðina til að ákvarða hvaða dagsetningar eru bókaðar.
 */
$( function() {
    $( "#datepicker" ).datepicker({
    	dateFormat : 'dd-mm-yy',
    	minDate: 0,
    	maxDate: "+2Y",
    	beforeShowDay: unavailable
	});
  });