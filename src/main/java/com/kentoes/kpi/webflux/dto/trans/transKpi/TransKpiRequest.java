package com.kentoes.kpi.webflux.dto.trans.transKpi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kentoes.kpi.webflux.dto.commons.PagingDto;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.trans.TransKpi;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

@Getter
@Setter
public class TransKpiRequest extends PagingDto {
    private String nipam;
    private Integer organizationId;
    private Integer positionId;
    private Integer profesiId;
    private Integer periode;
    private Integer kpiId;
    @Enumerated(EnumType.STRING)
    private EStatus status = EStatus.Enabled;

    public String getNipam() {
        return Objects.isNull(nipam) ? null : nipam.trim();
    }

    @JsonIgnore
    public Specification<TransKpi> getSpecification() {
        Specification<TransKpi> nipamSpec = Objects.isNull(nipam) ? null
                : (root, query, cb) -> cb.equal(root.get("nipam"), nipam);
        Specification<TransKpi> organizationSpec = Objects.isNull(organizationId) ? null
                : (root, query, cb) -> cb.equal(root.get("orgId"), organizationId);
        Specification<TransKpi> positionSpec = Objects.isNull(positionId) ? null
                : (root, query, cb) -> cb.equal(root.get("posId"), positionId);
        Specification<TransKpi> profesiSpec = Objects.isNull(profesiId) ? null
                : (root, query, cb) -> cb.equal(root.get("profesi").get("id"), profesiId);
        Specification<TransKpi> periodeSpec = Objects.isNull(periode) ? null
                : (root, query, cb) -> cb.equal(root.get("periode"), periode);
        Specification<TransKpi> kpiSpec = Objects.isNull(kpiId) ? null
                : (root, query, cb) -> cb.equal(root.get("kpi").get("id"), kpiId);
        Specification<TransKpi> statusSpec = Objects.isNull(status) ? null
                : (root, query, cb) -> cb.equal(root.get("status"), status);
        return Specification.where(nipamSpec).and(organizationSpec).and(positionSpec).and(profesiSpec).and(periodeSpec)
                .and(kpiSpec).and(statusSpec);
    }
}
