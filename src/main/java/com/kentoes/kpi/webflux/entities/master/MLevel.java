package com.kentoes.kpi.webflux.entities.master;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kentoes.kpi.webflux.entities.IdsAbstract;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "m_level")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MLevel extends IdsAbstract {
    private String level;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "level")
    @JsonIgnore
    private List<MGrade> grades;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "level")
    @JsonIgnore
    private List<MProfesi> profesiList;
}
