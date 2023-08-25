package com.kentoes.kpi.webflux.dto.master.mProfesi;

import com.kentoes.kpi.webflux.dto.master.mLevel.MLevelPostRequest;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.master.MLevel;
import com.kentoes.kpi.webflux.entities.master.MProfesi;
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
public class MProfesiPostRequest implements Serializable {
    @NotBlank(message = "name is required and cannot be empty")
    private String name;
    @NotNull(message = "levelId is required")
    @Min(value = 1, message = "levelId must be greater than 0")
    private Integer levelId;
    private MLevelPostRequest level;
    @Enumerated(EnumType.STRING)
    private EStatus status = EStatus.Enabled;

    public String getName() {
        return Objects.nonNull(name) ? name.trim() : null;
    }

    public static MProfesi toEntity(MProfesiPostRequest request, String createdBy, MLevel level) {
        MProfesi entity = new MProfesi();
        entity.setName(request.getName());
        entity.setLevel(level);
        entity.setStatus(request.getStatus());
        entity.setCreatedBy(createdBy);
        return entity;
    }

    public static MProfesiPostRequest fromMProfesi(MProfesi profesi) {
        MProfesiPostRequest request = new MProfesiPostRequest();
        request.setName(profesi.getName());
        request.setLevelId(profesi.getLevel().getId());
        request.setLevel(MLevelPostRequest.fromMLevel(profesi.getLevel()));
        request.setStatus(profesi.getStatus());
        return request;
    }
}