package com.kentoes.kpi.webflux.dto.bridge.bridgeLevelPerilaku;

import com.kentoes.kpi.webflux.entities.bridge.BridgeLevelPerilaku;
import com.kentoes.kpi.webflux.entities.master.MPerilaku;
import com.kentoes.kpi.webflux.entities.master.MLevel;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BridgeLevelPerilakuPutRequest extends BridgeLevelPerilakuPostRequest {
    @NotNull(message = "ID is required")
    @Min(value = 1, message = "ID must be greater than 0")
    private Integer id;

    public static BridgeLevelPerilaku toEntity(
            BridgeLevelPerilakuPutRequest request, MPerilaku mPerilaku,
            MLevel mLevel, String updatedBy
    ) {
        BridgeLevelPerilaku bridgeLevelPerilaku = new BridgeLevelPerilaku();
        bridgeLevelPerilaku.setId(request.getId());
        bridgeLevelPerilaku.setPerilaku(mPerilaku);
        bridgeLevelPerilaku.setLevel(mLevel);
        bridgeLevelPerilaku.setStatus(request.getStatus());
        bridgeLevelPerilaku.setUpdatedBy(updatedBy);
        return bridgeLevelPerilaku;
    }
}
