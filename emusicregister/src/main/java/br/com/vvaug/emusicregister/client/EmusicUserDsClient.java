package br.com.vvaug.emusicregister.client;

import br.com.vvaug.emusicregister.request.CreateUserRequest;
import br.com.vvaug.emusicregister.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("emusicuserds")
public interface EmusicUserDsClient {

    @PostMapping("/emusicuserds/v1/user/create")
    UserResponse createNewUser(@RequestBody CreateUserRequest createUserRequest);


}
