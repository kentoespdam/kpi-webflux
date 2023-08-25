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
public class MProfesi extends IdsAbstract {
    private String name;
}
