The file 'slf4j-jdk14-1.7.12.jar' is renamed into 'slf4j-jdk14-1.7.12.jar_original'
because it contains classes from package 'org.slf4j.impl' which also exist in the file
'logback-classic-1.1.6.jar' in folder '../pdfunit-2016.05_java-1.7/lib/tess4j-3.1.0'.

That produces a recursion with StackOverflow:
...
at org.slf4j.impl.JDK14LoggerAdapter.log(JDK14LoggerAdapter.java:574)
at org.slf4j.impl.JDK14LoggerAdapter.log(JDK14LoggerAdapter.java:648)
at org.slf4j.bridge.SLF4JBridgeHandler.callLocationAwareLogger(SLF4JBridgeHandler.java:221)
at org.slf4j.bridge.SLF4JBridgeHandler.publish(SLF4JBridgeHandler.java:303)
at java.util.logging.Logger.log(Logger.java:616)
at org.slf4j.impl.JDK14LoggerAdapter.log(JDK14LoggerAdapter.java:578)
at org.slf4j.impl.JDK14LoggerAdapter.log(JDK14LoggerAdapter.java:648)
at org.slf4j.bridge.SLF4JBridgeHandler.callLocationAwareLogger(SLF4JBridgeHandler.java:221)
at org.slf4j.bridge.SLF4JBridgeHandler.publish(SLF4JBridgeHandler.java:303)
at java.util.logging.Logger.log(Logger.java:616)
...
