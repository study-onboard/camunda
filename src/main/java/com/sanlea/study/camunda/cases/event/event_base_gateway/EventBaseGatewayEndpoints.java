package com.sanlea.study.camunda.cases.event.event_base_gateway;

import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.UUID;

@Path("/case/event-base-gateway")
public class EventBaseGatewayEndpoints {

    @Inject
    RuntimeService runtimeService;

    @Inject
    RepositoryService repositoryService;

    @Path("/start")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String start() {
        var variables = new HashMap<String, Object>();
        variables.put(Constant.VAR_KEY_TASK_ID, UUID.randomUUID().toString());
        var processInstance = runtimeService.startProcessInstanceByKey(
                Constant.PROCESS_DEFINITION_KEY,
                variables
        );
        return "OK - " + processInstance.getId();
    }

    @Path("/change_approver")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String changeApprover() {
        var processDefinition = repositoryService.createProcessDefinitionQuery()
                .processDefinitionKey(Constant.PROCESS_DEFINITION_KEY)
                .versionTag(Constant.PROCESS_DEFINITION_VERSION)
                .singleResult();
        runtimeService.startProcessInstanceByMessageAndProcessDefinitionId(
                "START_CHANGE_APPROVER",
                processDefinition.getId()
        );
        return "OK - " + LocalDateTime.now();
    }

    @Path("/send-approval-result")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String sendApprovalResult(@QueryParam("result") boolean accept,
                                     @QueryParam("piid") String processInstanceId) {
        var variables = new HashMap<String, Object>();
        variables.put("APPROVAL_RESULT", accept ? "ACCEPT" : "REJECT");

        runtimeService.createMessageCorrelation("APPROVAL_RESULT_MESSAGE")
                .processInstanceId(processInstanceId)
                .setVariables(variables)
                .correlate();
        return "OK - " + LocalDateTime.now();
    }
}
