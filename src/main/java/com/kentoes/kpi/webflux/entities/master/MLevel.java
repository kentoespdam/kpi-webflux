package com.kentoes.kpi.webflux.entities.master;

import com.kentoes.kpi.webflux.entities.IdsAbstract;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table("m_level")
public class MLevel extends IdsAbstract {
    private String level;
}
