package com.github.apprentice.cat.applicationFramework;

import com.github.apprentice.cat.applicationFramework.module.DaggerModule;
import com.github.apprentice.cat.applicationFramework.module.VertxModule;
import dagger.Component;
import io.vertx.core.Vertx;

import javax.inject.Inject;
import javax.inject.Singleton;

public class Main {
    @Inject
    Vertx vertx;
    public static void main(String[] args) {
        var app = new Main();
//        DaggerMain_MainComponent.create().inject(app);
    }

//    @Singleton
//    @Component(modules = {VertxModule.class, DaggerModule.class})
//    interface MainComponent {
//        void inject(Main mainVerticle);
//    }

}