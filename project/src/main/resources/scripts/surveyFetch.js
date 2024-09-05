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
fetchSurveyById(15);


// peticion post 

function createSurvey(surveyData) {
    const urlPost = 'http://localhost:8090/survey/createSurvey';

    fetch(urlPost, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(surveyData)
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
            console.log('Encuesta creada:', data);
            const createdSurvey = JSON.parse(data);
            console.log(createdSurvey);
        })
        .catch(error => {
            console.error('Error al crear la encuesta:', error);
        });
}

// Ejemplo de uso:
const newSurveyData = {
    name: 'Encuesta de Satisfacción',
    description: 'Encuesta para evaluar la satisfacción del cliente'
};
createSurvey(newSurveyData);

// PETICION PUT
function updateSurvey(id, updatedSurveyData) {
    const urlPut = `http://localhost:8090/survey/updateSurvey/${id}`;

    fetch(urlPut, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(updatedSurveyData)
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
            console.log('Encuesta actualizada:', data);
            const updatedSurvey = JSON.parse(data);
            console.log(updatedSurvey);
        })
        .catch(error => {
            console.error('Error al actualizar la encuesta:', error);
        });
}

// Ejemplo de uso:
const updatedSurveyData = {
    name: 'Encuesta de Satisfacción Actualizada',
    description: 'Descripción actualizada de la encuesta'
};
updateSurvey(15, updatedSurveyData);

// PETECION DELETE

function deleteSurvey(id) {
    const urlDelete = `http://localhost:8090/survey/deleteOne/${id}`;

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
            console.error('Error al eliminar la encuesta:', error);
        });
}

// Ejemplo de uso:
deleteSurvey(14);




// PETICION LIST ALL

function surveyAll() {
    const url = `http://localhost:8090/survey/findAll`;

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
surveyAll();