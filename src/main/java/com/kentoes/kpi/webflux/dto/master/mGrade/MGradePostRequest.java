package com.kentoes.kpi.webflux.dto.master.mGrade;

import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.master.MGrade;
import com.kentoes.kpi.webflux.entities.master.MLevel;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MGradePostRequest implements Serializable {
    @NotNull(message = "Level ID is required")
    @Min(value = 1, message = "Level ID must be greater than 0")
    protected Integer levelId;
    @NotNull(message = "Grade is required")
    @Min(value = 1, message = "Grade must be greater than 0")
    protected Integer grade;
    @NotNull(message = "Tukin is required")
    @Min(value = 1, message = "Tukin must be greater than 0")
    protected Double tukin;
    @Enumerated(EnumType.STRING)
    protected EStatus status = EStatus.Enabled;

    public static MGrade toEntity(MGradePostRequest request, String createdBy, MLevel level) {
        MGrade mGrade = new MGrade();
        mGrade.setLevel(level);
        mGrade.setGrade(request.getGrade());
        mGrade.setTukin(request.getTukin());
        mGrade.setStatus(request.getStatus());
        mGrade.setCreatedBy(createdBy);
        return mGrade;
    }
}
