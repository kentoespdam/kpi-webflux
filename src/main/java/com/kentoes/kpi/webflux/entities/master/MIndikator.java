package com.kentoes.kpi.webflux.entities.master;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kentoes.kpi.webflux.entities.IdsAbstract;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "m_indikator")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MIndikator extends IdsAbstract{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kpi_id")
    private MKpi kpi;
    private String indikator;
    private Integer urut;
    @OneToMany(mappedBy = "indikator")
    @JsonManagedReference
    private List<MUraianIndikator> uraianIndikatorList;

    public MIndikator(MKpi kpi, String indikator, Integer urut, List<MUraianIndikator> uraianIndikatorList, EStatus status) {
        this.kpi = kpi;
        this.indikator = indikator;
        this.urut = urut;
        this.uraianIndikatorList = uraianIndikatorList;
        this.status = status;
    }

    @Override
    public String toString() {
        return "MIndikator{" +
                "kpi=" + kpi +
                ", indikator='" + indikator + '\'' +
                ", urut=" + urut +
                ", uraianIndikatorList=" + uraianIndikatorList +
                ", id=" + id +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedAt=" + updatedAt +
                ", updatedBy='" + updatedBy + '\'' +
                '}';
    }
}
