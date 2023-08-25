package com.kentoes.kpi.webflux.repositories.trans;

import com.kentoes.kpi.webflux.entities.trans.TransPerilaku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface TransPerilakuRepository extends JpaRepository<TransPerilaku, Integer>, JpaSpecificationExecutor<TransPerilaku> {
    Optional<TransPerilaku> findByPeriodeAndNipam(Integer periode, String nipam);
}
