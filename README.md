jar-launcher
============

A launcher that starts the main class specified in a JAR while preserving the CLASSPATH.
Workaround for `java -classpath ... -jar ...` which does not work.

This is useful for injecting dependencies at runtime, e.g. when using [Zero Install](http://0install.net/).

Building
--------
Run `mvn package` to generate `target/jar-launcher-1.0-SNAPSHOT.jar`.

Usage
-----
You can manually invoke jar-launcher like this:
```
java -classpath target/jar-launcher-1.0-SNAPSHOT.jar:Application.jar:/directory/containing/library de.nanobyte.jar.JarLauncher Application.jar
```
Note: Using jar-launcher disables all the default classpath handling for JARs. Therefore, the classpath _must_ explicitly list the jar-launcher JAR and the Application JAR.
```
