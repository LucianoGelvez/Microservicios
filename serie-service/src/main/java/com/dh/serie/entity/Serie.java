package com.dh.serie.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "series")
public class Serie {
    @Id
    private String id;
    private String name;
    private String genre;
    private List<Season> seasons;
}
