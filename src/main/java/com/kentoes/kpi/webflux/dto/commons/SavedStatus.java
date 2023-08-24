package com.kentoes.kpi.webflux.dto.commons;

import com.kentoes.kpi.webflux.entities.enums.ESaveStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.io.Serializable;

public class SavedStatus<T> implements Serializable {
    private T data;
    @Enumerated(EnumType.STRING)
    private ESaveStatus status;

    public SavedStatus() {
    }


    public SavedStatus(T data, ESaveStatus status) {
        this.data = data;
        this.status = status;
    }

    public T getData() {
        return data;
    }


    public ESaveStatus getStatus() {
        return status;
    }

    public void setStatus(ESaveStatus status) {
        this.status = status;
    }

    public static <T> SavedStatus<T> build(ESaveStatus status, T data) {
        return new SavedStatus<>(data, status);
    }

}