package com.sanlea.study.camunda.cases.user_task.listener;

import com.sanlea.study.camunda.cases.user_task.Constant;
import com.sanlea.study.camunda.cases.user_task.domain.FormManager;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import static java.text.MessageFormat.format;

@ApplicationScoped
@Named("user_task_approval_task_listener")
public class ApprovalTaskListener implements TaskListener {

    @Inject
    FormManager formManager;

    @Inject
    Logger logger;

    @Override
    public void notify(DelegateTask delegateTask) {
        var formId = (String) delegateTask.getVariable(Constant.VAR_KEY_FORM_ID);

        logger.info(format("Approving for form: {0} - {1}", formId, delegateTask.getId()));
        formManager.startApproval(formId, delegateTask.getId());
    }
}
