package by.vit.roomswithbulbs.configuration;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Application handshake interceptor.
 *
 * @author Vitaly Lobatsevich
 */
public class AppInterceptor implements HandshakeInterceptor {

    /** Logger, */
    private static final Logger log = Logger.getLogger(AppInterceptor.class.getName());

    @Override
    public boolean beforeHandshake(
            final ServerHttpRequest request,
            final ServerHttpResponse response,
            final WebSocketHandler wsHandler,
            final Map<String,Object> attributes
    ) throws Exception {
        log.log(Level.INFO, "Client IP: " + request.getRemoteAddress().getAddress().getHostAddress());
        return true;
    }

    @Override
    public void afterHandshake(
            final ServerHttpRequest serverHttpRequest,
            final ServerHttpResponse serverHttpResponse,
            final WebSocketHandler webSocketHandler,
            final Exception e
    ) {

    }

}
