package com.github.apprentice.cat.applicationFramework.verticle;

import io.vertx.core.Promise;
import io.vertx.core.Verticle;
import io.vertx.core.spi.VerticleFactory;
import lombok.SneakyThrows;

import javax.inject.Provider;
import java.util.Map;
import java.util.concurrent.Callable;

public class DaggerVerticleFactory implements VerticleFactory {
    private final Map<String, Provider<BaseVerticle>> verticleMap;

    public DaggerVerticleFactory(Map<String, Provider<BaseVerticle>> verticleMap) {
        this.verticleMap = verticleMap;
    }

    @Override
    public String prefix() {
        return "dagger";
    }

    @SneakyThrows
    @Override
    public void createVerticle(String verticleName, ClassLoader classLoader, Promise<Callable<Verticle>> promise) {
        final var  verticle = verticleMap.get(sanitizeVerticleClassName(verticleName));
        if (verticle==null){
            throw new IllegalArgumentException("No provider for verticle type $verticleName found");
        }
        final Callable<Verticle> callableVerticle;
        callableVerticle = getVerticleCallable((Verticle) verticle.get());
        promise.complete(callableVerticle);
    }
    private String sanitizeVerticleClassName(String verticleName){
        return verticleName.substring(verticleName.lastIndexOf(":") + 1);
    }
    private Callable<Verticle> getVerticleCallable(Verticle verticle){
        return new Callable<Verticle>() {
            @Override
            public Verticle call() throws Exception {
                return verticle;
            }
        };
    }
}
