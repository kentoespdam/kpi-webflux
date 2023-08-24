package com.kentoes.kpi.webflux.entities;

import com.kentoes.kpi.webflux.entities.enums.EStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@MappedSuperclass
public abstract class IdsAbstract extends Audits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    protected EStatus status;

    public IdsAbstract(String createdBy, String updatedBy, Integer id, EStatus status) {
        super(createdBy, updatedBy);
        this.id = id;
        this.status = status;
    }
}