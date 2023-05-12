package com.maxime.movieappbackend.service.file;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    void init();

    String uploadFile(MultipartFile file);

    public Resource downloadFile(String path);
}
