package com.kentoes.kpi.webflux.controllers.master;

import com.kentoes.kpi.webflux.dto.master.level.MLevelRequest;
import com.kentoes.kpi.webflux.services.master.MLevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class MLevelControllerImpl implements MLevelController {

    private final MLevelService service;

    @Override
    public Flux<?> findAll() {
        return service.findAll();
    }

    @Override
    public Flux<?> search(MLevelRequest request) {
        return service.search(request);
    }

    @Override
    public Flux<?> pagination(MLevelRequest request) {
        return service.page(request);
    }
}
