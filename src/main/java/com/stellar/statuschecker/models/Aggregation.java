package com.stellar.statuschecker.models;

import lombok.Data;

import java.util.List;
@Data
public class Aggregation {
    private String aggregationType;
    private int aggregatedItemsCount;
    private int aggregationUnitCapacity;
    private List<String> sntins;

}
