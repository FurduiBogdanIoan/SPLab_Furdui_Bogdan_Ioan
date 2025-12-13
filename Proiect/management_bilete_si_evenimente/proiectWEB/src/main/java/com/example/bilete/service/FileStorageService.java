package com.example.bilete.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;

@Service
public class FileStorageService {

    private final Path fileStorageLocation;

    public FileStorageService() throws IOException {
        this.fileStorageLocation = Paths.get("uploads/images/evenimente/").toAbsolutePath().normalize();
        Files.createDirectories(this.fileStorageLocation);
    }

    public String storeFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return "/uploads/images/evenimente/" + fileName;
        } catch (Exception ex) {
            throw new RuntimeException("Nu pot salva fișierul " + fileName);
        }
    }
}