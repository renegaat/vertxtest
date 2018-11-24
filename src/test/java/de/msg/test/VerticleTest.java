package de.msg.test;

import de.msg.vertxtest.Service;
import de.msg.vertxtest.VerticleOne;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(VertxUnitRunner.class)
public class VerticleTest {

    private Vertx vertx;
    
    @Before
    public void setup() {
        vertx = Vertx.vertx();
        vertx.deployVerticle(new VerticleOne());
    }
    
    @After
    public void cleanUp() {
        vertx.close();
    }
    
    @Test
    public void VerticleOneTest(TestContext testContext) {

        Async async = testContext.async();
        
        vertx.eventBus().send(Service.VERTICLE_SERVICE_ONE.toString(), new JsonObject(), messageAsyncResult -> {
            testContext.assertEquals(messageAsyncResult.result().body(),
                    new JsonObject().put("key","value")
                    );
            async.complete();
        });
    }
}
