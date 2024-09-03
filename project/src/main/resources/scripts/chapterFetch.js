

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
fetchSurveyById(11);



function createChapter(surveyData) {
    const urlPost = 'http://localhost:8090/chapter/createOne';

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
    
        "chapter_number": "1",
        "chapter_title": "Introduction to Surveys",
        "survey": {
            "id": 1
    }
};
createSurvey(newSurveyData);