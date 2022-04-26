package com.sanlea.study.camunda.cases.sequential_multi_instance.delegate;

import com.sanlea.study.camunda.cases.sequential_multi_instance.Constant;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import static java.text.MessageFormat.format;

@ApplicationScoped
@Named("sequential_multi_instance_rollback")
public class RollbackDelegate  implements JavaDelegate {

    @Inject
    Logger logger;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        var taskId = execution.getVariable(Constant.VAR_KEY_TASK_ID);
        logger.info(format("Rollback for task {0}", taskId));
    }
}