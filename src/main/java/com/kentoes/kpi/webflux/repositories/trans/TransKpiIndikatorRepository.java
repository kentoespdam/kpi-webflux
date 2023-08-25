package com.kentoes.kpi.webflux.repositories.trans;

import com.kentoes.kpi.webflux.entities.trans.TransKpiIndikator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TransKpiIndikatorRepository extends JpaRepository<TransKpiIndikator, Integer>, JpaSpecificationExecutor<TransKpiIndikator> {
}
