/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import dao.impl.UserDaoImpl;
import dao.inter.UserDaoInter;

/**
 *
 * @author Abdulla.Maxsudov
 */
public class Context {
    
    public static UserDaoInter instanceUserDao() {
        return new UserDaoImpl();
    }
    
}
