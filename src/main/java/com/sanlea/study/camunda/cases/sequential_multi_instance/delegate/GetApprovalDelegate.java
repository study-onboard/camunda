package com.sanlea.study.camunda.cases.sequential_multi_instance.delegate;

import com.sanlea.study.camunda.cases.sequential_multi_instance.Constant;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.HashMap;
import java.util.Random;

import static java.text.MessageFormat.format;

@ApplicationScoped
@Named("sequential_multi_instance_get_approval")
public class GetApprovalDelegate implements JavaDelegate {

    @Inject
    Logger logger;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        var taskId =execution.getVariable(Constant.VAR_KEY_TASK_ID);
        int iv = new Random(System.currentTimeMillis()).nextInt(30);
        logger.info(format("Get approval for task {0}: {1}", taskId, iv));

        var variables = new HashMap<String, Object>();
        switch (iv) {
            case 2 -> {
                variables.put("APPROVAL_RESULT", "ACCEPT");
                variables.put("GET_APPROVAL_COMPLETE", true);
            }
            case 1 -> {
                variables.put("APPROVAL_RESULT", "REJECT");
                variables.put("GET_APPROVAL_COMPLETE", true);
            }
            default -> {
                variables.put("APPROVAL_RESULT", "FAIL");
                variables.put("GET_APPROVAL_COMPLETE", false);
            }
        }
        execution.setVariables(variables);
    }
}
