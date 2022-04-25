package com.sanlea.study.camunda.cases.subtask.escalation.non_blocking;

import org.camunda.bpm.engine.RuntimeService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;

@Path("/case/subtask/escalation/non-blocking")
public class HandleSubtaskNonBlockingEscalationEndpoints {
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
