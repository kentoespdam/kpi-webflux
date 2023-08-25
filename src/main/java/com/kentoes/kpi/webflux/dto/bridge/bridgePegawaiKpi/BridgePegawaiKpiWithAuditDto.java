package com.kentoes.kpi.webflux.dto.bridge.bridgePegawaiKpi;

import com.kentoes.kpi.webflux.dto.commons.AuditDto;
import com.kentoes.kpi.webflux.dto.master.mKpi.MKpiDto;
import com.kentoes.kpi.webflux.dto.master.mLevel.MLevelDto;
import com.kentoes.kpi.webflux.entities.bridge.BridgePegawaiKpi;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class BridgePegawaiKpiWithAuditDto extends AuditDto {
    private Integer id;
    private String nipam;
    private String name;
    private Integer organizationId;
    private Integer positionId;
    private MLevelDto level;
    private MKpiDto kpi;
    @Enumerated(EnumType.STRING)
    private EStatus status;

    public BridgePegawaiKpiWithAuditDto(
            Integer id, String nipam, String name, Integer organizationId, Integer positionId,
            MLevelDto level, MKpiDto kpi, EStatus status, LocalDateTime createdAt,
            String createdBy, LocalDateTime updatedAt, String updatedBy
    ) {
        this.id = id;
        this.nipam = nipam;
        this.name = name;
        this.organizationId = organizationId;
        this.positionId = positionId;
        this.level = level;
        this.kpi = kpi;
        this.status = status;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
    }

    public static BridgePegawaiKpiWithAuditDto fromEntity(BridgePegawaiKpi entity) {
        return new BridgePegawaiKpiWithAuditDto(
                entity.getId(),
                entity.getNipam(),
                entity.getName(),
                entity.getOrgId(),
                entity.getPosId(),
                MLevelDto.fromEntity(entity.getLevel()),
                MKpiDto.fromEntity(entity.getKpi()),
                entity.getStatus(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getUpdatedAt(),
                entity.getUpdatedBy());
    }

    public static Page<BridgePegawaiKpiWithAuditDto> from(Page<BridgePegawaiKpi> all) {
        return all.map(BridgePegawaiKpiWithAuditDto::fromEntity);
    }
}