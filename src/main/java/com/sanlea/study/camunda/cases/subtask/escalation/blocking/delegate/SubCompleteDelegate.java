package com.sanlea.study.camunda.cases.subtask.escalation.blocking.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ApplicationScoped
@Named("subtask_escalation_blocking_sub_complete_delegate")
public class SubCompleteDelegate  implements JavaDelegate {

    @Inject
    Logger logger;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        logger.info("Sub complete");
    }
}