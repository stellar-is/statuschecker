package com.stellar.statuschecker.models;

import lombok.Data;

import java.util.List;
@Data
public class AggregationUnits {
    private List<Aggregation> aggregationUnits;

    private String participantId;
    private String productionLineId;
    private String productionOrderId;
}
