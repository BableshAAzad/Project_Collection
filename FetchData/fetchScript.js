// asyn and await

document.getElementById("btn").addEventListener("click", makerequest);

function makerequest() {
    console.log("Button Clicked");
    fetch('data.json').then((res) => {
        if (!res.ok) {
            throw Error(res.statusText)
        }
        return res.json()
    }).then((data) => {
        document.getElementById("divData1").innerText = `Name : ${data.name}`
        document.getElementById("divData2").innerText = `Roll Number : ${data.roll}`
        document.getElementById("divData3").innerText = `Stream : ${data.stream}`

    }).catch((error) => { console.log(error) })
}