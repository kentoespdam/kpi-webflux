package com.kentoes.kpi.webflux.dto.trans.transKpiIndikator;

import com.kentoes.kpi.webflux.dto.trans.transKpiUraian.TransKpiUraianDto;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.trans.TransKpiIndikator;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransKpiIndikatorDto implements Serializable {
    private Integer id;
    private String indikator;
    private Integer urut;
    private List<TransKpiUraianDto> uraianList;
    @Enumerated(EnumType.STRING)
    private EStatus status;

    public static TransKpiIndikatorDto fromEntity(TransKpiIndikator entity) {
        TransKpiIndikatorDto dto = new TransKpiIndikatorDto();
        dto.setId(entity.getId());
        dto.setIndikator(entity.getIndikator());
        dto.setUrut(entity.getUrut());
        dto.setUraianList(TransKpiUraianDto.from(entity.getTransKpiUraianList()));
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public static List<TransKpiIndikatorDto> from(List<TransKpiIndikator> entities) {
        if (entities == null) return new ArrayList<>();
        return entities.stream().map(TransKpiIndikatorDto::fromEntity).toList();
    }
}
