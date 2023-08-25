package com.kentoes.kpi.webflux.dto.master.mUraianIndikator;

import com.kentoes.kpi.webflux.dto.commons.AuditDto;
import com.kentoes.kpi.webflux.dto.master.mIndikator.MIndikatorDto;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.enums.ETarget;
import com.kentoes.kpi.webflux.entities.master.MUraianIndikator;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class MUraianIndikatorWithAuditDto extends AuditDto {
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

    public MUraianIndikatorWithAuditDto(Integer id, MIndikatorDto indikator, String uraian, Float volume, String satuan, ETarget target, String waktu, Float bobot, EStatus status, LocalDateTime createdAt, String createdBy, LocalDateTime updatedAt, String updatedBy) {
        super(createdAt, createdBy, updatedAt, updatedBy);
        this.id = id;
        this.indikator = indikator;
        this.uraian = uraian;
        this.volume = volume;
        this.satuan = satuan;
        this.target = target;
        this.waktu = waktu;
        this.bobot = bobot;
        this.status = status;
    }

    public static MUraianIndikatorWithAuditDto fromEntity(MUraianIndikator entity) {
        return new MUraianIndikatorWithAuditDto(
                entity.getId(),
                MIndikatorDto.fromEntity(entity.getIndikator()),
                entity.getUraian(),
                entity.getVolume(),
                entity.getSatuan(),
                entity.getTarget(),
                entity.getWaktu(),
                entity.getBobot(),
                entity.getStatus(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getUpdatedAt(),
                entity.getUpdatedBy());
    }

    public static List<MUraianIndikatorWithAuditDto> from(List<MUraianIndikator> list) {
        return list.stream().map(MUraianIndikatorWithAuditDto::fromEntity).toList();
    }
}