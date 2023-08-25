package com.kentoes.kpi.webflux.controllers.master;

import com.kentoes.kpi.webflux.dto.commons.CustomResult;
import com.kentoes.kpi.webflux.dto.master.mLevel.*;
import com.kentoes.kpi.webflux.services.master.mLevel.MLevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class LevelControllerImpl implements LevelController {
    private final MLevelService service;


    @Override
    public Mono<CustomResult<?>> findAll(MLevelRequest request) {
        return CustomResult.build(service.findAll(request));
    }

    @Override
    public Mono<CustomResult<?>> findById(Integer id) {
        return CustomResult.build(service.findById(id));
    }

    @Override
    public Mono<CustomResult<?>> findPage(MLevelRequest request) {
        return CustomResult.build(service.findPage(request));
    }

    @Override
    public Mono<CustomResult<?>> save(MLevelPostRequest request, Errors errors) {
        return CustomResult.buildSave(service.save(request));
    }

    @Override
    public Mono<CustomResult<?>> update(Integer id, MLevelPutRequest request, Errors errors) {
        return CustomResult.buildUpdate(service.update(id, request));
    }

    @Override
    public Mono<CustomResult<?>> delete(Integer id) {
        return CustomResult.buildDelete(service.delete(id));
    }
}
