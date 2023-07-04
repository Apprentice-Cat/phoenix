package com.github.apprentice.cat.applicationFramework;

import com.github.apprentice.cat.applicationFramework.module.DaggerModule;
import com.github.apprentice.cat.applicationFramework.module.VertxModule;
import com.github.apprentice.cat.applicationFramework.verticle.BaseVerticle;
import dagger.Component;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.impl.VerticleManager;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import java.util.Map;
import java.util.stream.IntStream;

public class Main {
    @Inject
    Vertx vertx;
    @Inject
    Map<String, Provider<BaseVerticle>> verticleMap;
    public static void main(String[] args) {
        var app = new Main();
        DaggerMain_MainComponent.create().inject(app);
        app.getMap();

    }

    @Singleton
    @Component(modules = {VertxModule.class, DaggerModule.class})
    interface MainComponent {
        void inject(Main mainVerticle);
    }
    public void getMap(){
        verticleMap.forEach((k,v)->{
            IntStream.range(0,6).forEach(value -> {
                vertx.deployVerticle("service:"+k);
            });

        });
    }

}