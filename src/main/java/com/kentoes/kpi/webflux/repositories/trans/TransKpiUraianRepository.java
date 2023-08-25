package com.kentoes.kpi.webflux.repositories.trans;

import com.kentoes.kpi.webflux.entities.trans.TransKpiUraian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TransKpiUraianRepository extends JpaRepository<TransKpiUraian, Integer>, JpaSpecificationExecutor<TransKpiUraian> {
}
