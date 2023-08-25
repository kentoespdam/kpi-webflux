package com.kentoes.kpi.webflux.dto.master.mKpi;

import com.kentoes.kpi.webflux.entities.master.MGrade;
import com.kentoes.kpi.webflux.entities.master.MKpi;
import com.kentoes.kpi.webflux.entities.master.MProfesi;
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
public class MKpiPutRequest extends MKpiPostRequest {
    @NotNull(message = "id is required")
    @Min(value = 1, message = "id must be greater than 0")
    private Integer id;

    public static MKpi toEntity(MKpiPutRequest request, MProfesi profesi, MGrade grade, String updatedBy) {
        MKpi entity = new MKpi();
        entity.setId(request.getId());
        entity.setOrgId(request.getOrganizationId());
        entity.setPosId(request.getPositionId());
        entity.setProfesi(profesi);
        entity.setName(request.getName());
        entity.setGrade(grade);
        entity.setStatus(request.getStatus());
        entity.setUpdatedBy(updatedBy);
        return entity;
    }
}
