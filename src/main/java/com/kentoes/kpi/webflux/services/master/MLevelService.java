package com.kentoes.kpi.webflux.services.master;

import com.kentoes.kpi.webflux.dto.master.level.MLevelDto;
import com.kentoes.kpi.webflux.dto.master.level.MLevelRequest;
import com.kentoes.kpi.webflux.entities.master.MLevel;
import reactor.core.publisher.Flux;

public interface MLevelService {
    Flux<MLevel> findAll();

    Flux<MLevelDto> search(MLevelRequest request);

    Flux<MLevelDto> page(MLevelRequest request);
}
