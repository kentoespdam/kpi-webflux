package com.kentoes.kpi.webflux.repositories.master;

import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.master.MLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface MLevelRepository extends JpaRepository<MLevel, Integer>, JpaSpecificationExecutor<MLevel> {
    Optional<MLevel> findByIdAndStatusNot(Integer id, EStatus status);

    Optional<MLevel> findByLevelAndStatusNot(String nama, EStatus status);

}
