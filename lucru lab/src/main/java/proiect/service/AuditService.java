package main.java.proiect.service;

import main.java.proiect.entity.Audit;
import main.java.proiect.persistence.AuditRepository;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvWriter;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvWriterSettings;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class AuditService {
    public static String filePath = "src/main/java/proiect/audit/audit_";
    private static AuditService instance;
    private static AuditRepository auditRepository = AuditRepository.getInstance();

    private AuditService() {
    }

    public static synchronized AuditService getInstance() {
        if (instance == null) {
            instance = new AuditService();
        }
        return instance;
    }

    public static String createNewFile() {
        String pathString = filePath + System.currentTimeMillis() + ".csv";
        Path path = Path.of(filePath + System.currentTimeMillis() + ".csv");
        System.out.println("New CSV file created successfully: " + pathString);
        return pathString;
    }

    public static void writeData() throws IOException {
        String pathAudit = createNewFile();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathAudit))) {
            // Write headers
            writer.write("Action,Timestamp");
            writer.newLine();
            // Add rows
            for (Audit audit : auditRepository.findAll()) {
                writer.write( audit.getAction() + "," + audit.getTimestamp());
                writer.newLine();
            }
            // Add more data rows as needed

            System.out.println("Data written to CSV file successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to CSV file: " + e.getMessage());
        }
    }

    public static void save(Audit audit ){
    auditRepository.save(audit);
    }

    public static void findAll(){
    auditRepository.findAll();
    }

}
