package main.java.proiect.persistence;

import main.java.proiect.entity.building.Faculty;
import main.java.proiect.entity.person.Student;
import main.java.proiect.persistence.util.DatabaseConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import static main.java.proiect.persistence.util.DatabaseConnectionUtils.getDatabaseConnection;

public class StudentRepository implements GenericRepository<Student> {
    private final Connection connection = DatabaseConnectionUtils.getDatabaseConnection();
    private static volatile StudentRepository instance;
    private final Map<String, Student> students = new HashMap<>();
    private StudentRepository() {
    }

    public static StudentRepository getInstance() {
        if (instance == null) {
            synchronized (StudentRepository.class) {
                if (instance == null) {
                    instance = new StudentRepository();
                }
            }
        }
        return instance;
    }

    @Override
    public Student save(Student entity) {
        String sql = "INSERT INTO students VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            statement.setString(1, entity.getCnp());
            statement.setString(2, entity.getName());
            statement.setString(3, entity.getSurname());
            statement.setString(4, entity.getAddress());
            statement.setString(5, entity.getPhoneNumber());
            statement.setInt(6, entity.getYear());
            statement.setString(7, entity.getGroup());
            statement.setString(8, entity.getSpecialization());
            statement.executeUpdate();
            return entity;
        } catch (SQLException e) {
            System.out.println("Could not save student in database: " + e.getMessage());
        }
        return entity;
    }

    @Override
    public List<Student> findAll() {
        String sql = "SELECT * FROM students";
        List<Student> students = new Vector<>();
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            var result = statement.executeQuery();
            while (result.next()) {
                students.add(new Student(
                        result.getString("cnp"),
                        result.getString("name"),
                        result.getString("surname"),
                        result.getString("address"),
                        result.getString("phonenumber"),
                        result.getInt("year"),
                        result.getString("group"),
                        result.getString("specialization")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Could not find students in database: " + e.getMessage());
        }
        return students;
    }

    @Override
    public Optional<Student> findById(String id){
        String sql = "SELECT * FROM students WHERE cnp = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            statement.setString(1, id);
            var result = statement.executeQuery();
            if (result.next()) {
                return Optional.of(new Student(
                        result.getString("cnp"),
                        result.getString("name"),
                        result.getString("surname"),
                        result.getString("address"),
                        result.getString("phonenumber"),
                        result.getInt("year"),
                        result.getString("group"),
                        result.getString("specialization")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Could not find student in database: " + e.getMessage());
        }
        return Optional.empty();
    }


    @Override
    public void update(Student entity) {
        String sql = "UPDATE students SET name = ?, surname = ?, address = ?, phoneNumber = ?, year = ?, \"group\" = ?, specialization = ? WHERE cnp = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getSurname());
            statement.setString(3, entity.getAddress());
            statement.setString(4, entity.getPhoneNumber());
            statement.setInt(5, entity.getYear());
            statement.setString(6, entity.getGroup());
            statement.setString(7, entity.getSpecialization());
            statement.setString(8, entity.getCnp());
            System.out.println(entity.getCnp());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Could not update student in database: " + e.getMessage());
        }
    }

    @Override
    public Faculty findById(Integer Id) {
        return null;
    }

    @Override
    public void delete(Student entity) {

    }

    public void deleteByCnp(String cnp) {
        String sql = "DELETE FROM students WHERE cnp = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            statement.setString(1, cnp);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Could not delete student from database: " + e.getMessage());
        }
            }
            public List<Student> findByYear (Integer year){
                List<Student> students = new ArrayList<>();
                String sql = "SELECT * FROM students WHERE year = ?";
                try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
                    statement.setInt(1, year);
                    var result = statement.executeQuery();
                    while (result.next()) {
                        students.add( new Student(
                                result.getString("cnp"),
                                result.getString("name"),
                                result.getString("surname"),
                                result.getString("address"),
                                result.getString("phonenumber"),
                                result.getInt("year"),
                                result.getString("group"),
                                result.getString("specialization")
                        ));
                    }
                } catch (SQLException e) {
                    System.out.println("Could not find students in database: " + e.getMessage());
                }
                return students;
            }


    public Student findByName(String name){
        for(Student student : this.findAll()){
            if(student.getName().equals(name)){
                return student;
            }
        }
        return null;
    }
}
