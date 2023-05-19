package main.java.proiect.persistence;

import main.java.proiect.entity.building.Faculty;
import main.java.proiect.entity.person.Proffessor;
import main.java.proiect.entity.person.Student;
import main.java.proiect.persistence.util.DatabaseConnectionUtils;

import java.sql.Array;
import java.sql.Connection;
import java.util.*;

public class ProffessorRepository  implements GenericRepository<Proffessor> {
    private final Connection connection = DatabaseConnectionUtils.getDatabaseConnection();
    private static volatile ProffessorRepository instance;
    private final Map<String, Proffessor> proffessorMap = new HashMap<>();

    public static ProffessorRepository getInstance() {
        if (instance == null) {
            synchronized (StudentRepository.class) {
                if (instance == null) {
                    instance = new ProffessorRepository();
                }
            }
        }
        return instance;
    }
    @Override
    public Proffessor save(Proffessor entity) {
        String sql = "INSERT INTO proffessors(cnp, name, surname, address, phonenumber, department, title) VALUES(?,?,?,?,?,?,?)";
        try {
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, entity.getCnp());
            preparedStatement.setString(2, entity.getName());
            preparedStatement.setString(3, entity.getSurname());
            preparedStatement.setString(4, entity.getAddress());
            preparedStatement.setString(5, entity.getPhoneNumber());
            preparedStatement.setString(6, entity.getDepartment());
            preparedStatement.setString(7, entity.getTitle());
            preparedStatement.execute();
            proffessorMap.put(entity.getCnp(), entity);
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Proffessor> findAll() {
        String sql = "SELECT * FROM proffessors";
        try {
            var preparedStatement = connection.prepareStatement(sql);
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Proffessor proffessor = new Proffessor(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7));
                proffessorMap.put(proffessor.getCnp(), proffessor);
            }
            List<Proffessor> list = new ArrayList<Proffessor>(this.proffessorMap.values());
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<Proffessor> findById(String id) {
        return Optional.empty();
    }

    public Optional<Proffessor> findByCnp(String id) {
        String sql = "SELECT * FROM proffessors WHERE cnp=?";
        try {
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            var resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Proffessor proffessor = new Proffessor(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7));
                return Optional.of(proffessor);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void update(Proffessor entity) {
        String sql = "UPDATE proffessors SET name=?, surname=?, address=?, phonenumber=?, department=?, title=? WHERE cnp=?";
        try {
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getSurname());
            preparedStatement.setString(3, entity.getAddress());
            preparedStatement.setString(4, entity.getPhoneNumber());
            preparedStatement.setString(5, entity.getDepartment());
            preparedStatement.setString(6, entity.getTitle());
            preparedStatement.setString(7, entity.getCnp());
            preparedStatement.execute();
            proffessorMap.put(entity.getCnp(), entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Faculty findById(Integer Id) {
        return null;
    }

    @Override
    public void delete(Proffessor entity) {
        String sql = "DELETE FROM proffessors WHERE cnp=?";
        try {
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, entity.getCnp());
            preparedStatement.execute();
            proffessorMap.remove(entity.getCnp());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Proffessor findByName(String name) {
        String sql = "SELECT * FROM proffessors WHERE name=?";
        try {
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            var resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Proffessor proffessor = new Proffessor(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7));
                return proffessor;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Proffessor> findByDepartment(String department) {
        String sql = "SELECT * FROM proffessors WHERE department=?";
        try {
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, department);
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Proffessor proffessor = new Proffessor(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7));
                this.proffessorMap.put(proffessor.getCnp(), proffessor);
            }
            List<Proffessor> list = new ArrayList<Proffessor>(this.proffessorMap.values());
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteByCnp(String cnp) {
        String sql = "DELETE FROM proffessors WHERE cnp=?";
        try {
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cnp);
            preparedStatement.execute();
            proffessorMap.remove(cnp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public List<Proffessor>  findByDepartment(String department) {
//        String sql = "SELECT * FROM proffessors WHERE department=?";
//        try {
//            var preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, department);
//            var resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                Proffessor proffessor = new Proffessor(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7));
//                proffessorMap.put(proffessor.getCnp(), proffessor);
//            }
//            return (List<Proffessor>) proffessorMap.values();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
