package com.kentoes.kpi.webflux.controllers.master;

import com.kentoes.kpi.webflux.dto.master.mLevel.MLevelDto;
import com.kentoes.kpi.webflux.dto.master.mLevel.MLevelRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RequestMapping("/master/level")
public interface LevelController {
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    Flux<MLevelDto> findAll(MLevelRequest request);
    @GetMapping("/mono")
    Mono<List<MLevelDto>> findAllMono(MLevelRequest request);
}
