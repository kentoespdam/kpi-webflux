package com.kentoes.kpi.webflux.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@MappedSuperclass
public abstract class Audits implements Serializable {
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected LocalDateTime createdAt;
    @Column(name = "created_by", updatable = false)
    protected String createdBy;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @UpdateTimestamp
    @Column(name = "updated_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected LocalDateTime updatedAt;
    @Column(name = "updated_by")
    protected String updatedBy;

    public Audits(String createdBy, String updatedBy) {
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }
}
