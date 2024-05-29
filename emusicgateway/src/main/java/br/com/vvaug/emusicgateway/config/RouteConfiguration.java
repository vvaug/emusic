package br.com.vvaug.emusicgateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfiguration {

    @Value("${route.emusicauth.path}")
    private String emusicauthPath;
    @Value("${route.emusicuserds.path}")
    private String emusicUserDsPath;

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {

        return builder.routes()
                .route("emusicauth", r -> r.path("/emusicauth/v1/**")
                        .uri(emusicauthPath))
                .route("emusicuserds", r -> r.path("/emusicuserds/v1/**")
                        .uri(emusicUserDsPath))
                .build();
        }
}
