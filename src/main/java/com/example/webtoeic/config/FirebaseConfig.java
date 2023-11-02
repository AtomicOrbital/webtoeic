package com.example.webtoeic.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirebaseConfig {
    @Bean
    public void initialize() throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream("/media/thanhdat/data1/JavaCyber/JavaSpring/webtoeic/src/main/resources/box-chat-ef660-firebase-adminsdk-ooi2e-1c252a9bbc.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp.initializeApp(options);

    }
}
