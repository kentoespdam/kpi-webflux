package com.kentoes.kpi.webflux.dto.master.mLevel;

import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.master.MLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Data
public class MLevelDto implements Serializable {
    private Integer id;
    private String level;
    private EStatus status;

    public static MLevelDto fromEntity(MLevel mLevel) {
        return new MLevelDto(mLevel.getId(), mLevel.getLevel(), mLevel.getStatus());
    }

    public static List<MLevelDto> from(List<MLevel> all) {
        return all.stream().map(MLevelDto::fromEntity).toList();
    }
}
