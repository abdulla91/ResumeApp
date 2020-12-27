/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import entity.Country;
import entity.User;
import dao.inter.UserDaoInter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abdulla.Maxsudov
 */
public class UserDaoImpl extends AbstractConnectDao implements UserDaoInter {

    private User getUser(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        String profileDescription = rs.getString("profile_description");
        String address = rs.getString("address");
        Date birthdate = rs.getDate("birthdate");
        //int birthplaceId = rs.getInt("birthplace_id"); 
        //int nationalityId = rs.getInt("nationality_id"); 
        String birthplaceStr = rs.getString("birthplace");
        String nationalityStr = rs.getString("n.nationality");        

        Country birthplace = new Country(0, birthplaceStr, null);
        Country nationality = new Country(0, null, nationalityStr);        

        return new User(id, name, surname, email, phone, profileDescription, address, birthdate, nationality, birthplace);
    }

    @Override
    public List<User> getAllUser() {
        try (Connection c = connect()) {
            List<User> list = new ArrayList<>();
            Statement stm = c.createStatement();
            stm.execute("SELECT u.id, u.name, u.surname, u.email, u.phone, u.profile_description, u.address, u.birthdate, "
                    + "c.name as birthplace, n.nationality FROM user u "
                    + "LEFT JOIN country c ON u.birthplace_id = c.id "
                    + "LEFT JOIN country n ON u.nationality_id = n.id");

            ResultSet rs = stm.getResultSet();

            while (rs.next()) {
                User u = getUser(rs);
                list.add(u);
            }
            return list;
        } catch (SQLException ex) {
//            String message = ex.getMessage();
//            System.out.println("Error example : " + message);
            ex.printStackTrace();
            return null;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public boolean updateUser(User user) {
        try (Connection c = connect()) {
            PreparedStatement ps = c.prepareStatement("UPDATE user SET name = ?, surname = ?, email = ?, phone = ? WHERE id = ?");
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPhone());
            ps.setInt(5, user.getId());
            return ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeUser(int id) {
        try (Connection c = connect()) {
            Statement stm = c.createStatement();
            return stm.execute("DELETE FROM user WHERE id = " + id);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean insertUser(User user) {
        try (Connection c = connect()) {
            PreparedStatement ps = c.prepareStatement("INSERT INTO user (name, surname, email, phone) VALUES (?,?,?,?)");
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPhone());
            return ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User getUserById(int userId) {
        User user = null;
        try (Connection c = connect()) {
            PreparedStatement ps = c.prepareStatement("SELECT u.id, u.name, u.surname, u.email, u.phone, u.profile_description, u.address, u.birthdate, "
                    + "c.name as birthplace, n.nationality FROM user u "
                    + "LEFT JOIN country c ON u.birthplace_id = c.id "
                    + "LEFT JOIN country n ON u.nationality_id = n.id WHERE u.id = ?");
            ps.setInt(1, userId);
            ps.execute();

            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                user = getUser(rs);
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
