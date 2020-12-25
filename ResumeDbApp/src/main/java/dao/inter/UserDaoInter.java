/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.inter;

import bean.User;
import java.util.List;

/**
 *
 * @author Abdulla.Maxsudov
 */
public interface UserDaoInter {
    public User getUserById(int id);
    public List<User> getAllUser();
    public boolean updateUser(User user);
    public boolean removeUser(int id);
    public boolean insertUser(User user);
}
