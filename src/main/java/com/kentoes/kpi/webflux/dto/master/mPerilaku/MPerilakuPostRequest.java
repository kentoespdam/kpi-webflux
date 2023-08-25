package com.kentoes.kpi.webflux.dto.master.mPerilaku;


import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.master.MPerilaku;
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
public class MPerilakuPostRequest implements Serializable {
    @NotNull(message = "Urut is required")
    @Min(value = 1, message = "Urut must be greater than 0")
    protected Integer urut;
    @NotBlank(message = "Kompetensi is required")
    protected String kompetensi;
    @NotBlank(message = "Uraian is required")
    protected String uraian;
    @Enumerated(EnumType.STRING)
    protected EStatus status = EStatus.Enabled;

    public String getKompetensi() {
        return Objects.isNull(kompetensi) ? null : kompetensi.trim();
    }

    public String getUraian() {
        return Objects.isNull(uraian) ? null : uraian.trim();
    }

    public static MPerilaku toEntity(MPerilakuPostRequest request, String createdBy) {
        MPerilaku entity = new MPerilaku();
        entity.setUrut(request.getUrut());
        entity.setKompetensi(request.getKompetensi());
        entity.setUraian(request.getUraian());
        entity.setStatus(request.getStatus());
        entity.setCreatedBy(createdBy);
        return entity;
    }
}
