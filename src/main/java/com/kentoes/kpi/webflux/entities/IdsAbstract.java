package com.kentoes.kpi.webflux.entities;

import com.kentoes.kpi.webflux.entities.enums.EStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class IdsAbstract extends Audits {
    @Id
    protected Integer id;
    protected EStatus status;

    public IdsAbstract(String createdBy, String updatedBy, Integer id, EStatus status) {
        super(createdBy, updatedBy);
        this.id = id;
        this.status = status;
    }
}
