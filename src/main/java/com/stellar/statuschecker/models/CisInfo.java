package com.stellar.statuschecker.models;

import lombok.Data;

@Data
public class CisInfo {
    private String requestedCis;
    private String cis;
    private  String gtin;
    private String productName;
    private String productGroupId;
    private String productGroup;
    private String brand;
    private String producedDate;
    private String packageType;
    private String ownerInn;
    private String ownerName;
    private String status;
    private String parent;
    private String producerInn;
    private String producerName;
}
