package com.stellar.statuschecker.service;

import okhttp3.Response;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FromTrueAPIService {
    String fromTrueAPI(MultipartFile file) throws IOException;
}
