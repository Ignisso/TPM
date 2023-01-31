const onLoad = () => { 
    document.querySelector('input#nazwa_przystanku').addEventListener('blur', validateInputNotEmpty)
 }
const validateInputNotEmpty = (event) => {
    console.log(event.target)
    const elem = event.target;
    if (elem.value.length !== 0) {
        elem.setAttribute("aria-invalid", "false");
    } else {
        elem.setAttribute("aria-invalid", "true");
    }
}
const setPlaceholders = (event) => {
    document.querySelector('input#numer_przystanku').value = (event.target.getAttribute('value')).toString();
}

window.onload = () => {
    onLoad()
}