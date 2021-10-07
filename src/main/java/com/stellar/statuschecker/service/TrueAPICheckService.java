package com.stellar.statuschecker.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TrueAPICheckService {
    List<String> checkCodesWithTrueAPI(MultipartFile[] files);
}
