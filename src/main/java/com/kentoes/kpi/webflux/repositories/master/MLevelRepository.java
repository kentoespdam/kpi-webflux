package com.kentoes.kpi.webflux.repositories.master;

import com.kentoes.kpi.webflux.entities.master.MLevel;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MLevelRepository extends ReactiveCrudRepository<MLevel, Integer>,
        ReactiveQueryByExampleExecutor<MLevel> {
}
