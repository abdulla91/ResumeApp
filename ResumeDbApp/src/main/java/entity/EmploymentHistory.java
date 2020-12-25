/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author Abdulla.Maxsudov
 */
public class EmploymentHistory {
    private int id;
    private String header;
    private String jobDescription;
    private Date beginDate;
    private Date endDate;
    private User user;

    public EmploymentHistory() {
    }

    public EmploymentHistory(int id, String header, String jobDescription, Date beginDate, Date endDate, User user) {
        this.id = id;
        this.header = header;
        this.jobDescription = jobDescription;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "EmploymentHistory{" + "id=" + id + ", header=" + header + ", jobDescription=" + jobDescription + ", beginDate=" + beginDate + ", endDate=" + endDate + ", user=" + user + '}';
    }
    
    
}
