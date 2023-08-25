package com.kentoes.kpi.webflux.entities.bridge;

import com.kentoes.kpi.webflux.entities.IdsAbstract;
import com.kentoes.kpi.webflux.entities.master.MLevel;
import com.kentoes.kpi.webflux.entities.master.MPerilaku;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "bridge_level_perilaku")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BridgeLevelPerilaku extends IdsAbstract {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "perilaku_id")
    private MPerilaku perilaku;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id")
    private MLevel level;

    public static List<MPerilaku> toMPerilakuList(List<BridgeLevelPerilaku> bridgeLevelPerilakuList) {
        return bridgeLevelPerilakuList.stream().map(BridgeLevelPerilaku::getPerilaku).toList();
    }
}
