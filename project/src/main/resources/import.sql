INSERT INTO surveys (name, description, created_at, updated_at)
VALUES
    ('Encuesta 1', 'Descripción de la encuesta 1', '2024-08-29 10:00:00', '2024-08-29 10:00:00'),
    ('Encuesta 2', 'Descripción de la encuesta 2', '2024-08-29 11:00:00', '2024-08-29 11:00:00'),
    ('Encuesta 3', 'Descripción de la encuesta 3', '2024-08-29 12:00:00', '2024-08-29 12:00:00'),
    ('Encuesta 4', 'Descripción de la encuesta 4', '2024-08-29 13:00:00', '2024-08-29 13:00:00'),
    ('Encuesta 5', 'Descripción de la encuesta 5', '2024-08-29 14:00:00', '2024-08-29 14:00:00');


INSERT INTO chapter (chapter_number, chapter_title ,survey_id) 
VALUES ( '1' , 'Introducción a la Encuesta', 11);
INSERT INTO chapter (chapter_number, chapter_title ,survey_id) 
VALUES ( '1' , 'Introducción a la Encuesta', 11);
INSERT INTO chapter (chapter_number, chapter_title ,survey_id) 
VALUES ( '1' , 'Introducción a la Encuesta', 11);
INSERT INTO chapter (chapter_number, chapter_title ,survey_id) 
VALUES ( '1' , 'Introducción a la Encuesta', 11);

INSERT INTO question (chapter_number, chapter_title ,survey_id) 
VALUES ( '1' , 'Introducción a la Encuesta', 11);

INSERT INTO question ( chapter_id, question_number, comment_question) 
VALUES 
( 20, 'Q1',  'What is your favorite color?'),
( 20, 'Q2',  'Please describe your experience with our service.'),
( 20, 'Q3',  'Did you find everything you were looking for?'),
( 20, 'Q4',  'On a scale of 1 to 10, how would you rate our service?');

select * from surveys;
select * from chapter;

select * from question;