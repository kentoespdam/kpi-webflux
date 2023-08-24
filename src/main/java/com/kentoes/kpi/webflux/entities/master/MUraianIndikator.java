package com.kentoes.kpi.webflux.entities.master;

import com.kentoes.kpi.webflux.entities.IdsAbstract;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.enums.ETarget;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "m_uraian_indikator")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MUraianIndikator extends IdsAbstract {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "indikator_id")
    private MIndikator indikator;
    private String uraian;
    private Float volume;
    @Enumerated(EnumType.STRING)
    private ETarget target;
    private String satuan;
    private String waktu;
    private Float bobot;

    public MUraianIndikator(String uraian, Float volume, String satuan, ETarget target, String waktu, Float bobot) {
        this.uraian = uraian;
        this.volume = volume;
        this.satuan = satuan;
        this.target = target;
        this.waktu = waktu;
        this.bobot = bobot;
        this.status = EStatus.Enabled;
    }

    @Override
    public String toString() {
        return "MUraianIndikator{" +
                "indikator=" + indikator +
                ", uraian='" + uraian + '\'' +
                ", volume=" + volume +
                ", satuan='" + satuan + '\'' +
                ", target='" + target + '\'' +
                ", waktu='" + waktu + '\'' +
                ", bobot=" + bobot +
                ", id=" + id +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedAt=" + updatedAt +
                ", updatedBy='" + updatedBy + '\'' +
                '}';
    }
}