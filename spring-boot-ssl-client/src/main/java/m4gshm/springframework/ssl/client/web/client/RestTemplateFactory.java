package m4gshm.springframework.ssl.client.web.client;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import m4gshm.springframework.ssl.client.http.client.SslVerificationHttpRequestFactory;
import m4gshm.springframework.ssl.client.utils.SslContextHolder;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

@RequiredArgsConstructor
public class RestTemplateFactory {
    final SslContextHolder sslContextHolder;
    final HostnameVerifier hostnameVerifier;

    public static RestTemplate newClientSslVerificationRestTemplate(@NonNull SSLContext sslContext,
                                                                    HostnameVerifier hostnameVerifier) {
        return new RestTemplate(new SslVerificationHttpRequestFactory(sslContext, hostnameVerifier));
    }

    public RestTemplate newRestTemplate() {
        return newClientSslVerificationRestTemplate(sslContextHolder.getSslContext(), hostnameVerifier);
    }
}
