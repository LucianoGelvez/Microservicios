package com.dh.catalog.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class Serie {
    private String id;
    private String name;
    private String genre;
    private List<Season> seasons;
}
