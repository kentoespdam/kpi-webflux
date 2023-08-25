package com.kentoes.kpi.webflux.dto.master.mUraianIndikator;

import com.kentoes.kpi.webflux.entities.master.MIndikator;
import com.kentoes.kpi.webflux.entities.master.MUraianIndikator;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MUraianIndikatorPutRequest extends MUraianIndikatorPostRequest {
    @NotNull(message = "ID is required")
    @Min(value = 1, message = "ID must be greater than 0")
    private Integer id;

    public static MUraianIndikator toEntity(
            MUraianIndikatorPutRequest request,
            MIndikator mIndikator, String updatedBy
    ) {
        MUraianIndikator entity = new MUraianIndikator();
        entity.setId(request.getId());
        entity.setIndikator(mIndikator);
        entity.setUraian(request.getUraian());
        entity.setVolume(request.getVolume());
        entity.setSatuan(request.getSatuan());
        entity.setTarget(request.getTarget());
        entity.setWaktu(request.getWaktu());
        entity.setBobot(request.getBobot());
        entity.setStatus(request.getStatus());
        entity.setUpdatedBy(updatedBy);
        return entity;
    }
}
