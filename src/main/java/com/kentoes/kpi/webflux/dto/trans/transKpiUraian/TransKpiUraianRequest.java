package com.kentoes.kpi.webflux.dto.trans.transKpiUraian;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kentoes.kpi.webflux.dto.commons.PagingDto;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.trans.TransKpiUraian;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
public class TransKpiUraianRequest extends PagingDto {
    private Integer indikatorId;
    private String uraian;
    @Enumerated(EnumType.STRING)
    private EStatus status = EStatus.Enabled;

    @JsonIgnore
    public Specification<TransKpiUraian> getSpecification() {
        Specification<TransKpiUraian> indikatorSpec = Objects.isNull(indikatorId) ? null
                : (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("indikator").get("id"), indikatorId);
        Specification<TransKpiUraian> uraianSpec = Objects.isNull(uraian) ? null
                : (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("uraian"), "%" + uraian + "%");
        Specification<TransKpiUraian> statusSpec = Objects.isNull(status) ? null
                : (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("status"), status);
        return Specification.where(indikatorSpec).and(uraianSpec).and(statusSpec);
    }
}
