package org.learn.lra.apigateway.core;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;
import org.learn.lra.coreapi.Action;
import org.learn.lra.coreapi.LRA;
import org.learn.lra.coreapi.LRAResult;
import org.learn.lra.coreapi.Result;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class LRAExecutor {

    private static final Logger log = Logger.getLogger(LRAExecutor.class);

//    private ExecutorService executorService = Executors.newFixedThreadPool(5);

    @Inject
    @ConfigProperty(name = "lra.order.url", defaultValue = "order-service")
    private String orderUrl;

    public LRAResult processLRA(LRA lra) {

        log.infof("Processing LRA %s", lra);

        lra.getActions().forEach(this::executeAction);

        return new LRAResult(lra, Result.COMPLETED);

    }

    private void executeAction(Action action) {
        log.infof("executing action - %s", action);



    }

//    public Future<String> processLRA(LRA lra) {
//
//        log.infof("Processing LRA %s with id - %s", lra.getName(), lra.getId());
//        return executorService.submit(new LRAWorker(lra));
//    }
}