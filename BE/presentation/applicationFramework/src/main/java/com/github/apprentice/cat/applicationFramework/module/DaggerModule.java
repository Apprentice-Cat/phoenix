package com.github.apprentice.cat.applicationFramework.module;

import com.github.apprentice.cat.applicationFramework.verticle.BaseVerticle;
import com.github.apprentice.cat.applicationFramework.verticle.DaggerVerticleFactory;
import com.github.apprentice.cat.applicationFramework.verticle.TestVerticle;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import io.vertx.core.Verticle;
import io.vertx.core.spi.VerticleFactory;

import javax.inject.Provider;
import javax.inject.Singleton;
import java.util.Map;

@Module
public class DaggerModule {
    @Provides
    @Singleton
    public VerticleFactory providerVerticleFactory(Map<String, Provider<BaseVerticle>> verticleMap){
        return new DaggerVerticleFactory(verticleMap);
    }
    @Provides
    @IntoMap
    @StringKey(value = "com.github.apprentice.cat.applicationFramework.verticle.TestVerticle")
    public BaseVerticle providerTestVerticle(){
        return new TestVerticle();
    }
}
