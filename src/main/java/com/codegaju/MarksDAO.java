package com.codegaju;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MarksDAO extends Connect implements Operation<Marks> {
    @Override
    public void create(Marks table) {
        String query = "INSERT INTO marks(student_id, course_id, marks) VALUES(?,?,?)";
        try(Connection conn = connect(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1,table.getStudent_id());
            ps.setInt(2,table.getCourse_id());
            ps.setInt(3,table.getMarks());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void read(int student_id) {
        String query = "SELECT * FROM marks WHERE student_id = ?";
        try(Connection conn = connect(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1,student_id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                System.out.println("student_id: "+rs.getInt("student_id") +"  "+
                        "course_id: "+"  "+ rs.getInt("course_id") +"  "+
                        "marks: "+"  "+rs.getInt("marks"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Marks> readAll() {
        List<Marks> list = new ArrayList<Marks>();
        String query = "SELECT * FROM marks";
        try (Connection conn = connect(); Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                list.add(new Marks(rs.getInt("student_id"),
                        rs.getInt("course_id"),
                        rs.getInt("marks")));
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void update(Marks table) {
        String query = "UPDATE marks SET marks = ? WHERE student_id = ?,course_id = ?";
        try (Connection conn = connect(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1,table.getMarks());
            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(int student_id) {
        String query = "DELETE FROM marks WHERE student_id = ?";
        try (Connection conn = connect(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1,student_id);
            int rows = ps.executeUpdate();
            if(rows > 0) {
                System.out.println("marks deleted successfully");
            }else {
                System.out.println("marks deletion failed");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void create(Student stud) {

    }
}
