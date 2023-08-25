package com.kentoes.kpi.webflux.repositories.trans;

import com.kentoes.kpi.webflux.entities.trans.TransKpiUraian;
import com.kentoes.kpi.webflux.entities.trans.TransKpiUraianFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface TransKpiUraianFileRepository extends JpaRepository<TransKpiUraianFile, Integer>, JpaSpecificationExecutor<TransKpiUraianFile> {
    Optional<TransKpiUraianFile> findByPeriodeAndNipamAndTransKpiUraian_IdAndFileName(Integer periode, String nipam, Integer transKpiUraianId, String fileName);

    List<TransKpiUraianFile> findByTransKpiUraian_Id(Integer id);

    Optional<TransKpiUraianFile> findByPeriodeAndNipamAndTransKpiUraianAndFileName(Integer periode, String nipam, TransKpiUraian byId, String fileName);
}
