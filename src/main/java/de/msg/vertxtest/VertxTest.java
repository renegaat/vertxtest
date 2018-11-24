package de.msg.vertxtest;

import io.vertx.core.Vertx;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

/**
 * insert lombok
 *
 * create main method shortcut -> psvm 

 * deploy verticle one
 *
 * Verticle One is registered as consumer to service and returns some json object
 *
 */

public class VertxTest {
    public static void main(String[] args) {

        final Logger logger = LoggerFactory.getLogger(VertxTest.class);

        final Vertx vertx = Vertx.vertx();

        // deploy verticle with some code to test  

        vertx.deployVerticle(new VerticleOne(),stringAsyncResult -> {
            if(stringAsyncResult.succeeded()){
                logger.info("Verticle One deployed");
            }else{
                logger.error("Verticle One not deployed");
            }
        });

    }
}
