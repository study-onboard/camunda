package com.sanlea.study.camunda.support;

import io.quarkus.runtime.StartupEvent;
import org.camunda.bpm.engine.RepositoryService;
import org.jboss.logging.Logger;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import static java.text.MessageFormat.format;

public abstract class BaseSteward {
    private final String processDefinitionKey;
    private final String processDefinitionVersion;
    private final String processDefinitionResourceName;

    protected BaseSteward(String processDefinitionKey,
                          String processDefinitionVersion,
                          String processDefinitionResourceName) {
        this.processDefinitionKey = processDefinitionKey;
        this.processDefinitionVersion = processDefinitionVersion;
        this.processDefinitionResourceName = processDefinitionResourceName;
    }

    @Inject
    RepositoryService repositoryService;

    @Inject
    Logger logger;

    public void onApplicationStartup(@Observes StartupEvent event) {
        var definition = repositoryService.createProcessDefinitionQuery()
                .processDefinitionKey(processDefinitionKey)
                .versionTag(processDefinitionVersion)
                .singleResult();
        if (definition == null) {
            logger.info(format("Deploy process definition {0} - {1}", processDefinitionKey, processDefinitionVersion));
            repositoryService.createDeployment()
                    .addClasspathResource(format("bpmn/{0}", processDefinitionResourceName))
                    .deploy();
        }
    }
}
