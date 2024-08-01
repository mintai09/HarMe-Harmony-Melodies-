package harme.global.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.ClientHttpRequestFactories;
import org.springframework.boot.web.client.ClientHttpRequestFactorySettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

import java.time.Duration;

@Configuration
public class RestClientConfig {
    @Value("${client.transUrl}")
    String transUrl;
    @Value("${client.transToken}")
    String transToken;
    @Value("${client.musicUrl}")
    String musicUrl;

    final ClientHttpRequestFactory requestFactory = ClientHttpRequestFactories.get(ClientHttpRequestFactorySettings.DEFAULTS
            .withReadTimeout(Duration.ofSeconds(6000000L))
            .withConnectTimeout(Duration.ofSeconds(6000000L)));

    @Bean
    public RestClient transClient() {
        return RestClient.builder().baseUrl(transUrl)
                .defaultHeaders(header -> {
                    header.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
                    header.add(HttpHeaders.AUTHORIZATION, transToken);
                })
                .requestFactory(requestFactory)
                .build();
    }

    @Bean
    public RestClient musicClient() {
        return RestClient.builder()
                .defaultHeaders(header -> {
                    header.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
                })
                .requestFactory(requestFactory)
                .build();
    }
}
