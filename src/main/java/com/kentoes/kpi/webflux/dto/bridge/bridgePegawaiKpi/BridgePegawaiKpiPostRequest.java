package com.kentoes.kpi.webflux.dto.bridge.bridgePegawaiKpi;

import com.kentoes.kpi.webflux.entities.bridge.BridgePegawaiKpi;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.master.MKpi;
import com.kentoes.kpi.webflux.entities.master.MLevel;
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
public class BridgePegawaiKpiPostRequest implements Serializable {
    @NotBlank(message = "NIPAM is required")
    private String nipam;
    @NotBlank(message = "Name is required")
    private String name;
    @NotNull(message = "Position ID is required")
    @Min(value = 1, message = "Position ID must be greater than 0")
    private Integer positionId;
    @NotNull(message = "Organization ID is required")
    @Min(value = 1, message = "Organization ID must be greater than 0")
    private Integer organizationId;
    @NotNull(message = "Level ID is required")
    @Min(value = 1, message = "Level ID must be greater than 0")
    private Integer levelId;
    @NotNull(message = "KPI ID is required")
    @Min(value = 1, message = "KPI ID must be greater than 0")
    private Integer kpiId;
    @Enumerated(EnumType.STRING)
    private EStatus status = EStatus.Enabled;

    public String getNipam() {
        return Objects.isNull(nipam) ? null : nipam.trim();
    }

    public String getName() {
        return Objects.isNull(name) ? null : name.trim();
    }

    public static BridgePegawaiKpi toEntity(
            BridgePegawaiKpiPostRequest request, MLevel level, MKpi kpi, String createdBy
    ) {
        BridgePegawaiKpi entity = new BridgePegawaiKpi();
        entity.setNipam(request.getNipam());
        entity.setName(request.getName());
        entity.setPosId(request.getPositionId());
        entity.setOrgId(request.getOrganizationId());
        entity.setLevel(level);
        entity.setKpi(kpi);
        entity.setStatus(request.getStatus());
        entity.setCreatedBy(createdBy);
        return entity;
    }
}
