window.onload = function() {
    document.getElementById('statuses-control')
    .addEventListener('click', showStatuses);
};

const showStatuses = () => {
    console.log('statuses were loaded');
    const url = 'http://localhost:8080/statuses';
    ajaxDemoSample(url, (response) => {
        console.log(response);
        makeTable(response);
    });
};


const ajaxDemoSample = (url, callback) => {
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4 && xhr.status === 200) {
            callback(JSON.parse(xhr.responseText));
        }
    }
    xhr.open('GET', url);
    xhr.send();
}

const makeTable = (statuses) => {
    const statusesContainer = document.getElementById('statuses');

    for(let status in statuses) {
        let tr = document.createElement('tr');
        let td1 = document.createElement('td');
        let td2 = document.createElement('td');
        let td3 = document.createElement('td');
        let td4 = document.createElement('td');

        td1.textContent = statuses[status].id;
        tr.appendChild(td1);
        td2.textContent = statuses[status].scode;
        tr.appendChild(td2);
        td3.textContent = statuses[status].sname;
        tr.appendChild(td3);
        td4.textContent = statuses[status].isClosed;
        tr.appendChild(td4);

        statusesContainer.appendChild(tr);
    }
}


// ---------------------------------------------------------------------



// ---------------------------------------------------------------------