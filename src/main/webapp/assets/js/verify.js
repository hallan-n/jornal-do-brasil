const profile = document.getElementById("profileDefault");
if (profile.getAttribute('src') == "") {
    profile.setAttribute('src', 'storage/profile/profile.jpg')
}

let msg = document.getElementById("msg");
if (msg.textContent.length > 6) {
    msg.style.display = "block";
}

function passvalidate() {
    let pass = document.getElementById("txtPassword2").value;
    let copass = document.getElementById("txtPassword").value;
    if (pass !== copass) {
        alert("As senhas não correspondem!");
        return false;
    }
    return true;
}
