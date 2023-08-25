package com.kentoes.kpi.webflux.repositories.master;


import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.master.MIndikator;
import com.kentoes.kpi.webflux.entities.master.MKpi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface MIndikatorRepository extends JpaRepository<MIndikator, Integer>, JpaSpecificationExecutor<MIndikator> {

    List<MIndikator> findByKpi_IdAndStatus(Integer id, EStatus status);

    Page<MIndikator> findByKpi_idAndStatus(Integer id, EStatus status, Pageable pageable);

    Optional<MIndikator> findByKpi_IdAndIndikator(Integer kpiId, String indikator);

    Optional<MIndikator> findByIdAndStatusNot(Integer id, EStatus deleted);

    List<MIndikator> findByKpi(MKpi mKpi);
}
