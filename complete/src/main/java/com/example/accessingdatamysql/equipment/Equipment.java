package com.example.accessingdatamysql.equipment;

import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.NoArgsConstructor
@lombok.Data
public class Equipment {

    @JsonProperty("name")
    private String name;
    @JsonProperty("connectPintType")
    private String connectPintType;
    @JsonProperty("weldingTongType")
    private String weldingTongType;
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("type")
    private String type;
    @JsonProperty("img")
    private String img;
    @JsonProperty("model")
    private String model;
    @JsonProperty("A")
    private Integer a;
    @JsonProperty("B")
    private Integer b;
    @JsonProperty("C")
    private Integer c;
    @JsonProperty("D")
    private Integer d;
    @JsonProperty("E")
    private String e;
    @JsonProperty("listingDate")
    private String listingDate;
    @JsonProperty("stopProduction")
    private Boolean stopProduction;
}
