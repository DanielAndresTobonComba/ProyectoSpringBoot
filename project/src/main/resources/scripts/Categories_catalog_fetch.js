function createCatalog(newCatalogData) {
    const urlPost = 'http://localhost:8090/catalog/createOne';

    fetch(urlPost, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(newCatalogData)
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
            console.log('Categoria creada:', data);
            const createdSurvey = JSON.parse(data);
            console.log(createdSurvey);
        })
        .catch(error => {
            console.error('Error al crear la Categoria:', error);
        });
}

// Ejemplo de uso:
const newCatalogData = {
    name: 'Prueba de fuego catalog'

};
createCatalog(newCatalogData);






