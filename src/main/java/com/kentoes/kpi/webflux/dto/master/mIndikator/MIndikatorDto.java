package com.kentoes.kpi.webflux.dto.master.mIndikator;

import com.kentoes.kpi.webflux.dto.master.mKpi.MKpiDto;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.master.MIndikator;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Data
public class MIndikatorDto implements Serializable {
    private Integer id;
    private MKpiDto kpi;
    private String indikator;
    private Integer urut;
    @Enumerated(EnumType.STRING)
    private EStatus status;

    public static MIndikatorDto fromEntity(MIndikator entity) {
        return new MIndikatorDto(
                entity.getId(),
                MKpiDto.fromEntity(entity.getKpi()),
                entity.getIndikator(),
                entity.getUrut(),
                entity.getStatus()
        );
    }

    public static List<MIndikatorDto> from(List<MIndikator> entities) {
        return entities.stream().map(MIndikatorDto::fromEntity).toList();
    }
}
