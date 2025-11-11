package br.com.futurodotrabalho.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(TrilhaNotFoundException.class)
//    public ResponseEntity<ErrorResponse> handleTrilhaNotFoundException(TrilhaNotFoundException e) {
//        ErrorResponse errorResponse = new ErrorResponse(
//                HttpStatus.NOT_FOUND.value(),
//                e.getMessage(),
//                LocalDateTime.now()
//        );
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
//    }
//
//    @ExceptionHandler(UsuarioNotFoundException.class)
//    public ResponseEntity<ErrorResponse> handleUsuarioNotFoundException(UsuarioNotFoundException e) {
//        ErrorResponse errorResponse = new ErrorResponse(
//                HttpStatus.NOT_FOUND.value(),
//                e.getMessage(),
//                LocalDateTime.now()
//        );
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
//    }

    @ExceptionHandler({TrilhaNotFoundException.class, UsuarioNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleNotFoundExceptions(RuntimeException e) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                e.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericExceptions(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Erro interno do servidor, tente processar novamente",
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleBeanValidationsErrors(MethodArgumentNotValidException e) {
        String mensagem = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining(" - "));
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                mensagem,
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(RegraDeNegocioException.class)
    public ResponseEntity<ErrorResponse> handleRegraDeNegocioException(RegraDeNegocioException e) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                e.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }
}
