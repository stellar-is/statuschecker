package com.stellar.statuschecker.controllers;

import com.stellar.statuschecker.service.TrueAPICheckService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.stellar.statuschecker.configuration.Swagger2Config.ONE;

@Api(tags = ONE)
@RestController
@RequestMapping(value = "/api/v1/statuscheckservice")
public class TrueAPICheckController {
    @Autowired
    TrueAPICheckService trueAPICheckService;
    @PostMapping("/checkCodes")
    public List<String> checkCodesWithTrueAPI(@RequestBody MultipartFile[] files){
        return trueAPICheckService.checkCodesWithTrueAPI(files);
    }
}
