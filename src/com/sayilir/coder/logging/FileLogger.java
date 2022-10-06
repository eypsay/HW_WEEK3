package com.sayilir.coder.logging;

public class FileLogger implements Logger {
    @Override
    public void log(String data) {
        System.out.println("Dosyaya loglandı " + data);
    }
}
