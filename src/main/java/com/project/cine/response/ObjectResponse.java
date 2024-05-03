package com.project.cine.response;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ObjectResponse {

    private int code;

    private String message;

    private Object data;

    public ObjectResponse() {
    }

    public ObjectResponse(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public ObjectResponse(int code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }
}
