package com.kentoes.kpi.webflux.dto.bridge.bridgeLevelPerilaku;

import com.kentoes.kpi.webflux.dto.master.mLevel.MLevelDto;
import com.kentoes.kpi.webflux.dto.master.mPerilaku.MPerilakuDto;
import com.kentoes.kpi.webflux.entities.bridge.BridgeLevelPerilaku;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
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
public class BridgeLevelPerilakuDto implements Serializable {
    private Integer id;
    private MPerilakuDto perilaku;
    private MLevelDto level;
    @Enumerated(EnumType.STRING)
    private EStatus status;

    public static BridgeLevelPerilakuDto fromEntity(BridgeLevelPerilaku entity) {
        return new BridgeLevelPerilakuDto(
                entity.getId(),
                MPerilakuDto.fromEntity(entity.getPerilaku()),
                MLevelDto.fromEntity(entity.getLevel()),
                entity.getStatus()
        );
    }

    public static List<BridgeLevelPerilakuDto> from(List<BridgeLevelPerilaku> entities) {
        return entities.stream().map(BridgeLevelPerilakuDto::fromEntity).toList();
    }
}
