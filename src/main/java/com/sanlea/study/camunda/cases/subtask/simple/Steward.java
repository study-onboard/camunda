package com.sanlea.study.camunda.cases.subtask.simple;

import com.sanlea.study.camunda.support.BaseSteward;
import io.quarkus.runtime.Startup;

import javax.enterprise.context.ApplicationScoped;

import static com.sanlea.study.camunda.cases.subtask.simple.Constant.*;

@ApplicationScoped
@Startup
public class Steward extends BaseSteward {
    public Steward() {
        super(PROCESS_DEFINITION_KEY, PROCESS_DEFINITION_VERSION, PROCESS_DEFINITION_RESOURCE_NAME);
    }
}
