function fetchSurveyById(id) {
    const url = `http://localhost:8090/survey/findOne/${id}`;

    fetch(url, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        },
    })
        .then(response => {
            if (!response.ok) {
                return response.text().then(text => {
                    throw new Error(`HTTP error! Status: ${response.status}, Message: ${text}`);
                });
            }
            return response.text();  // Cambiado a `response.text()` para manejar respuestas de texto
        })
        .then(data => {
            console.log("Datos recibidos:", data);  // Aquí puedes manejar el string recibido
            const obj = JSON.parse(data);
            console.log(obj);
        })
        .catch(error => {
            console.error("Error al buscar los datos:", error);
            console.log("Error al buscar los datos.");  // Notifica al usuario en caso de error
        });
}

// Ejemplo de uso:
fetchQuestionById(15);


// peticion post 

function createQuestion(newQuestionData) {
    const urlPost = 'http://localhost:8090/question/createOne';

    fetch(urlPost, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(newQuestionData)
    })
        .then(response => {
            if (!response.ok) {
                return response.text().then(text => {
                    throw new Error(`HTTP error! Status: ${response.status}, Message: ${text}`);
                });
            }
            return response.text();  // O usar response.json() si la respuesta es JSON
        })
        .then(data => {
            console.log('Pregunta creada:', data);
            const createdSurvey = JSON.parse(data);
            console.log(createdSurvey);
        })
        .catch(error => {
            console.error('Error al crear la pregunta:', error);
        });
}

// Ejemplo de uso:
const newQuestionData = {
    "chapter": {
        "id": 20
    },
    "question_number": "Q1",
    "response_type": "Multiple Choice",
    "comment_question": "What is your favorite color?"
};
createQuestion(newQuestionData);

// PETICION PUT
function updateQuestion(id, updatedQuestionData) {
    const urlPut = `http://localhost:8090/question/updateQuestion/${id}`;

    fetch(urlPut, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(updatedQuestionData)
    })
        .then(response => {
            if (!response.ok) {
                return response.text().then(text => {
                    throw new Error(`HTTP error! Status: ${response.status}, Message: ${text}`);
                });
            }
            return response.text();  // O usar response.json() si la respuesta es JSON
        })
        .then(data => {
            console.log('Pregunta actualizada:', data);
            const updatedSurvey = JSON.parse(data);
            console.log(updatedSurvey);
        })
        .catch(error => {
            console.error('Error al actualizar la Pregunta:', error);
        });
}

// Ejemplo de uso:
const updatedQuestionData = {
    "chapter": {
        "id": 20
    },
    "question_number": "Q12",
    "response_type": "Multiple Choices baby",
    "comment_question": "Updating question fom js fetch?"
};
updateQuestion(16, updatedQuestionData);

// PETECION DELETE

function deleteQuestion(id) {
    const urlDelete = `http://localhost:8090/question/deleteOne/${id}`;

    fetch(urlDelete, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => {
            if (!response.ok) {
                // Manejar errores HTTP
                return response.text().then(text => {
                    throw new Error(`HTTP error! Status: ${response.status}, Message: ${text}`);
                });
            }
            // Leer el cuerpo de la respuesta como texto
            return response.text();
        })
        .then(text => {
            // Imprimir el contenido de la respuesta
            console.log(text);
        })
        .catch(error => {
            console.error('Error al eliminar la pregunta:', error);
        });
}

// Ejemplo de uso:
deleteQuestion(14);



// PETICION LIST ALL QUESTIONS BY CHAPTER ID

function fetchQuestionsByChapterId(id) {
    const url = `http://localhost:8090/question/findQuestionsByChapterId/${id}`;

    fetch(url, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        },
    })
        .then(response => {
            if (!response.ok) {
                return response.text().then(text => {
                    throw new Error(`HTTP error! Status: ${response.status}, Message: ${text}`);
                });
            }
            return response.text();  // Cambiado a `response.text()` para manejar respuestas de texto
        })
        .then(data => {
            console.log("Datos recibidos:", data);  // Aquí puedes manejar el string recibido
            const obj = JSON.parse(data);
            console.log(obj);
        })
        .catch(error => {
            console.error("Error al buscar los datos:", error);
            console.log("Error al buscar los datos.");  // Notifica al usuario en caso de error
        });
}

// Ejemplo de uso:
fetchQuestionsByChapterId(20);