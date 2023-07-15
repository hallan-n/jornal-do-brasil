
function checkAndSetImageSrc(){
    const profile = document.getElementsByClassName('profileDefault');
    for (let i = 0; i < profile.length; i++) {
        const img = profile[i];
        if (!img.getAttribute('src')) {
            img.setAttribute('src', 'storage/profile/profile.jpg');
        }
    }
}
window.addEventListener('load', checkAndSetImageSrc);

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
