package com.kentoes.kpi.webflux.dto.trans.transKpiUraian;

import com.kentoes.kpi.webflux.dto.trans.transKpiUraianFile.TransKpiUraianFileDto;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.enums.ETarget;
import com.kentoes.kpi.webflux.entities.trans.TransKpiUraian;
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
public class TransKpiUraianDto implements Serializable {
    private Integer id;
    private String uraian;
    private Float volume;
    private String satuan;
    private String waktu;
    @Enumerated(EnumType.STRING)
    private ETarget target;
    private Float capaianVolume;
    private String capaianSatuan;
    private String capaianWaktu;
    private Float nilaiProdukKerja;
    private Float nilaiWaktu;
    private Float nilaiTotalUraian;
    private Float bobot;
    private List<TransKpiUraianFileDto> fileList;
    @Enumerated(EnumType.STRING)
    private EStatus status;

    public static TransKpiUraianDto fromEntity(TransKpiUraian entity) {
        TransKpiUraianDto dto = new TransKpiUraianDto();
        dto.setId(entity.getId());
        dto.setUraian(entity.getUraian());
        dto.setVolume(entity.getVolume());
        dto.setSatuan(entity.getSatuan());
        dto.setWaktu(entity.getWaktu());
        dto.setTarget(entity.getTarget());
        dto.setCapaianVolume(entity.getCapaianVolume());
        dto.setCapaianSatuan(entity.getCapaianSatuan());
        dto.setCapaianWaktu(entity.getCapaianWaktu());
        dto.setNilaiProdukKerja(entity.getNilaiProdukKerja());
        dto.setNilaiWaktu(entity.getNilaiWaktu());
        dto.setNilaiTotalUraian(entity.getNilaiTotalUraian());
        dto.setBobot(entity.getBobot());
        dto.setFileList(TransKpiUraianFileDto.from(entity.getTransKpiUraianFilesList()));
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public static List<TransKpiUraianDto> from(List<TransKpiUraian> entities) {
        if (entities == null) return new ArrayList<>();
        return entities.stream().map(TransKpiUraianDto::fromEntity).toList();
    }
}
