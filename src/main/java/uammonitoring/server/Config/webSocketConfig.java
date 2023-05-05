package uammonitoring.server.Config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import uammonitoring.server.Compnent.adsbHandler;

@Configuration
@RequiredArgsConstructor
@EnableWebSocket
public class webSocketConfig implements WebSocketConfigurer {

    private final adsbHandler handler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(handler, "/socket").setAllowedOrigins("*");
    }
}
