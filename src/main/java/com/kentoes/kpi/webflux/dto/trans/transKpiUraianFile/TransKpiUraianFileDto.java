package com.kentoes.kpi.webflux.dto.trans.transKpiUraianFile;

import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.trans.TransKpiUraianFile;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransKpiUraianFileDto implements Serializable {
    private Integer id;
    private String nipam;
    private String fileName;
    private String fileType;
    @Enumerated(EnumType.STRING)
    private EStatus status;

    public static TransKpiUraianFileDto fromEntity(TransKpiUraianFile entity) {
        TransKpiUraianFileDto dto = new TransKpiUraianFileDto();
        dto.setId(entity.getId());
        dto.setNipam(entity.getNipam());
        dto.setFileName(entity.getFileName());
        dto.setFileType(entity.getFileType());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public static List<TransKpiUraianFileDto> from(List<TransKpiUraianFile> transKpiUraianFilesList) {
        return transKpiUraianFilesList.stream().map(TransKpiUraianFileDto::fromEntity).toList();
    }
}
