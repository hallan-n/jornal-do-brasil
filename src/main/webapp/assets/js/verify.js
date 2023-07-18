
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

$(document).ready(function () {
    $("#input").on("keyup", function () {
        var value = $(this).val().toLowerCase();
        $("#table tr").filter(function () {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });
});