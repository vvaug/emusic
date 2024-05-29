package br.com.vvaug.usecase.impl;

import br.com.vvaug.entity.User;
import br.com.vvaug.exception.ApplicationException;
import br.com.vvaug.gateway.GetUserDataGateway;
import br.com.vvaug.mapper.UserToUserResponseMapper;
import br.com.vvaug.request.GetUserDataRequest;
import br.com.vvaug.response.UserResponse;
import br.com.vvaug.usecase.GetUserDataUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetUserDataUseCaseImpl implements GetUserDataUseCase {

    private final GetUserDataGateway getUserDataGateway;

    @Override
    public ResponseEntity<UserResponse> execute(GetUserDataRequest request)  {

        String payload = request.getUserAuthenticationInfoBase64();
        byte[] payloadByte = Base64.decodeBase64(payload);
        String payloadStr;
        try {
            payloadStr = new String(payloadByte, "UTF8");
        } catch (UnsupportedEncodingException ex) {
            log.error("can't decode base64 payload (GetUserDataRequest): {}", ex.getMessage());
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        String[] userData = payloadStr.split(",");

        if(userData.length == 1) {
            throw new ApplicationException(HttpStatus.FORBIDDEN, "Bad Credentials.");
        }
        User user = getUserDataGateway.getUserData(userData[0], userData[1]);
        return ResponseEntity.ok(UserToUserResponseMapper.map(user));
    }

}
