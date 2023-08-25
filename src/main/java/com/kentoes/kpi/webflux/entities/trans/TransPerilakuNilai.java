package com.kentoes.kpi.webflux.entities.trans;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kentoes.kpi.webflux.entities.IdsAbstract;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.master.MPerilaku;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "trans_perilaku_nilai")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransPerilakuNilai extends IdsAbstract {
    private Integer urut;
    private String kompetensi;
    private String uraian;
    private Float nilai;

    @ManyToOne
    @JoinColumn(name = "trans_perilaku_id")
    @JsonBackReference
    private TransPerilaku transPerilaku;

    public TransPerilakuNilai(Integer urut, String kompetensi, String uraian, Float nilai, EStatus status, String createdBy) {
        this.urut = urut;
        this.kompetensi = kompetensi;
        this.uraian = uraian;
        this.nilai = nilai;
        this.status = status;
        this.createdBy = createdBy;
    }

    public static TransPerilakuNilai fromMPerilaku(MPerilaku mPerilaku, TransPerilaku transPerilaku, String createdBy) {
        TransPerilakuNilai entity = new TransPerilakuNilai();
        entity.setUrut(mPerilaku.getUrut());
        entity.setKompetensi(mPerilaku.getKompetensi());
        entity.setUraian(mPerilaku.getUraian());
        entity.setNilai(0F);
        entity.setTransPerilaku(transPerilaku);
        entity.setStatus(EStatus.Enabled);
        entity.setCreatedBy(createdBy);
        return entity;
    }
}
