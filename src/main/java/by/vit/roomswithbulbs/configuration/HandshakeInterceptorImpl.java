package by.vit.roomswithbulbs.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

/**
 * Handshake interceptor implementation.
 *
 * @author Vitaly Lobatsevich
 */
@Configuration
public class HandshakeInterceptorImpl implements HandshakeInterceptor {

    @Override
    public boolean beforeHandshake(
            final ServerHttpRequest request,
            final ServerHttpResponse response,
            final WebSocketHandler wsHandler,
            final Map<String,Object> attributes
    ) throws Exception {
        attributes.put("ip", request.getRemoteAddress().getAddress().getHostAddress());
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
