package com.amt.schedule.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
        private static Connection connect = null;

        public static Connection connection() throws Exception {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connect = DriverManager
                        .getConnection("jdbc:mysql://localhost:3306/amt_schedule?"
                                + "user=root&password=");
            } catch (Exception e) {
                throw e;
            } finally {
                return connect;
            }
        }

}