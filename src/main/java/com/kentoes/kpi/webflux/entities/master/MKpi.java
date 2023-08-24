package com.kentoes.kpi.webflux.entities.master;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kentoes.kpi.webflux.entities.IdsAbstract;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "m_kpi")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MKpi extends IdsAbstract {
    private Integer orgId;
    private Integer posId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profesi_id")
    private MProfesi profesi;
    private String name;
    @ManyToOne
    @JoinColumn(name = "grade_id")
    private MGrade grade;
    @OneToMany(mappedBy = "kpi")
    @JsonManagedReference
    private List<MIndikator> indikatorList;

    @Override
    public String toString() {
        return "MKpi{" +
                "orgId=" + orgId +
                ", posId=" + posId +
                ", profesi=" + profesi +
                ", name='" + name + '\'' +
                ", grade=" + grade +
//                ", mIndikators=" + getIndikatorList() +
                ", id=" + id +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedAt=" + updatedAt +
                ", updatedBy='" + updatedBy + '\'' +
                '}';
    }
}