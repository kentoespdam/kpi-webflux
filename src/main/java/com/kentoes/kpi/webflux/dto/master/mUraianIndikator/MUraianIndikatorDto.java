package com.kentoes.kpi.webflux.dto.master.mUraianIndikator;

import com.kentoes.kpi.webflux.dto.master.mIndikator.MIndikatorDto;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.enums.ETarget;
import com.kentoes.kpi.webflux.entities.master.MUraianIndikator;
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
public class MUraianIndikatorDto implements Serializable {
    private Integer id;
    private MIndikatorDto indikator;
    private String uraian;
    private Float volume;
    private String satuan;
    @Enumerated(EnumType.STRING)
    private ETarget target;
    private String waktu;
    private Float bobot;
    @Enumerated(EnumType.STRING)
    private EStatus status;

    public static MUraianIndikatorDto fromEntity(MUraianIndikator entity) {
        return new MUraianIndikatorDto(
                entity.getId(),
                MIndikatorDto.fromEntity(entity.getIndikator()),
                entity.getUraian(),
                entity.getVolume(),
                entity.getSatuan(),
                entity.getTarget(),
                entity.getWaktu(),
                entity.getBobot(),
                entity.getStatus()
        );
    }

    public static List<MUraianIndikatorDto> from(List<MUraianIndikator> entities) {
        return entities.stream().map(MUraianIndikatorDto::fromEntity).toList();
    }
}
