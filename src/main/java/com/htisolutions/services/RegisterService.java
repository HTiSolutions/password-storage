package com.htisolutions.services;

import com.htisolutions.entities.User;
import com.htisolutions.entities.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    private UserDao userDao;

    @Autowired
    RegisterService(UserDao userDao) {
        this.userDao = userDao;
    }

    public Boolean validRegister(String firstName, String lastName, String nickname, String registerPassword, String confirmPassword){
        if (registerPassword.equals(confirmPassword) && userDao.findByNickname(nickname) == null) {
            try {
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                String hashedPassword = passwordEncoder.encode(registerPassword);
                User user = new User(firstName, lastName, nickname, hashedPassword);
                userDao.save(user);
                return true;
            }
            catch (Exception ex) {
            }
        }
        return false;
    }
}
