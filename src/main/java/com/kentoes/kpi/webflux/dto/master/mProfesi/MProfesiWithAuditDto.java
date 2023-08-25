package com.kentoes.kpi.webflux.dto.master.mProfesi;

import com.kentoes.kpi.webflux.dto.commons.AuditDto;
import com.kentoes.kpi.webflux.dto.master.mLevel.MLevelDto;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.master.MProfesi;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MProfesiWithAuditDto extends AuditDto {
    private Integer id;
    private MLevelDto level;
    private String name;
    @Enumerated(EnumType.STRING)
    private EStatus status;

    public MProfesiWithAuditDto(Integer id, MLevelDto level, String name, EStatus status, LocalDateTime createdAt,
                                String createdBy, LocalDateTime updatedAt, String updatedBy) {
        super(createdAt, createdBy, updatedAt, updatedBy);
        this.id = id;
        this.level = level;
        this.name = name;
        this.status = status;
    }

    public static MProfesiWithAuditDto fromEntity(MProfesi entity) {
        return new MProfesiWithAuditDto(
                entity.getId(),
                MLevelDto.fromEntity(entity.getLevel()),
                entity.getName(),
                entity.getStatus(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getUpdatedAt(),
                entity.getUpdatedBy());
    }
}
