package org.springframework.config;

import io.net.ssl.client.ClientSslProperties;
import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientSslPropertiesTestConfig {

    @Bean
    public ClientSslProperties clientSslProperties() {
        val clientSslProperties = new ClientSslProperties();
        clientSslProperties.setTrustStorePassword("password");
        clientSslProperties.setTrustStore("classpath:keystore.p12");
        clientSslProperties.setTrustStoreType("PKCS12");
        return clientSslProperties;
    }
}
