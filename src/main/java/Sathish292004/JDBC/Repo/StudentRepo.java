package Sathish292004.JDBC.Repo;


import Sathish292004.JDBC.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student std){
        //System.out.println("StudentRepo save");
        String sql = "insert into Student (rollno, name, marks) values (?,?,?)";

        int rows = jdbc.update(sql, std.getRollNo(), std.getName(), std.getMark());
        System.out.println(rows + " affected");

    }

    public List<Student> findAll() {

        String sql = "select * from Student";

        return jdbc.query(sql, (rs, rowNum)-> {

            Student std = new Student();
            std.setRollNo(rs.getInt("rollno"));
            std.setName(rs.getString("name"));
            std.setMark(rs.getInt("marks"));

            return std;
        });

    }
}
