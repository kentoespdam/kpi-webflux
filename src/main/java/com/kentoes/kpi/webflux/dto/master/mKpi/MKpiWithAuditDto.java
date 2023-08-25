package com.kentoes.kpi.webflux.dto.master.mKpi;

import com.kentoes.kpi.webflux.dto.commons.AuditDto;
import com.kentoes.kpi.webflux.dto.master.mGrade.MGradeDto;
import com.kentoes.kpi.webflux.dto.master.mProfesi.MProfesiDto;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.master.MKpi;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MKpiWithAuditDto extends AuditDto {
    private Integer id;
    private Integer organizationId;
    private Integer positionId;
    private MProfesiDto profesi;
    private String name;
    private MGradeDto grade;
    @Enumerated(EnumType.STRING)
    private EStatus status;

    public MKpiWithAuditDto(Integer id, Integer organizationId, Integer positionId, MProfesiDto profesi, String name,
                            MGradeDto grade, EStatus status, LocalDateTime createdAt, String createdBy, LocalDateTime updatedAt,
                            String updatedBy) {
        super(createdAt, createdBy, updatedAt, updatedBy);
        this.id = id;
        this.organizationId = organizationId;
        this.positionId = positionId;
        this.profesi = profesi;
        this.name = name;
        this.grade = grade;
        this.status = status;
    }

    public static MKpiWithAuditDto fromEntity(MKpi entity) {
        return new MKpiWithAuditDto(
                entity.getId(),
                entity.getOrgId(),
                entity.getPosId(),
                MProfesiDto.fromEntity(entity.getProfesi()),
                entity.getName(),
                MGradeDto.fromEntity(entity.getGrade()),
                entity.getStatus(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getUpdatedAt(),
                entity.getUpdatedBy());
    }

}
