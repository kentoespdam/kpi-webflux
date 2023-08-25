package com.kentoes.kpi.webflux.services.master;

import com.kentoes.kpi.webflux.dto.master.level.MLevelDto;
import com.kentoes.kpi.webflux.dto.master.level.MLevelRequest;
import com.kentoes.kpi.webflux.entities.master.MLevel;
import com.kentoes.kpi.webflux.repositories.master.MLevelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import static org.springframework.data.relational.core.query.Criteria.where;

@Slf4j
@Service
@RequiredArgsConstructor
public class MLevelServiceImpl implements MLevelService {

    private final MLevelRepository repository;
    private final R2dbcEntityTemplate entityTemplate;

    @Override
    public Flux<MLevel> findAll() {
        return repository.findAll();
    }

    @Override
    public Flux<MLevelDto> search(MLevelRequest request) {
        return repository.findAll(MLevelRequest.getCriteria(request))
                .map(MLevelDto::fromEntity)
                .onErrorMap(throwable -> new Throwable("Data Not Found!"))
                .log();
    }

    @Override
    public Flux<MLevelDto> page(MLevelRequest request) {
        Criteria wLevel = where("level").like("%" + request.getLevel() + "%");
        Criteria wStatus = where("status").is(request.getStatus());
        Query query = Query.query(wStatus.and(wLevel)).limit(10).offset(0);

        return entityTemplate.select(MLevel.class)
                .matching(query)
                .all()
                .map(MLevelDto::fromEntity).log();
    }
}
