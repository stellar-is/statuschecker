package com.stellar.statuschecker.controllers;

import com.stellar.statuschecker.models.CisInfo;
import com.stellar.statuschecker.service.FromTrueAPIService;
import io.swagger.annotations.Api;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static com.stellar.statuschecker.configuration.Swagger2Config.ONE;


@Api(tags = ONE)
@RestController
@RequestMapping(value = "/api/v1/statuscheckservice")
public class FromTrueAPIController {
    @Autowired
    FromTrueAPIService fromTrueAPIService;
    @PostMapping("/cisInfo")
    public String fromTrueAPI(MultipartFile file) throws IOException {

      return fromTrueAPIService.fromTrueAPI(file);
    }
}
