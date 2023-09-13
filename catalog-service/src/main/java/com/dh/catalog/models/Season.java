package com.dh.catalog.models;

import lombok.Data;

import java.util.List;

@Data
public class Season {
    private Integer seasonNumber;
    private List<Chapter> chapters;
}

