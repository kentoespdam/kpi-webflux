package com.kentoes.kpi.webflux.dto.master.mPerilaku;

import com.kentoes.kpi.webflux.dto.commons.AuditDto;
import com.kentoes.kpi.webflux.entities.enums.EStatus;
import com.kentoes.kpi.webflux.entities.master.MPerilaku;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MPerilakuWithAuditDto extends AuditDto {
    private Integer id;
    private Integer urut;
    private String kompetensi;
    private String uraian;
    @Enumerated(EnumType.STRING)
    private EStatus status;

    public MPerilakuWithAuditDto(Integer id, Integer urut, String kompetensi, String uraian, EStatus status, LocalDateTime createdAt,
                                 String createdBy, LocalDateTime updatedAt, String updatedBy) {
        super(createdAt, createdBy, updatedAt, updatedBy);
        this.id = id;
        this.urut = urut;
        this.kompetensi = kompetensi;
        this.uraian = uraian;
        this.status = status;
    }

    public static MPerilakuWithAuditDto fromEntity(MPerilaku entity) {
        return new MPerilakuWithAuditDto(
                entity.getId(),
                entity.getUrut(),
                entity.getKompetensi(),
                entity.getUraian(),
                entity.getStatus(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getUpdatedAt(),
                entity.getUpdatedBy());
    }

    public static Page<MPerilakuWithAuditDto> from(Page<MPerilaku> entities) {
        return entities.map(MPerilakuWithAuditDto::fromEntity);
    }
}