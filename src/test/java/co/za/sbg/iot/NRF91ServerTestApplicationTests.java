package co.za.sbg.iot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.integration.ip.udp.UnicastSendingMessageHandler;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

@SpringBootTest
class NRF91ServerTestApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void udpTest() {
        UnicastSendingMessageHandler handler =
            new UnicastSendingMessageHandler("localhost", 11111);

        String payload = "Hello world";
        final Message<String> message = MessageBuilder
            .withPayload(payload)
            .build();

        handler.handleMessage(message);
    }
}