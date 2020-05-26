package com.vgs.showjsdemo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
public class GetSecretController {

    @PostMapping(path="/get-secret-data", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> getSecret(@RequestBody String requestBody, @RequestHeader(value="X-ACCESS-TOKEN") String accessToken) {
        if(accessToken.equals("YWRtaW46cGFzc3dvcmQ=")) { // Fake Authentication
            return ResponseEntity.ok(requestBody);
        }
        else {
            return new ResponseEntity<>("Failed to authenticate token", HttpStatus.FORBIDDEN);
        }

    }
}
