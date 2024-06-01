package br.com.vvaug.emusicgateway.filter;

import br.com.vvaug.emusicgateway.client.SpotifyAccessTokenClient;
import br.com.vvaug.emusicgateway.dto.SignInResponse;
import br.com.vvaug.emusicgateway.router.validator.RouterValidator;
import br.com.vvaug.emusicgateway.utils.JsonWebTokenUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RefreshScope
@Component
@Slf4j
public class AuthenticationFilter implements GatewayFilter {

    @Autowired
    private RouterValidator routerValidator;
    @Autowired
    private JsonWebTokenUtils jsonWebTokenUtils;
    @Autowired
    private SpotifyAccessTokenClient spotifyAccessTokenClient;

    @Value("${spotify.grant-type}")
    private String grantType;
    @Value("${spotify.client-id}")
    private String clientId;
    @Value("${spotify.secret-id}")
    private String secretId;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();

        if (routerValidator.isSecured.test(request)) {
            if (this.isAuthMissing(request))
                return this.onError(exchange, "Authorization header is missing in request", HttpStatus.UNAUTHORIZED);

            String token = this.getAuthHeader(request);
            token = token.substring("Bearer ".length());

            if (! jsonWebTokenUtils.isBearerTokenValid(token))
                return this.onError(exchange, "Authorization header is invalid", HttpStatus.UNAUTHORIZED);

            this.populateRequestWithHeaders(exchange, token);
        }

        return chain.filter(exchange);
    }


    private Mono<Void> onError(ServerWebExchange exchange, String err, HttpStatus httpStatus) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(httpStatus);
        return response.setComplete();
    }

    private String getAuthHeader(ServerHttpRequest request) {
        return request.getHeaders().getOrEmpty("Authorization").get(0);
    }

    private boolean isAuthMissing(ServerHttpRequest request) {
        return !request.getHeaders().containsKey("Authorization");
    }

    private void populateRequestWithHeaders(ServerWebExchange exchange, String token) {
        SignInResponse signInResponse = spotifyAccessTokenClient.getAccessToken(clientId, secretId, grantType);
        exchange.getRequest().mutate().header(HttpHeaders.AUTHORIZATION, "Bearer " + signInResponse.getAccessToken()).build();
    }
}
