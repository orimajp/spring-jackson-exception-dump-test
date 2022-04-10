package com.example.springjacksonexceptiondumptest;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class TestRequest {

    @NotNull
    private Integer num;

}
