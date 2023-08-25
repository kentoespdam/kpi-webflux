package com.kentoes.kpi.webflux.dto.bridge.bridgeLevelPerilaku;

import com.kentoes.kpi.webflux.entities.bridge.BridgeLevelPerilaku;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.master.MPerilaku;
import com.kentoes.kpi.webflux.entities.master.MLevel;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BridgeLevelPerilakuPostRequest implements Serializable {
    @NotNull(message = "Perilaku is required")
    @Min(value = 1, message = "Perilaku must be greater than 0")
    protected Integer perilakuId;
    @NotNull(message = "Level is required")
    @Min(value = 1, message = "Level must be greater than 0")
    protected Integer levelId;
    @Enumerated
    protected EStatus status = EStatus.Enabled;

    public static BridgeLevelPerilaku toEntity(
            BridgeLevelPerilakuPostRequest request,
            MPerilaku mPerilaku, MLevel mLevel, String createdBy
    ) {
        BridgeLevelPerilaku bridgeLevelPerilaku = new BridgeLevelPerilaku();
        bridgeLevelPerilaku.setPerilaku(mPerilaku);
        bridgeLevelPerilaku.setLevel(mLevel);
        bridgeLevelPerilaku.setStatus(request.getStatus());
        bridgeLevelPerilaku.setCreatedBy(createdBy);
        return bridgeLevelPerilaku;
    }
}
