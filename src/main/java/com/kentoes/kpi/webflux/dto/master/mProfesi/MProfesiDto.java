package com.kentoes.kpi.webflux.dto.master.mProfesi;

import com.kentoes.kpi.webflux.dto.master.mLevel.MLevelDto;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.master.MProfesi;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MProfesiDto implements Serializable {
    private Integer id;
    private MLevelDto level;
    private String name;
    @Enumerated(EnumType.STRING)
    private EStatus status;

    public static MProfesiDto fromEntity(MProfesi entity) {
        return new MProfesiDto(
                entity.getId(),
                MLevelDto.fromEntity(entity.getLevel()),
                entity.getName(),
                entity.getStatus());
    }

    public static List<MProfesiDto> from(List<MProfesi> all) {
        return all.stream().map(MProfesiDto::fromEntity).toList();
    }
}
