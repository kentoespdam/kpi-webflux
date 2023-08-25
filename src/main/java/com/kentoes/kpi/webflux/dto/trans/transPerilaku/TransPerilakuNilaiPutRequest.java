package com.kentoes.kpi.webflux.dto.trans.transPerilaku;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Data
public class TransPerilakuNilaiPutRequest implements Serializable {
    @NotNull(message = "ID is required")
    @Min(value = 1, message = "ID must be greater than 0")
    private Integer id;
    @NotNull(message = "Nilai is required")
    private Float nilai;

    @Override
    public String toString() {
        return "TransPerilakuNilaiPutRequest{" +
                "id=" + id +
                ", nilai=" + nilai +
                '}';
    }
}
