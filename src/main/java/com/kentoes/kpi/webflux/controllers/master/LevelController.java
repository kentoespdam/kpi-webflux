package com.kentoes.kpi.webflux.controllers.master;

import com.kentoes.kpi.webflux.dto.commons.CustomResult;
import com.kentoes.kpi.webflux.dto.master.mLevel.*;
import jakarta.validation.Valid;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RequestMapping("/master/level")
public interface LevelController {
    @GetMapping
    Mono<CustomResult<?>> findAll(MLevelRequest request);

    @GetMapping("/{id}")
    Mono<? extends CustomResult<?>> findById(@PathVariable Integer id);

    @GetMapping("/page")
    Mono<CustomResult<?>> findPage(MLevelRequest request);

    @PostMapping
   Mono<CustomResult<?>> save(@Valid @RequestBody MLevelPostRequest request, Errors errors);

    @PutMapping("/{id}")
   Mono<CustomResult<?>> update(@PathVariable Integer id, @Valid @RequestBody MLevelPutRequest request, Errors errors);

    @DeleteMapping("/{id}")
   Mono<CustomResult<?>> delete(@PathVariable Integer id);
}
