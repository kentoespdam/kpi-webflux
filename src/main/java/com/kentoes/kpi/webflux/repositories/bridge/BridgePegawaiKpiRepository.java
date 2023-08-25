package com.kentoes.kpi.webflux.repositories.bridge;

import com.kentoes.kpi.webflux.entities.bridge.BridgePegawaiKpi;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.master.MKpi;
import com.kentoes.kpi.webflux.entities.master.MLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface BridgePegawaiKpiRepository extends JpaRepository<BridgePegawaiKpi, Integer>, JpaSpecificationExecutor<BridgePegawaiKpi> {
    Optional<BridgePegawaiKpi> findByNipamAndLevelAndKpiAndStatusNot(String nipam, MLevel mLevel, MKpi mKpi, EStatus deleted);

    Optional<BridgePegawaiKpi> findByIdAndStatusNot(Integer id, EStatus deleted);

    Optional<BridgePegawaiKpi> findByNipamAndStatusNot(String nipam, EStatus eStatus);

    Optional<BridgePegawaiKpi> findByNipamAndStatus(String nipam, EStatus eStatus);
}
