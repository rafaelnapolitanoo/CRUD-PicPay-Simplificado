package com.picpaysimplificado.infra;

import com.picpaysimplificado.dtos.ExecptionDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity threatDuplicationEntry (DataIntegrityViolationException exception){
        ExecptionDTO execptionDTO = new ExecptionDTO("Usuario já cadastrado",
                "400");
        return ResponseEntity.badRequest().body(execptionDTO);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity threat404 (EntityNotFoundException exception){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity treatGeneralException(Exception exception) {
        ExecptionDTO execptionDTO = new ExecptionDTO(exception.getMessage(),"500");
        return ResponseEntity.internalServerError().body(execptionDTO);
    }
}
