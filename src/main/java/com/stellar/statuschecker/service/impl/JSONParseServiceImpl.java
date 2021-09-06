package com.stellar.statuschecker.service.impl;

import com.google.gson.Gson;
import com.stellar.statuschecker.models.Aggregation;
import com.stellar.statuschecker.models.AggregationUnits;
import com.stellar.statuschecker.service.JSONParseService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
@Service
public class JSONParseServiceImpl implements JSONParseService {
    @Override
    public List<String> parseJSON() {
        String path = "010487021676507120011121072910.json";
        List<String>codes = new ArrayList<>();
        try {
            String contents = new String(Files.readAllBytes(Paths.get(path)));
            Gson g = new Gson();
            AggregationUnits aggregationUnits = g.fromJson(contents, AggregationUnits.class);
            for (Aggregation a:aggregationUnits.getAggregationUnits()) {
                System.out.println(a.getSntins());
                for (String i:a.getSntins()) {
                    codes.add(i);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return codes;
    }

}
