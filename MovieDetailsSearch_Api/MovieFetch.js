/**
 * const apiKey = "YOUR_API_KEY";
let movieTitle = "The Matrix";
let apiUrl = http://www.omdbapi.com/?apikey=${apiKey}&t=${movieTitle};
 key : 1f3af220
 */
// let apiKey = "8f5bae9";

// async function fetchData(){
//     try{
//         let data = await fetchData(apiUrl);
//         let finalData = await data.json();
//         console.log(data.json())
//     }catch(err){
//         console.log("My Error : ",err)
//     }
// }
// fetchData();
let pic = document.getElementById("moviePic");
let movieName = document.getElementById("movieName");
let released = document.getElementById("released");
let imdbRating = document.getElementById("imdbRating");
let runtime = document.getElementById("runtime");
let genre = document.getElementById("genre");
let awards = document.getElementById("awards");
let boxOffice = document.getElementById("boxOffice");
let language = document.getElementById("language");
let country = document.getElementById("country");
let director = document.getElementById("director");
let actors = document.getElementById("actors");
let writer = document.getElementById("writer");
let plot = document.getElementById("plot");

document.getElementById("sbmt").addEventListener("click", () => {
    let apiKey = "1f3af220";
    let movieNameEnter = document.getElementById("movieNameEnter").value;
    let apiUrl = `http://www.omdbapi.com/?apikey=${apiKey}&t=${movieNameEnter}`;
    if (movieNameEnter) {
        fetch(apiUrl).then((msg) => {
            msg.json().then((ele) => {
                // console.log(ele);
                let poster = ele.Poster;

                pic.innerHTML = `<img src=${poster} alt="Picture"></img>`;
                movieName.innerHTML = `<h3>Movie Name</h3> : <h2>${ele.Title}</h2>`;
                released.innerHTML = `<p id="conHead">Release Date : </p>${ele.Released}`;
                imdbRating.innerHTML = `<p id="conHead">IMDB Rating : </p>${ele.Ratings[0].Value} (IMDB Votes ${ele.imdbVotes})`;
                let ttime = (parseInt(ele.Runtime)) / 60;
                let mHours = (ttime + "").slice(0, 4);
                runtime.innerHTML = `<p id="conHead">Movie Length : </p>${mHours} hours`;
                genre.innerHTML = `<p id="conHead">Movie Catagory : </p>${ele.Genre}`;
                awards.innerHTML = `<p id="conHead">Awards : </p>${ele.Awards}`;
                boxOffice.innerHTML = `<p id="conHead">BoxOffice : </p>${ele.BoxOffice} USD`;
                language.innerHTML = `<p id="conHead">Language : </p>${ele.Language}`;
                country.innerHTML = `<p id="conHead">Country : </p>${ele.Country}`;
                director.innerHTML = `<p id="conHead">Director : </p>${ele.Director}`;
                writer.innerHTML = `<p id="conHead">Writer : </p>${ele.Writer}`
                actors.innerHTML = `<p id="conHead">Actors : </p>${ele.Actors}`;
                plot.innerHTML = `<p id="conHead">Plot : </p>${ele.Plot}`;
            })
        })
    } else {
        alert("Please Enter Movie Name ...!!!")
    }
});