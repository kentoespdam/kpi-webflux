package com.kentoes.kpi.webflux.dto.bridge.bridgeLevelPerilaku;

import com.kentoes.kpi.webflux.dto.commons.AuditDto;
import com.kentoes.kpi.webflux.dto.master.mLevel.MLevelDto;
import com.kentoes.kpi.webflux.dto.master.mPerilaku.MPerilakuDto;
import com.kentoes.kpi.webflux.entities.bridge.BridgeLevelPerilaku;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

@Getter
@Setter
public class BridgeLevelPerilakuWithAuditDto extends AuditDto {
    private Integer id;
    private MPerilakuDto perilaku;
    private MLevelDto level;
    @Enumerated(EnumType.STRING)
    private EStatus status;

    public BridgeLevelPerilakuWithAuditDto(
            Integer id, MPerilakuDto perilaku, MLevelDto level, EStatus status,
            LocalDateTime createdAt, String createdBy, LocalDateTime updatedAt, String updatedBy
    ) {
        this.id = id;
        this.perilaku = perilaku;
        this.level = level;
        this.status = status;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
    }

    public static BridgeLevelPerilakuWithAuditDto fromEntity(BridgeLevelPerilaku entity) {
        return new BridgeLevelPerilakuWithAuditDto(
                entity.getId(),
                MPerilakuDto.fromEntity(entity.getPerilaku()),
                MLevelDto.fromEntity(entity.getLevel()),
                entity.getStatus(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getUpdatedAt(),
                entity.getUpdatedBy()
        );
    }

    public static Page<BridgeLevelPerilakuWithAuditDto> from(Page<BridgeLevelPerilaku> allPage) {
        return allPage.map(BridgeLevelPerilakuWithAuditDto::fromEntity);
    }
}