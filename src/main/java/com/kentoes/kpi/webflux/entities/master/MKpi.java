package com.kentoes.kpi.webflux.entities.master;

import com.kentoes.kpi.webflux.entities.IdsAbstract;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table("m_profesi")
public class MKpi extends IdsAbstract {
    private Integer orgId;
    private Integer posId;
    private Integer profesiId;
    private String name;
    private Integer gradeId;
}
