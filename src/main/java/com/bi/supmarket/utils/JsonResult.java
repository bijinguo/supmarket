package com.bi.supmarket.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class JsonResult<T> {
    @JsonInclude(value= JsonInclude.Include.ALWAYS)
    private Integer state;
@JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String message;
@JsonInclude(value= JsonInclude.Include.ALWAYS)
    private T data;

    public JsonResult() {
    }

    public JsonResult(String message) {
        this.message = message;
    }

    public JsonResult(Integer state) {
        this.state = state;
    }

    public JsonResult(Integer state, String message) {
        this.state = state;
        this.message = message;
    }

    public JsonResult(Integer state, T data) {
        this.state = state;
        this.data = data;
    }



}
