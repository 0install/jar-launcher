JAR Launcher
============

A launcher that starts the main class specified in a JAR while preserving the CLASSPATH.
Workaround for `java -classpath ... -jar ...` which does not work.

This is useful for injecting dependencies at runtime, e.g. when using [Zero Install](http://0install.net/).

CI Builds:  
[![Windows](https://img.shields.io/appveyor/ci/0install/jar-launcher.svg?label=Windows)](https://ci.appveyor.com/project/0install/jar-launcher)
[![Linux](https://img.shields.io/travis/0install/jar-launcher.svg?label=Linux)](https://travis-ci.org/0install/jar-launcher)

Building
--------
Run `mvn package` to generate `target/jar-launcher-X.Y.jar`.

Usage
-----
You can manually invoke jar-launcher like this:
```
java -classpath target/jar-launcher-X.Y.jar:Application.jar:/directory/containing/library net.zeroinstall.jar.launcher.JarLauncher Application.jar
```
Note: Using jar-launcher disables all the default classpath handling for JARs. Therefore, the classpath _must_ explicitly list the jar-launcher JAR and the Application JAR.

jar-launcher is usually used in [Zero Install feeds](http://0install.net/interface-spec.html) like this:
```xml
<command name="run" path="Application.jar" />
	<runner interface="http://0install.de/feeds/jar-launcher.xml" />
</command>
<environment name="CLASSPATH" insert="Application.jar" />
<requires interface="http://some/library.xml">
	<environment name="CLASSPATH" insert="Library.jar" />
</requires>
```
