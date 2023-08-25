package com.kentoes.kpi.webflux.dto.master.mUraianIndikator;

import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.enums.ETarget;
import com.kentoes.kpi.webflux.entities.master.MIndikator;
import com.kentoes.kpi.webflux.entities.master.MUraianIndikator;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MUraianIndikatorPostRequest implements Serializable {
    @NotNull(message = "Indikator ID is required")
    @Min(value = 1, message = "Indikator ID must be greater than 0")
    protected Integer indikatorId;
    @NotBlank(message = "Uraian is required")
    protected String uraian;
    @NotNull(message = "Volume is required")
    protected Float volume;
    @NotBlank(message = "Satuan is required")
    protected String satuan;
    @Enumerated(EnumType.STRING)
    protected ETarget target = ETarget.MIN;
    @NotBlank(message = "Waktu is required")
    protected String waktu;
    @NotNull(message = "Bobot is required")
    protected Float bobot;
    @Enumerated(EnumType.STRING)
    protected EStatus status = EStatus.Enabled;

    public String getUraian() {
        return Objects.isNull(uraian) ? null : uraian.trim();
    }

    public String getSatuan() {
        return Objects.isNull(satuan) ? null : satuan.trim();
    }

    public String getWaktu() {
        return Objects.isNull(waktu) ? null : waktu.trim();
    }


    public static MUraianIndikator toEntity(MUraianIndikatorPostRequest request, MIndikator mIndikator, String createdBy) {
        MUraianIndikator entity = new MUraianIndikator();
        entity.setIndikator(mIndikator);
        entity.setUraian(request.getUraian());
        entity.setVolume(request.getVolume());
        entity.setSatuan(request.getSatuan());
        entity.setTarget(request.getTarget());
        entity.setWaktu(request.getWaktu());
        entity.setBobot(request.getBobot());
        entity.setStatus(request.getStatus());
        entity.setCreatedBy(createdBy);
        return entity;
    }
}
