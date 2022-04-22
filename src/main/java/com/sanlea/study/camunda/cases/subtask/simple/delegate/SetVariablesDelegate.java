package com.sanlea.study.camunda.cases.subtask.simple.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.UUID;

import static com.sanlea.study.camunda.cases.subtask.simple.Constant.VAR_KEY_NEW_VAR;
import static java.text.MessageFormat.format;

@ApplicationScoped
@Named("subtask_simple_set_variables_delegate")
public class SetVariablesDelegate implements JavaDelegate {
    @Inject
    Logger logger;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        var newVar = UUID.randomUUID().toString();
        logger.info(format("New variable in subtask: {0}", newVar));
        execution.setVariableLocal(VAR_KEY_NEW_VAR, newVar);
    }
}
