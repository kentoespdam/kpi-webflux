package com.kentoes.kpi.webflux.repositories.trans;

import com.kentoes.kpi.webflux.entities.trans.TransKpi;
import com.kentoes.kpi.webflux.entities.trans.TransKpiUraian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface TransKpiRepository extends JpaRepository<TransKpi, Integer>, JpaSpecificationExecutor<TransKpi> {
    Optional<TransKpi> findByPeriodeAndNipam(Integer periode, String nipam);

    Optional<TransKpi> findByIndikatorList_TransKpiUraianList(TransKpiUraian transKpiUraian);
}
