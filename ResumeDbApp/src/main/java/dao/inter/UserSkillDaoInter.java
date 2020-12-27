/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.inter;

import entity.UserSkill;
import java.util.List;

/**
 *
 * @author HOME
 */
public interface UserSkillDaoInter {
    public List<UserSkill> getUserSkill(int userId);
}
