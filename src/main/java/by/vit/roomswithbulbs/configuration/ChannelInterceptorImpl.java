package by.vit.roomswithbulbs.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;

/**
 * Channel interceptor implementaion.
 *
 * @author Vitaly Lobatsevich
 */
@Configuration
public class ChannelInterceptorImpl implements ChannelInterceptor {

    @Override
    public Message<?> preSend(final Message<?> message, final MessageChannel channel) {
        return message;
    }

}
