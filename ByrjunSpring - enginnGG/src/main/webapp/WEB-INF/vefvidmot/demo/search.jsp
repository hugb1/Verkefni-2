<!DOCTYPE html>

<html>
<head>
    <title>Search</title>
</head>
<body >

<font size="20"><marquee behavior="alternate">Search Interface</marquee></font>
    <h1>Search Page</h1>
        <h2>Search Details</h2>
        <form action="/demo/submit" method="post">
        <br/>select your desired accomidation:
        <input type="radio" name=myradio value="1"/>Veislusalir
        <input type="radio" name=myradio value="2"/>��r�ttasalir
        
        <br/>select your desired location:
        <select name=loc>
        <option name=one value="1"> Reykjav�k </option>
        <option name=two value="2"> Hafnarfj�r�ur </option>
        <option name=three value="3"> Gar�ab�r </option>
        <option name=four value="4"> K�pavogur </option>
        </select>


        <br/>select your required capacity:
        <select name=cap>
        <option name=one value="1"> 50 </option>
        <option name=two value="2"> 100 </option>
        <option name=three value="3"> 150 </option>
        <option name=four value="4"> 200+ </option>
        </select>



        <br/><input type="submit" value="Submit">
        </form>
</body>
</html>