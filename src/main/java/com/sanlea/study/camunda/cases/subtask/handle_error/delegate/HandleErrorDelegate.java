package com.sanlea.study.camunda.cases.subtask.handle_error.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import static java.text.MessageFormat.format;

@ApplicationScoped
@Named("subtask_handle_error_handle_error_delegate")
public class HandleErrorDelegate implements JavaDelegate {
    @Inject
    Logger logger;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        logger.info(format("Catch error: {0}", execution.getVariables()));
    }
}
