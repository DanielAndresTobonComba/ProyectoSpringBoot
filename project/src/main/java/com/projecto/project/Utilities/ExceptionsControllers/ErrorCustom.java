package com.projecto.project.Utilities.ExceptionsControllers;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//genera el to string y el hashcode pero si se usa lazy la informacion no se carga 
@Data 
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor 

public class ErrorCustom {
    private String message; 
    private String error; 
    private int status;
    private Date date;
}
