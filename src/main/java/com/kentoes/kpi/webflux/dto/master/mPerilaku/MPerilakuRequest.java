package com.kentoes.kpi.webflux.dto.master.mPerilaku;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kentoes.kpi.webflux.dto.commons.PagingDto;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.master.MPerilaku;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

@Getter
@Setter
public class MPerilakuRequest extends PagingDto {
    private String kompetensi;
    private String uraian;
    @Enumerated(EnumType.STRING)
    private EStatus status = EStatus.Enabled;

    @JsonIgnore
    public Specification<MPerilaku> getSpecification() {
        Specification<MPerilaku> kompetensiSpec = Objects.isNull(kompetensi) ? null
                : ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("kompetensi"),
                "%" + kompetensi + "%"));
        Specification<MPerilaku> uraianSpec = Objects.isNull(uraian) ? null
                : ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("uraian"), "%" + uraian + "%"));
        Specification<MPerilaku> statusSpec = Objects.isNull(status) ? null
                : ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("status"), status));
        return Specification.where(kompetensiSpec).and(uraianSpec).and(statusSpec);
    }
}
