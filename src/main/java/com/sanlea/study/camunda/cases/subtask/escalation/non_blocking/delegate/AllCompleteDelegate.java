package com.sanlea.study.camunda.cases.subtask.escalation.non_blocking.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import static java.text.MessageFormat.format;

@ApplicationScoped
@Named("subtask_escalation_non_blocking_all_complete_delegate")
public class AllCompleteDelegate  implements JavaDelegate {

    @Inject
    Logger logger;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        logger.info(format("Main all complete: {0}", execution.getVariables()));
    }
}