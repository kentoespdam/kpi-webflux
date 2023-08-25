package com.kentoes.kpi.webflux.dto.trans.transPerilaku;

import com.kentoes.kpi.webflux.entities.trans.TransPerilaku;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransPerilakuDto implements Serializable {
    private Integer id;
    private String nipam;
    private Integer organizationId;
    private Integer positionId;
    private Integer periode;
    private Float totalNilai;
    private List<TransPerilakuNilaiDto> perilakuList;

    public Float getTotalNilai() {
        int size = this.perilakuList.size();
        return this.perilakuList.stream().map(TransPerilakuNilaiDto::getNilai).reduce(0f, Float::sum) / size;
    }

    public static TransPerilakuDto fromEntity(TransPerilaku entity) {
        TransPerilakuDto dto = new TransPerilakuDto();
        dto.setId(entity.getId());
        dto.setNipam(entity.getNipam());
        dto.setOrganizationId(entity.getOrgId());
        dto.setPositionId(entity.getPosId());
        dto.setPeriode(entity.getPeriode());
        dto.setPerilakuList(TransPerilakuNilaiDto.from(entity.getTransPerilakuNilaiList()));
        return dto;
    }
}