package com.kentoes.kpi.webflux.services.master.mLevel;

import com.kentoes.kpi.webflux.dto.commons.SavedStatus;
import com.kentoes.kpi.webflux.dto.master.mLevel.*;
import org.springframework.data.domain.Page;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface MLevelService {
    Flux<MLevelDto> findAll(MLevelRequest request);

    Mono<List<MLevelDto>> findAllMono(MLevelRequest request);

    MLevelDto findById(Integer id);

    Page<MLevelWithAuditDto> findPage(MLevelRequest request);

    SavedStatus<?> save(MLevelPostRequest request);

    SavedStatus<?> update(MLevelPutRequest request);

    Boolean delete(Integer id);
}
