package by.vit.roomswithbulbs.configuration;

import by.vit.roomswithbulbs.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Channel interceptor implementaion.
 *
 * @author Vitaly Lobatsevich
 */
@Configuration
public class ChannelInterceptorImpl implements ChannelInterceptor {

    /** Logger. */
    private final static Logger log = Logger.getLogger(ChannelInterceptorImpl.class.getName());

    /** Access service. */
    private final AccessService accessService;

    /** Topic url regex. */
    private final static String urlRegex1 = "^/topic/room/.*";

    /** Switch light method url. */
    private final static String urlRegex2 = "^/app/switchLight/.*";

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
        final MessageHeaders headers = message.getHeaders();
        final Map<String, Object> sessionAttributes = SimpMessageHeaderAccessor.wrap(message).getSessionAttributes();
        final String messageType = headers.get("simpMessageType") != null
                ? headers.get("simpMessageType").toString() : null;
        final String destination = headers.get("simpDestination") != null
                ? headers.get("simpDestination").toString() : null;
        final String ip = sessionAttributes != null
                ? sessionAttributes.get("ip") != null ? sessionAttributes.get("ip").toString() : null
                : null;

        if (messageType != null && destination != null && (
                (messageType.equals("SUBSCRIBE") && destination.matches(urlRegex1)) ||
                (messageType.equals("MESSAGE") && destination.matches(urlRegex2))
        )) {
            String[] destinationParts = destination.split("/");
            final String id = destinationParts[destinationParts.length - 1];
            if (!accessService.checkByRoomId(id, ip)) {
                log.log(Level.INFO, "Rejected!");
            }
        }

        return message;
    }

}
