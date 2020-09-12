package by.vit.roomswithbulbs.configuration;

import by.vit.roomswithbulbs.service.AccessService;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Web socket configuration.
 *
 * @author Vitaly Lobatsevich
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /** Access service. */
    private final AccessService accessService;

    /**
     * Constructor.
     *
     * @param accessService - access service.
     */
    public WebSocketConfig(final AccessService accessService) {
        this.accessService = accessService;
    }

    @Override
    public void configureMessageBroker(final MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(final StompEndpointRegistry registry) {
        registry
                .addEndpoint("/rooms-with-bulbs")
                .addInterceptors(new HandshakeInterceptorImpl())
                .withSockJS();
    }

    @Override
    public void configureClientInboundChannel(final ChannelRegistration registration) {
        registration.interceptors(new ChannelInterceptorImpl(accessService));
    }

}
