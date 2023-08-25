package com.kentoes.kpi.webflux.dto.master.mKpi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kentoes.kpi.webflux.dto.commons.PagingDto;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.master.MKpi;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

@Getter
@Setter
public class MKpiRequest extends PagingDto {
    private Integer organizationId;
    private Integer positionId;
    private Integer profesiId;
    private String name;
    private Integer gradeId;
    @Enumerated(EnumType.STRING)
    private EStatus status = EStatus.Enabled;

    @JsonIgnore
    public Specification<MKpi> getSpecification() {
        Specification<MKpi> orgIdSpec = Objects.isNull(organizationId) ? null
                : (root, query, cb) -> cb.equal(root.get("orgId"), organizationId);
        Specification<MKpi> posIdSpec = Objects.isNull(positionId) ? null
                : (root, query, cb) -> cb.equal(root.get("posId"), positionId);
        Specification<MKpi> profesiIdSpec = Objects.isNull(profesiId) ? null
                : (root, query, cb) -> cb.equal(root.get("profesi").get("id"), profesiId);
        Specification<MKpi> nameSpec = Objects.isNull(name) ? null
                : (root, query, cb) -> cb.like(root.get("name"), "%" + name + "%");
        Specification<MKpi> gradeIdSpec = Objects.isNull(gradeId) ? null
                : (root, query, cb) -> cb.equal(root.get("grade").get("id"), gradeId);
        Specification<MKpi> statusSpec = Objects.isNull(status) ? null
                : (root, query, cb) -> cb.equal(root.get("status"), status);
        return Specification.where(orgIdSpec).and(posIdSpec).and(profesiIdSpec).and(nameSpec).and(gradeIdSpec)
                .and(statusSpec);
    }
}