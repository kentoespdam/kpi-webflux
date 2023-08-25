package com.kentoes.kpi.webflux.dto.trans.transKpi;

import com.kentoes.kpi.webflux.dto.master.mProfesi.MProfesiDto;
import com.kentoes.kpi.webflux.dto.trans.transKpiIndikator.TransKpiIndikatorDto;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.trans.TransKpi;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransactionKpiDto implements Serializable {
    private Integer id;
    private String nipam;
    private Integer organizationId;
    private Integer positionId;
    private MProfesiDto profesi;
    private Integer periode;
    private String name;
    private Float nilaiTotal;
    private List<TransKpiIndikatorDto> indikatorList;
    @Enumerated(EnumType.STRING)
    private EStatus status;

    public static TransactionKpiDto fromEntity(TransKpi entity) {
        TransactionKpiDto dto = new TransactionKpiDto();
        dto.setId(entity.getId());
        dto.setNipam(entity.getNipam());
        dto.setOrganizationId(entity.getOrgId());
        dto.setPositionId(entity.getPosId());
        dto.setProfesi(MProfesiDto.fromEntity(entity.getProfesi()));
        dto.setPeriode(entity.getPeriode());
        dto.setName(entity.getName());
        dto.setNilaiTotal(entity.getNilaiTotal());
        dto.setIndikatorList(TransKpiIndikatorDto.from(entity.getIndikatorList()));
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public static List<TransactionKpiDto> from(List<TransKpi> entities) {
        return entities.stream().map(TransactionKpiDto::fromEntity).toList();
    }

    public static Page<TransactionKpiDto> from(Page<TransKpi> entities) {
        return entities.map(TransactionKpiDto::fromEntity);
    }
}
