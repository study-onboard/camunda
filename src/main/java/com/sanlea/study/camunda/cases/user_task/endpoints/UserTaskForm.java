package com.sanlea.study.camunda.cases.user_task.endpoints;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
public class UserTaskForm {
    @NotEmpty
    @Length(min = 1, max = 20)
    private String requester;

    @NotEmpty
    private String data;
}
