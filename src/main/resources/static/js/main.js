var d = new Date();

window.onload = function () {
    document.getElementById('adultPassengerNumber').value = 1;
    document.getElementById('departuretime').value = new Date().toJSON().slice(0,10).replace(/-/g,'-') ;
    document.getElementById('arrivaltime').value = new Date().toJSON().slice(0,10).replace(/-/g,'-') ;
    document.getElementById('economyClass1').checked = true;
};

function GetInfo() {
    var newName = document.getElementById("cityInput");
    var cityName = document.getElementById("cityName");
    cityName.innerHTML = "--" + newName.value + "--";

    fetch('https://api.openweathermap.org/data/2.5/forecast?q=' + newName.value + '&appid=32ba0bfed592484379e51106cef3f204')
        .then(response => response.json())
        .then(data => {

            //Getting the min and max values for each day
            for (f = 0; f < 5; f++) {
                let min = 999;
                let a = d.getDate();
                let b = Number(a + f);
                console.log(b);
                for (i = 0; i < data.list.length; i++) {
                    //Check the Date, since the api might display previous date
                    if (b == Number(String(data.list[i].dt_txt).substring(8, 10))) {

                        for (k = i; k < i + 8; k++) {

                            if (Number(data.list[k].main.temp_min - 273.15) < min) {
                                min = Number(data.list[k].main.temp_min - 273.15);
                            }

                            // condition to break(when the api reached end)
                            if (k == data.list.length - 1) break;
                        }
                        break;
                    }
                }
                document.getElementById("day" + (f + 1) + "Min").innerHTML = "Min: " + min.toFixed(1) + "°";


            }
            for (f = 0; f < 5; f++) {
                let max = 0;
                let a = d.getDate();
                let b = Number(a + f);
                console.log(b);
                for (i = 0; i < data.list.length; i++) {
                    //Check the Date, since the api might display previous date
                    if (b == Number(String(data.list[i].dt_txt).substring(8, 10))) {
                        for (k = i; k < i + 8; k++) {
                            if (max < Number(data.list[k].main.temp_max - 273.15)) {
                                max = Number(data.list[k].main.temp_max - 273.15);
                            }
                            // condition to break(when the api reached end)
                            if (k == data.list.length - 1) break;
                        }
                        break;
                    }
                }
                document.getElementById("day" + (f + 1) + "Max").innerHTML = "Max: " + max.toFixed(1) + "°";


            }
            //------------------------------------------------------------

            //Getting Weather Icons
            for (i = 0; i < 5; i++) {
                document.getElementById("img" + (i + 1)).src = "http://openweathermap.org/img/wn/" +
                    data.list[i].weather[0].icon
                    + ".png";
            }
            //------------------------------------------------------------
            console.log(data)


        })

        .catch(err => alert("Entered wrong City Name or failed to fetch API(Internet Connection)"))
}




//Getting and displaying the text for the upcoming five days of the week
var weekday = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
function CheckDay(day) {
    if (day + d.getDay() > 6) {
        return day + d.getDay() - 7;
    }
    else {
        return day + d.getDay();
    }
}
for (i = 0; i < 5; i++) {
    document.getElementById("day" + (i + 1)).innerHTML = weekday[CheckDay(i)];
}
//Function to get the correct integer for the index of the days array

function DefaultScreen() {
    document.getElementById("cityInput").defaultValue = "Ha Noi";
    GetInfo();
}

