-- Insertar categorías de encuesta
INSERT INTO survey_category (name, reference_html)
VALUES s
('Deportes', '<p>Deporte category reference HTML</p>'),
('Contabilidad', '<p>Contabilidad category reference HTML</p>');

-- Insertar las encuestas
INSERT INTO surveys (reference_html, name, description, survey_category)
VALUES 
('<p>Survey 1 reference HTML</p>', 'Survey 1', 'Description of Survey 1', 1),
('<p>Survey 2 reference HTML</p>', 'Survey 2', 'Description of Survey 2', 2);

-- Insertar los capítulos de la primera encuesta
INSERT INTO chapter (chapter_title, reference_html, survey_id)
VALUES 
('Chapter 1', '<p>Chapter 1 reference HTML</p>', 1),
('Chapter 2', '<p>Chapter 2 reference HTML</p>', 1);

-- Insertar los capítulos de la segunda encuesta
INSERT INTO chapter (chapter_title, reference_html, survey_id)
VALUES 
('Chapter 1', '<p>Chapter 1 reference HTML</p>', 2),
('Chapter 2', '<p>Chapter 2 reference HTML</p>', 2);

-- Insertar las preguntas en cada capítulo de la primera encuesta
INSERT INTO question (question_number, response_type, reference_html, chapter_id)
VALUES 
('Q1', 'Single Choice', '<p>Question 1 reference HTML</p>', 1),
('Q2', 'Single Choice', '<p>Question 2 reference HTML</p>', 2);

-- Insertar las preguntas en cada capítulo de la segunda encuesta
INSERT INTO question (question_number, response_type, reference_html, chapter_id)
VALUES 
('Q1', 'Single Choice', '<p>Question 1 reference HTML</p>', 3),
('Q2', 'Single Choice', '<p>Question 2 reference HTML</p>', 4);

-- Insertar las opciones de respuesta para cada pregunta de la primera encuesta
INSERT INTO response_options (response, reference_html, question_id)
VALUES 
('Option 1 for Q1', '<p>Response option 1 for Q1 HTML</p>', 1),
('Option 1 for Q2', '<p>Response option 1 for Q2 HTML</p>', 2);

-- Insertar las opciones de respuesta para cada pregunta de la segunda encuesta
INSERT INTO response_options (response, reference_html, question_id)
VALUES 
('Option 1 for Q1', '<p>Response option 1 for Q1 HTML</p>', 3),
('Option 1 for Q2', '<p>Response option 1 for Q2 HTML</p>', 4);

-- Consultas para verificar la inserción de datos
SELECT * FROM surveys;
SELECT * FROM chapter;
SELECT * FROM question;
SELECT * FROM response_options;
