package cinema.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.BAD_REQUEST)
public class WrongColumnRowException extends RuntimeException {
    public WrongColumnRowException(String cause) {
        super(cause);
    }
}
