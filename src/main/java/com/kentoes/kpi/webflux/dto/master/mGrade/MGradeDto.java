package com.kentoes.kpi.webflux.dto.master.mGrade;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.kentoes.kpi.webflux.dto.master.mLevel.MLevelDto;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.master.MGrade;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@JsonPropertyOrder({"id", "level", "grade", "tukin", "status"})
@AllArgsConstructor
@Data
public class MGradeDto implements Serializable {
    private Integer id;
    private MLevelDto level;
    private Integer grade;
    private Double tukin;
    @Enumerated(EnumType.STRING)
    private EStatus status;

    public static MGradeDto fromEntity(MGrade mGrade) {
        return new MGradeDto(
                mGrade.getId(),
                MLevelDto.fromEntity(mGrade.getLevel()),
                mGrade.getGrade(),
                mGrade.getTukin(),
                mGrade.getStatus()
        );
    }

    public static List<MGradeDto> from(List<MGrade> all) {
        return all.stream().map(MGradeDto::fromEntity).toList();
    }
}