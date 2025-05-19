package com.codegaju;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public  class CourseDAO extends Connect implements Operation<Courses>{

    @Override
    public void create(Courses course) {
        String query ="INSERT INTO courses(course_name, course_description) VALUES(?,?)";
        try(Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1,course.getCourse_name());
            stmt.setString(2,course.getCourse_description());
            stmt.executeUpdate();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void read(int id) {
        String query = "SELECT * FROM courses WHERE id = ?";
        try(Connection conn = connect(); PreparedStatement st = conn.prepareStatement(query)){
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("course_name")+"  "
                        +rs.getString("course_description"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Courses> readAll() {
        List<Courses> courses = new ArrayList<Courses>();
        String query = "SELECT * FROM courses";
        try(Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
            while(rs.next()){
                courses.add(new Courses(rs.getString("course_name"),
                        rs.getString("course_description")));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return courses;
    }

    @Override
    public void update(Courses table) {
        String query = "UPDATE courses SET course_name = ?,course_description = ? WHERE id = ?";
        try(Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1,table.getCourse_name());
            stmt.setString(2,table.getCourse_description());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM courses WHERE id = ?";
        try(Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            if(rowsDeleted>0){
                System.out.println("Deleted "+rowsDeleted+" row(s)");
            } else{
                System.out.println("No rows to delete");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void create(Student stud) {

    }
}
