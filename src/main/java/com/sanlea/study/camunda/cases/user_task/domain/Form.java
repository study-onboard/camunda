package com.sanlea.study.camunda.cases.user_task.domain;

import com.sanlea.study.camunda.support.BaseEntity;
import lombok.Getter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * Order
 *
 * @author kut
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "TBL_USER_TASK_FORM")
@Getter
public class Form extends BaseEntity {
    @Column(length = 20, name = "REQUESTER", nullable = false)
    private String requester;

    @Column(name = "DATA", nullable = false)
    private String data;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private FormStatus status;

    @Column(name = "UPLOAD_TASK_ID")
    private String uploadTaskId;

    @Column(name = "APPROVAL_TASK_ID")
    private String approvalTaskId;

    public static Form create(String requester, String data) {
        var result = new Form();
        result.requester = requester;
        result.data = data;
        result.status = FormStatus.NEW;
        return result;
    }

    public void startUpload(String uploadTaskId) {
        this.uploadTaskId = uploadTaskId;
        this.status = FormStatus.UPLOADING;
    }

    public void uploadComplete() {
        this.status = FormStatus.UPLOADED;
    }

    public void startApproval(String approvalTaskId) {
        this.approvalTaskId = approvalTaskId;
        this.status = FormStatus.APPROVING;
    }

    public void approvalComplete() {
        this.status = FormStatus.APPROVED;
    }
}
