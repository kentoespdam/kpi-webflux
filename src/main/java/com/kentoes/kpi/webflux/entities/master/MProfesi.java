package com.kentoes.kpi.webflux.entities.master;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kentoes.kpi.webflux.entities.IdsAbstract;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "m_profesi")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MProfesi extends IdsAbstract {
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id")
    private MLevel level;

    @OneToMany(mappedBy = "profesi", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<MKpi> kpiList;

//    @OneToMany(mappedBy = "profesi", fetch = FetchType.LAZY)
//    @JsonIgnore
//    private List<TransKpi> transKpiList;
}
