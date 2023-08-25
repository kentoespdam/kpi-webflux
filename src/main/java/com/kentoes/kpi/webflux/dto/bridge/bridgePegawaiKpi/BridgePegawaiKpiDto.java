package com.kentoes.kpi.webflux.dto.bridge.bridgePegawaiKpi;

import com.kentoes.kpi.webflux.dto.master.mKpi.MKpiDto;
import com.kentoes.kpi.webflux.dto.master.mLevel.MLevelDto;
import com.kentoes.kpi.webflux.entities.bridge.BridgePegawaiKpi;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Data
public class BridgePegawaiKpiDto implements Serializable {
    private Integer id;
    private String nipam;
    private String name;
    private Integer organizationId;
    private Integer positionId;
    private MLevelDto level;
    private MKpiDto kpi;
    @Enumerated(EnumType.STRING)
    private EStatus status;

    public static BridgePegawaiKpiDto fromEntity(BridgePegawaiKpi entity) {
        return new BridgePegawaiKpiDto(
                entity.getId(),
                entity.getNipam(),
                entity.getName(),
                entity.getOrgId(),
                entity.getPosId(),
                MLevelDto.fromEntity(entity.getLevel()),
                MKpiDto.fromEntity(entity.getKpi()),
                entity.getStatus()
        );
    }

    public static List<BridgePegawaiKpiDto> from(List<BridgePegawaiKpi> entities) {
        return entities.stream().map(BridgePegawaiKpiDto::fromEntity).toList();
    }
}