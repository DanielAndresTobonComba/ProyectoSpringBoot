function fetchSurveyById(id) {
    const url = `http://localhost:8090/chapter/findChapterBySurveyId/${id}`;

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
fetchSurveyById(1);


function createChapter(surveyData) {
    const urlPost = 'http://localhost:8090/chapter/create';

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

    "survey": {
        "id": 1
    },
    "chapterNumber": "01",
    "chapterTitle": "Introducción"
};
createChapter(newSurveyData);


function updateSurvey(id, updateChapterData) {
    const urlPut = `http://localhost:8090/chapter/updateChapter/${id}`;

    fetch(urlPut, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(updateChapterData)
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
            console.log('Capitulo actualizado:', data);
            const updatedSurvey = JSON.parse(data);
            console.log(updatedSurvey);
        })
        .catch(error => {
            console.error('Error al actualizar el capitulo:', error);
        });
}


// Ejemplo de uso:
const updateChapterData =
{
    "survey": {
        "id": 1
    },
    "chapterNumber": "12",
    "chapterTitle": "prueba de fuego"
}

    ;
updateSurvey(33, updateChapterData);



function deleteChapter(id) {
    const urlDelete = `http://localhost:8090/chapter/deleteOne/${id}`;

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
            console.error('Error al eliminar el capítulo:', error);
        });
}

// Ejemplo de uso:
deleteChapter(13);