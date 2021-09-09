package com.stellar.statuschecker.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface JSONParseService {
    List<String> parseJSON(MultipartFile[] files);
}
