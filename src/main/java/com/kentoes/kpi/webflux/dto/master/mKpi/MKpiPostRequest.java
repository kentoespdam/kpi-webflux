package com.kentoes.kpi.webflux.dto.master.mKpi;


import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.master.MGrade;
import com.kentoes.kpi.webflux.entities.master.MKpi;
import com.kentoes.kpi.webflux.entities.master.MProfesi;
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
public class MKpiPostRequest implements Serializable {
    @NotNull(message = "organizationId is required")
    @Min(value = 1, message = "organizationId must be greater than 0")
    protected Integer organizationId;
    @NotNull(message = "positionId is required")
    @Min(value = 1, message = "positionId must be greater than 0")
    protected Integer positionId;
    @NotNull(message = "profesiId is required")
    @Min(value = 1, message = "profesiId must be greater than 0")
    protected Integer profesiId;
    @NotBlank(message = "name is required")
    protected String name;
    @NotNull(message = "gradeId is required")
    @Min(value = 1, message = "gradeId must be greater than 0")
    protected Integer gradeId;
    @Enumerated(EnumType.STRING)
    protected EStatus status = EStatus.Enabled;

    public String getName() {
        return Objects.nonNull(name) ? name.trim() : null;
    }

    public static MKpi toEntity(MKpiPostRequest request, MProfesi profesi, MGrade grade, String createdBy) {
        MKpi entity = new MKpi();
        entity.setOrgId(request.getOrganizationId());
        entity.setPosId(request.getPositionId());
        entity.setProfesi(profesi);
        entity.setName(request.getName());
        entity.setGrade(grade);
        entity.setStatus(request.getStatus());
        entity.setCreatedBy(createdBy);
        return entity;
    }
}
