package com.sambaash.platform.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public final class ClassLoaderUtil {

	private ClassLoaderUtil() {
		// Cannot instantiate
	}
	
	public static List<Class<?>> getClassesInPackage(String packageName) throws ClassNotFoundException, IOException {
		return getClassesInClassLoaderAndPackage(Thread.currentThread().getContextClassLoader(), packageName);
	}
	
	public static List<Class<?>> getClassesInPackage(String packageName, Class<?> assignableClazz) throws ClassNotFoundException, IOException {
		return getClassesInClassLoaderAndPackage(Thread.currentThread().getContextClassLoader(), packageName, assignableClazz);
	}
	
	public static List<Class<?>> getClassesInClassLoaderAndPackage(ClassLoader classLoader, String packageName) 
			throws ClassNotFoundException, IOException 
	{
		return getClassesInClassLoaderAndPackage(classLoader, packageName, null);
	}
	
	public static List<Class<?>> getClassesInClassLoaderAndPackage(ClassLoader classLoader, String packageName, Class<?> assignableClazz) 
			throws ClassNotFoundException, IOException 
	{
		String path = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        List<Class<?>> classes = new ArrayList<>();
        for (File directory : dirs) {
            classes.addAll(findClasses(classLoader, directory, packageName, assignableClazz));
        }
		return classes;
	}
	
	/**
     * Recursive method used to find all classes in a given directory and subdirs.
     *
     * @param directory   The base directory
     * @param packageName The package name for classes found inside the base directory
     * @param assignableClazz Include only classes that can be cast to this class or interface
     * @return The classes
     * @throws ClassNotFoundException
     */
    private static List<Class<?>> findClasses(ClassLoader classLoader, File directory, String packageName, Class<?> assignableClazz) throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(classLoader, file, packageName + "." + file.getName(), assignableClazz));
            } else if (file.getName().endsWith(".class")) {
            	Class<?> clazz = classLoader.loadClass(packageName + '.' + file.getName().substring(0, file.getName().length() - 6));
                if (assignableClazz == null || assignableClazz.isAssignableFrom(clazz)) 
                {
                	classes.add(clazz);
                }
            }
        }
        return classes;
    }

}
