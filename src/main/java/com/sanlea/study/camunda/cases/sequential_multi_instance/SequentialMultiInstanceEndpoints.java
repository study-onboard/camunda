package com.sanlea.study.camunda.cases.sequential_multi_instance;

import org.camunda.bpm.engine.RuntimeService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.UUID;

@Path("/case/sequential-multi-instance")
public class SequentialMultiInstanceEndpoints {

    @Inject
    RuntimeService runtimeService;

    @Path("/start")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String start() {
        var variables = new HashMap<String, Object>();
        variables.put(Constant.VAR_KEY_TASK_ID, UUID.randomUUID().toString());
        runtimeService.startProcessInstanceByKey(Constant.PROCESS_DEFINITION_KEY, variables);
        return "OK - " + LocalDateTime.now();
    }
}
