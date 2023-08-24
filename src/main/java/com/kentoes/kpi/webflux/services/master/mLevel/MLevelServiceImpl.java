package com.kentoes.kpi.webflux.services.master.mLevel;

import com.kentoes.kpi.webflux.dto.commons.SavedStatus;
import com.kentoes.kpi.webflux.dto.master.mLevel.*;
import com.kentoes.kpi.webflux.entities.master.MLevel;
import com.kentoes.kpi.webflux.repositories.master.MLevelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MLevelServiceImpl implements MLevelService {
    private final MLevelRepository repository;

    @Override
    public Flux<MLevelDto> findAll(MLevelRequest request) {
        List<MLevel> all = repository.findAll(request.getSpecification());
        return Flux.fromIterable(all).map(MLevelDto::fromEntity).log();
    }

    @Override
    public Mono<List<MLevelDto>> findAllMono(MLevelRequest request) {
        List<MLevel> all = repository.findAll(request.getSpecification());
        return Mono.just(MLevelDto.from(all)).log();
    }

    @Override
    public MLevelDto findById(Integer id) {
//        Optional<MLevel> byId = repository.findById(id);
//        return byId.map(MLevelDto::fromEntity).orElse(null);
        return null;
    }

    @Override
    public Page<MLevelWithAuditDto> findPage(MLevelRequest request) {
//        Page<MLevel> all = repository.findAll(request.getSpecification(), request.getPageable());
//        return all.map(MLevelWithAuditDto::fromEntity);
        return null;
    }

    @Override
    public SavedStatus<?> save(MLevelPostRequest request) {
//        Optional<MLevel> byNamaAndStatusNot = repository.findByLevelAndStatusNot(request.getLevel(), EStatus.Deleted);
//        if (byNamaAndStatusNot.isPresent()) return SavedStatus.build(ESaveStatus.FAILED, LEVEL_ALREADY_EXIST);
//
//        String createdBy = "admin";
//        MLevel mLevel = MLevelPostRequest.toEntity(request, createdBy);
//        MLevel saved = repository.save(mLevel);
//        return SavedStatus.build(ESaveStatus.SUCCESS, MLevelWithAuditDto.fromEntity(saved));
        return null;
    }

    @Override
    public SavedStatus<?> update(MLevelPutRequest request) {
//        Optional<MLevel> byId = repository.findById(request.getId());
//        if (byId.isEmpty()) return SavedStatus.build(ESaveStatus.FAILED, UNKNOWN_KPI);
//
//        String updatedBy = "admin";
//        MLevel mLevel = MLevelPutRequest.toEntity(request, updatedBy);
//        MLevel saved = repository.save(mLevel);
//        return SavedStatus.build(ESaveStatus.SUCCESS, MLevelWithAuditDto.fromEntity(saved));
        return null;
    }

    @Override
    public Boolean delete(Integer id) {
//        MLevel mLevel = repository.findByIdAndStatusNot(id, EStatus.Deleted).orElse(null);
//        if (mLevel == null) return false;
//
//        String updatedBy = "admin";
//        mLevel.setUpdatedBy(updatedBy);
//        mLevel.setStatus(EStatus.Deleted);
//        repository.save(mLevel);
//        return true;
        return true;
    }
}
