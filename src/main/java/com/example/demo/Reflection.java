package com.example.demo;

public class Reflection {
    public DemoApplication getDemo() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class classz = Class.forName("com.example.demo.DemoApplication");
        return (DemoApplication) classz.newInstance();
    }
}
