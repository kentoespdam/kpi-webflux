package com.kentoes.kpi.webflux.dto.bridge.bridgePegawaiKpi;

import com.kentoes.kpi.webflux.entities.bridge.BridgePegawaiKpi;
import com.kentoes.kpi.webflux.entities.master.MKpi;
import com.kentoes.kpi.webflux.entities.master.MLevel;
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
public class BridgePegawaiKpiPutRequest extends BridgePegawaiKpiPostRequest {
    @NotNull(message = "id is required")
    @Min(value = 1, message = "id must be greater than 0")
    private Integer id;

    public static BridgePegawaiKpi toEntity(BridgePegawaiKpiPutRequest request, MLevel level, MKpi kpi, String updatedBy) {
        BridgePegawaiKpi entity = new BridgePegawaiKpi();
        entity.setId(request.getId());
        entity.setNipam(request.getNipam());
        entity.setName(request.getName());
        entity.setPosId(request.getPositionId());
        entity.setOrgId(request.getOrganizationId());
        entity.setLevel(level);
        entity.setKpi(kpi);
        entity.setStatus(request.getStatus());
        entity.setUpdatedBy(updatedBy);
        return entity;
    }

    public static BridgePegawaiKpi toEntity(
            BridgePegawaiKpi entity, BridgePegawaiKpiPutRequest request,
            MLevel mLevel, MKpi mKpi, String updatedBy
    ) {
        entity.setNipam(request.getNipam());
        entity.setName(request.getName());
        entity.setPosId(request.getPositionId());
        entity.setOrgId(request.getOrganizationId());
        entity.setLevel(mLevel);
        entity.setKpi(mKpi);
        entity.setStatus(request.getStatus());
        entity.setUpdatedBy(updatedBy);
        return entity;
    }
}