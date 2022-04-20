package com.sanlea.study.camunda.cases.user_task.endpoints;

import com.sanlea.study.camunda.cases.user_task.Constant;
import com.sanlea.study.camunda.cases.user_task.domain.FormManager;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;

import static java.text.MessageFormat.format;

@Path("/case/user-task")
public class UserTaskEndpoints {

    @Inject
    FormManager formManager;

    @Inject
    RuntimeService runtimeService;

    @Inject
    TaskService taskService;

    @Inject
    Logger logger;

    @Path("/submit")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String submit(@Valid UserTaskForm formData) {
        var form = formManager.submit(formData.getRequester(), formData.getData());

        var variables = new HashMap<String, Object>();
        variables.put(Constant.VAR_KEY_FORM_ID, form.getId());
        runtimeService.startProcessInstanceByKey(
                Constant.PROCESS_DEFINITION_KEY, variables
        );
        logger.info(format("Form {0} submitted", form.getId()));
        return "Submit OK";
    }

    @Path("/{id}/complete/upload")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String completeUpload(@PathParam("id") String id) {
        var form = formManager.fetchDetail(id);
        formManager.completeUpload(id);
        taskService.complete(form.getUploadTaskId());
        logger.info(format("Form {0} upload complete", id));
        return "Upload OK";
    }

    @Path("/{id}/complete/approval")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String completeApproval(@PathParam("id") String id) {
        var form = formManager.fetchDetail(id);
        formManager.completeApproval(id);
        taskService.complete(form.getApprovalTaskId());
        logger.info(format("Form {0} approval complete", id));
        return "Approval OK";
    }
}
