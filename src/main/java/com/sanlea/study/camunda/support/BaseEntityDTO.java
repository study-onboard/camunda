package com.sanlea.study.camunda.support;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(of = "id")
@RegisterForReflection
public abstract class BaseEntityDTO {
    // ID
    private String id;

    // create datetime
    protected LocalDateTime createDatetime;

    // update datetime
    protected LocalDateTime updateDatetime;
}
