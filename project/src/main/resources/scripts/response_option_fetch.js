function createResponse(newResponseData) {
    const urlPost = 'http://localhost:8090/responseOptions/save';

    fetch(urlPost, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(newResponseData)
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
            console.log('Respuesta creada:', data);
            const createdSurvey = JSON.parse(data);
            console.log(createdSurvey);
        })
        .catch(error => {
            console.error('Error al crear la Respuesta:', error);
        });
}

// Ejemplo de uso:
const newResponseData = {
    
    "question": {
      "id": 1,
    },

    "response": "París",
    "reference_html": "<p>Referencia a la capital de Francia</p>"
  }
  ;
createResponse(newResponseData);