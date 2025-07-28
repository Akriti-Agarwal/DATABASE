import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDaoDemo {
    public static void main(String args[])
    {
        StudentDAO dao = new StudentDAO();
        Student s1= dao.getStudent(1);
        if (s1!=null) {
            System.out.println(s1.sname);
        }
        else {
            System.out.println("Student not found");
        }

    }
    static class StudentDAO
    {
        public Student getStudent(int rollno)
        {
            try {
                String query = "select sname from student where rollno = " + rollno;
                Student s = new Student();
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/alien", "root", "Avaya@123");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query);
                if (rs.next()) {

                    s.rollno = rollno;
                    s.sname = rs.getString("rollno");
                    return s;

                }
            }
            catch (Exception ex)
            {
                System.out.println(ex);
            }
            return null;
        }
    }
     static class Student
    {
        int rollno;
        String sname;
    }
}
