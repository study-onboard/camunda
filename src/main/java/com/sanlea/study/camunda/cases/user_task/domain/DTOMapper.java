package com.sanlea.study.camunda.cases.user_task.domain;

import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface DTOMapper {
    FormDTO map(Form form);
}
