const onLoad = () => { 
    setInterval(() => {
        document.location.href = '/index';
    }, 5000);
}

window.onload = () => {
    onLoad()
}