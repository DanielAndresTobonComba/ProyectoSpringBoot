
document.body.setAttribute("onload", "onLoadCreate()");
document.getElementById("logout").setAttribute("onclick", "backToLogin()");

document.getElementById("back").setAttribute("onclick", "backToViewUser()");

document.getElementById("close-view-button").setAttribute("onclick", "closeView()");



function onLoadCreate() {

    query = "http://localhost:8090/api/surveyjson/allSurveys";
    
    fetch (query, {
        method: 'GET',
        // mode: "cors",
        headers: {
        'Content-type' : 'application/json; charset=UTF-8',
        'Access-Control-Allow-Origin': '*',
        },
        })
        .then(response => response.json())
        .then(json => {

            jsonList = json;

            let divContent = document.getElementById("saved-survey");

            if (json.length === 0) {

                divContent.innerHTML="<h1>NO HAY ENCUESTAS GUARDADAS EN ESTE MOMENTO</h1>";

            } else {

                json.forEach(element => {

                
                    let idSurvey = element.id;
                    let headSuervey = JSON.parse(element.json)[0].value_html;
                    let descriptionSurvey = JSON.parse(element.json)[1].value_html;
                    let idSeeSurvey = "see-" + idSurvey; 
                    let newDiv = document.createElement("div");
                    let idNewDiv = "survey-" + idSurvey;
                    newDiv.id=idNewDiv;
                    newDiv.classList.add("centrado", "container-survey","bg-body-tertiary", "rounded", "shadow", "p-3", "mb-5");
                    newDiv.innerHTML = `<div class="w-100 d-flex justify-content-center centrado-vertical gap-3"><button id='${idSeeSurvey}' type="button" class="border border-0 bg-body-tertiary" ><img src="./static/visibility.png" alt="" class="shadow-component rounded-circle"></button></div><p class="head fw-bold text-decoration-underline text-break text-center">${headSuervey}</p><p class="description text-start w-100 text-break">${descriptionSurvey}</p>`
                    divContent.appendChild(newDiv);

                    document.getElementById(`${idSeeSurvey}`).setAttribute("onclick", `seeSurvey(${idSurvey})`);
                    document.getElementById("saved-survey").style.display = "flex";
                    document.getElementById("saved-survey").style.flexWrap = "wrap"; 
                    document.getElementById("saved-survey").style.justifyContent = "center"; 
                    document.getElementById("back").style.visibility = "hidden";
    
                    
                });

            }

            
 
        })

}

function backToLogin() {
    location.href = "http://localhost:8090/index"
}

function backToViewUser() {
    location.href = "http://localhost:8090/user"
}


function seeSurvey(idSurvey) {

    document.getElementById("saved-survey").style.display = "none";
    // document.getElementById("div-close-view-button").style.visibility = "visible";
    document.getElementById("board").style.display = "flex";
    document.getElementById("back").style.visibility = "visible";
    

    

    query = `http://localhost:8090/api/surveyjson/${idSurvey}`
    
    fetch (query, {
        method: 'GET',
        mode: "cors",
        headers: {
        'Content-type' : 'application/json; charset=UTF-8',
        'Access-Control-Allow-Origin': '*',
        },
        })
        .then(response => response.json())
        .then(json => {
            
            let htmlText = json.html;
            let jsonHtml =JSON.parse(json.json);
            let divContent = document.getElementById("painter");

            divContent.innerHTML = htmlText;

            for (let i=0; i<=jsonHtml.length - 1; i++) {

                let idHtml = JSON.parse(json.json)[i].id_html;
                let textContent = JSON.parse(json.json)[i].value_html;

                document.getElementById(idHtml).value = textContent;

            }
    
        })
    
}



