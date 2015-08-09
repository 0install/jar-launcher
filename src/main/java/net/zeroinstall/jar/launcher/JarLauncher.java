package net.zeroinstall.jar.launcher;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.jar.JarFile;

public class JarLauncher {

    public static void main(final String[] arguments) throws IOException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        final String jarFilePath = arguments[0];
        final String[] targetArguments = (String[]) Arrays.copyOfRange(arguments, 1, arguments.length);

        final String mainClass = new JarFile(jarFilePath).getManifest().getMainAttributes().getValue("Main-Class");
        launchMain(mainClass, targetArguments);
    }

    private static void launchMain(final String mainClass, final String[] targetArguments) throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Class.forName(mainClass)
                .getMethod("main", new Class[]{targetArguments.getClass()})
                .invoke(null, new Object[]{targetArguments});
    }
}
