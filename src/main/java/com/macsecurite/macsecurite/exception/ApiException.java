package com.macsecurite.macsecurite.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Compte déjà existant")
public class ApiException extends RuntimeException {
}
