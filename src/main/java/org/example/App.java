package org.example;
import java.sql.*;

public class App {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:postgresql://localhost:5432/alien";
        String user = "postgres";
        String pass = "Avaya@123";
        String query = "SELECT * FROM stud";
        String query1 = "insert into stud values(?,?)";
        int userid =2;
        String username="priti";
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement ps =con.prepareStatement(query1);
        Statement st = con.createStatement();
        ps.setInt(1,userid);
        ps.setString(2,username);
        int count = ps.executeUpdate();
        System.out.println(count+" "+"rows are affected");
        ResultSet rs = st.executeQuery(query);


        if (rs.next()) {
            System.out.println( rs.getString("username")+" " +rs.getInt("userid"));
        } else {
            System.out.println("❌ No student found with userid = 3");
        }

        rs.close();
        st.close();
        con.close();
    }
}