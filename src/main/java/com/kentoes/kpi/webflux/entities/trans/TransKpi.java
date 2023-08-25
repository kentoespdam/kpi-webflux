package com.kentoes.kpi.webflux.entities.trans;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kentoes.kpi.webflux.entities.IdsAbstract;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.master.MGrade;
import com.kentoes.kpi.webflux.entities.master.MProfesi;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "trans_kpi")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = "indikatorList", callSuper = true)
public class TransKpi extends IdsAbstract {
    private String nipam;
    private Integer orgId;
    private Integer posId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profesi_id")
    private MProfesi profesi;
    @ManyToOne
    @JoinColumn(name = "grade_id")
    private MGrade grade;
    private String name;
    private Integer periode;
    private Float nilaiTotal;

    @OneToMany(mappedBy = "transKpi")
    @JsonManagedReference
    private List<TransKpiIndikator> indikatorList;

    public TransKpi(Integer id, String nipam, Integer orgId, Integer posId, MProfesi profesi, MGrade grade, String name, Integer periode, Float nilaiTotal, EStatus status, List<TransKpiIndikator> indikatorList, String updatedBy) {
        this.id = id;
        this.nipam = nipam;
        this.orgId = orgId;
        this.posId = posId;
        this.profesi = profesi;
        this.grade = grade;
        this.name = name;
        this.periode = periode;
        this.nilaiTotal = nilaiTotal;
        this.status = status;
        this.indikatorList = indikatorList;
        this.updatedBy = updatedBy;
    }

    public TransKpi(
            Integer id, String nipam, Integer orgId, Integer posId, MProfesi profesi, MGrade grade,
            String name, Integer periode, Float nilaiTotal, EStatus status, String updatedBy
    ) {
        this.id = id;
        this.nipam = nipam;
        this.orgId = orgId;
        this.posId = posId;
        this.profesi = profesi;
        this.grade = grade;
        this.name = name;
        this.periode = periode;
        this.nilaiTotal = nilaiTotal;
        this.status = status;
        this.updatedBy = updatedBy;
    }

    public TransKpi(Integer transKpiId) {
        this.id = transKpiId;
    }

    @Override
    public String toString() {
        return "TransKpi{" +
                "nipam='" + nipam + '\'' +
                ", orgId=" + orgId +
                ", posId=" + posId +
                ", profesi=" + profesi +
                ", grade=" + grade +
                ", name='" + name + '\'' +
                ", periode=" + periode +
                ", nilaiTotal=" + nilaiTotal +
                ", indikatorList=" + getIndikatorList() +
                ", id=" + id +
                ", status=" + status +
                '}';
    }
}
