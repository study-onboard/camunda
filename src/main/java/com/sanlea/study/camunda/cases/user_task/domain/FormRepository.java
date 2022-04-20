package com.sanlea.study.camunda.cases.user_task.domain;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FormRepository implements PanacheRepositoryBase<Form, String> {
}
