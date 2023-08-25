package com.kentoes.kpi.webflux.dto.master.mPerilaku;

import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.master.MPerilaku;
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
public class MPerilakuDto implements Serializable {
    private Integer id;
    private Integer urut;
    private String kompetensi;
    private String uraian;
    @Enumerated(EnumType.STRING)
    private EStatus status;

    public static MPerilakuDto fromEntity(MPerilaku entity) {
        return new MPerilakuDto(
                entity.getId(),
                entity.getUrut(),
                entity.getKompetensi(),
                entity.getUraian(),
                entity.getStatus()
        );
    }

    public static List<MPerilakuDto> from(List<MPerilaku> entities) {
        return entities.stream().map(MPerilakuDto::fromEntity).toList();
    }
}
