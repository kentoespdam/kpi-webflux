package com.kentoes.kpi.webflux.dto.master.mIndikator;

import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.master.MIndikator;
import com.kentoes.kpi.webflux.entities.master.MKpi;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MIndikatorPostRequest implements Serializable {
    @NotNull(message = "KPI ID is required")
    @Min(value = 1, message = "KPI ID must be greater than 0")
    private Integer kpiId;
    @NotBlank(message = "Indikator is required")
    private String indikator;
    @NotNull(message = "Urut is required")
    @Min(value = 1, message = "Urut must be greater than 0")
    private Integer urut;
    @Enumerated(EnumType.STRING)
    private EStatus status = EStatus.Enabled;

    public String getIndikator() {
        return Objects.isNull(indikator) ? null : indikator.trim();
    }

    public static MIndikator toEntity(MIndikatorPostRequest request, MKpi kpi, String createdBy) {
        MIndikator entity = new MIndikator();
        entity.setKpi(kpi);
        entity.setIndikator(request.getIndikator());
        entity.setUrut(request.getUrut());
        entity.setStatus(request.getStatus());
        entity.setCreatedBy(createdBy);
        return entity;
    }
}
