package com.github.apprentice.cat.applicationFramework.module;

import com.github.apprentice.cat.applicationFramework.verticle.DaggerVerticleFactory;
import dagger.Module;
import dagger.Provides;
import io.vertx.core.Verticle;
import io.vertx.core.spi.VerticleFactory;

import javax.inject.Provider;
import javax.inject.Singleton;
import java.util.Map;

@Module
public class DaggerModule {
    @Provides
    @Singleton
    public VerticleFactory providerVerticleFactory(Map<String, Provider<Verticle>> verticleMap){
        return new DaggerVerticleFactory(verticleMap);
    }
}
