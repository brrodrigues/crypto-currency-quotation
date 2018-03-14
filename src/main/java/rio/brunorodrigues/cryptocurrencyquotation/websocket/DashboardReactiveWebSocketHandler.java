package rio.brunorodrigues.cryptocurrencyquotation.websocket;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;
import rio.brunorodrigues.cryptocurrencyquotation.controller.TickerController;

@Component
public class DashboardReactiveWebSocketHandler implements WebSocketHandler {

    @Autowired
    private TickerController controller;

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public Mono<Void> handle(WebSocketSession webSocketSession) {

        return webSocketSession.
                send(controller.getTickers().map(this::toJsonString).map(webSocketSession::textMessage)).
                and(webSocketSession.receive().map(WebSocketMessage::getPayloadAsText));

    }


    private String toJsonString(Object object){
        ObjectMapper bean = applicationContext.getBean(ObjectMapper.class);

        try {
            return bean.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return "{}";

    }
}
