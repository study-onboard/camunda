package com.sanlea.study.camunda.cases.subtask.handle_error.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ApplicationScoped
@Named("subtask_handle_error_start_delegate")
public class StartDelegate implements JavaDelegate {
    @Inject
    Logger logger;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        logger.info("Task start.............................");
    }
}
