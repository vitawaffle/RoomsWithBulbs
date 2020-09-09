package by.vit.roomswithbulbs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This exception is used to send forbidden http status.
 *
 * @author Vitaly Lobatsevich
 */
@ResponseStatus(HttpStatus.FORBIDDEN)
public class ForbiddenException extends RuntimeException {

    /** Default constructor. */
    public ForbiddenException() {
        super();
    }

    /**
     * Parameterized constructor.
     *
     * @param errorMessage - error message.
     */
    public ForbiddenException(final String errorMessage) {
        super(errorMessage);
    }

}
