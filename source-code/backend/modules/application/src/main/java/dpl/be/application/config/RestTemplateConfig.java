package dpl.be.application.config;


import dpl.be.application.interceptor.HttpClientHeaderInterceptor;
import dpl.be.application.interceptor.HttpClientLoggingInterceptor;
import org.apache.hc.client5.http.config.ConnectionConfig;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.core5.http.io.SocketConfig;
import org.apache.hc.core5.util.TimeValue;
import org.apache.hc.core5.util.Timeout;
import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean
    CloseableHttpClient httpClient() {

        PoolingHttpClientConnectionManager connectionManager =
                PoolingHttpClientConnectionManagerBuilder.create()
                        .setMaxConnTotal(200)
                        .setMaxConnPerRoute(50)
                        .setDefaultSocketConfig(
                                SocketConfig.custom()
                                        .setSoTimeout(Timeout.ofSeconds(10)) // read timeout
                                        .build()
                        )
                        .setDefaultConnectionConfig(
                                ConnectionConfig.custom()
                                        .setConnectTimeout(Timeout.ofSeconds(5)) // ✅ correct API
                                        .build()
                        )
                        .build();

        RequestConfig requestConfig = RequestConfig.custom()
                .setResponseTimeout(Timeout.ofSeconds(10)) // response timeout
                .build();

        return HttpClients.custom()
                .setConnectionManager(connectionManager)
                .setDefaultRequestConfig(requestConfig)
                .evictIdleConnections(TimeValue.ofSeconds(30))
                .disableAutomaticRetries()
                .build();
    }

    @Bean
    public HttpClientLoggingInterceptor loggingInterceptor() {
        return new HttpClientLoggingInterceptor();
    }

    @Bean
    public HttpClientHeaderInterceptor headerPropagationInterceptor() {
        return new HttpClientHeaderInterceptor();
    }
    @Bean
    RestTemplate restTemplate(
            RestTemplateBuilder builder,
            CloseableHttpClient httpClient,
            HttpClientLoggingInterceptor loggingInterceptor,
            HttpClientHeaderInterceptor headerPropagationInterceptor
    ) {
        return builder
                .requestFactory(() ->
                        new HttpComponentsClientHttpRequestFactory(httpClient))
                .additionalInterceptors(
                        loggingInterceptor,
                        headerPropagationInterceptor
                )
                .errorHandler(new DefaultResponseErrorHandler())
                .build();
    }
}
