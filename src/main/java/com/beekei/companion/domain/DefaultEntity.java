package com.beekei.companion.domain;

import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class DefaultEntity {

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", nullable = false, updatable = false)
    private Date created;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date", insertable = false)
    private Date updated;

    @Column(name = "isDeleted", columnDefinition = "BIT(1) DEFAULT 0", nullable = false)
    private boolean isDeleted;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "deleted_date", insertable = false)
    private Date deleted;

    private LocalDateTime convertLocalDateTime(Date date) {
        return new Timestamp(date.getTime()).toLocalDateTime();
    }

    public LocalDateTime getCreated() {
        return this.convertLocalDateTime(this.created);
    }

    public LocalDateTime getUpdated() {
        return this.convertLocalDateTime(this.updated);
    }

    public LocalDateTime getDeleted() {
        return this.convertLocalDateTime(this.deleted);
    }

}
