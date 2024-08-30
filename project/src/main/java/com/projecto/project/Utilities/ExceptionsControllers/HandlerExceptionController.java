package com.projecto.project.Utilities.ExceptionsControllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler({ArithmeticException.class})

    public ResponseEntity<ErrorCustom> divisionByZero(Exception ex) {

        ErrorCustom error = new ErrorCustom(); // creo el objeto de la clase errorcustom
        error.setDate(new Date()); // tomo la fecha del sistema
        error.setError("Error divisiòn por cero"); // coloco el mensaje predeterminado
        error.setMessage(ex.getMessage()); // obtengo el mensaje de la excepcion del error
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value()); // obtengo el codigo de estatus del error


        // el repsonse entity necesita si o si un codigo de status
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);

        // retorno la entidad completa y como cuerpo es el objeto error con los datos
    }

    @ExceptionHandler(NoResourceFoundException.class)

    public ResponseEntity<ErrorCustom> notFoundEx(NoResourceFoundException ex) {

        ErrorCustom error = new ErrorCustom(); 
        error.setDate(new Date()); 
        error.setError("Api rest no encontrado"); 
        error.setMessage(ex.getMessage()); 
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value()); 


        
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
    }
}   
