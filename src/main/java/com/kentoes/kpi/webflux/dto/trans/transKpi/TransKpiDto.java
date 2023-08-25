package com.kentoes.kpi.webflux.dto.trans.transKpi;

import com.kentoes.kpi.webflux.dto.master.mKpi.MKpiDto;
import com.kentoes.kpi.webflux.dto.master.mProfesi.MProfesiDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class TransKpiDto implements Serializable {
    private Integer id;
    private String nipam;
    private Integer organizationId;
    private Integer positionId;
    private MProfesiDto profesi;
    private Integer periode;
    private MKpiDto kpi;
    private Float nilaiTotal;
}
