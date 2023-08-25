package com.kentoes.kpi.webflux.dto.trans.transKpi;

import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.trans.TransKpi;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
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
public class TransactionKpiPutRequest implements Serializable {
    @NotNull(message = "Id is required")
    @Min(value = 1, message = "Id must be greater than 0")
    private Integer id;
    private Float nilaiTotal;
    @Enumerated(EnumType.STRING)
    private EStatus status;

    public static TransKpi toEntity(
            TransKpi entity, TransactionKpiPutRequest request, String updatedBy
    ) {
        entity.setNilaiTotal(request.getNilaiTotal());
        entity.setStatus(request.getStatus());
        entity.setUpdatedBy(updatedBy);
        return entity;
    }
}
