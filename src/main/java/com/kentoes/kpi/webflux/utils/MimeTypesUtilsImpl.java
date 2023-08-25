package com.kentoes.kpi.webflux.utils;

import org.springframework.stereotype.Service;

@Service
public class MimeTypesUtilsImpl implements MimeTypesUtils {
    private final String[] imageMimeTypes = {
            "image/jpeg",
            "image/png",
    };
    private final String[] documentMimeTypes = {
            "application/pdf",
            "application/msword",
            "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
            "application/vnd.ms-excel",
            "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
            "application/vnd.ms-powerpoint",
            "application/vnd.openxmlformats-officedocument.presentationml.presentation",
            "application/vnd.oasis.opendocument.text",
            "application/vnd.oasis.opendocument.spreadsheet",
            "application/vnd.oasis.opendocument.presentation"
    };

    private final String[] compressedMimeTypes = {
            "application/zip",
            "application/x-7z-compressed",
            "application/x-rar-compressed",
            "application/x-tar",
            "application/gzip"
    };

    public boolean isImage(String mimeType) {
        for (String imageMimeType : imageMimeTypes) {
            if (imageMimeType.equals(mimeType)) return true;
        }
        return false;
    }

    public boolean isDocument(String mimeType) {
        for (String documentMimeType : documentMimeTypes) {
            if (documentMimeType.equals(mimeType)) return true;
        }
        return false;
    }

    public boolean isCompressed(String mimeType) {
        for (String compressedMimeType : compressedMimeTypes) {
            if (compressedMimeType.equals(mimeType)) return true;
        }
        return false;
    }

    @Override
    public String isSupported(String mimeType) {
        return (isImage(mimeType) || isDocument(mimeType) || isCompressed(mimeType)) ? mimeType : null;

    }

    @Override
    public String getExtension(String mimeType) {
        if (isImage(mimeType)) {
            return mimeType.substring(mimeType.indexOf("/") + 1);
        } else if (isDocument(mimeType)) {
            return mimeType.substring(mimeType.indexOf("/") + 1);
        } else if (isCompressed(mimeType)) {
            return mimeType.substring(mimeType.indexOf("/") + 1);
        } else {
            return null;
        }
    }
}
