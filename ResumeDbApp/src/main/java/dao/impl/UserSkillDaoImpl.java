/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.inter.UserSkillDaoInter;
import entity.Skill;
import entity.User;
import entity.UserSkill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HOME
 */
public class UserSkillDaoImpl extends AbstractConnectDao implements UserSkillDaoInter {

    private UserSkill getUserSkill(ResultSet rs) throws Exception {
        int id = rs.getInt("skill_id");
        String skillName = rs.getString("skill_name");
        int userId = rs.getInt("id");
        int power = rs.getInt("power");
        
        User u = new User(userId);
        Skill s = new Skill(id, skillName);
        
        return new UserSkill(id, u, s, power);
    }

    @Override
    public List<UserSkill> getUserSkill(int userId) {

        List<UserSkill> list = new ArrayList<>();
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("SELECT u*, s.name as skill_name, s.id as skill_id, us.id as user_skill_id, us.power FROM user_skill us "
                    + "INNER JOIN user u ON us.user_id = u.id INNER JOIN skill s ON us.skill_id = s.id "
                    + "WHERE us.user_id = ?");
            stmt.setInt(1, userId);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                UserSkill us = getUserSkill(rs);
                list.add(us);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
