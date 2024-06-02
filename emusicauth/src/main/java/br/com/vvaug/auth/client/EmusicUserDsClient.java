package br.com.vvaug.auth.client;

import br.com.vvaug.auth.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("emusicuserds")
public interface EmusicUserDsClient {

    @GetMapping("/emusicuserds/v1/user/{username}")
    UserResponse getUser(@PathVariable("username") String username);


}
