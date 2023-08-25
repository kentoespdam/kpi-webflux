package com.kentoes.kpi.webflux.controllers.master;

import com.kentoes.kpi.webflux.dto.master.level.MLevelRequest;
import com.kentoes.kpi.webflux.entities.master.MLevel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;

@RequestMapping("/master/level")
public interface MLevelController {
    @GetMapping
    Flux<?> findAll();

    @GetMapping("/search")
    Flux<?> search(MLevelRequest request);

    @GetMapping("/page")
    Flux<?> pagination(MLevelRequest request);
}
