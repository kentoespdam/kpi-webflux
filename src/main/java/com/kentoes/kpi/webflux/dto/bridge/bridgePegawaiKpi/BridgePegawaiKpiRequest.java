package com.kentoes.kpi.webflux.dto.bridge.bridgePegawaiKpi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kentoes.kpi.webflux.dto.commons.PagingDto;
import com.kentoes.kpi.webflux.entities.bridge.BridgePegawaiKpi;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

@Getter
@Setter
public class BridgePegawaiKpiRequest extends PagingDto {
    private String nipam;
    private String name;
    private Integer positionId;
    private Integer organizationId;
    private Integer levelId;
    private Integer kpiId;
    @Enumerated(EnumType.STRING)
    private EStatus status = EStatus.Enabled;

    @JsonIgnore
    public Specification<BridgePegawaiKpi> getSpecification() {
        Specification<BridgePegawaiKpi> nipamSpec = Objects.isNull(nipam) ? null : ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("nipam"), nipam));
        Specification<BridgePegawaiKpi> nameSpec = Objects.isNull(name) ? null : ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + name + "%"));
        Specification<BridgePegawaiKpi> positionSpec = Objects.isNull(positionId) ? null : ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("posId"), positionId));
        Specification<BridgePegawaiKpi> orgIdSpec = Objects.isNull(organizationId) ? null : ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("orgId"), organizationId));
        Specification<BridgePegawaiKpi> levelSpec = Objects.isNull(levelId) ? null : ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("level").get("id"), levelId));
        Specification<BridgePegawaiKpi> kpiSpec = Objects.isNull(kpiId) ? null : ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("kpi").get("id"), kpiId));
        Specification<BridgePegawaiKpi> statusSpec = (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("status"), status);
        return Specification.where(nipamSpec).and(nameSpec).and(positionSpec).and(orgIdSpec).and(levelSpec).and(kpiSpec).and(statusSpec);
    }
}
