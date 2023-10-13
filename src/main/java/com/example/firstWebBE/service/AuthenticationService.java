package com.example.firstWebBE.service;

import com.example.firstWebBE.config.exceptionHandler.AuthenticationFailException;
import com.example.firstWebBE.model.entity.AuthenticationToken;
import com.example.firstWebBE.model.entity.User;
import com.example.firstWebBE.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    @Autowired
    private final TokenRepository tokenRepository;

    public void saveConfirmationToken(AuthenticationToken authenticationToken) {
        tokenRepository.save(authenticationToken);
    }

    public AuthenticationToken getToken(User user) {
        return tokenRepository.findByUser(user);
    }

    public User getUser(String token){
        AuthenticationToken authenticationToken = tokenRepository.findByToken(token);
        if (Objects.nonNull(authenticationToken)) {
            if (Objects.nonNull(authenticationToken.getToken())){
                return authenticationToken.getUser();
            }
        }
        return null;
    }

//    public boolean authenticate(String token) {
//        if (Objects.isNull(token)){
//            return false;
//        }
//        else if (Objects.isNull(getUser(token))) {
//            return false;
//        } else {
//            return true;
//        }
//    }

    public void authenticate(String token) throws AuthenticationFailException {
        if (Objects.isNull(token)) {
            throw new AuthenticationFailException("Token Must Be Not Null !");
        }
        if (Objects.isNull(getUser(token))) {
            throw new AuthenticationFailException("User Is NOT Exist");
        }
    }
}
