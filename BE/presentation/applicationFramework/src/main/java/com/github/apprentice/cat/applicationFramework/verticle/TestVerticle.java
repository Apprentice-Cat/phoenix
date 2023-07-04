package com.github.apprentice.cat.applicationFramework.verticle;

public class TestVerticle extends BaseVerticle{
    @Override
    public void start() throws Exception {

        System.out.println(config().getString("foo"));
        System.out.println("test");
    }
}
