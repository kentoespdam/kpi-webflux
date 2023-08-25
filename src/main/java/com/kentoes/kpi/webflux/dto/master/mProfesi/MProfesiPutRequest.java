package com.kentoes.kpi.webflux.dto.master.mProfesi;

import com.kentoes.kpi.webflux.entities.master.MLevel;
import com.kentoes.kpi.webflux.entities.master.MProfesi;
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
public class MProfesiPutRequest extends MProfesiPostRequest {
    @NotNull(message = "id is required")
    @Min(value = 1, message = "id must be greater than 0")
    private Integer id;

    public static MProfesi toEntity(MProfesiPutRequest request, String updatedBy, MLevel level) {
        MProfesi entity = new MProfesi();
        entity.setId(request.getId());
        entity.setName(request.getName());
        entity.setLevel(level);
        entity.setStatus(request.getStatus());
        entity.setUpdatedBy(updatedBy);
        return entity;
    }
}
