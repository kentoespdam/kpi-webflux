package com.kentoes.kpi.webflux.utils;

import com.kentoes.kpi.webflux.helpers.RandomStringHelper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@RequiredArgsConstructor
@Service
public class FileUploadUtilImpl implements FileUploadUtil {
    private final RandomStringHelper randomStringHelper;
    private final MimeTypesUtils mimeTypesUtils;

    @Override
    public UploadResultUtil uploadFile(MultipartFile file, Integer periode, String nipam) {
        String mimeType = mimeTypesUtils.isSupported(file.getContentType());
        if (mimeType == null)
            return UploadResultUtil.build(false, "File type not supported");

        String fileType = FilenameUtils.getExtension(file.getOriginalFilename());
        String hashedFileName = randomStringHelper.generate();
        String fileName = file.getOriginalFilename();

        File dir = new File(BASE_PATH + periode + "/" + nipam);
        createDirectory(dir);

        boolean saved = saveToStorage(file, dir, hashedFileName);
        if (!saved)
            return UploadResultUtil.build(false, "Failed to save file");


        return UploadResultUtil.build(true, "File uploaded successfully", fileName, fileType, mimeType, hashedFileName);
    }

    @Override
    public void deleteOldFile(String oldFileName) {
        try {
            File file = new File(BASE_PATH + oldFileName);
            Files.deleteIfExists(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createDirectory(File dir) {
        if (!dir.exists()) {
            try {
                Files.createDirectories(dir.toPath());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private boolean saveToStorage(MultipartFile file, File dir, String hashedFileName) {
        try (InputStream inputStream = file.getInputStream()) {
            Path filePath = dir.toPath().resolve(hashedFileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
