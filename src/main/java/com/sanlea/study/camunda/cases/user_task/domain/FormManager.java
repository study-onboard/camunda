package com.sanlea.study.camunda.cases.user_task.domain;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class FormManager {

    @Inject
    DTOMapper dtoMapper;

    @Inject
    FormRepository repository;

    @Transactional
    public FormDTO submit(String requester, String data) {
        var form = Form.create(requester, data);
        repository.persistAndFlush(form);
        return dtoMapper.map(form);
    }

    @Transactional
    public void startUpload(String id, String taskId) {
        var form = repository.findById(id);
        form.startUpload(taskId);
        repository.persistAndFlush(form);
    }

    @Transactional
    public void completeUpload(String id) {
        var form = repository.findById(id);
        form.uploadComplete();
        repository.persistAndFlush(form);
    }

    @Transactional
    public void startApproval(String id, String taskId) {
        var form = repository.findById(id);
        form.startApproval(taskId);
        repository.persistAndFlush(form);
    }

    @Transactional
    public void completeApproval(String id) {
        var form = repository.findById(id);
        form.approvalComplete();
        repository.persistAndFlush(form);
    }

    public FormDTO fetchDetail(String id) {
        var form = repository.findById(id);
        return dtoMapper.map(form);
    }
}
