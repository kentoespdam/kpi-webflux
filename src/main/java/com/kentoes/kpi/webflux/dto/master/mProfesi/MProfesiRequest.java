package com.kentoes.kpi.webflux.dto.master.mProfesi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kentoes.kpi.webflux.dto.commons.PagingDto;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.master.MProfesi;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

@Getter
@Setter
public class MProfesiRequest extends PagingDto {
    private String levelName;
    private Integer levelId;
    private String name;
    @Enumerated(EnumType.STRING)
    private EStatus status = EStatus.Enabled;

    @JsonIgnore
    public Specification<MProfesi> getSpecification() {
        Specification<MProfesi> levelNameSpec = Objects.isNull(levelName) ? null :
                (root, query, cb) -> cb.like(root.get("level").get("level"), "%" + levelName + "%");
        Specification<MProfesi> levelIdSpec = Objects.isNull(levelId) ? null
                : ((root, query, cb) -> cb.equal(root.get("level").get("id"), levelId));
        Specification<MProfesi> nameSpec = Objects.isNull(name) ? null
                : ((root, query, cb) -> cb.like(root.get("name"), "%" + name + "%"));
        Specification<MProfesi> statusSpec = Objects.isNull(status) ? null
                : ((root, query, cb) -> cb.equal(root.get("status"), status));
        return Specification.where(levelNameSpec).and(levelIdSpec).and(nameSpec).and(statusSpec);
    }
}
