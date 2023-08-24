package com.kentoes.kpi.webflux.config;

public class EnvConfig {
    public static final String RESPONSE_FORMAT = System.getenv("APPWRITE_RESPONSE_FORMAT");
    public static final String APPWRITE_HOST = System.getenv("APPWRITE_HOST");
    public static final String ENDPOINT = System.getenv("APPWRITE_ENDPOINT");
    public static final String PROJECT_ID = System.getenv("APPWRITE_PROJECT_ID");
    public static final String API_KEY = System.getenv("APPWRITE_API_KEY");
}
