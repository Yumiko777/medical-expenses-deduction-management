package com.example.login.loginsample.controller;

import com.example.login.loginsample.model.Account;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegisterController {

    private final UserDetailsManager manager;

    public RegisterController(UserDetailsManager manager) {
        this.manager = manager;
    }

    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@ModelAttribute Account account, RedirectAttributes redirectAttributes) {
        // 入力したユーザー名の前後のスペースを削除
        String username = account.getUsername().trim();

        // 入力したユーザー名がDBに存在した場合はエラーメッセージを表示
        if (manager.userExists(username)){
            redirectAttributes.addAttribute("error", "exist");
            return "redirect:/register";
        }

        // ユーザー情報作成
        UserDetails user = User.withUsername(username)
                .password(PasswordEncoderFactories
                        .createDelegatingPasswordEncoder()
                        .encode(account.getPassword()))
                .roles("USER")
                .build();
        // ユーザー情報をDBに登録
        manager.createUser(user);

        redirectAttributes.addAttribute("register", "success");
        return "redirect:/login";
    }
}
