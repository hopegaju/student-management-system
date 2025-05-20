package com.codegaju;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends Connect implements Operation<Student>{
    @Override
    public void create(Student stud) {
        String query = "insert into students (first_name,last_name,email, date_of_birth) " +
                "values(?,?,?,CAST(? AS DATE))";
        try(Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, stud.getFirstName());
            stmt.setString(2, stud.getLastName());
            stmt.setString(3, stud.getEmail());
            stmt.setString(4, stud.getBirthDate());
            stmt.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }


    @Override
    public void read(int id) {
        String query = "select * from students where id = ?";
        try(Connection conn = connect(); PreparedStatement st= conn.prepareStatement(query)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("last_name") +"  "+
                        rs.getString("first_name") + "  "+
                        rs.getString("email") + "  "+
                        rs.getString("date_of_birth"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Student> readAll() {
        List<Student> list = new ArrayList<Student>();
        String query = "select * from students";
        try (Connection conn= connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while(rs.next()){
             list.add(new Student(rs.getString("first_name"),
                     rs.getString("last_name"),
                             rs.getString("email"),
                             rs.getString("date_of_birth")));
            }

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void update(Student st) {
        String query ="UPDATE students first_name=?,last_name=?,email=? WHERE id=?";
        try(Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, st.getFirstName());
            stmt.setString(2, st.getLastName());
            stmt.setString(3, st.getEmail());
            stmt.setString(4,st.getBirthDate());
            stmt.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {

    }
}
