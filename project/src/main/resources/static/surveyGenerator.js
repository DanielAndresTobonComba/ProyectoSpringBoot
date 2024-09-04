let jsonList;
// let lastidButtonActived = "";

document.body.setAttribute("onload", "onLoadCreate()");
document.getElementById("categories").setAttribute("onchange", "seeCategory()");

function seeCategory() {
    let categoryElement = document.getElementById("categories");
    console.log(categoryElement.value);
}



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
            let secondPartIdContent = className.split(" ")[2];
            let idContentSection = firtPartIdContent.concat(secondPartIdContent)
            let divIdContentSection = document.getElementById(idContentSection);
            let numQuestions = divIdContentSection.children.length;
            let numChapter = divIdContentSection.children[0].id.split("-")[2];
            idNewQuestionContent = idNewQuestionContent + `${numQuestions}-chapter-${numChapter}`;
            idNewHeaderQuestion = idNewHeaderQuestion + `${numQuestions}-chapter-${numChapter}`;
            idNewTextQuestion = idNewTextQuestion + `${numQuestions}-chapter-${numChapter}`;
            console.log(idNewQuestionContent);
            let newQuestionContent = document.createElement("div");
            newQuestionContent.id= idNewQuestionContent;
            newQuestionContent.className="w-100";
            newQuestionContent.innerHTML= `<div id="${idNewHeaderQuestion}" class="d-flex justify-content-around centrado-vertical header-question"><input class="question ${idNewTextQuestion} w-50 border border-0 border-bottom p-2 bg-body-tertiary"><select id = "categories" class="form-select w-25 shadow p-3 mb-5 bg-body-tertiary rounded" aria-label="Default select example"><option value="" selected>Tipo de respuesta</option></select><button type="button" class="btn-close close-button" aria-label="Close"></button></div>`;
            // newQuestion.value="Nueva pregunta";
            // newQuestion.className= secondPartIdContent;
            // newQuestion.classList.add("w-100");
            // newQuestion.classList.add("border", "border-0", "border-bottom", "p-2", "bg-body-tertiary");
            divIdContentSection.appendChild(newQuestionContent);
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
    
    

