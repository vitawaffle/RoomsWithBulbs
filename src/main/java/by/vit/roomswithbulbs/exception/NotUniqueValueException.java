package by.vit.roomswithbulbs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * NotUniqueValueException class.
 *
 * Throws if the value is not unique.
 *
 * @author Vitaly Lobatsevich
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotUniqueValueException extends RuntimeException {

    /** Default constructor. */
    public NotUniqueValueException() {
        super();
    }

    /**
     * Constructor with specified error message.
     *
     * @param errorMessage - error message.
     */
    public NotUniqueValueException(final String errorMessage) {
        super(errorMessage);
    }

}
