package com.stellar.statuschecker.service.impl;

import com.google.gson.Gson;
import com.stellar.statuschecker.models.CisInfo;
import com.stellar.statuschecker.models.CodesInfo;
import com.stellar.statuschecker.models.Root;
import com.stellar.statuschecker.service.TrueAPICheckService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TrueAPICheckServiceImpl implements TrueAPICheckService {
    public List<String> checkCodesWithTrueAPI(MultipartFile[] files) {
        List<String>emittedCodes = new ArrayList<>();
        List<CisInfo> cisInfoList = new ArrayList<>();
        for (MultipartFile m : files) {
            try {
                String contents = new String(m.getBytes());
                Gson g = new Gson();
                CodesInfo codesInfo = g.fromJson(contents, CodesInfo.class);
                for (CisInfo c:codesInfo.getCisInfo()) {
                    if(c.getStatus().equals("APPLIED")){
                        emittedCodes.add(c.getStatus());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } return emittedCodes;
    }
}