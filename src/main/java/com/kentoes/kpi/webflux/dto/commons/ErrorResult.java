package com.kentoes.kpi.webflux.dto.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrorResult implements Serializable {
    private HttpStatus status = HttpStatus.BAD_REQUEST;
    private List<String> errors = new ArrayList<>();

    private void addError(String message) {
        this.errors.add(message);
    }

    public Integer getCode() {
        return status.value();
    }

}