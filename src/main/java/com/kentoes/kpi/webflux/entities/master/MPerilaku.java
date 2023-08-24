package com.kentoes.kpi.webflux.entities.master;

import com.kentoes.kpi.webflux.entities.IdsAbstract;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "m_perilaku")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MPerilaku extends IdsAbstract {
    private Integer urut;
    private String kompetensi;
    private String uraian;
}
