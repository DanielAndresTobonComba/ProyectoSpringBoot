/* let jsonList;
let lastidButtonActived = "but-section-1";

function loginFunct() {
            
    alert("Hola")
}



function onLoadCreate() {

    // const corsAnywhere = 'https://cors-anywhere.herokuapp.com/';

    query = "http://localhost:8090/api/categories"
    
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



// function readCategory() {
//     let categories = jsonList;
//     let category_select = document.getElementById("categories");
//     console.log(category_select.value);
//     console.log(categories);
// }

function createQuestion() {
    let  count = 1;
    const myCustomListener = function(e) {
        e.stopPropagation();
        count++;

        if (count ===2 ) {
            let buttonQuestion = document.getElementById(lastidButtonActived);
            

            let className = e.target.className; 
            let firtPartIdContent= "content-";
            let secondPartIdContent = className.split(" ")[2];
            let idContentSection = firtPartIdContent.concat(secondPartIdContent)
            let divIdContentSection = document.getElementById(idContentSection);
            let newQuestion = document.createElement("input");
            newQuestion.value="Nueva pregunta";
            newQuestion.className= secondPartIdContent;
            divIdContentSection.appendChild(newQuestion);
            buttonQuestion.style.visibility= "visible";
        }
        
    }
    
    document.body.addEventListener("click", myCustomListener);  
    
    
}

function buttonVisible() {
    let  count = 1;
    const myCustomListener = function(e) {
        e.stopPropagation();
        count++;

        if (count==2) {
            let idSection = e.target.id;
            if (idSection.split("-").length == 2) {
                let idButtonToActive = "but-" + idSection;

                let buttonQuestionToHide = document.getElementById(lastidButtonActived);
                let buttonQuestionToAppear = document.getElementById(idButtonToActive);

                buttonQuestionToHide.style.visibility= "collapse";
                buttonQuestionToAppear.style.visibility = "visible";

                lastidButtonActived = idButtonToActive;

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
    newDiv.classList.add("p-5");
    newDiv.classList.add("section");
    newDiv.setAttribute('onclick', 'buttonVisible()')
    newDiv.innerHTML=`<div id = 'content-${idNewDiv}' class = 'centrado'><input id = 'header-chapter-${numChildren}' type='text' class = 'section-${numChildren}' value = 'Capítulo ${numChildren}'></div><button id = 'but-section-${numChildren}' class = ' but-question section-${numChildren} ' onclick='createQuestion()'>Nueva pregunta</button>`;
    divContent.appendChild(newDiv);


    
}


*/
/* alert("hiii") 



// Importa las funciones desde surveyApi.js
import { getSurveyById, createSurvey, updateSurvey, deleteSurvey } from './surveyFetch';


// Ahora puedes usar las funciones como lo necesites
getSurveyById(1);
createSurvey({ name: 'Nueva Encuesta', description: 'Descripción de la encuesta' });
updateSurvey(1, { name: 'Encuesta Actualizada', description: 'Descripción actualizada' });
deleteSurvey(1); */
