package com.devbraga.bragacommerce.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError{

    private List<FieldMessage> errors = new ArrayList<>();
    public ValidationError(Instant timestamp, Integer status, String path, String error) {
        super(timestamp, status, path, error);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    /* Método para adicionar uma nova FieldMessage a essa lista de erros. FieldMessage foi criada
          para salvar as exceções descritas nos atributos do DTO */
    public void addErrors(String fieldName, String message){
        errors.add(new FieldMessage(fieldName, message));
    }


}
