package com.kentoes.kpi.webflux.dto.trans.transKpiUraianFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kentoes.kpi.webflux.dto.commons.PagingDto;
import com.kentoes.kpi.webflux.entities.trans.TransKpiUraianFile;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
public class TransKpiUraianFileRequest extends PagingDto {
    private Integer transKpiUraianId;
    private String fileName;

    @JsonIgnore
    public Specification<TransKpiUraianFile> getSpecification() {
        Specification<TransKpiUraianFile> transKpiUraianFileSpecification = Objects.isNull(transKpiUraianId) ? null
                : (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("transKpiUraian").get("id"),
                transKpiUraianId);
        Specification<TransKpiUraianFile> fileNameSpecification = Objects.isNull(fileName) ? null
                : (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("originalFileName"),
                "%" + fileName + "%");
        return Specification.where(transKpiUraianFileSpecification).and(fileNameSpecification);
    }
}
