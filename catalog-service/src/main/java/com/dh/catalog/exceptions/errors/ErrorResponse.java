package com.dh.catalog.exceptions.errors;

public record ErrorResponse(int status, String code, String message){
}
