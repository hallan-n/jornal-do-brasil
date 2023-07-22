const editor = document.getElementById('editor');
const count = document.getElementById('count');
const caracterLimit = 10000;
const imagesLimit = 4;

editor.addEventListener('input', () => {
    const texto = editor.textContent;
    if (texto.length > caracterLimit) {
        editor.textContent = texto.slice(0, caracterLimit);
    }
    const imagens = editor.querySelectorAll('img');
    if (imagens.length > imagesLimit) {
        for (let i = imagesLimit; i < imagens.length; i++) {
            imagens[i].parentNode.removeChild(imagens[i]);
        }
    }

    const numCaracteres = editor.textContent.length;
    count.textContent = `${numCaracteres}/3000`;
});
editor.addEventListener('DOMNodeInserted', (event) => {
    if (event.target.tagName === 'IMG') {
        const imagens = editor.querySelectorAll('img');
        if (imagens.length > imagesLimit) {
            event.target.parentNode.removeChild(event.target);
        }
    }
});




function checkAndSetImageSrc() {
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