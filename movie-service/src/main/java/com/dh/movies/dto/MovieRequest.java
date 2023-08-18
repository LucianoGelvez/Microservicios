package com.dh.movies.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MovieRequest {
    private String name;
    private String genre;
    private String urlStream;
}
