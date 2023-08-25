package com.kentoes.kpi.webflux.dto.trans.transKpiUraian;

import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.trans.TransKpiUraian;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransKpiUraianPutRequest {
    @NotNull(message = "id is required")
    @Min(value = 1, message = "id must be greater than 0")
    private Integer id;
    @NotNull(message = "Capaian Volume is required")
    private Float capaianVolume;
    @NotBlank(message = "Capaian Satuan is required")
    private String capaianSatuan;
    @NotBlank(message = "Capaian Waktu is required")
    private String capaianWaktu;
    @NotNull(message = "Nilai Produk Kerja is required")
    private Float nilaiProdukKerja;
    @NotNull(message = "Nilai Waktu is required")
    private Float nilaiWaktu;
    @NotNull(message = "Nilai Total Uraian is required")
    private Float nilaiTotalUraian;
    @Enumerated(EnumType.STRING)
    private EStatus status = EStatus.Enabled;

    public static TransKpiUraian toEntity(
            TransKpiUraian entity, TransKpiUraianPutRequest request, String updatedBy
    ) {
        entity.setCapaianVolume(request.getCapaianVolume());
        entity.setCapaianSatuan(request.getCapaianSatuan());
        entity.setCapaianWaktu(request.getCapaianWaktu());
        entity.setNilaiProdukKerja(request.getNilaiProdukKerja());
        entity.setNilaiWaktu(request.getNilaiWaktu());
        entity.setNilaiTotalUraian(request.getNilaiTotalUraian());
        entity.setStatus(request.getStatus());
        entity.setUpdatedBy(updatedBy);
        return entity;
    }
}
