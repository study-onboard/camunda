package com.sanlea.study.camunda.cases.user_task.domain;

import com.sanlea.study.camunda.support.BaseEntityDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FormDTO extends BaseEntityDTO {
    private String requester;
    private String data;
    private FormStatus status;
    private String uploadTaskId;
    private String approvalTaskId;
}
