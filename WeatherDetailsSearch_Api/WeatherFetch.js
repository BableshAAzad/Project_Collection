// ^ Your API key is 2d0fbb026121b3d2c795ce2487fca026
// ^ http://api.openweathermap.org/data/2.5/forecast?id=524901&appid={API key}

let apiKey = "2d0fbb026121b3d2c795ce2487fca026";

let cityName = document.getElementById("city");
let temp = document.getElementById("temp");
let desciption = document.getElementById("desciption");
let windS = document.getElementById("windS");
async function fetchWeather(city) {
    try {
        let url = `http://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${apiKey}`;
        let data = await fetch(url);
        let finalData = await data.json();
        // console.log(finalData);
        cityName.innerHTML = `Weater Report of ${finalData.name}, ${finalData.sys.country}`;
        let celc = finalData.main.temp-273.15 +"";
         celc = celc.slice(0, 5)
        temp.innerHTML = `Temperature is : <h3>${celc} celsius</h3>`;
        desciption.innerHTML = `Weather type is : <h3>${finalData.weather[0].description}</h3>`;
        windS.innerHTML = `Wind speed is : <h3>${finalData.wind.speed} meter/sec</h>`
    } catch (err) {
        console.log("Error Occured : ", err);
    }
}

document.addEventListener("submit", (e) => {
    e.preventDefault();
    let city = document.getElementById("cityname").value;
    // console.log(city)
    if (city) {
        fetchWeather(city);
    } else {
        alert("Please Enter city Name.....!!!")
    }
})