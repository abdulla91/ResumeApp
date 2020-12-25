/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.inter.EmploymentHistoryDaoInter;
import entity.EmploymentHistory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abdulla.Maxsudov
 */
public class EmploymentHistoryImpl extends AbstractConnectDao implements EmploymentHistoryDaoInter{

    @Override
    public List<EmploymentHistory> getAllEmploymentHistory() {
        try (Connection c = connect()){
            List<EmploymentHistory> list = new ArrayList<>();
            PreparedStatement ps = c.prepareStatement("SELECT * FROM employment_history eh INNER JOIN  user u ON "
                    + "eh.user_id = u.id");
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                String header = rs.getString("header");
                String jobDescription = rs.getString("job_description");
                Date beginDate = rs.getDate("begin_date");
                Date endDate = rs.getDate("end_date");
                int userId = rs.getInt("user_id");
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
}
