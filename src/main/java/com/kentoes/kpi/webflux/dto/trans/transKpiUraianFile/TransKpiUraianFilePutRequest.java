package com.kentoes.kpi.webflux.dto.trans.transKpiUraianFile;

import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.trans.TransKpiUraian;
import com.kentoes.kpi.webflux.entities.trans.TransKpiUraianFile;
import com.kentoes.kpi.webflux.utils.UploadResultUtil;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransKpiUraianFilePutRequest extends TransKpiUraianFilePostRequest {
    @NotNull(message = "Id is required")
    @Min(value = 1, message = "Id must be greater than 0")
    private Integer id;

    public static TransKpiUraianFile toEntity(
            TransKpiUraianFilePutRequest request, UploadResultUtil uploadResultUtil,
            TransKpiUraian transKpiUraian, String updatedBy
    ) {
        TransKpiUraianFile entity = new TransKpiUraianFile();
        entity.setId(request.getId());
        entity.setTransKpiUraian(transKpiUraian);
        entity.setNipam(request.getNipam());
        entity.setPeriode(request.getPeriode());
        entity.setFileName(uploadResultUtil.getFileName());
        entity.setFileType(uploadResultUtil.getFileType());
        entity.setMimeType(uploadResultUtil.getMimeType());
        entity.setHashedFileName(uploadResultUtil.getHashedFileName());
        entity.setStatus(EStatus.Enabled);
        entity.setUpdatedBy(updatedBy);
        return entity;
    }

    public static TransKpiUraianFile toEntity(
            TransKpiUraianFile entity, UploadResultUtil uploadResultUtil, String updatedBy
    ) {
        entity.setFileName(uploadResultUtil.getFileName());
        entity.setFileType(uploadResultUtil.getFileType());
        entity.setMimeType(uploadResultUtil.getMimeType());
        entity.setHashedFileName(uploadResultUtil.getHashedFileName());
        entity.setUpdatedBy(updatedBy);
        return entity;
    }
}
