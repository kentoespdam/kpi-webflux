package com.kentoes.kpi.webflux.repositories.master;

import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.master.MKpi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface MKpiRepository extends JpaRepository<MKpi, Integer>, JpaSpecificationExecutor<MKpi> {
    Optional<MKpi> findByOrgIdAndPosIdAndNameAndStatusNot(Integer orgId, Integer posId, String name, EStatus deleted);

    Optional<MKpi> findByIdAndStatusNot(Integer id, EStatus deleted);
}
