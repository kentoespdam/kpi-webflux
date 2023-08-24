package com.kentoes.kpi.webflux.dto.master.mLevel;

import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.master.MLevel;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MLevelPostRequest implements Serializable {
    @NotBlank(message = "Level is required")
    protected String level;
    @Enumerated(EnumType.STRING)
    protected EStatus status = EStatus.Enabled;

    public static MLevelPostRequest fromMLevel(MLevel level) {
        return new MLevelPostRequest(level.getLevel(), level.getStatus());
    }

    public String getLevel() {
        return Objects.nonNull(level) ? level.trim() : null;
    }

    public static MLevel toEntity(MLevelPostRequest request, String createdBy) {
        MLevel entity = new MLevel();
        entity.setLevel(request.getLevel());
        entity.setStatus(request.getStatus());
        entity.setCreatedBy(createdBy);
        return entity;
    }
}

