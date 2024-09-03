
alert ("llegue a mi funciones")

const getSurveyById = async (id) => {
    try {
        const response = await fetch(`survey/findOne/${id}`);
        if (!response.ok) {
            throw new Error('Error al obtener la encuesta');
        }
        const survey = await response.json();
        console.log(survey);
    } catch (error) {
        console.error(error);
    }
};

// Ejemplo de uso:
getSurveyById(1);


const createSurvey = async (surveyData) => {
    try {
        const response = await fetch('/api/surveys', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(surveyData)
        });

        if (!response.ok) {
            throw new Error('Error al crear la encuesta');
        }
        const newSurvey = await response.json();
        console.log('Encuesta creada:', newSurvey);
    } catch (error) {
        console.error(error);
    }
};

// Ejemplo de uso:
const newSurveyData = {
    name: 'Encuesta de Satisfacción',
    description: 'Encuesta para evaluar la satisfacción del cliente'
};
createSurvey(newSurveyData);



const updateSurvey = async (id, updatedData) => {
    try {
        const response = await fetch(`/api/surveys/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(updatedData)
        });

        if (!response.ok) {
            throw new Error('Error al actualizar la encuesta');
        }
        const updatedSurvey = await response.json();
        console.log('Encuesta actualizada:', updatedSurvey);
    } catch (error) {
        console.error(error);
    }
};

// Ejemplo de uso:
const updatedSurveyData = {
    name: 'Encuesta de Satisfacción Actualizada',
    description: 'Descripción actualizada de la encuesta'
};
updateSurvey(1, updatedSurveyData);





const deleteSurvey = async (id) => {
    try {
        const response = await fetch(`/api/surveys/${id}`, {
            method: 'DELETE'
        });

        if (!response.ok) {
            throw new Error('Error al eliminar la encuesta');
        }
        console.log('Encuesta eliminada');
    } catch (error) {
        console.error(error);
    }
};

// Ejemplo de uso:
deleteSurvey(1);



export { getSurveyById, createSurvey, updateSurvey, deleteSurvey };