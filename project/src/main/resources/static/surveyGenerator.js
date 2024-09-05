let jsonList;

let optionsList = ["Única Respuesta", "Respuesta Múltiple", "Respuesta Abierta"];

document.body.setAttribute("onload", "onLoadCreate()");


function onLoadCreate() {

    // Asignar función registrar HTML en la tabla survey_json
    let sendHTMLButton = document.getElementById("regist-button");
    sendHTMLButton.setAttribute("onclick", "sendHTML()");
    

    
    query = "http://localhost:8090/api/categories"
    
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
            const category_select = document.getElementById("categories");
            json.forEach(element => {
                let option_element = document.createElement("option");
                option_element.value= element;
                option_element.textContent = element;
                category_select.appendChild(option_element);
            });
 
        })
    
}



function createQuestion() {
    let  count = 1;
    const myCustomListener = function(e) {
        e.stopPropagation();
        count++;

        if (count ===2 ) {
            

            let className = e.target.className; 
            let firtPartIdContent= "content-";
            let idNewQuestionContent = "content-question-"
            let idNewHeaderQuestion = "header-question-";
            let idNewTextQuestion = "text-question-";
            let idNewSelectOptionType = "select-question-";
            let idNewResponseOption = "option-question-";
            let idCloseQuestion="close-question-"
            let secondPartIdContent = className.split(" ")[2];
            let idContentSection = firtPartIdContent.concat(secondPartIdContent)
            let divIdContentSection = document.getElementById(idContentSection);
            let numQuestions = divIdContentSection.children.length;
            let numChapter = divIdContentSection.children[0].id.split("-")[2];
            let extenderId = `${numQuestions}-chapter-${numChapter}`;
            idNewQuestionContent = idNewQuestionContent + extenderId;
            idNewHeaderQuestion = idNewHeaderQuestion + extenderId;
            idNewTextQuestion = idNewTextQuestion + extenderId;
            idNewSelectOptionType = idNewSelectOptionType  + extenderId;
            idNewResponseOption = idNewResponseOption + extenderId;
            idCloseQuestion = idCloseQuestion + extenderId;
            console.log(idNewQuestionContent);
            let newQuestionContent = document.createElement("div");
            newQuestionContent.id= idNewQuestionContent;
            newQuestionContent.className="w-100";
            newQuestionContent.innerHTML= `<div id="${idNewHeaderQuestion}" class="d-flex justify-content-between centrado-vertical header-question"><input class="question ${idNewTextQuestion} w-50 border border-0 border-bottom p-2 rounded bg-warning-subtle"><button id="${idNewResponseOption}" type="button" class="btn btn-outline-success">Añadir Opción</button><select id = "${idNewSelectOptionType}" class="form-select w-25 shadow p-3 mb-5 bg-body-tertiary rounded" aria-label="Default select example"></select><button type="button" id="${idCloseQuestion}" class="close btn-close close-button" aria-label="Close"></button></div>`;
            
            divIdContentSection.appendChild(newQuestionContent);


            let addOptionButton = document.getElementById(idNewResponseOption);
            addOptionButton.setAttribute("onclick", "addNewOption()");
            let selectelement = document.getElementById(idNewSelectOptionType);
            let countOption = 0;
            optionsList.forEach( option => {
                countOption++;
                let newResponseOption = document.createElement("option");

                newResponseOption.value = option;
                newResponseOption.textContent = option;
                if (countOption === 1) {
                    newResponseOption.selected = true;
                }
                selectelement.appendChild(newResponseOption);
                
                let selectElement = document.getElementById(idNewSelectOptionType);
                selectElement.setAttribute("onchange", `changeTypeOption("${idNewQuestionContent}", "${idNewSelectOptionType}")`)
            })
        }
        
    }
    
    document.body.addEventListener("click", myCustomListener);  
    
    
}

function addNewOption() {
    let  count = 1;
    const myCustomListener = function(e) {
        e.stopPropagation();
        count++;
        if (count==2) {
            let finalPartId = e.target.id.replace("option-", "");
            let divContentQuestionId = "content-" + finalPartId;
            let divContentQuestion = document.getElementById(divContentQuestionId);
            let lengthDivContentQuestionChildren = divContentQuestion.children.length;
            let numCreatedOptions = lengthDivContentQuestionChildren - 1;
            let newDivOption = document.createElement("div");
            let idNewDivOption = "divOption-" + `${numCreatedOptions++}-` + finalPartId;
            let idCloseButton = "close-" + `${finalPartId}-${++numCreatedOptions}`
            newDivOption.classList.add("d-flex", "justify-content-start", "gap-3", "w-100", "centrado-vertical", "p-2");
            newDivOption.id = idNewDivOption;
            if (lengthDivContentQuestionChildren == 1) {
                let idSelectParent = "select-" + finalPartId;
                
                let selectParent = document.getElementById(idSelectParent);
                let selectOptionResponseValue = selectParent.value;
                
                if (selectOptionResponseValue === "Única Respuesta") {
                    
                    newDivOption.innerHTML = `<input type="radio" id="${finalPartId}-${++numCreatedOptions}-unique" class="option-marked p-2 form-check-input border border-primary" name="${finalPartId}" value=""><input type="text" class="border border-0 border-bottom rounded w-25 p-2 bg-success-subtle" id="text-${finalPartId}-${++numCreatedOptions}" value=""><button type="button" id="close-${finalPartId}-1" class="close btn-close close-button" aria-label="Close"></button>`;
                    
                } else if (selectOptionResponseValue === "Respuesta Múltiple") {

                    newDivOption.innerHTML = `<input type="checkbox" id="${finalPartId}-${++numCreatedOptions}-several" class="option-marked p-2 form-check-input border border-primary" name="${finalPartId}-${++numCreatedOptions}" value=""><input type="text" class="border border-0 border-bottom rounded w-25 p-2 bg-success-subtle" id="text-${finalPartId}-${++numCreatedOptions}" value=""><button type="button" id="close-${finalPartId}-1" class="close btn-close close-button" aria-label="Close"></button>`;

                } else if (selectOptionResponseValue === "Respuesta Abierta") {

                    newDivOption.innerHTML = `<textarea id="${finalPartId}-text" name="${finalPartId}" rows="3" cols="60" class="rounded p-2 border border-0 bg-success-subtle"></textarea>`;

                }


                divContentQuestion.appendChild(newDivOption);

                document.getElementById(`close-${finalPartId}-1`).setAttribute("onclick", `removeElement("${idNewDivOption}")`);

                
            } else {

                let lastPartIdFirstResponseOptionInto = divContentQuestion.children[1].children[0].id.split("-").slice(-1)[0];
                
                if (lastPartIdFirstResponseOptionInto != "text") {

                    if (lastPartIdFirstResponseOptionInto === "unique") {

                        newDivOption.innerHTML = `<input type="radio" id="${finalPartId}-${++numCreatedOptions}-unique" class="option-marked p-2 form-check-input border border-primary" name="${finalPartId}" value=""><input type="text" class="border border-0 border-bottom rounded w-25 p-2 bg-success-subtle" id="text-${finalPartId}-${++numCreatedOptions}" value=""><button type="button" id="${idCloseButton}" class="close btn-close close-button" aria-label="Close"></button>`;

                    } else {

                        newDivOption.innerHTML = `<input type="checkbox" id="${finalPartId}-${++numCreatedOptions}-several" class="option-marked p-2 form-check-input border border-primary" name="${finalPartId}-${++numCreatedOptions}" value=""><input type="text" class="border border-0 border-bottom rounded w-25 p-2 bg-success-subtle" id="text-${finalPartId}-${++numCreatedOptions}" value=""><button type="button" id="${idCloseButton}" class="close btn-close close-button" aria-label="Close"></button>`;

                    }

                    divContentQuestion.appendChild(newDivOption);
                    document.getElementById(`${idCloseButton}`).setAttribute("onclick", `removeElement("${idNewDivOption}")`)

                }

            }
        }
    }

    document.body.addEventListener("click", myCustomListener);  

}


function createChapter() {
    let divContent = document.getElementById("content");
    let numChildren = divContent.children.length;
    let newDiv = document.createElement("div");
    let idNewDiv = "section-" + ++numChildren;
    newDiv.id=idNewDiv;
    newDiv.classList.add("centrado");
    newDiv.classList.add("p-3");
    newDiv.classList.add("section");
    newDiv.classList.add("w-100");
    newDiv.classList.add("shadow", "p-3", "mb-5", "bg-body-tertiary", "rounded");
    newDiv.innerHTML=`<div id = 'content-${idNewDiv}' class = 'centrado w-75'><input id = 'header-chapter-${numChildren}' type='text' class = 'section-${numChildren} p-3 mb-2 bg-body-secondary text-success-emphasis border border-bottom-0 rounded fw-bold w-100' value = 'Capítulo ${numChildren}'></div><button id = 'but-section-${numChildren}' class = ' but-question section-${numChildren} btn btn-outline-warning ' onclick='createQuestion()'>Nueva pregunta</button>`;
    divContent.appendChild(newDiv);
    
}

function changeTypeOption(idDiv, idSelector) {
    
    
    let idFinalPart = idDiv.replace("content-", "");
    let divContentQuestionElement = document.getElementById(idDiv);
    let selectorChanged = document.getElementById(idSelector);
    let typeOption;
    let numQuestionOptions = divContentQuestionElement.children.length -1;
    if (numQuestionOptions == 1) {
        let tagNameOption = divContentQuestionElement.children.item(1).children.item(0).tagName;
        let idElementToChangeType = divContentQuestionElement.children.item(1).children.item(0).id;
        if (selectorChanged.value === optionsList[0] && tagNameOption != "TEXTAREA") {

            typeOption = "radio";
            divContentQuestionElement.children.item(1).children.item(0).id = idElementToChangeType.replace("several", "unique");
            divContentQuestionElement.children.item(1).children.item(0).name = idFinalPart;
            divContentQuestionElement.children.item(1).children.item(0).type = typeOption;

        }  else if (selectorChanged.value === optionsList[1] && tagNameOption != "TEXTAREA") {

            typeOption = "checkbox";
            divContentQuestionElement.children.item(1).children.item(0).id = idElementToChangeType.replace("unique", "several");
            divContentQuestionElement.children.item(1).children.item(0).name = idFinalPart + "-1";
            divContentQuestionElement.children.item(1).children.item(0).type = typeOption;

        } else if(selectorChanged.value === optionsList[0] && tagNameOption === "TEXTAREA") {
            
            let idDivToChange =divContentQuestionElement.children.item(1).id;
            divContentQuestionElement.children.item(1).innerHTML = `<input type="radio" id="${idFinalPart}-1-unique" class="option-marked p-2 form-check-input border border-primary" name="${idFinalPart}" value=""><input type="text" class="border border-0 border-bottom rounded w-25 p-2 bg-success-subtle" id="text-${idFinalPart}-1" value=""><button type="button" id="close-${idFinalPart}-1" class="close btn-close close-button" aria-label="Close"></button>`;;
            document.getElementById(`close-${idFinalPart}-1`).setAttribute("onclick", `removeElement("${idDivToChange}")`); 



        } else if(selectorChanged.value === optionsList[1] && tagNameOption === "TEXTAREA") {

            let idDivToChange =divContentQuestionElement.children.item(1).id;
            divContentQuestionElement.children.item(1).innerHTML = `<input type="checkbox" id="${idFinalPart}-1-several" class="option-marked p-2 form-check-input border border-primary" name="${idFinalPart}-1" value=""><input type="text" class="border border-0 border-bottom rounded w-25 p-2 bg-success-subtle" id="text-${idFinalPart}-1" value=""><button type="button" id="close-${idFinalPart}-1" class="close btn-close close-button" aria-label="Close"></button>`;
            document.getElementById(`close-${idFinalPart}-1`).setAttribute("onclick", `removeElement("${idDivToChange}")`); 
        }
        
        else {

            divContentQuestionElement.children.item(1).innerHTML = `<textarea id="${idFinalPart}-text" name="${idFinalPart}" rows="3" cols="60" class="rounded p-2 border border-0 bg-success-subtle"></textarea>`;

        }

        
                  
    } else if (numQuestionOptions > 1) {

        if (selectorChanged.value === optionsList[0]) {

            typeOption = "radio";
            
            for (let i = 1; i <= numQuestionOptions; i++) {
                
                let idElementToChangeType = divContentQuestionElement.children.item(i).children.item(0).id;
                divContentQuestionElement.children.item(i).children.item(0).id = idElementToChangeType.replace("several", "unique");
                divContentQuestionElement.children.item(i).children.item(0).name = idFinalPart;
                divContentQuestionElement.children.item(i).children.item(0).type = typeOption;

            }
            

        } else if(selectorChanged.value === optionsList[1]) {

            typeOption = "checkbox";
            
            for (let j= 1; j<=numQuestionOptions; j++) {

                let idElementToChangeType = divContentQuestionElement.children.item(j).children.item(0).id;
                divContentQuestionElement.children.item(j).children.item(0).id = idElementToChangeType.replace("unique", "several");
                divContentQuestionElement.children.item(j).children.item(0).name= idFinalPart + `-${j}`;
                divContentQuestionElement.children.item(j).children.item(0).type = typeOption;

            }

        } else if(selectorChanged.value === optionsList[2]) {


            for (let k = 1; k <= numQuestionOptions; k++) {

                if (k === 1) {

                    divContentQuestionElement.children.item(1).innerHTML = `<textarea id="${idFinalPart}-text" name="${idFinalPart}" rows="3" cols="60" class="rounded p-2 border border-0 bg-success-subtle"></textarea>`;

                } else {

                    divContentQuestionElement.children.item(2).remove();

                }


            }

        }

    }
    
}

function removeElement(idElementToEliminate) { 

    let divToRemove = document.getElementById(idElementToEliminate);
    divToRemove.remove(); 

}


function sendHTML() {
    let htmlSurveyRow = document.body.innerHTML.split("<script")[0];
    let htmlSurveyWhiteSpace = htmlSurveyRow.replace(/\n/g, "");
    let htmlSurveyClean = htmlSurveyWhiteSpace.replace(/\s\s/g, "");
    let surveyJsonHtml = {
        "json" : `${htmlSurveyClean}`
    }

    //Montar en la base de datos
    fetch ('http://localhost:8090/api/surveyjson', {
        method: 'POST',
        body: JSON.stringify(surveyJsonHtml),
        headers: {
        'Content-type' : 'application/json; charset=UTF-8'
        },
        })
        .then(response => response.json())
        .then(json => console.log(json))
        .catch(error => console.error("ERROR!!!:" + error))

    }
    
    

