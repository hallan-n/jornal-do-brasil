
const thumb = document.getElementById("thumb")
const thumbValue = document.getElementById("thumbValue")

thumb.addEventListener("change", e => {
    let reader = new FileReader()
    let file = e.currentTarget.files[0]
    reader.onloadend = () => {
        let profile = `<img class="card-img-top" src="${reader.result}">`
        thumbValue.value = profile
        console.log(thumbValue.value);
    }
    reader.readAsDataURL(file)
})


// thumb.value = ""

function renderThumb(fileName){
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = () => {
        document.getElementById(fileName).innerHTML = xhttp.responseText;
    };
    console.log("storage/thumb/"+fileName+".html");
    xhttp.open("GET", "storage/thumb/"+fileName+".html", true);
    xhttp.send();
}