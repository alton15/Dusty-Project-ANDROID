package com.example.dsm2018.dusty;

import lombok.Data;

@Data
public class DustyModel {

    private long dusty;     //미세먼지 농도
    private long humidity;     //습도
    private long temperature;     //온도

}
