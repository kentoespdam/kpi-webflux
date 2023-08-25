package com.kentoes.kpi.webflux.dto.master.mPerilaku;

import com.kentoes.kpi.webflux.entities.master.MPerilaku;
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
public class MPerilakuPutRequest extends MPerilakuPostRequest {
    @NotNull(message = "ID is required")
    @Min(value = 1, message = "ID must be greater than 0")
    private Integer id;

    public static MPerilaku toEntity(MPerilakuPutRequest request, String updatedBy) {
        MPerilaku entity = new MPerilaku();
        entity.setId(request.getId());
        entity.setUrut(request.getUrut());
        entity.setKompetensi(request.getKompetensi());
        entity.setUraian(request.getUraian());
        entity.setStatus(request.getStatus());
        entity.setUpdatedBy(updatedBy);
        return entity;
    }
}
