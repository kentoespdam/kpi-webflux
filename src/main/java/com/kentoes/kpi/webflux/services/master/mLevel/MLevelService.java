package com.kentoes.kpi.webflux.services.master.mLevel;

import com.kentoes.kpi.webflux.dto.commons.SavedStatus;
import com.kentoes.kpi.webflux.dto.master.mLevel.*;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MLevelService {

    List<MLevelDto> findAll(MLevelRequest request);

    MLevelDto findById(Integer id);

    Page<MLevelWithAuditDto> findPage(MLevelRequest request);

    SavedStatus<?> save(MLevelPostRequest request);

    SavedStatus<?> update(Integer id, MLevelPutRequest request);

    Boolean delete(Integer id);
}
