package com.kentoes.kpi.webflux.dto.master.mUraianIndikator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kentoes.kpi.webflux.dto.commons.PagingDto;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.master.MUraianIndikator;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

@Getter
@Setter
public class MUraianIndikatorRequest extends PagingDto {
    private Integer indikatorId;
    private String uraian;
    private Integer kpiId;
    private Integer profesiId;
    private Integer levelId;
    @Enumerated(EnumType.STRING)
    private EStatus status = EStatus.Enabled;

    @JsonIgnore
    public Specification<MUraianIndikator> getSpecification() {
        Specification<MUraianIndikator> indikatorSpec = Objects.isNull(indikatorId) ? null : ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("indikator").get("id"), indikatorId));
        Specification<MUraianIndikator> uraianSpec = Objects.isNull(uraian) ? null : ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("uraian"), "%" + uraian + "%"));
        Specification<MUraianIndikator> kpiSpec = Objects.isNull(kpiId) ? null : ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("indikator").get("kpi").get("id"), kpiId));
        Specification<MUraianIndikator> profesiSpec = Objects.isNull(profesiId) ? null : ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("indikator").get("kpi").get("profesi").get("id"), profesiId));
        Specification<MUraianIndikator> levelSpec = Objects.isNull(levelId) ? null : ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("indikator").get("kpi").get("profesi").get("level").get("id"), levelId));
        Specification<MUraianIndikator> statusSpec = Objects.isNull(status) ? null : ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("status"), status));
        return Specification.where(indikatorSpec).and(uraianSpec).and(kpiSpec).and(profesiSpec).and(levelSpec).and(statusSpec);
    }
}
