package com.kentoes.kpi.webflux.repositories.master;

import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.master.MLevel;
import com.kentoes.kpi.webflux.entities.master.MProfesi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface MProfesiRepository extends JpaRepository<MProfesi, Integer>, JpaSpecificationExecutor<MProfesi> {
    Optional<MProfesi> findByIdAndStatusNot(Integer id, EStatus status);

    Optional<MProfesi> findByLevelAndNameAndStatusNot(MLevel level, String name, EStatus status);

    List<MProfesi> findByLevel_IdAndStatusNot(Integer id, EStatus deleted);

    List<MProfesi> findByLevel_IdAndStatus(Integer id, EStatus enabled);
}
