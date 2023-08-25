package com.kentoes.kpi.webflux.utils;

public interface MimeTypesUtils {
    String getExtension(String mimeType);

    String isSupported(String mimeType);
}
