package by.vit.roomswithbulbs.configuration;

import by.vit.roomswithbulbs.exception.AccessDeniedException;
import by.vit.roomswithbulbs.exception.BadMessageHeaderException;
import by.vit.roomswithbulbs.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * Channel interceptor implementaion.
 *
 * @author Vitaly Lobatsevich
 */
@Component
public class ChannelInterceptorImpl implements ChannelInterceptor {

    /** Logger. */
    private static final Logger log = Logger.getLogger(ChannelInterceptorImpl.class.getName());

    /** Access service. */
    private final AccessService accessService;

    /**
     * Constructor.
     *
     * @param accessService - access service.
     */
    @Autowired
    public ChannelInterceptorImpl(final AccessService accessService) {
        this.accessService = accessService;
    }

    @Override
    public Message<?> preSend(final Message<?> message, final MessageChannel channel) {
        String messageType = null;
        String destination = null;
        String ip = null;
        try {
            messageType = message.getHeaders().get("simpMessageType").toString();
            destination = message.getHeaders().get("simpDestination").toString();
            ip = SimpMessageHeaderAccessor.wrap(message).getSessionAttributes().get("ip").toString();
        } catch (Exception ignore) {}
        if (messageType == null) {
            throw new BadMessageHeaderException();
        }
        if (messageType.equals("SUBSCRIBE") || messageType.equals("MESSAGE")) {
            if (ip == null || destination == null) {
                throw new BadMessageHeaderException();
            }
            final String[] destinationParts = destination.split("/");
            final String id = destinationParts[destinationParts.length - 1];
            if (!accessService.checkByRoomId(id, ip)) {
                throw new AccessDeniedException();
            }
        }
        return message;
    }

}
