package com.github.apprentice.cat.applicationFramework.module;

import dagger.Module;
import dagger.Provides;
import io.vertx.core.Vertx;
import io.vertx.core.spi.VerticleFactory;

import javax.inject.Singleton;

@Module
public class VertxModule {
    @Provides
    @Singleton
    public Vertx providerVertx(VerticleFactory verticleFactory){
        var vertx = Vertx.vertx();
        vertx.registerVerticleFactory(verticleFactory);
        return vertx;
    }
}
