package com.kentoes.kpi.webflux.entities.trans;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kentoes.kpi.webflux.entities.IdsAbstract;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "trans_kpi_uraian_file")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = "transKpiUraian", callSuper = true)
public class TransKpiUraianFile extends IdsAbstract {
    private String nipam;
    private Integer periode;
    private String fileName;
    private String fileType;
    private String mimeType;
    private String hashedFileName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trans_kpi_uraian_id")
    @JsonBackReference
    private TransKpiUraian transKpiUraian;
}
