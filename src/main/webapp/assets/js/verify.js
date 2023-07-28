




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


function categoryValidate() {
    const txtTitle = document.getElementById('txtTitle');
    const txtDescription = document.getElementById('txtDescription');
    const txtCategory = document.getElementById('txtCategory');
    const thumb = document.getElementById('thumb');
    if (txtCategory.selectedIndex !== "" && thumb.files.length > 0 && txtDescription.textContent.length > 0 && txtTitle.textContent.length > 0) {
        return true;
    } else {
        alert("Preencha todos os campos corretamente!");
        return false;
    }
}
function categoryValidateT() {
    const txtTitle = document.getElementById('txtTitleT');
    const txtDescription = document.getElementById('txtDescriptionT');
    const txtCategory = document.getElementById('txtCategoryT');
    const thumb = document.getElementById('thumb');
    if (txtCategory.selectedIndex !== "" && thumb.files.length > 0 && txtDescription.textContent.length > 0 && txtTitle.textContent.length > 0) {
        return true;
    } else {
        alert("Preencha todos os campos corretamente!");
        return false;
    }
}

$(document).ready(function () {
    $("#input").on("keyup", function () {
        var value = $(this).val().toLowerCase();
        $("#table tr").filter(function () {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });
});