package com.kentoes.kpi.webflux.entities.bridge;

import com.kentoes.kpi.webflux.entities.IdsAbstract;
import com.kentoes.kpi.webflux.entities.master.MKpi;
import com.kentoes.kpi.webflux.entities.master.MLevel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bridge_pegawai_kpi")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BridgePegawaiKpi extends IdsAbstract {
    private String nipam;
    private String name;
    private Integer posId;
    private Integer orgId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id")
    private MLevel level;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kpi_id")
    private MKpi kpi;
}
