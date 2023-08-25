package com.kentoes.kpi.webflux.dto.master.mGrade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kentoes.kpi.webflux.entities.master.MGrade;
import com.kentoes.kpi.webflux.entities.master.MLevel;
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
public class MGradePutRequest extends MGradePostRequest {
    @NotNull(message = "ID is required")
    @Min(value = 1, message = "ID must be greater than 0")
    private Integer id;

    @JsonIgnore
    public static MGrade toEntity(MGradePutRequest request, String updatedBy, MLevel level) {
        MGrade mGrade = new MGrade();
        mGrade.setId(request.getId());
        mGrade.setLevel(level);
        mGrade.setGrade(request.getGrade());
        mGrade.setTukin(request.getTukin());
        mGrade.setStatus(request.getStatus());
        mGrade.setUpdatedBy(updatedBy);
        return mGrade;
    }
}