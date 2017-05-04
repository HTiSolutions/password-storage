package com.htisolutions.services;

import com.htisolutions.entities.User;
import com.htisolutions.entities.UserDao;
import com.htisolutions.viewModels.UserEntryViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HomeService {

    private UserDao userDao;

    @Autowired
    HomeService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<UserEntryViewModel> calculateUsers() {
        List<UserEntryViewModel> viewModelList = new ArrayList<>();
        Iterable<User> users = userDao.findAll();
        for (User user: users){
            UserEntryViewModel viewModel = new UserEntryViewModel(user.getForename(), user.getSurname(), user.getNickname(), user.getHashedPassword());
            viewModelList.add(viewModel);
        }
        return viewModelList;
    }
}
