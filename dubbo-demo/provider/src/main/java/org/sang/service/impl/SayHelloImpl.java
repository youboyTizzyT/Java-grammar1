package org.sang.service.impl;

import org.sang.SayHello;

public class SayHelloImpl implements SayHello {
    @Override
    public String sayHello(String name) {
        return "hello"+name;
    }
}
