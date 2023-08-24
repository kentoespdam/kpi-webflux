package com.kentoes.kpi.webflux.controllers.master;

import com.kentoes.kpi.webflux.dto.master.mLevel.MLevelDto;
import com.kentoes.kpi.webflux.dto.master.mLevel.MLevelRequest;
import com.kentoes.kpi.webflux.services.master.mLevel.MLevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LevelControllerImpl implements LevelController {
    private final MLevelService service;

    @Override
    public Flux<MLevelDto> findAll(MLevelRequest request) {
        return service.findAll(request);
    }

    @Override
    public Mono<List<MLevelDto>> findAllMono(MLevelRequest request) {
        return service.findAllMono(request);
    }
}
