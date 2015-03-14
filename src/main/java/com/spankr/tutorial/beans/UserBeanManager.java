package com.spankr.tutorial.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.spankr.tutorial.model.User;

@ManagedBean
@ApplicationScoped
public class UserBeanManager {

    protected List<User> users = new ArrayList<User>();

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }
}
