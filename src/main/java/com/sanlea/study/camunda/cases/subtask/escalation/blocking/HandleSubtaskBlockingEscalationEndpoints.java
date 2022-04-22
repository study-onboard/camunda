package com.sanlea.study.camunda.cases.subtask.escalation.blocking;

import org.camunda.bpm.engine.RuntimeService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;

@Path("/case/subtask/escalation/blocking")
public class HandleSubtaskBlockingEscalationEndpoints {
    @Inject
    RuntimeService runtimeService;

    @Path("/start")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String start() {
        runtimeService.startProcessInstanceByKey(Constant.PROCESS_DEFINITION_KEY);
        return "OK - " + LocalDateTime.now();
    }
}
