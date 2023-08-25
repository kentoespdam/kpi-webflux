package com.kentoes.kpi.webflux.dto.trans.transPerilaku;

import com.kentoes.kpi.webflux.entities.trans.TransPerilakuNilai;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransPerilakuNilaiDto implements Serializable {
    private Integer id;
    private Integer urut;
    private String kompetensi;
    private String uraian;
    private Float nilai;

    public static TransPerilakuNilaiDto fromEntity(TransPerilakuNilai entity) {
        TransPerilakuNilaiDto dto = new TransPerilakuNilaiDto();
        dto.setId(entity.getId());
        dto.setUrut(entity.getUrut());
        dto.setKompetensi(entity.getKompetensi());
        dto.setUraian(entity.getUraian());
        dto.setNilai(entity.getNilai());
        return dto;
    }

    public static List<TransPerilakuNilaiDto> from(List<TransPerilakuNilai> entities) {
        return entities.stream().map(TransPerilakuNilaiDto::fromEntity).toList();
    }
}
