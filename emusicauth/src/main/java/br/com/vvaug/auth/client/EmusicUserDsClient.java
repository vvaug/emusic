package br.com.vvaug.auth.client;

import br.com.vvaug.auth.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "e-music-user-ds-client", url = "${feign.clients.emusicuserds}")
public interface EmusicUserDsClient {

    @GetMapping("/user/{username}")
    UserResponse getUser(@PathVariable("username") String username);


}
