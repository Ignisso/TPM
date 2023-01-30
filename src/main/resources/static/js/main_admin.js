const onLoad = () => { 
    document.querySelector('input#numer_pasazera').addEventListener('blur', validateInputNotEmpty)
    document.querySelector('select#rodzaj_biletu').addEventListener('blur', validateInputNotEmpty)
    
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

window.onload = () => {
    onLoad()
}