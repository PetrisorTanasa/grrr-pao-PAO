package main.java.proiect.persistence;

import main.java.proiect.entity.Audit;
import main.java.proiect.entity.building.Faculty;
import main.java.proiect.entity.person.Proffessor;
import main.java.proiect.persistence.util.DatabaseConnectionUtils;

import java.sql.Connection;
import java.util.*;

public class AuditRepository implements GenericRepository<Audit> {

    private final Connection connection = DatabaseConnectionUtils.getDatabaseConnection();
    private final Map<String, Audit> auditMap = new HashMap<>();
    private static AuditRepository instance;

    private AuditRepository() {
    }

    public static synchronized AuditRepository getInstance() {
        if (instance == null) {
            instance = new AuditRepository();
        }
        return instance;
    }

    @Override
    public Audit save(Audit entity) {
        String sql = "INSERT INTO audit(action, timestamp) VALUES(?,?)";
        try {
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, entity.getAction());
            preparedStatement.setString(2, entity.getTimestamp());
            preparedStatement.execute();
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Audit> findAll() {
        String sql = "SELECT * FROM audit";
        try{
            var preparedStatement = connection.prepareStatement(sql);
            var resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Audit audit = new Audit(resultSet.getString(2), resultSet.getString(3));
                auditMap.put(audit.getAction(), audit);
            }
            List<Audit> list = new ArrayList<Audit>(auditMap.values());
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<Audit> findById(String id) {
        return Optional.empty();
    }

    @Override
    public void update(Audit entity) {

    }

    @Override
    public Faculty findById(Integer Id) {
        return null;
    }

    @Override
    public void delete(Audit entity) {

    }
}
