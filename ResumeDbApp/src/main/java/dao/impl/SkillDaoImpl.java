/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.inter.SkillDaoInter;
import entity.Skill;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HOME
 */
public class SkillDaoImpl extends AbstractConnectDao implements SkillDaoInter{

    @Override
    public List<Skill> getAllSkill() {
        
        List<Skill> list = new ArrayList<>();
        
        try (Connection c = connect()){
            Statement stmt = c.createStatement();
            stmt.execute("SELECT * FROM skill");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {                
                int id = rs.getInt("id");
                String name = rs.getString("name");
                list.add(new Skill(id, name));                
            }
            return list;
            
        } catch (Exception e) {
            
            e.printStackTrace();
            return null;
        }
    }
    
}
