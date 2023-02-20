package com.example.demo_seq.controller.sequence.dto;

import lombok.Data;

@Data
public class SequenceDto {

    private String value;

    public SequenceDto(String value) {
        this.value = value;
    }
}
