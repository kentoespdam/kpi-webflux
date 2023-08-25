package com.kentoes.kpi.webflux.services.master.mLevel;

import com.kentoes.kpi.webflux.dto.commons.SavedStatus;
import com.kentoes.kpi.webflux.dto.master.mLevel.*;
import com.kentoes.kpi.webflux.entities.enums.ESaveStatus;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.master.MLevel;
import com.kentoes.kpi.webflux.repositories.master.MLevelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.kentoes.kpi.webflux.dto.commons.IGlobalMessage.LEVEL_ALREADY_EXIST;
import static com.kentoes.kpi.webflux.dto.commons.IGlobalMessage.UNKNOWN_LEVEL;

@Service
@RequiredArgsConstructor
public class MLevelServiceImpl implements MLevelService {
    private final MLevelRepository repository;

    @Override
    public List<MLevelDto> findAll(MLevelRequest request) {
        List<MLevel> all = repository.findAll(request.getSpecification());
        return MLevelDto.from(all);
    }

    @Override
    public MLevelDto findById(Integer id) {
        Optional<MLevel> byId = repository.findById(id);
        return byId.map(MLevelDto::fromEntity).orElse(null);
    }

    @Override
    public Page<MLevelWithAuditDto> findPage(MLevelRequest request) {
        Page<MLevel> all = repository.findAll(request.getSpecification(), request.getPageable());
        return all.map(MLevelWithAuditDto::fromEntity);
    }

    @Override
    public SavedStatus<?> save(MLevelPostRequest request) {
        Optional<MLevel> byNamaAndStatusNot = repository.findByLevelAndStatusNot(request.getLevel(), EStatus.Deleted);
        if (byNamaAndStatusNot.isPresent()) return SavedStatus.build(ESaveStatus.FAILED, LEVEL_ALREADY_EXIST);

        String createdBy = "admin";
        MLevel mLevel = MLevelPostRequest.toEntity(request, createdBy);
        MLevel saved = repository.save(mLevel);
        return SavedStatus.build(ESaveStatus.SUCCESS, MLevelWithAuditDto.fromEntity(saved));
    }

    @Override
    public SavedStatus<?> update(Integer id, MLevelPutRequest request) {
        if (Objects.equals(id, request.getId())) return SavedStatus.build(ESaveStatus.FAILED, UNKNOWN_LEVEL);
        Optional<MLevel> byId = repository.findById(request.getId());
        if (byId.isEmpty()) return SavedStatus.build(ESaveStatus.FAILED, UNKNOWN_LEVEL);

        String updatedBy = "admin";
        MLevel mLevel = MLevelPutRequest.toEntity(request, updatedBy);
        MLevel saved = repository.save(mLevel);
        return SavedStatus.build(ESaveStatus.SUCCESS, MLevelWithAuditDto.fromEntity(saved));
    }

    @Override
    public Boolean delete(Integer id) {
        MLevel mLevel = repository.findByIdAndStatusNot(id, EStatus.Deleted).orElse(null);
        if (mLevel == null) return false;

        String updatedBy = "admin";
        mLevel.setUpdatedBy(updatedBy);
        mLevel.setStatus(EStatus.Deleted);
        repository.save(mLevel);
        return true;
    }
}
