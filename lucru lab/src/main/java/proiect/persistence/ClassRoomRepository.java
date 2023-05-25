package main.java.proiect.persistence;

import main.java.proiect.entity.building.Faculty;
import main.java.proiect.entity.room.ClassRoom;
import main.java.proiect.persistence.util.DatabaseConnectionUtils;

import java.sql.Connection;
import java.util.*;

public class ClassRoomRepository implements GenericRepository<ClassRoom>{
    private final Connection connection = DatabaseConnectionUtils.getDatabaseConnection();
    private static volatile ClassRoomRepository instance;
    private final Map<String, ClassRoom> classRoomMap = new HashMap<>();
    @Override
    public ClassRoom save(ClassRoom entity) {
        String query = "INSERT INTO classroom(number, capacity, type, nrCalculators, nrTables) VALUES(?, ?, ?, ?, ?)";
        try{
            var preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, entity.getNumber());
            preparedStatement.setInt(2, entity.getCapacity());
            preparedStatement.setString(3, entity.getType());
            preparedStatement.setInt(4, entity.getNumberOfCalculators());
            preparedStatement.setInt(5, entity.getNumberOfTables());
            preparedStatement.execute();
            return entity;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ClassRoom> findAll() {
        String query = "SELECT * FROM classroom";
        try {
            var preparedStatement = connection.prepareStatement(query);
            var resultSet = preparedStatement.executeQuery();
            List<ClassRoom> classRooms = new ArrayList<>();
            while (resultSet.next()) {
                ClassRoom classRoom = new ClassRoom();
                classRoom.setNumber(resultSet.getInt("number"));
                classRoom.setCapacity(resultSet.getInt("capacity"));
                classRoom.setType(resultSet.getString("type"));
                classRoom.setNumberOfCalculators(resultSet.getInt("nrCalculators"));
                classRoom.setNumberOfTables(resultSet.getInt("nrTables"));
                classRooms.add(classRoom);
            }
            return classRooms;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ClassRoom findByName(String name) {
        String query = "SELECT * FROM classroom WHERE number = ?";
        try {
            var preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            var resultSet = preparedStatement.executeQuery();
            ClassRoom classRoom = null;
            while (resultSet.next()) {
                classRoom = new ClassRoom();
                classRoom.setNumber(resultSet.getInt("number"));
                classRoom.setCapacity(resultSet.getInt("capacity"));
                classRoom.setType(resultSet.getString("type"));
                classRoom.setNumberOfCalculators(resultSet.getInt("nrCalculators"));
                classRoom.setNumberOfTables(resultSet.getInt("nrTables"));
            }
            return classRoom;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ClassRoom> findByType(String type){
        String query = "SELECT * FROM classroom WHERE type = ?";
        try {
            var preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, type);
            var resultSet = preparedStatement.executeQuery();
            List<ClassRoom> classRooms = new ArrayList<>();
            while (resultSet.next()) {
                ClassRoom classRoom = new ClassRoom();
                classRoom.setNumber(resultSet.getInt("number"));
                classRoom.setCapacity(resultSet.getInt("capacity"));
                classRoom.setType(resultSet.getString("type"));
                classRoom.setNumberOfCalculators(resultSet.getInt("nrCalculators"));
                classRoom.setNumberOfTables(resultSet.getInt("nrTables"));
                classRooms.add(classRoom);
            }
            return classRooms;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<ClassRoom> findById(String id) {
        return Optional.empty();
    }

    @Override
    public void update(ClassRoom entity) {
        String query = "UPDATE classroom SET capacity = ?, type = ?, nrCalculators = ?, nrTables = ? WHERE number = ?";
        try {
            var preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, entity.getCapacity());
            preparedStatement.setString(2, entity.getType());
            preparedStatement.setInt(3, entity.getNumberOfCalculators());
            preparedStatement.setInt(4, entity.getNumberOfTables());
            preparedStatement.setString(5, Integer.toString(entity.getNumber()));
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Faculty findById(Integer Id) {
        return null;
    }

    @Override
    public void delete(ClassRoom entity) {
        String query = "DELETE FROM classroom WHERE number = ?";
        try {
            var preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, Integer.toString(entity.getNumber()));
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void remove(Integer number) {
        String query = "DELETE FROM classroom WHERE number = ?";
        try {
            var preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, Integer.toString(number));
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ClassRoomRepository getInstance() {
        if (instance == null) {
            synchronized (ClassRoomRepository.class) {
                if (instance == null) {
                    instance = new ClassRoomRepository();
                }
            }
        }
        return instance;
    }
}
