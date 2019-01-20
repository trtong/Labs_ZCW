var request = new XMLHttpRequest();

request.open('GET', "https://data.sfgov.org/api/views/yitu-d5am/rows.json?accessType=DOWNLOAD");

request.onreadystatechange = function () {

    let data;
    if ((request.status === 200 && request.readyState === 4)) {
        // console.log(request.responseText);

        data = JSON.parse(request.response);

        var movieData = data.data;

        let output = "Movies Filmed at the Golden Gate Bridge <br><br>";
        for (let i = 0; i < movieData.length; i++) {
            if (movieData[i][10] === "Golden Gate Bridge") {
                var tempMovie = movieData[i];
                output += "Movie Title: " + tempMovie[8] + "<br>";
                output += "Release Year: " + tempMovie[9] + "<br>";
                output += "Production Co.: " + tempMovie[12] + "<br><br>";
            }
        }

        document.getElementById('result').innerHTML = output;
    }
};
request.send();
