const anchorQuery = document.getElementById('anchorQuery');
const inputQuery = document.getElementById('inputQuery');
inputQuery.addEventListener('change', (e) => {
    anchorQuery.setAttribute('href', 'http:\/\/localhost:8080/jornal_do_brasil/publication?action=list&contain=' + e.target.value)
})