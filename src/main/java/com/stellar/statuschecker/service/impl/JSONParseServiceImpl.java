package com.stellar.statuschecker.service.impl;

import com.google.gson.Gson;
import com.stellar.statuschecker.models.Aggregation;
import com.stellar.statuschecker.models.AggregationUnits;
import com.stellar.statuschecker.service.JSONParseService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service
@MultipartConfig
public class JSONParseServiceImpl implements JSONParseService {
    @Override
    public List<String> parseJSON(MultipartFile[] files) {
        List<String>codes = new ArrayList<>();
        List<String>transportCodes = new ArrayList<>();
        for (MultipartFile m:files) {
            try {
                String contents = new String(m.getBytes());
                Gson g = new Gson();
                AggregationUnits aggregationUnits = g.fromJson(contents, AggregationUnits.class);
                for (Aggregation a : aggregationUnits.getAggregationUnits()) {
                    for (String y : a.getSntins()) {
                        if (y.contains("'")) {
                            y.replaceAll("'", "''");
                            if (y.startsWith("(01") || y.startsWith("01")) {
                                StringBuffer sb = new StringBuffer(y);
                                sb.insert(0, "(");
                                sb.insert(3, ")");
                                sb.insert(18, "(");
                                sb.insert(21, ")");
                                String code = sb.toString();
                                transportCodes.add(code);
                                codes.add(code);
                            }
                            codes.add(y);
                            System.out.println(y);
                        }else if (y.startsWith("(01") || y.startsWith("01")) {
                            StringBuffer sb = new StringBuffer(y);
                            sb.insert(0, "(");
                            sb.insert(3, ")");
                            sb.insert(18, "(");
                            sb.insert(21, ")");
                            String code = sb.toString();
                            transportCodes.add(code);
                            codes.add(code);
                        } else
                            codes.add(y);
                    }
                        }


                } catch(IOException e){
                    e.printStackTrace();
                }
            }

        return codes;

    }

}
