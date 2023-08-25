package com.kentoes.kpi.webflux.repositories.master;

import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.master.MGrade;
import com.kentoes.kpi.webflux.entities.master.MLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface MGradeRepository extends JpaRepository<MGrade, Integer>, JpaSpecificationExecutor<MGrade> {
    Optional<MGrade> findByIdAndStatusNot(Integer id, EStatus status);

    Optional<MGrade> findByGradeAndLevelAndStatusNot(Integer grade, MLevel level, EStatus status);

    List<MGrade> findByLevel_Id(Integer id);

    List<MGrade> findByLevel_IdAndStatus(Integer id, EStatus enabled);
}