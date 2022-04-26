package com.sanlea.study.camunda.cases.event.event_base_gateway.delegate;

import com.sanlea.study.camunda.cases.event.event_base_gateway.Constant;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import static java.text.MessageFormat.format;

@ApplicationScoped
@Named("event_base_gateway_start_work")
public class StartWorkDelegate implements JavaDelegate {

    @Inject
    Logger logger;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        logger.info(format("Start work for task: {0}", execution.getVariable(Constant.VAR_KEY_TASK_ID)));
    }
}
