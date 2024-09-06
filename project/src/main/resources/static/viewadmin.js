
document.body.setAttribute("onload", "onLoadCreate()");


function onLoadCreate() {

    query = "http://localhost:8090/api/surveyjson/allSurveys"
    
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
            json.forEach(element => {

                let divContent = document.getElementById("saved-survey");
                let idSurvey = element.id;
                let headSuervey = JSON.parse(element.json)[0].value_html;
                let descriptionSurvey = JSON.parse(element.json)[1].value_html;
                let idEliminateSurvey = "close-" + idSurvey;
                let idEditSurvey = "edit-" + idSurvey;
                let idSeeSurvey = "see-" + idSurvey; 
                let newDiv = document.createElement("div");
                let idNewDiv = "survey-" + idSurvey;
                newDiv.id=idNewDiv;
                newDiv.classList.add("centrado", "container-survey","bg-body-tertiary", "rounded", "shadow", "p-3", "mb-5");
                newDiv.innerHTML = `<div class="w-100 d-flex justify-content-center centrado-vertical gap-3"><button id='${idEliminateSurvey}' type="button" class="border border-0 bg-body-tertiary" ><img src="./static/eliminate.png" alt="" class="shadow-component rounded-circle"></button><button id='${idEditSurvey}' type="button" class="border border-0 bg-body-tertiary" ><img src="./static/edit.png" alt="" class="shadow-component rounded-circle"></button><button id='${idSeeSurvey}' type="button" class="border border-0 bg-body-tertiary" ><img src="./static/visibility.png" alt="" class="shadow-component rounded-circle"></button></div><p class="head fw-bold text-decoration-underline">${headSuervey}</p><p class="description text-start w-100">${descriptionSurvey}</p>`
                divContent.appendChild(newDiv);

                
            });
 
        })

}