/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.main;

import entity.Context;
import entity.User;
import dao.inter.UserDaoInter;
import java.util.List;

/**
 *
 * @author Abdulla.Maxsudov
 */
public class Main {

    public static void main(String[] args) throws Exception {

        UserDaoInter daoImpl = Context.instanceUserDao();

//        User u = daoImpl.getUserById(1);
//        u.setName("Abdulla");
//        daoImpl.updateUser(u);
//        User nUser = new User(3, "Ali", "Maxsudov", "alimax@gmail.com", "+994502297019");
//        daoImpl.insertUser(nUser);
//        daoImpl.removeUser(2);

        List<User> users = daoImpl.getAllUser();
        for (User user : users) {
            System.out.println(user.toString());
        }

    }

}
