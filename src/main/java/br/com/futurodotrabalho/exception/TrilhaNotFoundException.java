package br.com.futurodotrabalho.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TrilhaNotFoundException extends RuntimeException {
    public TrilhaNotFoundException(String message) {
        super(message);
    }
}
