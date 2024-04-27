package raiper.com.ecomerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import raiper.com.ecomerce.result.Result;
import raiper.com.ecomerce.result.StatusCode;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(AddressNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Result AddressNotFoundExceptionHandler(Exception ex) {
        return new Result(false, StatusCode.NOT_FOUND, ex.getMessage());
    }
}
