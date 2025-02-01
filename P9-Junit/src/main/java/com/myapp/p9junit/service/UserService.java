package com.myapp.p9junit.service;


import com.myapp.p9junit.model.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }
}
