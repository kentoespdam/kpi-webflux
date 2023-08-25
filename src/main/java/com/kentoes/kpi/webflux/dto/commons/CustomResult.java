package com.kentoes.kpi.webflux.dto.commons;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.kentoes.kpi.webflux.entities.enums.ESaveStatus;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.domain.Page;
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

    private static <T> CustomResult<T> buildOk(T data) {
        return new CustomResult<>(data, OK_STATUS, OK_MESSAGE);
    }

    private static CustomResult<String> buildNoContent() {
        return new CustomResult<>(NO_CONTENT_STATUS);
    }

    public static <T> Mono<CustomResult<?>> build(List<T> all) {
        return Mono.just(all.isEmpty() ?
                CustomResult.buildNoContent() :
                CustomResult.buildOk(all));
    }

    public static <T> Mono<CustomResult<?>> build(Page<T> page) {
        return Mono.just(page.isEmpty() ?
                CustomResult.buildNoContent() :
                CustomResult.buildOk(page));
    }

    public static <T> Mono<CustomResult<?>> build(T data) {
        return Mono.just(data == null ?
                CustomResult.buildNoContent() :
                CustomResult.buildOk(data));
    }

    public static <T> Mono<CustomResult<?>> buildSave(SavedStatus<T> data) {
        return Mono.just(
                switch (data.getStatus()) {
                    case FAILED -> new CustomResult<>(BAD_REQUEST_STATUS, data.getData().toString());
                    case DUPLICATE -> new CustomResult<>(CONFLICT_STATUS, data.getData().toString());
                    default -> new CustomResult<>(data.getData(), SAVE_STATUS, SAVE_MESSAGE);
                });
    }

    public static <T> Mono<CustomResult<?>> buildUpdate(SavedStatus<T> data) {
        return Mono.just(
                data.getStatus() == ESaveStatus.FAILED ?
                        new CustomResult<>(BAD_REQUEST_STATUS, data.getData().toString()) :
                        new CustomResult<>(data.getData(), UPDATE_STATUS, UPDATE_MESSAGE)
        );
    }

    public static Mono<CustomResult<?>> buildDelete(Boolean deleted) {
        return Mono.just(
                deleted ?
                        new CustomResult<>(DELETE_STATUS, DELETE_MESSAGE) :
                        new CustomResult<>(BAD_REQUEST_STATUS, NOT_DELETED_MESSAGE)
        );
    }

    public static Mono<CustomResult<?>> buildDelete(SavedStatus<?> data) {
        return Mono.just(
                data.getStatus() == ESaveStatus.FAILED ?
                        new CustomResult<>(INTERNAL_SERVER_ERROR_STATUS, data.getData().toString()) :
                        new CustomResult<>(DELETE_STATUS, DELETE_MESSAGE)
        );
    }

}
