package com.dh.serie.entity;

import lombok.Data;

import java.util.List;

@Data
public class Season {
    private Integer seasonNumber;
    private List<Chapter> chapters;
}