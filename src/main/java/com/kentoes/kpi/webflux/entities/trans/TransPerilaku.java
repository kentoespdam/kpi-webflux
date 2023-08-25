package com.kentoes.kpi.webflux.entities.trans;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kentoes.kpi.webflux.entities.IdsAbstract;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "trans_perilaku")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransPerilaku extends IdsAbstract {
    private String nipam;
    private Integer orgId;
    private Integer posId;
    private Integer periode;

    @OneToMany(mappedBy = "transPerilaku")
    @JsonManagedReference
    private List<TransPerilakuNilai> transPerilakuNilaiList;

    public TransPerilaku(String nipam, Integer orgId, Integer posId, Integer periode, List<TransPerilakuNilai> transPerilakuNilaiList, EStatus status, String createdBy) {
        this.nipam = nipam;
        this.orgId = orgId;
        this.posId = posId;
        this.periode = periode;
        this.transPerilakuNilaiList = transPerilakuNilaiList;
        this.status = status;
        this.createdBy = createdBy;
    }
}
