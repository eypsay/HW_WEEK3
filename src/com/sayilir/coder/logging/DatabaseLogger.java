package com.sayilir.coder.logging;

public class DatabaseLogger implements Logger {
    @Override
    public void log(String data) {
        System.out.println("DB'ye loglandı: " + data);
    }
}
