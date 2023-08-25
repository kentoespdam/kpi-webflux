package com.kentoes.kpi.webflux.entities.trans;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kentoes.kpi.webflux.entities.IdsAbstract;
import com.kentoes.kpi.webflux.entities.enums.ETarget;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "trans_kpi_uraian")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = {"transKpiUraianFilesList", "transKpiIndikator"}, callSuper = true)
public class TransKpiUraian extends IdsAbstract {
    private String uraian;
    private Float volume;
    private String satuan;
    private String waktu;
    @Enumerated(EnumType.STRING)
    private ETarget target;
    private Float capaianVolume;
    private String capaianSatuan;
    private String capaianWaktu;
    private Float nilaiProdukKerja;
    private Float nilaiWaktu;
    private Float nilaiTotalUraian;
    private Float bobot;

    @OneToMany(mappedBy = "transKpiUraian")
    @JsonManagedReference
    private List<TransKpiUraianFile> transKpiUraianFilesList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trans_kpi_indikator_id")
    @JsonBackReference
    private TransKpiIndikator transKpiIndikator;

}
