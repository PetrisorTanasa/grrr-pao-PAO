package main.java.proiect.persistence;

import main.java.proiect.entity.building.Faculty;
import main.java.proiect.persistence.util.DatabaseConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import static main.java.proiect.persistence.util.DatabaseConnectionUtils.getDatabaseConnection;

public class FacultyRepository implements GenericRepository<Faculty> {
    private final Connection connection = DatabaseConnectionUtils.getDatabaseConnection();
    private static volatile FacultyRepository instance;
    private final Map<String, Faculty> faculties = new HashMap<>();
    private FacultyRepository() {
    }

    public static FacultyRepository getInstance() {
        if (instance == null) {
            synchronized (FacultyRepository.class) {
                if (instance == null) {
                    instance = new FacultyRepository();
                }
            }
        }
        return instance;
    }

    @Override
    public Faculty save(Faculty entity) {
        String sql = "INSERT INTO faculties (name,address,nrrooms,nrfloors, foundingyear, squaremeters, usefulsquaremeters, dean,secretary,nrdepartments,nrstudents,nrteachers,nrlaboratories,nrclassrooms,nroffices,nrlibraries,nrcafeterias,nramphitheaters) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getAddress());
            statement.setInt(3, entity.getNumberOfRooms());
            statement.setInt(4, entity.getNumberOfFloors());
            statement.setInt(5, entity.getFoundingYear());
            statement.setInt(6, entity.getSquareMeters());
            statement.setInt(7, entity.getUsefulSquareMeters());
            statement.setString(8, entity.getNameOfDean());
            statement.setString(9, entity.getNameOfSecretary());
            statement.setInt(10, entity.getNumberOfDepartments());
            statement.setInt(11, entity.getNumberOfStudents());
            statement.setInt(12, entity.getNumberOfTeachers());
            statement.setInt(13, entity.getNumberOfLaboratories());
            statement.setInt(14, entity.getNumberOfClassRooms());
            statement.setInt(15, entity.getNumberOfOffices());
            statement.setInt(16, entity.getNumberOfLibraries());
            statement.setInt(17, entity.getNumberOfCafeterias());
            statement.setInt(18, entity.getNumberOfAmphitheaters());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Could not save faculty to database: " + e.getMessage());
        }
        return entity;
    }

    @Override
    public Optional<Faculty> findById(String id) {
        String sql = "SELECT * FROM faculties WHERE id = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            statement.setString(1, id);
            var result = statement.executeQuery();
            if (result.next()) {
                return Optional.of(new Faculty(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("address"),
                        result.getInt("nrrooms"),
                        result.getInt("nrfloors"),
                        result.getInt("foundingyear"),
                        result.getInt("squaremeters"),
                        result.getInt("usefulsquaremeters"),
                        result.getString("dean"),
                        result.getString("secretary"),
                        result.getInt("nrdepartments"),
                        result.getInt("nrstudents"),
                        result.getInt("nrteachers"),
                        result.getInt("nrlaboratories"),
                        result.getInt("nrclassrooms"),
                        result.getInt("nroffices"),
                        result.getInt("nrlibraries"),
                        result.getInt("nrcafeterias"),
                        result.getInt("nramphitheaters")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Could not find faculty in database: " + e.getMessage());
        }
        return Optional.empty();
    }

//    public Optional<Faculty> findByName(Faculty entity){
//        String sql = "SELECT * FROM faculties WHERE name = ?";
//        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
//            statement.setString(1, entity.getName());
//            var result = statement.executeQuery();
//            if (result.next()) {
//                return Optional.of(new Faculty(
//                        result.getString("name"),
//                        result.getString("address"),
//                        result.getInt("nrrooms"),
//                        result.getInt("nrfloors"),
//                        result.getInt("foundingyear"),
//                        result.getInt("squaremeters"),
//                        result.getInt("usefulsquaremeters"),
//                        result.getString("dean"),
//                        result.getString("secretary"),
//                        result.getInt("nrdepartments"),
//                        result.getInt("nrstudents"),
//                        result.getInt("nrteachers"),
//                        result.getInt("nrlaboratories"),
//                        result.getInt("nrclassrooms"),
//                        result.getInt("nroffices"),
//                        result.getInt("nrlibraries"),
//                        result.getInt("nrcafeterias"),
//                        result.getInt("nramphitheaters")
//                ));
//            }
//        } catch (SQLException e) {
//            System.out.println("Could not find faculty in database: " + e.getMessage());
//        }
//        return Optional.empty();
//    }

    @Override
    public List<Faculty> findAll() {
        Connection connection = getDatabaseConnection();
        System.out.println(connection);
        List<Faculty> faculties = new ArrayList<>();
        String sql = "SELECT * FROM faculties";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            var result = statement.executeQuery();
            while (result.next()) {
                faculties.add(new Faculty(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("address"),
                        result.getInt("nrrooms"),
                        result.getInt("nrfloors"),
                        result.getInt("foundingyear"),
                        result.getInt("squaremeters"),
                        result.getInt("usefulsquaremeters"),
                        result.getString("dean"),
                        result.getString("secretary"),
                        result.getInt("nrdepartments"),
                        result.getInt("nrstudents"),
                        result.getInt("nrteachers"),
                        result.getInt("nrlaboratories"),
                        result.getInt("nrclassrooms"),
                        result.getInt("nroffices"),
                        result.getInt("nrlibraries"),
                        result.getInt("nrcafeterias"),
                        result.getInt("nramphitheaters")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Could not find faculties in database: " + e.getMessage());
        }
        return faculties;
    }

    @Override
    public void update(Faculty entity) {
        String sql = "UPDATE faculties SET " +
                "name = ?, " +
                "address = ?," +
                "nrrooms = ?, " +
                "nrfloors = ? " +
                "foundingyear = ? " +
                "squaremeters = ? " +
                "usefulsquaremeters = ? " +
                "dean = ? " +
                "secretary = ? " +
                "nrdepartments = ? " +
                "nrstudents = ? " +
                "nrteachers = ? " +
                "nrlaboratories = ? " +
                "nrclassrooms = ? " +
                "nroffices = ? " +
                "nrlibraries = ? " +
                "nrcafeterias = ? " +
                "nramphitheaters = ? " +
                "WHERE name = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getAddress());
            statement.setInt(3, entity.getNumberOfRooms());
            statement.setInt(4, entity.getNumberOfFloors());
            statement.setInt(5, entity.getFoundingYear());
            statement.setInt(6, entity.getSquareMeters());
            statement.setInt(7, entity.getUsefulSquareMeters());
            statement.setString(8, entity.getNameOfDean());
            statement.setString(9, entity.getNameOfSecretary());
            statement.setInt(10, entity.getNumberOfDepartments());
            statement.setInt(11, entity.getNumberOfStudents());
            statement.setInt(12, entity.getNumberOfTeachers());
            statement.setInt(13, entity.getNumberOfLaboratories());
            statement.setInt(14, entity.getNumberOfClassRooms());
            statement.setInt(15, entity.getNumberOfOffices());
            statement.setInt(16, entity.getNumberOfLibraries());
            statement.setInt(17, entity.getNumberOfCafeterias());
            statement.setInt(18, entity.getNumberOfAmphitheaters());
            statement.setString(19, entity.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Could not update faculty in database: " + e.getMessage());
        }

    }

    @Override
    public Faculty findById(Integer Id) {
        return null;
    }


    public Faculty findByIdInt(Integer Id) {
        for(Faculty faculty : this.findAll()){
            if(faculty.getId() == Id){
                return faculty;
            }
        }
        return null;
    }

    public Faculty findByName(String name){
        for(Faculty faculty : this.findAll()){
            if(faculty.getName().equals(name)){
                return faculty;
            }
        }
        return null;
    }

    @Override
    public void delete(Faculty entity) {
        String sql = "DELETE FROM faculties WHERE name = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            statement.setString(1, entity.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Could not delete faculty from database: " + e.getMessage());
        }
    }
}
