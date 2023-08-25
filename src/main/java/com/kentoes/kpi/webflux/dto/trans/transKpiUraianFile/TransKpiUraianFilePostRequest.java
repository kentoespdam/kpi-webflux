package com.kentoes.kpi.webflux.dto.trans.transKpiUraianFile;

import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.trans.TransKpiUraian;
import com.kentoes.kpi.webflux.entities.trans.TransKpiUraianFile;
import com.kentoes.kpi.webflux.utils.UploadResultUtil;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransKpiUraianFilePostRequest implements Serializable {
    @NotNull(message = "Periode is required")
    @Min(value = 1, message = "Periode must be greater than 0")
    protected Integer periode;
    @NotBlank(message = "Nipam is required")
    protected String nipam;
    @NotNull(message = "TransKpiUraianId is required")
    @Min(value = 1, message = "TransKpiUraianId must be greater than 0")
    protected Integer transKpiUraianId;
    @NotNull(message = "File is required")
    protected MultipartFile file;

    public static TransKpiUraianFile toEntity(
            TransKpiUraianFilePostRequest request,
            UploadResultUtil uploadResultUtil,
            TransKpiUraian transKpiUraian,
            String createdBy
    ) {
        TransKpiUraianFile entity = new TransKpiUraianFile();
        entity.setTransKpiUraian(transKpiUraian);
        entity.setNipam(request.getNipam());
        entity.setPeriode(request.getPeriode());
        entity.setFileName(uploadResultUtil.getFileName());
        entity.setFileType(uploadResultUtil.getFileType());
        entity.setMimeType(uploadResultUtil.getMimeType());
        entity.setHashedFileName(uploadResultUtil.getHashedFileName());
        entity.setStatus(EStatus.Enabled);
        entity.setCreatedBy(createdBy);
        return entity;
    }

}