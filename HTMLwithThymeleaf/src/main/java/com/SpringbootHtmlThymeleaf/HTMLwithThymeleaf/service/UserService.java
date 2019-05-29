package com.SpringbootHtmlThymeleaf.HTMLwithThymeleaf.service;

import com.SpringbootHtmlThymeleaf.HTMLwithThymeleaf.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> allUsers = new ArrayList<>();
    public List<User> getAllUserArticles(){
        return allUsers;
    }
    public void addUser(User user) {
        allUsers.add(user);
    }
}
