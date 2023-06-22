console.log("teste");
const txtTextAreaT = document.getElementById('txtTextArea');
const publicarT = document.getElementById('publicarT');
const editorT = document.querySelector("#editorT")
publicarT.addEventListener('click', () => {
    txtTextAreaT.value = editorT.innerHTML.trim();
    console.log(txtTextAreaT.value);
})