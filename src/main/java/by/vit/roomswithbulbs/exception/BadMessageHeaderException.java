package by.vit.roomswithbulbs.exception;

/**
 * Thrown if incorrect message headers were sent.
 *
 * @author Vitaly Lobatsevich
 */
public class BadMessageHeaderException extends RuntimeException {

    /**
     * Default constructor.
     */
    public BadMessageHeaderException() {
        super("Bad message header.");
    }

    /**
     * Parameterized constructor.
     *
     * @param errorMessage - error message.
     */
    public BadMessageHeaderException(final String errorMessage) {
        super(errorMessage);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

}
