package com.kentoes.kpi.webflux.dto.trans.transKpi;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransactionKpiPostRequest implements Serializable {
    @NotBlank(message = "NIPAM cannot be blank")
    private String nipam;
    @NotNull(message = "Periode cannot be null")
    @Min(value = 1, message = "Periode must be greater than 0")
    private Integer periode;
    @NotNull(message = "KpiId cannot be null")
    @Min(value = 1, message = "KpiId must be greater than 0")
    private Integer kpiId;
}
