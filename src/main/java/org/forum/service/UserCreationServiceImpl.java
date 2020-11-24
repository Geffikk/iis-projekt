package org.forum.service;

import org.forum.entities.user.User;
import org.forum.entities.user.activation.ActivationSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserCreationServiceImpl implements UserCreationService {

    @Autowired
    private UserService userService;

    @Autowired
    private ActivationSenderService activationSenderService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void create(User user) {
        userService.save(prepareUzivatel(user));
        activationSenderService.sendActivationCode(user);
    }

    private User prepareUzivatel(User user) {
        user.setPassword(getEncodedPassword(user.getPassword()));
        user.setActive(false);
        return user;
    }

    private String getEncodedPassword(String heslo) {
        return passwordEncoder.encode(heslo);
    }
}
