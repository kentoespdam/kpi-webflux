package com.kentoes.kpi.webflux.dto.commons;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;

@MappedSuperclass
@Getter
@Setter
public abstract class PagingDto implements Serializable {
    private Integer page = 0;
    private Integer size = 10;
    private String sort = "id";
    private String direction = "asc";

    @JsonIgnore
    public Pageable getPageable() {
        return PageRequest.of(page, size,
                Sort.by(Sort.Direction.fromString(direction), sort));
    }
}

