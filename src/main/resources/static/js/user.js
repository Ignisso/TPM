let tickets;

const formatDate = (date) => {
    return `${("00" + date.getDate()).slice (-2)}.${("00" + (date.getMonth() + 1)).slice (-2)}.${date.getFullYear()} ${("00" + (date.getHours())).slice (-2)}:${("00" + (date.getMinutes())).slice (-2)}:${("00" + (date.getSeconds())).slice (-2)}`
}

const parseDate =  (date) => {
    const year = date.substr(0,4);
    const month = date.substr(5,2);
    const day = date.substr(8,2);
    const hour = date.substr(11,2);
    const minute = date.substr(14,2);
    const seconds =  date.substr(17,2);

    return new Date(`${month}/${day}/${year} ${hour}:${minute}:${seconds}`).getTime();
}

const humanizeTimestamp = (timestamp) => {
    const day = Math.floor(timestamp / (24 * 3600));
    timestamp -= day * 24 * 3600 ;
    const hour = Math.floor(timestamp / (3600));
    timestamp -= hour * 3600;
    const minute = Math.floor(timestamp / (60));
    const seconds = timestamp - minute * 60;
    let final_string = "";
    if(day > 0) {
        if(day == 1) final_string += "1 dzień ";
        else final_string += `${day} dni `;

        if(hour == 1) final_string += "1 godzina";
        else if(hour <= 4) final_string += `${hour} godziny`;
        else if (hour <= 21) final_string += `${hour} godzin`;
        else final_string += `${hour} godziny`;
    }

    else if(hour > 0) {
        if(hour == 1) final_string += "1 godzina ";
        else if(hour <= 4) final_string += `${hour} godziny `
        else if (hour <= 21) final_string += `${hour} godzin `;
        else final_string += `${hour} godziny `;

        if(minute == 1) final_string += "1 minuta ";
        else if(minute <= 4) final_string += `${minute} minuty `;
        else if (minute <= 21) final_string += `${minute} minut `;
        else if (minute % 10 == 2 || minute % 10 == 3 || minute % 10 == 4) final_string += `${minute} minuty `;
        else final_string += `${minute} minut `;
    } 
    else if (minute > 0) {
        if(minute == 1) final_string += "1 minuta ";
        else if(minute <= 4) final_string += `${minute} minuty `;
        else if (minute <= 21) final_string += `${minute} minut `;
        else if (minute % 10 == 2 || minute % 10 == 3 || minute % 10 == 4) final_string += `${minute} minuty `;
        else final_string += `${minute} minut `;

        if(seconds == 1) final_string += "1 sekunda ";
        else if(seconds <= 4) final_string += `${seconds} sekundy `;
        else if (seconds <= 21) final_string += `${seconds} sekund `;
        else if (seconds % 10 == 2 || seconds % 10 == 3 || seconds % 10 == 4) final_string += `${seconds} sekundy `;
        else final_string += `${seconds} sekund `;
    } else if(seconds > 0) {
        if(seconds == 1) final_string += "1 sekunda ";
        else if(seconds <= 4) final_string += `${seconds} sekundy `;
        else if (seconds <= 21) final_string += `${seconds} sekund `;
        else if (seconds % 10 == 2 || seconds % 10 == 3 || seconds % 10 == 4) final_string += `${seconds} sekundy `;
        else final_string += `${seconds} sekund `;
    } else {
        final_string = ""
    }
    return final_string;
}


const updateTime = () => {
    tickets.forEach(element => {
        if(element.children[1].children[2].children.length <= 1) return;
        const value = element.children[1].children[2].children[1].getAttribute('value');
        const next_value = value - 1;
        if(value !== null) {
            if(value < 0) {
                const div = document.querySelector('div.progress-bar');
                element.children[1].children[2].children[0].innerHTML = "<b>BILET STRACIŁ WAŻNOŚĆ</b>"
                element.children[1].children[2].children[0].setAttribute("style", "color:red")
                element.children[1].children[2].children[1].remove();
                element.children[1].children[2].children[1].remove();
            }
            else {
                element.children[1].children[2].children[1].setAttribute('value', next_value);
                element.children[1].children[2].children[0].innerHTML = `<b>Pozostało: </b> ${humanizeTimestamp(next_value)}`
            }
        }
    })
}

const onLoad = () => { 
    tickets = document.querySelectorAll('div.ticket-container');
    tickets.forEach(element => {
        const ticket_name = element.children[1].children[0].textContent.substr(8);
        const scan_date = element.children[1].children[2].children[2].textContent.substr(17);

        if(ticket_name === "Bilet jednoprzejazdowy" || ticket_name === "Bilet jednoprzejazdowy ULGOWY") {
            element.children[1].children[2].children[1].setAttribute('max', 5400);
            element.children[1].children[2].children[1].setAttribute('value', 5400 - (Date.now() - parseDate(scan_date))/1000);
        } else if (ticket_name === "Bilet 24-godzinny" || ticket_name === "Bilet 24-godzinny ULGOWY") {
            element.children[1].children[2].children[1].setAttribute('max', 86400);
            element.children[1].children[2].children[1].setAttribute('value', 86400 - (Date.now() - parseDate(scan_date))/1000);
        } else if (ticket_name === "Bilet miesięczny" || ticket_name === "Bilet jednoprzejazdowy ULGOWY") {
            element.children[1].children[2].children[1].setAttribute('max', 2592000);
            element.children[1].children[2].children[1].setAttribute('value', 2592000 - (Date.now() - parseDate(scan_date))/1000);
        }
    })
    setInterval(updateTime, 1000);
}


window.onload = () => {
    onLoad()
}