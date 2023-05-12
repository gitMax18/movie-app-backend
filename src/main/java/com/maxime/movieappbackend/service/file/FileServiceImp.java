package com.maxime.movieappbackend.service.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImp implements FileService {

    private final Path directory = Paths.get("uploads");

    public FileServiceImp() {
        this.init();
    }

    @Override
    public void init() {
        if (!Files.exists(directory)) {
            try {
                Files.createDirectory(directory);
            } catch (Exception e) {
                throw new RuntimeException("Cannot create file directory");
            }
        }
    }

    @Override
    public String uploadFile(MultipartFile file) {
        try {
            String originalFileName = file.getOriginalFilename();
            String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
            String fileName = UUID.randomUUID().toString() + extension;
            Files.copy(file.getInputStream(), directory.resolve(fileName));
            return fileName;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }

    }

    @Override
    public Resource downloadFile(String fileName) {
        try {
            Path path = directory.resolve(fileName);
            Resource resource = new UrlResource(path.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Cannot read file");
            }
        } catch (Exception e) {
            throw new RuntimeException("issue with file");
        }
    }

}
