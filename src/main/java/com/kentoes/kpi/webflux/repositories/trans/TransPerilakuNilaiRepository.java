package com.kentoes.kpi.webflux.repositories.trans;

import com.kentoes.kpi.webflux.entities.trans.TransPerilakuNilai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TransPerilakuNilaiRepository extends JpaRepository<TransPerilakuNilai, Integer>, JpaSpecificationExecutor<TransPerilakuNilai> {
}