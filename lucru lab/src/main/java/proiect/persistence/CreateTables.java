package main.java.proiect.persistence;

import main.java.proiect.entity.building.Faculty;
import main.java.proiect.persistence.util.DatabaseConnectionUtils;

import java.sql.*;
public class CreateTables {
    public static void main(String[] args) throws SQLException {
        try(Connection connection = DatabaseConnectionUtils.getDatabaseConnection();){
            String createSequence = "CREATE SEQUENCE SEQ START 1;";
            String createFacultyTable = "CREATE TABLE Faculties("+
                    "id INT PRIMARY KEY DEFAULT nextval('seq'),"+
                    "name VARCHAR(255) ,"+
                    "address VARCHAR(255) ,"+
                    "nrRooms INTEGER ,"+
                    "nrFloors INTEGER ,"+
                    "foundingYear INTEGER ,"+
                    "squareMeters INTEGER,"+
                    "usefulSquareMeters INTEGER ,"+
                    "Dean VARCHAR(255),"+
                    "Secretary VARCHAR(255),"+
                    "nrDepartments VARCHAR(255),"+
                    "nrStudents VARCHAR(255),"+
                    "nrTeachers VARCHAR(255),"+
                    "nrLaboratories VARCHAR(255),"+
                    "nrClassRooms VARCHAR(255),"+
                    "nrLibraries VARCHAR(255),"+
                    "nrCafeterias VARCHAR(255),"+
                    "nroffices VARCHAR(255),"+
                    "nrAmphitheaters VARCHAR(255));";

            String createPersonBaseTable =
                    "cnp VARCHAR(50) PRIMARY KEY," +
                    "name VARCHAR(255) ," +
                    "surname VARCHAR(255) ," +
                    "address VARCHAR(255) ," +
                    "phoneNumber VARCHAR(255) ,";

            String createProffessorTable =  "CREATE TABLE Proffessors(" +
                    createPersonBaseTable +
                    "department VARCHAR(255) ," +
                    "title VARCHAR(255));";

            String createStudentTable = "CREATE TABLE Students(" +
                    createPersonBaseTable +
                    "year  INTEGER," +
                    "\"group\" VARCHAR(255)," +
                    "specialization VARCHAR(255));";

            String createRoomBaseTable =
                    "number VARCHAR(50) PRIMARY KEY," +
                    "capacity INTEGER ," +
                    "type VARCHAR(255) ,";

            String createClassRoomTable = "CREATE TABLE ClassRoom(" +
                    createRoomBaseTable +
                    "nrCalculators INTEGER, " +
                    "nrTables  INTEGER);";

            String createAmphitheaterTable = "CREATE TABLE Amphitheater(" +
                    createRoomBaseTable +
                    "nrSeats INTEGER, " +
                    "nrChalkboards  INTEGER, " +
                    "nrProjectors INTEGER, " +
                    "nrOutlets INTEGER);";

            String createAuditTable = "CREATE TABLE Audit(" +
                    "id INT PRIMARY KEY DEFAULT nextval('seq')," +
                    "action VARCHAR(255) ," +
                    "timestamp VARCHAR(255));";

            try(Statement statement = connection.createStatement()){
                System.out.println(createAmphitheaterTable);
                System.out.println(createClassRoomTable);
                System.out.println(createStudentTable);
                System.out.println(createProffessorTable);
                System.out.println(createFacultyTable);
                System.out.println(createAuditTable);
                statement.execute("DROP TABLE IF EXISTS Proffessors CASCADE;");
                statement.execute(createProffessorTable);
                statement.execute("DROP TABLE IF EXISTS Students CASCADE;");
                statement.execute(createStudentTable);
                statement.execute("DROP TABLE IF EXISTS ClassRoom CASCADE;");
                statement.execute(createClassRoomTable);
                statement.execute("DROP TABLE IF EXISTS Amphitheater CASCADE;");
                statement.execute(createAmphitheaterTable);
                statement.execute("DROP SEQUENCE IF EXISTS SEQ CASCADE;");
                statement.execute(createSequence);
                statement.execute("DROP TABLE IF EXISTS Faculties CASCADE;");
                statement.execute(createFacultyTable);
                statement.execute("DROP TABLE IF EXISTS Audit CASCADE;");
                statement.execute(createAuditTable);
                System.out.println("Table created successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
