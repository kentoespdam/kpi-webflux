package com.kentoes.kpi.webflux.dto.master.level;

import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.master.MLevel;
import lombok.Data;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

@Data
public class MLevelRequest {
    private String level;
    private EStatus status = EStatus.Enabled;

    public MLevel getRequest() {
        MLevel entity = new MLevel();
        entity.setLevel(level);
        entity.setStatus(status);
        return entity;
    }

    public static Example<MLevel> getCriteria(MLevelRequest request){
        MLevel mLevel = request.getRequest();
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase("level")
                .withMatcher("level", ExampleMatcher.GenericPropertyMatchers.contains());

        return Example.of(mLevel, matcher);
    }

    public static MLevel getRequest(MLevelRequest request) {
        MLevel entity = new MLevel();
        entity.setLevel(request.getLevel());
        entity.setStatus(request.getStatus());
        return entity;
    }
}
