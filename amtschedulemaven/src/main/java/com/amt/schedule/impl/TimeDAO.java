package com.amt.schedule.impl;

import com.amt.schedule.entities.Lecture;
import com.amt.schedule.entities.Time;
import com.amt.schedule.inter.LectureEJB;
import com.amt.schedule.inter.SlotEventEJB;
import com.amt.schedule.inter.TimeEJB;
import com.amt.schedule.utility.DB;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateless(name = "TimeImpl")
public class TimeDAO implements TimeEJB {
    private Connection db = DB.connection();

    @EJB
    private SlotEventEJB slotEventEJB;

    @EJB
    private LectureEJB lectureEJB;

    public TimeDAO() throws Exception {
    }

    @Override
    public List<Time> list(Lecture lecture) {
        String req = "SELECT * FROM time WHERE lectureid = ?";
        PreparedStatement preparedStatement = null;
        List<Time> times = new ArrayList<>();
        try {
            preparedStatement = db.prepareStatement(req);
            preparedStatement.setInt(1, lecture.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                times.add(new Time(lecture, slotEventEJB.chercher(resultSet.getInt("sloteventid"))));
            }
        } catch (SQLException e) {

        }
        return times;
    }
}
