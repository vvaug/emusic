package br.com.vvaug.emusicgateway.config;

import br.com.vvaug.emusicgateway.filter.AuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Value("${route.emusicapp.path}")
    private String emusicAppPath;

    @Autowired
    private AuthenticationFilter authenticationFilter;

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {

        return builder.routes()
                .route("emusicauth", r -> r.path("/emusicauth/v1/**")
                        .filters(f -> f.filter(authenticationFilter))
                        .uri(emusicauthPath))
                .route("emusicuserds", r -> r.path("/emusicuserds/v1/**")
                        .filters(f -> f.filter(authenticationFilter))
                        .uri(emusicUserDsPath))
                .route("emusicapp", r -> r.path("/emusicapp/v1/**")
                        .filters(f -> f.filter(authenticationFilter))
                        .uri(emusicAppPath))
                .build();
        }
}
