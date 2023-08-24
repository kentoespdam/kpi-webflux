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
@Table(name = "m_grade")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MGrade extends IdsAbstract {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id")
    private MLevel level;
    private Integer grade;
    private Double tukin;
    @OneToMany(mappedBy = "grade", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<MKpi> kpiList;

    @Override
    public String toString() {
        return "MGrade{" +
                "id=" + id +
                ", level=" + level +
                ", grade=" + grade +
                ", tukin=" + tukin +
                ", status=" + status +
                '}';
    }
}