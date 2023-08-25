package com.kentoes.kpi.webflux.dto.bridge.bridgeLevelPerilaku;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kentoes.kpi.webflux.dto.commons.PagingDto;
import com.kentoes.kpi.webflux.entities.bridge.BridgeLevelPerilaku;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

@Getter
@Setter
public class BridgeLevelPerilakuRequest extends PagingDto {
    private Integer perilakuId;
    private Integer levelId;
    @Enumerated(EnumType.STRING)
    private EStatus status = EStatus.Enabled;

    @JsonIgnore
    public Specification<BridgeLevelPerilaku> getSpecification() {
        Specification<BridgeLevelPerilaku> perilakuSpec = Objects.isNull(perilakuId) ? null : (root, query, cb) -> cb.equal(root.get("perilaku").get("id"), perilakuId);
        Specification<BridgeLevelPerilaku> levelSpec = Objects.isNull(levelId) ? null : (root, query, cb) -> cb.equal(root.get("level").get("id"), levelId);
        Specification<BridgeLevelPerilaku> statusSpec = (root, query, cb) -> cb.equal(root.get("status"), status);
        return Specification.where(perilakuSpec).and(levelSpec).and(statusSpec);
    }
}
