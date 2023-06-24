
const thumb = document.getElementById("thumb")
const thumbValue = document.getElementById("thumbValue")

thumb.addEventListener("change", e => {    
    let reader = new FileReader()
    let img = new Image()
    let file = e.currentTarget.files[0]    
    reader.onloadend = () => {
        img.src = reader.result
        let profile = `<img class="rounded-circle" src="${img.src}" width="50%">`
        thumbValue.value = profile        
        console.log(thumbValue.value);
    }
    reader.readAsDataURL(file)
})


// thumb.value = ""

