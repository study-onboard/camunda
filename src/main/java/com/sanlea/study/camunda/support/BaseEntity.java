package com.sanlea.study.camunda.support;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Base Entity
 *
 * @author kut
 */
@MappedSuperclass
@Getter
public abstract class BaseEntity extends PanacheEntityBase {
    // ID
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "ID", length = 36)
    private String id;

    // create datetime
    @CreationTimestamp
    @Column(nullable = false, name = "CREATE_DATETIME")
    protected LocalDateTime createDatetime;

    // update datetime
    @UpdateTimestamp
    @Column(name = "UPDATE_DATETIME")
    protected LocalDateTime updateDatetime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
