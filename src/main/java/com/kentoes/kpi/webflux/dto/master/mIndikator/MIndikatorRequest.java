package com.kentoes.kpi.webflux.dto.master.mIndikator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kentoes.kpi.webflux.dto.commons.PagingDto;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.master.MIndikator;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

@Getter
@Setter
public class MIndikatorRequest extends PagingDto {
    private Integer id;
    private Integer kpiId;
    private String indikator;
    @Enumerated(EnumType.STRING)
    private EStatus status = EStatus.Enabled;

    @JsonIgnore
    public Specification<MIndikator> getSpecification() {
        Specification<MIndikator> idSpec = Objects.isNull(id) ? null
                : (root, query, cb) -> cb.equal(root.get("id"), id);
        Specification<MIndikator> kpiIdSpec = Objects.isNull(kpiId) ? null
                : (root, query, cb) -> cb.equal(root.get("kpi").get("id"), kpiId);
        Specification<MIndikator> indikatorSpec = Objects.isNull(indikator) ? null
                : (root, query, cb) -> cb.like(root.get("indikator"), "%" + indikator + "%");
        Specification<MIndikator> statusSpec = (root, query, cb) -> cb.equal(root.get("status"), status);
        return Specification.where(idSpec).and(kpiIdSpec).and(indikatorSpec).and(statusSpec);
    }

    @Override
    public String toString() {
        return "MIndikatorRequest{" +
                "id=" + id +
                ", kpiId=" + kpiId +
                ", indikator='" + indikator + '\'' +
                ", status=" + status +
                '}';
    }
}
