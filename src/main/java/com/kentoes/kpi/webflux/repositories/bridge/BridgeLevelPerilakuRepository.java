package com.kentoes.kpi.webflux.repositories.bridge;

import com.kentoes.kpi.webflux.entities.bridge.BridgeLevelPerilaku;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.master.MLevel;
import com.kentoes.kpi.webflux.entities.master.MPerilaku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BridgeLevelPerilakuRepository extends JpaRepository<BridgeLevelPerilaku, Integer>, JpaSpecificationExecutor<BridgeLevelPerilaku> {
    Optional<BridgeLevelPerilaku> findByPerilakuAndLevelAndStatusNot(MPerilaku mPerilaku, MLevel mLevel, EStatus deleted);

    Optional<BridgeLevelPerilaku> findByIdAndStatusNot(Integer id, EStatus deleted);

    List<BridgeLevelPerilaku> findByLevel_IdAndStatusNot(Integer level, EStatus eStatus);

    List<BridgeLevelPerilaku> findByLevelAndStatus(Integer level, EStatus eStatus);

    List<BridgeLevelPerilaku> findByLevel_IdAndStatus(Integer level, EStatus eStatus);
}

