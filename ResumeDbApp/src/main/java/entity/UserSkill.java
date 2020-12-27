/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author HOME
 */
public class UserSkill {
    private int id;
    private User userId;
    private Skill skillId;
    private int power;

    public UserSkill(int id, User userId, Skill skillId, int power) {
        this.id = id;
        this.userId = userId;
        this.skillId = skillId;
        this.power = power;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Skill getSkillId() {
        return skillId;
    }

    public void setSkillId(Skill skillId) {
        this.skillId = skillId;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "UserSkill{" + "id=" + id + ", userId=" + userId + ", skillId=" + skillId + ", power=" + power + '}';
    }
    
}
