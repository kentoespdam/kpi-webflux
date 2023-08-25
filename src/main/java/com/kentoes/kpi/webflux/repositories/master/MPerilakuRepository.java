package com.kentoes.kpi.webflux.repositories.master;

import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.master.MPerilaku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface MPerilakuRepository extends JpaRepository<MPerilaku, Integer>, JpaSpecificationExecutor<MPerilaku> {

    Optional<MPerilaku> findByIdAndStatusNot(Integer id, EStatus deleted);

    Optional<MPerilaku> findByKompetensiAndUraianAndStatusNot(String kompetensi, String uraian, EStatus deleted);
}
