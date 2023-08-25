package com.kentoes.kpi.webflux.entities.trans;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kentoes.kpi.webflux.entities.IdsAbstract;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Entity
@Table(name = "trans_kpi_indikator")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = {"transKpiUraianList", "transKpi"}, callSuper = true)
@DynamicUpdate
public class TransKpiIndikator extends IdsAbstract {
    private String indikator;
    private Integer urut;
    @OneToMany(mappedBy = "transKpiIndikator")
    @JsonManagedReference
    private List<TransKpiUraian> transKpiUraianList;

    @ManyToOne
    @JoinColumn(name = "trans_kpi_id")
    @JsonBackReference
    private TransKpi transKpi;

    public TransKpiIndikator(Integer id, String indikator, Integer urut, EStatus status, List<TransKpiUraian> entities, String updateBy) {
        this.id = id;
        this.indikator = indikator;
        this.urut = urut;
        this.status = status;
        this.transKpiUraianList = entities;
        this.updatedBy = updateBy;
    }

    @Override
    public String toString() {
        return "TransKpiIndikator{" +
                "id=" + id +
                ", indikator='" + indikator + '\'' +
                ", urut=" + urut +
                ", transKpiUraianList=" + getTransKpiUraianList() +
                ", transKpi=" + transKpi +
                ", status=" + status +
                '}';
    }
}
