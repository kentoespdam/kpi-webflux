package com.kentoes.kpi.webflux.utils;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadUtil {
    String BASE_PATH = System.getProperty("user.dir") + "/uploads/";

    UploadResultUtil uploadFile(MultipartFile file, Integer periode, String nipam);

    void deleteOldFile(String oldFileName);
}

