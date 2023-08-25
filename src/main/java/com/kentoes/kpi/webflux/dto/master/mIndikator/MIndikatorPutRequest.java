package com.kentoes.kpi.webflux.dto.master.mIndikator;

import com.kentoes.kpi.webflux.entities.master.MIndikator;
import com.kentoes.kpi.webflux.entities.master.MKpi;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MIndikatorPutRequest extends MIndikatorPostRequest {
    @NotNull(message = "ID is required")
    @Min(value = 1, message = "ID must be greater than 0")
    private Integer id;

    public static MIndikator toEntity(MIndikatorPutRequest request, MKpi kpi, String updatedBy) {
        MIndikator entity = new MIndikator();
        entity.setId(request.getId());
        entity.setKpi(kpi);
        entity.setIndikator(request.getIndikator());
        entity.setUrut(request.getUrut());
        entity.setStatus(request.getStatus());
        entity.setUpdatedBy(updatedBy);
        return entity;
    }
}