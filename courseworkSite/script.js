idClient=Number(localStorage.getItem('idClient'));
idWorker=Number(localStorage.getItem('idWorker'));


function authorized()
{
    const email = document.getElementById('inputEmail'); 
    const emailValue = email.value.trim();

    const password = document.getElementById('inputPassword'); 
    const passwordValue = password.value.trim();

    const url = 'http://localhost:8080/clients';
        ajaxDemoSample(url, (clients) => {
            for(let client in clients)
            {
                if(clients[client].clientEmail===emailValue&&clients[client].clientPassword===passwordValue)
                {
                    localStorage.setItem('idClient',String(clients[client].id));
                    idClient=Number(localStorage.getItem('idClient'));
                    console.log(localStorage.getItem('idClient'));
                    if(clients[client].idUserType===1)
                    {
                        window.location.href = 'client.html';
                    }
                    else if(clients[client].idUserType===2)
                    {
                        const urlWorker = 'http://localhost:8080/workers';
                        ajaxDemoSample(urlWorker, (workers) => {
                            console.log("psd");
                            for(let worker in workers)
                            {
                                console.log(workers[worker].idClient);
                                console.log(idClient);
                                if(workers[worker].idClient===idClient)
                                {
                                    console.log("psd2");
                                    localStorage.setItem('idWorker', String(workers[worker].id));
                
                                    window.location.href = 'worker.html';
                                    return;
                                }
                            }
                        });
                    }
                    else if(clients[client].idUserType===3)
                    {
                        window.location.href = 'manager.html';
                    }
                    
                }
            }
        });


    //checkLogInUser()
}

//----------------WORK WITH LOCALE STORAGE

function checkLogInUser()
{
    //console.log("pipiska");
    if(localStorage.getItem('idClient')===null)
    {
        localStorage.setItem('idClient','0');
    }
    else if(localStorage.getItem('idClient')==='0')
    {
        console.log("Go to authorize igga");
    }
    else {
        idClient=Number(localStorage.getItem('idClient'));
        
        const url = 'http://localhost:8080/clients/'+idClient;
        ajaxDemoSample(url, (client) => {
            if(client.idUserType===3)
            {
                window.location.href = 'manager.html';
                return;
            }
            else if(client.idUserType===2)
            {
                window.location.href = 'worker.html';
                return;
            }
            else if(client.idUserType===1)
            {
                window.location.href = 'client.html';
                return;
            }
        });
    }
}



function startWorker()
{
    idClient=Number(localStorage.getItem('idClient'));
    idWorker=Number(localStorage.getItem('idWorker'));
    console.log('1');
}
function startClient()
{
    idClient=Number(localStorage.getItem('idClient'));
}
function startManager()
{
    idClient=Number(localStorage.getItem('idClient'));
    console.log(idClient);
}



// ------------------------ BUTTONS FOR AUTHORIZED

function buttonSignIn(){
    document.getElementById('registration-fild').style.display='';
    document.getElementsByClassName('main-page')[0].style.display='none';
    document.getElementsByClassName('main-page')[1].style.display='none';
    document.getElementById('button-sign-into').style.display='none';
    
}

function buttonMainPage(){
    document.getElementById('registration-fild').style.display='none';
    document.getElementsByClassName('main-page')[0].style.display='';
    document.getElementsByClassName('main-page')[1].style.display='';
    document.getElementById('button-sign-into').style.display='';
}


//---------------BUTTONS FOR MANAGER

function buttonMainPageForManager()
{
    document.getElementsByClassName('main-page')[0].style.display='';
    document.getElementsByClassName('main-page')[1].style.display='';
    document.getElementById('table-contracts-and-projects').style.display='none';
    document.getElementById('table-eemployers').style.display='none';
    document.getElementById('table-conclude-project').style.display='none';
    
}

function buttonConcludeProjectForManager()
{
    document.getElementsByClassName('main-page')[0].style.display='none';
    document.getElementsByClassName('main-page')[1].style.display='none';
    document.getElementById('table-contracts-and-projects').style.display='none';
    document.getElementById('table-eemployers').style.display='none';
    document.getElementById('table-conclude-project').style.display='';
}

function buttonTableEemployersForManager()
{
    document.getElementsByClassName('main-page')[0].style.display='none';
    document.getElementsByClassName('main-page')[1].style.display='none';
    document.getElementById('table-contracts-and-projects').style.display='none';
    document.getElementById('table-eemployers').style.display='';
    document.getElementById('table-conclude-project').style.display='none';
}

function buttonContractsAndProjectsForManager()
{
    document.getElementsByClassName('main-page')[0].style.display='none';
    document.getElementsByClassName('main-page')[1].style.display='none';
    document.getElementById('table-contracts-and-projects').style.display='';
    document.getElementById('table-eemployers').style.display='none';
    document.getElementById('table-conclude-project').style.display='none';
}

function buttonExitForManager()
{
    localStorage.removeItem('idClient');
    window.location.href = 'index.html';
}

//----------------BUTTONS FOR WORKER
function buttonMainPageForWorker()
{
    document.getElementsByClassName('main-page')[0].style.display='';
    document.getElementsByClassName('main-page')[1].style.display='';
    document.getElementById('table-conclude-project').style.display='none';
    document.getElementById('table-my-projects').style.display='none';
}

function buttonConcludeProjectForWorker()
{
    document.getElementsByClassName('main-page')[0].style.display='none';
    document.getElementsByClassName('main-page')[1].style.display='none';
    document.getElementById('table-conclude-project').style.display='';
    document.getElementById('table-my-projects').style.display='none';
}

function buttonMyProjectsForWorker()
{
    document.getElementsByClassName('main-page')[0].style.display='none';
    document.getElementsByClassName('main-page')[1].style.display='none';
    document.getElementById('table-conclude-project').style.display='none';
    document.getElementById('table-my-projects').style.display='';
}
function buttonExitForWorker()
{
    localStorage.removeItem('idClient');
    localStorage.removeItem('idWorker');
    window.location.href = 'index.html';
}


//----------------BUTTONS FOR CLIENT
function buttonMainPageForClient()
{
    document.getElementsByClassName('main-page')[0].style.display='';
    document.getElementsByClassName('main-page')[1].style.display='';
    document.getElementById('table-conclude-project').style.display='none';
}

function buttonConcludeProjectForClient()
{
    document.getElementsByClassName('main-page')[0].style.display='none';
    document.getElementsByClassName('main-page')[1].style.display='none';
    document.getElementById('table-conclude-project').style.display='';
}

function buttonExitForClient()
{
    localStorage.removeItem('idClient');
    window.location.href = 'index.html';
}

//---------------------------------------------------------
window.onload = function() {
    //document.getElementById('clients').addEventListener('click', showClients); 
    //let i=document.getElementById("check-workers").checked; //console.log(i);
};  

const showClients = () => {
    //console.log('clients were loaded');
    
    const url = 'http://localhost:8080/clients';
    ajaxDemoSample(url, (response) => {
        //console.log(response);
        makeTableClients(response);
        console.log('2');
    })
    
};

function checkWorkers(){
    
    let checkbox = document.getElementById('check-workers');
    if (checkbox.checked === true) 
    {
        let elems = document.getElementsByClassName("worker");
        //console.log(elems);
        for (let i = 0; i < elems.length; i++)
            elems[i].style.display = '';
    }
    //document.getElementsByClassName('worker')[0].style.display = '';//checkboxWorkers=true;
    else {
        let elems = document.getElementsByClassName("worker");
        for (let i = 0; i < elems.length; i++)
            elems[i].style.display = "none";
    }
    //document.getElementsByClassName('worker')[0].style.display = "none";//checkboxWorkers=false;
    //console.log(checkboxWorkers);
}

function checkClients(){
    let checkbox = document.getElementById('check-clients');
    if (checkbox.checked === true) 
    {
        let elems = document.getElementsByClassName("client");
        //console.log(elems);
        for (let i = 0; i < elems.length; i++)
            elems[i].style.display = '';
    }
    //document.getElementsByClassName('client')[0].style.display = '';//checkboxClients=true;
    else {
        let elems = document.getElementsByClassName("client");
        for (let i = 0; i < elems.length; i++)
            elems[i].style.display = "none";
    }
    //document.getElementsByClassName('client')[0].style.display = "none";//checkboxClients=false;
    //console.log(checkboxClients);
}

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

const makeTableClients = (clients) => {
    const clientsContainer = document.getElementById('clients');

    for(let client in clients) {
        let tr = document.createElement('tr');
        if(clients[client].idUserType===1) tr.className= "client";
        else if (clients[client].idUserType===2) tr.className= "worker";
        else if (clients[client].idUserType===3) tr.className= "manager";

        let td1 = document.createElement('td');
        let td2 = document.createElement('td');
        let td3 = document.createElement('td');
        let td4 = document.createElement('td');
        let td5 = document.createElement('button');
        td5.className="btn-primary"
        td5.style="width:100%;border-radius: .25rem;";
        //td5.add("btn-primary");

        td1.textContent = clients[client].id; 
        tr.appendChild(td1);
        td2.textContent = clients[client].clientName;
        tr.appendChild(td2);
        td3.textContent = clients[client].clientEmail;
        tr.appendChild(td3);
        td4.textContent = clients[client].idUserType===1?"Client": clients[client].idUserType===2?"Worker": "Manager";
        tr.appendChild(td4);
        if(clients[client].idUserType===2)td5.textContent = "Dismiss";
        else if(clients[client].idUserType===1)td5.textContent = "Accept";
        else td5 = document.createElement('td');
        tr.appendChild(td5);
        td5.addEventListener('click', e => {    
            if(td5.textContent === "Dismiss")
            {
                td5.textContent="Accept";

                let xhr = new XMLHttpRequest();
                let url = "http://localhost:8080/clients/update/"+clients[client].id;
                xhr.open("PUT", url, true);
                xhr.setRequestHeader("Content-Type", "application/json");
            
                td4.textContent="Client";
                tr.className="client";
                
                // xhr.onreadystatechange = function () 
                // {
                //     if (xhr.readyState === 4 && xhr.status === 200) {
                //         let json = JSON.parse(xhr.responseText);
                //     }
                // };

                let data = JSON.stringify({"clientName": clients[client].clientName,"clientEmail": clients[client].clientEmail, "clientPassword": clients[client].clientPassword,"idUserType": 1 });
                //console.log(data);
                xhr.send(data);
                //console.log(idWorker);
                //let url_delete = "http://localhost:8080/workers/delete/"+8;
                //xhr.open("DELETE", url_delete, true);
                //xhr.setRequestHeader("Content-Type", "application/json");
                deleteOldWorker(clients[client].id);
                console.log(clients[client].id);
            }
            else if (td5.textContent === "Accept")
            {
                td5.textContent="Dismiss";

                const xhr = new XMLHttpRequest();
                const url = "http://localhost:8080/clients/update/"+clients[client].id;
                xhr.open("PUT", url, true);
                xhr.setRequestHeader("Content-Type", "application/json");
            
                let data = JSON.stringify({"clientName": clients[client].clientName,"clientEmail": clients[client].clientEmail, "clientPassword": clients[client].clientPassword,"idUserType": 2 });
                //console.log(data);
                xhr.send(data);
                td4.textContent="Worker";
                tr.className="worker";
                saveNewWorker(clients[client].id);
            }
        });
        //Доделать апдейт и вернутся к этому блоку
        clientsContainer.appendChild(tr);
    }
}

function deleteOldWorker(idOld)
{
    console.log("pisska mari");
    const xhr = new XMLHttpRequest();
    const url = "http://localhost:8080/workers/deleteByClient/"+idOld;
    xhr.open("DELETE", url, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(null);
}

function saveNewWorker(idNew)
{
    console.log("pisska mari");
    const xhr = new XMLHttpRequest();
    const url = "http://localhost:8080/workers/save";
    xhr.open("POST", url, true);
    xhr.setRequestHeader("Content-Type", "application/json");

    let data = JSON.stringify({"idClient": idNew, "idDepartment": 1, "startDate": "2021-01-10", "idWorkPosition": 1});

    xhr.send(data);
}

const showContracts = () => {
    //console.log('contracts were loaded');
    const url = 'http://localhost:8080/contracts';
    ajaxDemoSample(url, (response) => {
        //console.log(response);
        makeTableContracts(response);
    });
};


/*const ajaxDemoSample = (url, callback) => {
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4 && xhr.status === 200) {
            callback(JSON.parse(xhr.responseText));
        }
    }
    xhr.open('GET', url);
    xhr.send();
}*/


const makeTableContracts = (contracts) => {
    const contractsContainer = document.getElementById('contracts');

    for(let contract in contracts) {

        const url = "http://localhost:8080/clients/"+contracts[contract].idClient;
        ajaxDemoSample(url, (response) => {
            //console.log(response.clientName);
            //response.clientName;

            let tr = document.createElement('tr');
            tr.id="contract-row-"+contracts[contract].id;
            tr.style.display="none";
            //tr.id="10";

            let td1 = document.createElement('td');
            let td2 = document.createElement('td');
            let td3 = document.createElement('td');
            let td4 = document.createElement('button');
             
            td3.id="cost-contract-"+contracts[contract].id;
            td4.className="btn-primary";

            tr.style.backgroundColor="#d3d3d3";
            td4.addEventListener("click", function(e) {
                let obj=document.getElementsByClassName("projects-for-contract-"+contracts[contract].id);

                if(obj[0].style.display==="none") 
                {
                    for(i of obj) 
                    {
                        i.style.display="";
                    }
                }
                else {
                    for(i of obj) 
                    {
                        i.style.display="none";
                    }
                }

            }, false);

            td4.style="width:100%;border-radius: .25rem;";

            td1.textContent = contracts[contract].id; 
            tr.appendChild(td1);
            td2.textContent = response.clientName;
            tr.appendChild(td2);
            td3.textContent = "0";
            tr.appendChild(td3);
            td4.textContent = "Projects";
            tr.appendChild(td4);
            
            td4.id= contracts[contract].id;
            contractsContainer.appendChild(tr);
            
            showProjects(contracts[contract].id, tr,td3);

        });
    }
}



const showProjects = (id_contract, tr_contract,td3_cost) =>
{
    //console.log('projects were loaded');
    const url = 'http://localhost:8080/contractProjects';
    ajaxDemoSample(url, (response) => {
        //console.log(response);
        makeTableProjects(response, id_contract, tr_contract,td3_cost);
    });
};

const makeTableProjects = (contractProjects, id_contract, tr_contract,td3_cost) => {
    
    const projectsContainer = document.getElementById("contract-row-"+id_contract);
    let contract_cost=0;
    for(let contractProject in contractProjects) {

        const url = "http://localhost:8080/projects/"+contractProjects[contractProject].idProject;
        
        ajaxDemoSample(url, (response) => {
            if(id_contract===contractProjects[contractProject].idContract){
                let tr = document.createElement('tr');

                

                let td1 = document.createElement('td');
                let td2 = document.createElement('td');
                let td3 = document.createElement('td');
                let td4 = document.createElement('td');
                if(contractProjects[contractProject].idStatusProject!=2) {
                    contract_cost+=response.projectCost;
                    tr_contract.style.display="";
                }
                
                //console.log(contract_cost);
                document.getElementById('cost-contract-'+contractProjects[contractProject].idContract).textContent=contract_cost;
                //td4.className="btn-primary"
                //td4.style="width:100%;border-radius: .25rem;";
                td1.textContent = "Project #: "+contractProjects[contractProject].id; 
                tr.appendChild(td1);
                td2.textContent = response.projectName;
                tr.appendChild(td2);
                if(contractProjects[contractProject].idStatusProject!=2) td3.textContent = response.projectCost;
                else td3.textContent = response.projectCost+' (0)';
                tr.appendChild(td3);
               
                
                if(contractProjects[contractProject].idStatusProject===1) //awaiting
                {
                    //Confirm Decline 
                    let button_confirm=document.createElement('button');
                    button_confirm.className="btn-primary"
                    button_confirm.style="width:50%;border-radius: .25rem; background:green; border-color: green;";
                    button_confirm.textContent = "Confirm";


                    //console.log(button_confirm);
                    let button_decline=document.createElement('button');
                    button_decline.className="btn-primary"
                    button_decline.style="width:50%;border-radius: .25rem; background:#8B0000; border-color:#8B0000;";
                    button_decline.textContent = "Decline";
                    td4.id="buttons-for-project-"+contractProjects[contractProject].idStatusProject;
                    td4.style="padding:0; margin:0;";
                    button_confirm.addEventListener('click', e =>    
                    {
                        td4.textContent="In processing";
                        td4.style="";

                        let xhr = new XMLHttpRequest();
                        let url = "http://localhost:8080/contractProjects/update/"+contractProjects[contractProject].id;
                        xhr.open("PUT", url, true);
                        xhr.setRequestHeader("Content-Type", "application/json");
                    
                        let data = JSON.stringify({"idProject": contractProjects[contractProject].idProject, "idContract": contractProjects[contractProject].idContract, "idStatusProject": 3});
                        console.log(data);
                        xhr.send(data);
                    });
                    button_decline.addEventListener('click', e =>    
                    {
                        td4.textContent="Regected";
                        td4.style="";

                        let xhr = new XMLHttpRequest();
                        let url = "http://localhost:8080/contractProjects/update/"+contractProjects[contractProject].id;
                        xhr.open("PUT", url, true);
                        xhr.setRequestHeader("Content-Type", "application/json");
                    
                        let data = JSON.stringify({"idProject": contractProjects[contractProject].idProject, "idContract": contractProjects[contractProject].idContract, "idStatusProject": 2});
                        console.log(data);
                        xhr.send(data);

                        if(contractProjects[contractProject].idProject===1)
                        {
                            td3_cost.textContent=Number(td3_cost.textContent)-10000;
                            td3.textContent="10000 (0)";
                        }
                        else if (contractProjects[contractProject].idProject===2)
                        {
                            td3_cost.textContent=Number(td3_cost.textContent)-3000;
                            td3.textContent="3000 (0)";
                        }
                        else if (contractProjects[contractProject].idProject===3)
                        {
                            td3_cost.textContent=Number(td3_cost.textContent)-30000;
                            td3.textContent="30000 (0)";
                        }
                        else if (contractProjects[contractProject].idProject===4)
                        {
                            td3_cost.textContent=Number(td3_cost.textContent)-5000;
                            td3.textContent="5000 (0)";
                        }
                        else if (contractProjects[contractProject].idProject===5)
                        {
                            td3_cost.textContent=Number(td3_cost.textContent)-15000;
                            td3.textContent="15000 (0)";
                        }/////////////////////////////////////

                        
                    });

                    td4.insertAdjacentElement('beforeend', button_confirm);
                    td4.insertAdjacentElement('beforeend', button_decline);

                }
                else if (contractProjects[contractProject].idStatusProject===2) td4.textContent = "Regected";
                else if (contractProjects[contractProject].idStatusProject===3) td4.textContent = "In processing";
                else if (contractProjects[contractProject].idStatusProject===4) td4.textContent = "Completed";
                
                //td4.textContent = status;
                tr.appendChild(td4);
                //td4.insertAdjacentHTML('beforeend', td4.innerHTML);
                //nth.innerHTML = "<b>"+ nth.innerHTML +"</b>";

                tr.classList.add("projects-for-contract-"+contractProjects[contractProject].idContract);
                tr.style.display="none";
                //console.log(tr);
                
                projectsContainer.insertAdjacentElement('afterend', tr);
                //console.log(tr.innerHTML);

            }

        });
    }

}
//const showMyProjects = () => };
const showMyProjects = () =>
{
    //console.log('my projects were loaded');
    const url = 'http://localhost:8080/contractProjects';
    ajaxDemoSample(url, (response) => {
        //console.log(response);
        makeTableMyProjects(response);
    });
};

const makeTableMyProjects = (myProjects) => {

    const myProjectsContainer = document.getElementById('my-projects');

    for(let myProject in myProjects) {

        //console.log('type projects were loaded');
        const url = 'http://localhost:8080/projects/'+myProjects[myProject].idProject;
        ajaxDemoSample(url, (response) => {
            
            if(myProjects[myProject].idStatusProject===3||myProjects[myProject].idStatusProject===4) //3-in proc 4-completed
            {
                //console.log();
                let tr = document.createElement('tr');

                let td1 = document.createElement('td');
                let td2 = document.createElement('td');
                let td3 = document.createElement('td');
                let td4 = document.createElement('td');
                let td5 = document.createElement('td');  
    
                td1.textContent = myProjects[myProject].id;
                tr.appendChild(td1);
                td2.textContent = response.projectName;
                tr.appendChild(td2);

                setRewardStaffStatus(myProjectsContainer, tr, td3, td4, td5, response, myProjects[myProject].id, myProjects[myProject].idStatusProject);

                
            }//projectCost

        });

    }
}




const setRewardStaffStatus = (myProjectsContainer, tr, td3, td4, td5, projects, idProject, idStatusProject) => 
{
    const url = 'http://localhost:8080/projectStaffs';
    ajaxDemoSample(url, (response) => {
        
        let countStaffInProject=0;
        let checkInProject=false;
        for(let i in response)
        {
            if(idProject===response[i].idContractProject)
                countStaffInProject++;

            if(idWorker===response[i].idWorker&&idProject===response[i].idContractProject)
                checkInProject=true;
        }
        let  tr_descr = document.createElement('tr');
        

        td3.textContent=countStaffInProject===0?projects.projectCost*0.5:projects.projectCost*0.5/(countStaffInProject+(!checkInProject));
        td4.textContent=countStaffInProject+"/20";
        td4.id="staff-for-project-"+idProject;
        if(idStatusProject===4&&checkInProject) 
        {
            td5.textContent="Completed";
            tr.className="completed-proj-for-worker";
            tr_descr.className=tr.className;
        }
        else if(idStatusProject===4)tr.style.display="none";
        else if(checkInProject){
            td5.textContent="You already in project";
        }
        else if(countStaffInProject===20) td5.textContent="Full team";
        else {
            let button_takeprj=document.createElement('button');
            button_takeprj.className="btn-primary"
            button_takeprj.style="width:50%;border-radius: .25rem; background:green; border-color: green;";

            button_takeprj.textContent = "Take";
            td5.style="padding:0; margin:0;";
            td5.insertAdjacentElement('beforeend', button_takeprj);
            tr.className="new-proj-for-worker";
            tr_descr.className=tr.className;
            button_takeprj.addEventListener('click', e => {                  
                e.preventDefault();
                td5.textContent="You already in project";
                tr.className="";
                td4.textContent=(countStaffInProject+1)+"/20";
                td5.style="";
                tr_descr.className="";
                let xhr = new XMLHttpRequest();
                let url = "http://localhost:8080/projectStaffs/save";
                xhr.open("POST", url, true);
                xhr.setRequestHeader("Content-Type", "application/json");
        
                xhr.onreadystatechange = function () 
                {
                    if (xhr.readyState === 4 && xhr.status === 200) {
                        let json = JSON.parse(xhr.responseText);
                    }
                };
                let data = JSON.stringify({"idContractProject": idProject, "idWorker": idWorker});
                //console.log(data);
                xhr.send(data);
            });

        }
        
        //td3.textContent = ;//reward
        tr.appendChild(td3);
        //td4.textContent = ;//staff#
        tr.appendChild(td4);  
        tr.appendChild(td5); //status 
        //console.log("dfsdfsdfsd"+tr.style.display);
        //console.log(response.description);
        myProjectsContainer.appendChild(tr);

        
        let td = document.createElement('td');
        td.colSpan="5";
        td.textContent = "Description: "+projects.description;
        tr_descr.appendChild(td);
        //tr.style.display="none";
        
        if(tr.style.display==="none") tr_descr.style.display="none";
        
        myProjectsContainer.appendChild(tr_descr);
    });
}

function checkNewProjForWorker(){
    
    let checkbox = document.getElementById('check-new-proj-for-worker');
    if (checkbox.checked === true) 
    {
        let elems = document.getElementsByClassName("new-proj-for-worker");
        //console.log(elems);
        for (let i = 0; i < elems.length; i++)
            elems[i].style.display = '';
    }
   
    else {
        let elems = document.getElementsByClassName("new-proj-for-worker");
        for (let i = 0; i < elems.length; i++)
            elems[i].style.display = "none";
    }
    
}

function checkCompletedProjForWorker(){
    
    let checkbox = document.getElementById('check-completed-proj-for-worker');
    if (checkbox.checked === true) 
    {
        let elems = document.getElementsByClassName("completed-proj-for-worker");
        //console.log(elems);
        for (let i = 0; i < elems.length; i++)
            elems[i].style.display = '';
    }
   
    else {
        let elems = document.getElementsByClassName("completed-proj-for-worker");
        for (let i = 0; i < elems.length; i++)
            elems[i].style.display = "none";
    }
    
}






const showClientProjects = () =>
{
 

    console.log('my projects were loaded');
    const url = 'http://localhost:8080/contracts';
    ajaxDemoSample(url, (response) => {
        //console.log(response);
        makeTableClientProjects(response);
    });
};

const makeTableClientProjects = (contracts) => {
    const contractsContainer = document.getElementById('client-projects');
    console.log(idClient);
    for(let contract in contracts) {
        if(idClient===contracts[contract].idClient)                                          //IMPORTANT
        {
            let tr = document.createElement('tr');
            let td_id_contract = document.createElement('td');
            let td_cost = document.createElement('td');

            td_cost.id='cost-for-clients-contract-'+contracts[contract].id;
            tr.id='contract-for-client-'+contracts[contract].id;
            tr.style.backgroundColor="#d3d3d3";

            td_id_contract.colSpan="2";
            td_cost.colSpan="3";

            td_id_contract.textContent = 'Contract #' + contracts[contract].id;
            tr.appendChild(td_id_contract);
            
            //console.log(contract);
            td_cost.textContent = "0";
            tr.appendChild(td_cost);

            contractsContainer.appendChild(tr);

            showProjectsForContract(contracts[contract].id, contractsContainer);
        }
    }
    
}


const showProjectsForContract = (idContract, contractsContainer) =>
{
    //console.log(idContract);

    const contractProjectsContainer = document.getElementById('contract-for-client-'+idContract);
////////////////////////////
    let tr = document.createElement('tr');
    let td1 = document.createElement('td');
    let td2 = document.createElement('td');
    let td3 = document.createElement('td');
    let td4 = document.createElement('td');

    td4.colSpan="2";
    //Add 
    let button_add_project=document.createElement('button');

    button_add_project.className="btn-primary";
    button_add_project.style="width:60%;border-radius: .25rem; background:green; border-color: green;";
    button_add_project.textContent = "Add";
    button_add_project.id='button-add-project-'+idContract;

    td1.style="padding:0; margin:0;";
    

    td1.insertAdjacentElement('beforeend', button_add_project);

    //td2.textContent = "In processing";

    let select_projects = document.createElement('select');
    select_projects.onchange='findOptionProjects(this)'; //
    select_projects.className="form-select";
    //selector_projects.ariaLabel = "Default select example";

    let opt1=document.createElement('option');
    let opt2=document.createElement('option');
//
    let opt3=document.createElement('option');
    let opt4=document.createElement('option');///////
    let opt5=document.createElement('option');
//

    opt1.value='1';
    opt2.value='2';
//
    opt3.value='3';
    opt4.value='4';/////////
    opt5.value='5';
//

    opt1.textContent='home design software';
    opt2.textContent='consultation';
//
    opt3.textContent='building design';
    opt4.textContent='author\'s supervision';///////////////
    opt5.textContent='interior design';
//

    select_projects.insertAdjacentElement('beforeend', opt1);
    select_projects.insertAdjacentElement('beforeend', opt2);
//
    select_projects.insertAdjacentElement('beforeend', opt3);
    select_projects.insertAdjacentElement('beforeend', opt4);////////////////
    select_projects.insertAdjacentElement('beforeend', opt5);
//

    

    td2.insertAdjacentElement('beforeend', select_projects);
    //let opt3=

    td3.textContent = "10000";
    td3.id='cost-for-select-'+idContract;
    td4.textContent = "Description: Development home design software";
    td4.id='description-for-select-'+idContract;
    select_projects.value=1;
    select_projects.addEventListener('change', e => {
        //alert(select_projects.value);
        if(select_projects.value==1)
        {
            document.getElementById('cost-for-select-'+idContract).textContent="10000";
            document.getElementById('description-for-select-'+idContract).textContent="Description: Development home design software";
        }
        else if (select_projects.value==2)
        {
            document.getElementById('cost-for-select-'+idContract).textContent="3000";
            document.getElementById('description-for-select-'+idContract).textContent="Description: Consultation on any issue";
        }
        else if (select_projects.value==3)
        {
            document.getElementById('cost-for-select-'+idContract).textContent="30000";
            document.getElementById('description-for-select-'+idContract).textContent="Development and drawing of the entire building";
        }
        else if (select_projects.value==4)
        {
            document.getElementById('cost-for-select-'+idContract).textContent="5000";
            document.getElementById('description-for-select-'+idContract).textContent="Description: Supervision and professional advice for the construction of your building ";
        }
        else if (select_projects.value==5)
        {
            document.getElementById('cost-for-select-'+idContract).textContent="15000";
            document.getElementById('description-for-select-'+idContract).textContent="Description: Building interior layout ";
        }
        //console.log("do Marina know");
        //console.log(document.getElementById('button-add-project-'+idContract));
    });

//console.log(button_add_project);
//console.log(document.getElementById('button-add-project-'+idContract));
    button_add_project.addEventListener('click', e => {                  
        e.preventDefault();
        let xhr = new XMLHttpRequest();
        let url = "http://localhost:8080/contractProjects/save";
        xhr.open("POST", url, true);
        xhr.setRequestHeader("Content-Type", "application/json");

        xhr.onreadystatechange = function () 
        {
            if (xhr.readyState === 4 && xhr.status === 200) {
                let json = JSON.parse(xhr.responseText);
            }
        };
        let data = JSON.stringify({"idProject": select_projects.value, "idContract": idContract, "idStatusProject": 1});
        //console.log(data);
        xhr.send(data);
        //console.log("do you know");

        url = 'http://localhost:8080/contractProjects';
        ajaxDemoSample(url, (contractProjects) => {
            //console.log(contractProjects[contractProjects.length-1]);
            //makeTable(response);
            let tr = document.createElement('tr');
            let td1 = document.createElement('td');
            let td2 = document.createElement('td');
            let td3 = document.createElement('td');
            let td4 = document.createElement('td');
            let td5 = document.createElement('td');
    
            td1.textContent = contractProjects[contractProjects.length-1].id;
            tr.appendChild(td1);
            if(select_projects.value==1){
                td2.textContent = "home design software";
                td3.textContent = "10000";
            }
            else if(select_projects.value==2)
            {
                td2.textContent = "consultation";
                td3.textContent = "3000";
            }
            else if(select_projects.value==3)
            {
                td2.textContent = "building design";
                td3.textContent = "30000";
            }
            else if(select_projects.value==4)
            {
                td2.textContent = "author's supervision";
                td3.textContent = "5000";
            }
            else if(select_projects.value==5)
            {
                td2.textContent = "interior design";
                td3.textContent = "15000";
            }

            let cost_contracts = document.getElementById("cost-for-clients-contract-"+idContract);
            let upd_cost_contract=String(Number(td3.textContent)+Number(cost_contracts.textContent));
            cost_contracts.textContent=upd_cost_contract;


            tr.appendChild(td2);
            tr.appendChild(td3);
            
            td4.textContent = "0/20";
            tr.appendChild(td4);
            td5.textContent = "Awaiting";
            tr.appendChild(td5);
    
            document.getElementById("add-function-for-contract-"+idContract).insertAdjacentElement('beforebegin', tr);

        });
        /*
        */
//
    });

    tr.appendChild(td1);
    tr.appendChild(td2);
    tr.appendChild(td3);
    tr.appendChild(td4);

    tr.id="add-function-for-contract-"+idContract;
    //tr.style.borderColor = "black";

    contractProjectsContainer.insertAdjacentElement('afterend', tr);


////////////////////////
    const url = 'http://localhost:8080/contractProjects';
    ajaxDemoSample(url, (contractProjects) => {
        //console.log(response.idStatusProject);
        let costContract=0;
        let countProjects=0;
        //console.log(contractProjects);
        for(let contractProject in contractProjects) {
            if(idContract===contractProjects[contractProject].idContract)
            {
                //console.log(contractProjects[contractProject]);
                let tr = document.createElement('tr');
                let td1 = document.createElement('td');
                let td2 = document.createElement('td');
                let td3 = document.createElement('td');
                let td4 = document.createElement('td');
                let td5 = document.createElement('td');

                //console.log("Project # " + idContract+" "+contractProjects[contractProject].idProject); /////////////////////////

                td1.textContent = contractProjects[contractProject].id;
                tr.appendChild(td1);


                const url1 = 'http://localhost:8080/projects/'+contractProjects[contractProject].idProject;
                ajaxDemoSample(url1, (project) => {
                    td2.textContent = project.projectName;  
                    //console.log("name " + idContract+" "+contractProjects[contractProject].idProject); /////////////////////////
                    tr.appendChild(td2);
                    if(contractProjects[contractProject].idStatusProject!=2) 
                    {
                        td3.textContent = project.projectCost;  
                        costContract+=project.projectCost;
                    } else td3.textContent = project.projectCost+' (0)'; 
                    //console.log("cost " + idContract+" "+contractProjects[contractProject].idProject); /////////////////////////
                    tr.appendChild(td3);
                    
                
                    document.getElementById('cost-for-clients-contract-'+idContract).textContent=costContract;
                

                    const url2 = 'http://localhost:8080/projectStaffs';
                    ajaxDemoSample(url2, (staffs) => {
    
                        let countStaff=0;
                        for(let staff in staffs)
                        {
                            if(staffs[staff].idContractProject===contractProjects[contractProject].id)
                            {
                                countStaff++;
                            }
                            
                        }
                        td4.textContent = countStaff+'/20';
                        //console.log("staff # " + idContract+" "+contractProjects[contractProject].idProject); /////////////////////////
                        tr.appendChild(td4);
                        //close button in ajax for pr_staff
                        if(contractProjects[contractProject].idStatusProject===1) td5.textContent = "Awaiting";
                        else if (contractProjects[contractProject].idStatusProject===2) td5.textContent = "Regected";
                        else if (contractProjects[contractProject].idStatusProject===3) 
                        {
                            let button_close=document.createElement('button');
                            button_close.className="btn-primary";
                            button_close.style="width:70%;border-radius: .25rem; background:#8B0000; border-color:#8B0000;";
                            button_close.textContent = "Close";
                            
                            //console.log("status " + idContract+" "+contractProjects[contractProject].idProject); /////////////////////////
                            td5.insertAdjacentElement('beforeend', button_close);

                            button_close.addEventListener('click', e =>    
                            {
                                td5.textContent="Completed";
                                td5.style='margin:0;padding:0;';
        
                                let xhr = new XMLHttpRequest();
                                let url = "http://localhost:8080/contractProjects/update/"+contractProjects[contractProject].id;
                                xhr.open("PUT", url, true);
                                xhr.setRequestHeader("Content-Type", "application/json");
                            
                                let data = JSON.stringify({"idProject": contractProjects[contractProject].idProject, "idContract": contractProjects[contractProject].idContract, "idStatusProject": 4});
                                console.log(data);
                                xhr.send(data);
                            });
                            
                        }
                        else if (contractProjects[contractProject].idStatusProject===4) td5.textContent = "Completed";
                        td5.style="padding:0; margin:0;";
                        
                        tr.appendChild(td5);
                        //
                    });  
                    tr.id='count-last-row-for-selection-'+(++countProjects)+'-'+idContract;
                    //console.log(tr.id);
                    //console.log(tr);
                    contractProjectsContainer.insertAdjacentElement('afterend', tr);
                    //contractProjectsContainer.appendChild(tr);
                });

                
                
            }
            //console.log("1");
        }
        //console.log(lastRowSelectionContainer);
        



    });
};

// BUTTON ADD NEW CONTRACT
const addNewContract = () =>{

    //button_add_project.addEventListener('click', e => {                  
        //e.preventDefault();
    let xhr = new XMLHttpRequest();
    let url = "http://localhost:8080/contracts/save";
    xhr.open("POST", url, true);
    xhr.setRequestHeader("Content-Type", "application/json");

    xhr.onreadystatechange = function () 
    {
        if (xhr.readyState === 4 && xhr.status === 200) {
            let json = JSON.parse(xhr.responseText);
        }
    };
    let data = JSON.stringify({"idClient": idClient});
    //console.log(data);
    xhr.send(data);

//alert();
    url = 'http://localhost:8080/contracts';
    setTimeout(function(){

        ajaxDemoSample(url, (contracts) => {

            const contractsContainer = document.getElementById('client-projects');
    
            let tr = document.createElement('tr');
            let td_id_contract = document.createElement('td');
            let td_cost = document.createElement('td');

            let high_id_contracts = function(){
                let high=contracts[0].id;
                for(let contract in contracts)
                {
                    if(high<contracts[contract].id) high=contracts[contract].id;
                }
                
                return high;
            }();

            //console.log(high_id_contracts);
            //console.log("sadasdasd");
            td_cost.id='cost-for-clients-contract-'+high_id_contracts;
            tr.id='contract-for-client-'+high_id_contracts;
            tr.style.backgroundColor="#d3d3d3";
            
            td_id_contract.colSpan="2";
            td_cost.colSpan="3";
    
            td_id_contract.textContent = 'Contract #' + high_id_contracts;
            tr.appendChild(td_id_contract);
    
    
            tr.appendChild(td_cost);
    
            contractsContainer.insertAdjacentElement('beforeend', tr);
            //contractsContainer.appendChild(tr);
            console.log(contracts);
            //console.log(contracts[contracts.length-1]);

            showProjectsForContract(high_id_contracts, contractsContainer);

        });

    },100);
    


    //});
    
}