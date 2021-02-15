package co.za.sbg.iot.configuration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.ip.dsl.Udp;

import co.za.sbg.iot.controller.LedController;

@Configuration
public class UDPConfiguration {

    private final LedController ledController;
    private final ObjectMapper objectMapper;
    final Logger log = LoggerFactory.getLogger(UDPConfiguration.class);

    public UDPConfiguration(final LedController ledController, final ObjectMapper objectMapper) {
        this.ledController = ledController;
        this.objectMapper = objectMapper;
    }

    @Bean
    public IntegrationFlow udpLedServer() {
        return IntegrationFlows.from(Udp.inboundAdapter(11111).id("udpIn")).<byte[], String>transform(p -> getLedJson())
            .handle(Udp.outboundAdapter("headers['ip_packetAddress']").socketExpression("@udpIn.socket"))
            .get();
    }

    private String getLedJson() {
        log.info("Incoming UDP Request");
        try {
            return objectMapper.writeValueAsString(ledController.index());
        } catch (JsonProcessingException e) {
            throw new IllegalStateException(e);
        }
    }
}
