package com.kentoes.kpi.webflux.repositories.master;

import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.master.MIndikator;
import com.kentoes.kpi.webflux.entities.master.MUraianIndikator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface MUraianIndikatorRepository extends JpaRepository<MUraianIndikator, Integer>, JpaSpecificationExecutor<MUraianIndikator> {

    Optional<MUraianIndikator> findByIdAndStatusNot(Integer id, EStatus deleted);

    Optional<MUraianIndikator> findByIndikator_IdAndUraianAndVolumeAndBobotAndStatusNot(Integer indikatorId, String uraian, Float volume, Float bobot, EStatus deleted);

    List<MUraianIndikator> findByIndikator(MIndikator indikator);

    List<MUraianIndikator> findByIndikator_IdAndStatus(Integer id, EStatus status);

}