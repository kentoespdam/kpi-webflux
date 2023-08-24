package com.kentoes.kpi.webflux.dto.master.mLevel;

import com.kentoes.kpi.webflux.entities.master.MLevel;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MLevelPutRequest extends MLevelPostRequest {
    @NotNull(message = "ID is required")
    @Min(value = 1, message = "ID must be greater than 0")
    private Integer id;

    public static MLevel toEntity(MLevelPutRequest request, String updatedBy) {
        MLevel mLevel = new MLevel();
        mLevel.setId(request.getId());
        mLevel.setLevel(request.getLevel());
        mLevel.setStatus(request.getStatus());
        mLevel.setUpdatedBy(updatedBy);
        return mLevel;
    }
}

