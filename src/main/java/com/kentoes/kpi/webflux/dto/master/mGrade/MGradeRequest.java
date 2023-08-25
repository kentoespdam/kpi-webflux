package com.kentoes.kpi.webflux.dto.master.mGrade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kentoes.kpi.webflux.dto.commons.PagingDto;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.master.MGrade;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

@Getter
@Setter
public class MGradeRequest extends PagingDto {
    private Integer id;
    private Integer grade;
    @Enumerated(EnumType.STRING)
    private EStatus status = EStatus.Enabled;

    @JsonIgnore
    public Specification<MGrade> getSpecification() {
        Specification<MGrade> idSpec = Objects.isNull(id) ? null : (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
        Specification<MGrade> gradeSpec = Objects.isNull(grade) ? null : (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("grade"), grade);
        Specification<MGrade> statusSpec = Objects.isNull(status) ? null : (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("status"), status);
        return Specification.where(idSpec).and(gradeSpec).and(statusSpec);
    }
}