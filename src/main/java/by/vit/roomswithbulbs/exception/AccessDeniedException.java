package by.vit.roomswithbulbs.exception;

/**
 * Thrown if the client does not have access.
 *
 * @author Vitaly Lobatsevich
 */
public class AccessDeniedException extends RuntimeException {

    /**
     * Default constructor.
     */
    public AccessDeniedException() {
        super("Access denied.");
    }

    /**
     * Parameterized constructor.
     *
     * @param errorMessage - error message.
     */
    public AccessDeniedException(final String errorMessage) {
        super(errorMessage);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

}
