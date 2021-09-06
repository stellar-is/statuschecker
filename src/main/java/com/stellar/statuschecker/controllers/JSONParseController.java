package com.stellar.statuschecker.controllers;

import com.stellar.statuschecker.service.JSONParseService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.stellar.statuschecker.configuration.Swagger2Config.ONE;

@Api(tags = ONE)
@RestController
@RequestMapping(value = "/api/v1/statuscheckservice")
public class JSONParseController {
    @Autowired
    JSONParseService jsonParseService;

    @GetMapping("/parser")
    public List<String>parseJSON(){
        return jsonParseService.parseJSON();
    }
}
