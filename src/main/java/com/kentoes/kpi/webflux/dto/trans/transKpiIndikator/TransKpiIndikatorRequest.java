package com.kentoes.kpi.webflux.dto.trans.transKpiIndikator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kentoes.kpi.webflux.dto.commons.PagingDto;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.trans.TransKpiIndikator;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

@Getter
@Setter
public class TransKpiIndikatorRequest extends PagingDto {
    private Integer transKpiId;
    private String indikator;
    @Enumerated(EnumType.STRING)
    private EStatus status = EStatus.Enabled;

    @JsonIgnore
    public Specification<TransKpiIndikator> getSpecification() {
        Specification<TransKpiIndikator> transKpiSpec = Objects.isNull(transKpiId) ? null
                : ((root, query, cb) -> cb.equal(root.get("transKpi").get("id"), transKpiId));
        Specification<TransKpiIndikator> indikatorSpec = Objects.isNull(indikator) ? null
                : ((root, query, cb) -> cb.like(root.get("indikator"), "%" + indikator + "%"));
        Specification<TransKpiIndikator> statusSpec = Objects.isNull(status) ? null
                : ((root, query, cb) -> cb.equal(root.get("status"), status));
        return Specification.where(transKpiSpec).and(indikatorSpec).and(statusSpec);
    }
}
