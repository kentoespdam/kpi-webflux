package com.kentoes.kpi.webflux.dto.commons;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;

import static com.kentoes.kpi.webflux.dto.commons.IGlobalMessage.*;

@JsonPropertyOrder({"status", "statusText", "timestamp", "message", "data"})
@Data
@ToString
public class CustomResult<T> {
    private HttpStatus statusText;
    private String message;
    private T data;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime timestamp;

    public CustomResult(T data, HttpStatus statusText, String message) {
        this.data = data;
        this.statusText = statusText;
        this.message = message;
    }

    public CustomResult(HttpStatus statusText, String message) {
        this.statusText = statusText;
        this.message = message;
    }

    public CustomResult(HttpStatus statusText) {
        this.statusText = statusText;
    }

    public Integer getStatus() {
        return statusText.value();
    }

    public static CustomResult<?> build(List<?> list) {
        return list.isEmpty() ?
                new CustomResult<>(NO_CONTENT_STATUS) :
                new CustomResult<>(list, OK_STATUS, OK_MESSAGE);
    }
}
