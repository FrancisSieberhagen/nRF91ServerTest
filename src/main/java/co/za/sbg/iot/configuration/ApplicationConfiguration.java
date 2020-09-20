package co.za.sbg.iot.configuration;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class ApplicationConfiguration {

    @Value("${server.ssl.key-store-password}")
    private String keyStorePassword;
    @Value("${server.ssl.trust-store-password}")
    private String trustStorePassword;

    @Bean
    public ServletWebServerFactory servletContainer(@Value("${http.port}") int httpPort) {
        final Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
        connector.setPort(httpPort);
        final TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addAdditionalTomcatConnectors(connector);
        return tomcat;
    }

    @PostConstruct
    private void setProperty() {
        System.setProperty("javax.net.ssl.trustStore", "src/main/resources/ssl/sbsatrustanchor.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", keyStorePassword);
        System.setProperty("javax.net.ssl.keyStore", "src/main/resources/ssl/ssl-keystore.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", trustStorePassword);
    }
}
