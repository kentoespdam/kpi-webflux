package com.kentoes.kpi.webflux.dto.master.mLevel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kentoes.kpi.webflux.dto.commons.PagingDto;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.master.MLevel;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

@Getter
@Setter
public class MLevelRequest extends PagingDto {
    private Integer id;
    private String level;
    @Enumerated(EnumType.STRING)
    private EStatus status = EStatus.Enabled;

    @JsonIgnore
    public Specification<MLevel> getSpecification() {
        Specification<MLevel> idSpec = Objects.isNull(id) ? null
                : (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
        Specification<MLevel> levelSpec = Objects.isNull(level) ? null
                : (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("level"), "%" + level + "%");
        Specification<MLevel> statusSpec = Objects.isNull(status) ? null
                : (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("status"), status);
        return Specification.where(idSpec).and(levelSpec).and(statusSpec);
    }
}

