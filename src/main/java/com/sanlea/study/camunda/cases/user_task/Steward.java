package com.sanlea.study.camunda.cases.user_task;

import com.sanlea.study.camunda.support.BaseSteward;
import io.quarkus.runtime.Startup;

import javax.enterprise.context.ApplicationScoped;

import static com.sanlea.study.camunda.cases.user_task.Constant.*;

@ApplicationScoped
@Startup
public class Steward extends BaseSteward {
    protected Steward() {
        super(PROCESS_DEFINITION_KEY, PROCESS_DEFINITION_VERSION, PROCESS_DEFINITION_RESOURCE_NAME);
    }
}
