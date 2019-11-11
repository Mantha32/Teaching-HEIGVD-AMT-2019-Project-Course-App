package com.amt.schedule.impl;

import com.amt.schedule.entities.SlotEvent;
import com.amt.schedule.inter.SlotEventEJB;
import com.amt.schedule.utility.DB;

import javax.ejb.Stateless;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateless(name = "SlotEventImpl")
public class SlotEventDAO implements SlotEventEJB {
    private Connection db = DB.connection();

    public SlotEventDAO() throws Exception {
    }

    @Override
    public List<SlotEvent> list() {
        String req = "SELECT * FROM slotevent";
        PreparedStatement preparedStatement = null;
        List<SlotEvent> slotEvents = new ArrayList<>();
        SlotEvent slotEvent;
        try {
            preparedStatement = db.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                slotEvent = new SlotEvent(resultSet.getString("date"), resultSet.getString("hour"));
                slotEvent.setSloteventid(resultSet.getInt("sloteventid"));
                slotEvents.add(slotEvent);
            }
        } catch (SQLException e) {

        }
        return slotEvents;
    }

    @Override
    public SlotEvent chercher(int id) {
        String req = "SELECT * FROM slotevent WHERE sloteventid = ?";
        SlotEvent slotevent = new SlotEvent();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = db.prepareStatement(req);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.first()) {
                slotevent.setSloteventid(resultSet.getInt("sloteventid"));
                slotevent.setJour(resultSet.getString("date"));
                slotevent.setHeure(resultSet.getString("hour"));
            }
        } catch (SQLException e) {

        }
        return slotevent;
    }
}
