package com.kentoes.kpi.webflux.dto.master.mGrade;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.kentoes.kpi.webflux.dto.commons.AuditDto;
import com.kentoes.kpi.webflux.dto.master.mLevel.MLevelDto;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.master.MGrade;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonPropertyOrder({"id", "level", "grade", "tukin", "status", "createdAt", "createdBy", "updatedAt", "updatedBy"})
public class MGradeWithAuditDto extends AuditDto {
    private Integer id;
    private MLevelDto level;
    private Integer grade;
    private Double tukin;
    @Enumerated(EnumType.STRING)
    private EStatus status;

    public MGradeWithAuditDto(Integer id, MLevelDto level, Integer grade, Double tukin, EStatus status, LocalDateTime createdAt, String createdBy, LocalDateTime updatedAt, String updatedBy) {
        super(createdAt, createdBy, updatedAt, updatedBy);
        this.id = id;
        this.level = level;
        this.grade = grade;
        this.tukin = tukin;
        this.status = status;
    }

    public static MGradeWithAuditDto fromEntity(MGrade entity) {
        return new MGradeWithAuditDto(
                entity.getId(),
                MLevelDto.fromEntity(entity.getLevel()),
                entity.getGrade(),
                entity.getTukin(),
                entity.getStatus(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getUpdatedAt(),
                entity.getUpdatedBy()
        );
    }
}