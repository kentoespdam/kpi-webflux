package com.kentoes.kpi.webflux.dto.master.mLevel;

import com.kentoes.kpi.webflux.dto.commons.AuditDto;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.master.MLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class MLevelWithAuditDto extends AuditDto {
    private Integer id;
    private String level;
    private EStatus status;

    public MLevelWithAuditDto(Integer id, String level, EStatus status, LocalDateTime createdAt, String createdBy,
                              LocalDateTime updatedAt, String updatedBy) {
        super(createdAt, createdBy, updatedAt, updatedBy);
        this.id = id;
        this.level = level;
        this.status = status;
    }

    public static MLevelWithAuditDto fromEntity(MLevel mLevel) {
        return new MLevelWithAuditDto(
                mLevel.getId(),
                mLevel.getLevel(),
                mLevel.getStatus(),
                mLevel.getCreatedAt(),
                mLevel.getCreatedBy(),
                mLevel.getUpdatedAt(),
                mLevel.getUpdatedBy());
    }

    private static List<MLevelWithAuditDto> from(List<MLevel> content) {
        return content.stream().map(MLevelWithAuditDto::fromEntity).toList();
    }
}
