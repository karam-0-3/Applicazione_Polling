package com.example.mobifog_polling;

import okhttp3.OkHttpClient;
import java.util.concurrent.TimeUnit;

public enum HttpClientSingleton {
    INSTANCE;

    private final OkHttpClient client;

    HttpClientSingleton() {
        client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS).build();
    }

    public OkHttpClient getClient() {
        return client;
    }
}
