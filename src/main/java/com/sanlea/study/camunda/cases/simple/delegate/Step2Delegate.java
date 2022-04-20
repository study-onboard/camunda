package com.sanlea.study.camunda.cases.simple.delegate;

import com.sanlea.study.camunda.cases.simple.Constant;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ApplicationScoped
@Named("simple_step2_delegate")
public class Step2Delegate  implements JavaDelegate {

    @Inject
    Logger logger;

    @Override
    public void execute(DelegateExecution execution) {
        logger.info("simple - step 2 - " + execution.getVariable(Constant.VAR_KEY_TASK_NAME));
    }
}