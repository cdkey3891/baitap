package com.company.jdbc;

import java.sql.*;

public class JDBCConnection {
    private static final String connectionURL = "";
    private static final String username = "root";
    private static final String password = "";
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.load driver
        Class.forName("com.mysql.jdbc.Driver");
        //2.create connection
        Connection con = DriverManager.getConnection(connectionURL, username, password);
        //3. create statement
        Statement st = con.createStatement();
        //4. create query
        String sql = "SELECT * FROM users";
        //5. querry
        ResultSet rs = st.executeQuery(sql);
        if (rs.absolute(2)) {
            do {
                System.out.println(rs.getInt(1));
            } while (rs.next());
        }

    }
}
