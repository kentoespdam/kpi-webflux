package com.kentoes.kpi.webflux.dto.master.mIndikator;

import com.kentoes.kpi.webflux.dto.commons.AuditDto;
import com.kentoes.kpi.webflux.dto.master.mKpi.MKpiDto;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.master.MIndikator;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class MIndikatorWithAuditDto extends AuditDto {
    private Integer id;
    private MKpiDto kpi;
    private String indikator;
    private Integer urut;
    @Enumerated(EnumType.STRING)
    private EStatus status;

    public MIndikatorWithAuditDto(Integer id, MKpiDto kpi, String indikator, Integer urut, EStatus status,
                                  LocalDateTime createdAt, String createdBy, LocalDateTime updatedAt, String updatedBy) {
        super(createdAt, createdBy, updatedAt, updatedBy);
        this.id = id;
        this.kpi = kpi;
        this.indikator = indikator;
        this.urut = urut;
        this.status = status;
    }

    public static MIndikatorWithAuditDto fromEntity(MIndikator entity) {
        return new MIndikatorWithAuditDto(
                entity.getId(),
                MKpiDto.fromEntity(entity.getKpi()),
                entity.getIndikator(),
                entity.getUrut(),
                entity.getStatus(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getUpdatedAt(),
                entity.getUpdatedBy());
    }

    public static List<MIndikatorWithAuditDto> from(List<MIndikator> list) {
        return list.stream().map(MIndikatorWithAuditDto::fromEntity).toList();
    }
}