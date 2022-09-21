package com.example.kcktest.service.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class StorageService {
    @Value("${image.folder}")
    private String imagesFolder;

    public String fileUpload(MultipartFile file) {

        String fileName = file.getOriginalFilename();
        File newFile = new File(imagesFolder + fileName);

        try (InputStream inputStream = file.getInputStream();
             OutputStream outputStream = new FileOutputStream(newFile)) {
            if (!newFile.exists()) {
                newFile.createNewFile();
            }
            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return newFile.getAbsolutePath();
    }
}
