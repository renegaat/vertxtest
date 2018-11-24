package de.msg.vertxtest;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public class VerticleOne extends AbstractVerticle {

    final private Logger logger = LoggerFactory.getLogger(VerticleOne.class);
    
    @Override
    public void start(Future<Void> startFuture){
        vertx.eventBus().consumer(Service.VERTICLE_SERVICE_ONE.toString(), this::handleMessage);
        startFuture.complete();
    }
    
    @Override
    public void stop() throws Exception {
        super.stop();
    }
    
    private void handleMessage(Message<Object> message) {
        logger.info("VerticleOne handleMessage");
        message.reply(new JsonObject().put("key", "value"));
    }
}
