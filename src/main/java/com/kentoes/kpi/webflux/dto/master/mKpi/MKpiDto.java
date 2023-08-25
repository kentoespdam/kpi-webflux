package com.kentoes.kpi.webflux.dto.master.mKpi;

import com.kentoes.kpi.webflux.dto.master.mGrade.MGradeDto;
import com.kentoes.kpi.webflux.dto.master.mProfesi.MProfesiDto;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.master.MKpi;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MKpiDto implements Serializable {
    private Integer id;
    private Integer organizationId;
    private Integer positionId;
    private MProfesiDto profesi;
    private String name;
    private MGradeDto grade;
    @Enumerated(EnumType.STRING)
    private EStatus status;

    public static MKpiDto fromEntity(MKpi entity) {
        return new MKpiDto(
                entity.getId(),
                entity.getOrgId(),
                entity.getPosId(),
                MProfesiDto.fromEntity(entity.getProfesi()),
                entity.getName(),
                MGradeDto.fromEntity(entity.getGrade()),
                entity.getStatus()
        );
    }

    public static List<MKpiDto> from(List<MKpi> all) {
        return all.stream().map(MKpiDto::fromEntity).toList();
    }
}
