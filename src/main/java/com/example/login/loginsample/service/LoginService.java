package com.example.login.loginsample.service;

import com.example.login.loginsample.entity.Login;
import com.example.login.loginsample.repository.LoginRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LoginService {

    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public List<Login> searchAll() {
        return loginRepository.findAll();
    }
}
