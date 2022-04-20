package com.sanlea.study.camunda.cases.simple;

import org.camunda.bpm.engine.RuntimeService;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;
import java.util.HashMap;

@Path("/case/simple")
public class SimpleEndpoints {

    @Inject
    RuntimeService runtimeService;

    @Path("/start")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String start(@QueryParam("name") @NotNull String name) {
        var variables = new HashMap<String, Object>();
        variables.put(Constant.VAR_KEY_TASK_NAME, name);
        runtimeService.startProcessInstanceByKey(
                Constant.PROCESS_DEFINITION_KEY, variables
        );
        return "OK - " + LocalDateTime.now();
    }
}
