/*
 * Copyright (c) 2019, LSafer, All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * -You can edit this file (except the header).
 * -If you have change anything in this file. You
 *   shall mention that this file has been edited.
 *   By adding a new header (at the bottom of this header)
 *   with the word "Editor" on top of it.
 */

package org.cufy.util;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("JavaDoc")
final public class ReflectUtil {
	//TODO improve
	private ReflectUtil() {
		throw new AssertionError();
	}

	public static List<Field> allFields(Class<?> klass) {
		List<Field> fields = new ArrayList<>(Arrays.asList(klass.getDeclaredFields()));

		for (Class<?> cl = klass.getSuperclass(); cl != null; cl = cl.getSuperclass())
			fields.addAll(Arrays.asList(cl.getDeclaredFields()));

		return fields;
	}

	public static List<Method> allMethods(Class<?> klass) {
		List<Method> methods = new ArrayList<>(Arrays.asList(klass.getDeclaredMethods()));

		for (Class<?> cl = klass.getSuperclass(); cl != null; cl = cl.getSuperclass()) {
			List<Method> declared = new ArrayList<>(10);
			for0:
			for (Method method : cl.getDeclaredMethods()) {
				for (Method override : methods)
					if (ReflectUtil.overrides(method, override))
						continue for0;
				declared.add(method);
			}
			methods.addAll(declared);
		}

		return methods;
	}

	/**
	 * Get an array class of the given class.
	 *
	 * @param klass to get an array class of
	 * @param <C>   the targeted class
	 * @return an array class of the given class
	 */
	public static <C> Class<C[]> arrayClass(Class<C> klass) {
		return (Class<C[]>) Array.newInstance(klass, 0).getClass();
	}

	/**
	 * Get the class that extends {@link Object} that represent the given class.
	 *
	 * @param klass to get the object class of
	 * @return the class that extends Object class and represent the given class
	 * @throws NullPointerException if the given class is null
	 */
	@SuppressWarnings("OverlyComplexMethod")
	public static Class<?> objectiveClass(Class<?> klass) {
		ObjectUtil.requireNonNull(klass, "klass");
		Class<?> comp = klass.getComponentType();
		Class<?> comp1;

		if (comp != null && (comp.isPrimitive() || comp.isArray()))
			return (comp1 = objectiveClass(comp)) == comp ? klass : arrayClass(comp1);
		else if (klass.isPrimitive())
			if (klass == char.class)
				return Character.class;
			else if (klass == int.class)
				return Integer.class;
			else if (klass == boolean.class)
				return Boolean.class;
			else if (klass == byte.class)
				return Byte.class;
			else if (klass == double.class)
				return Double.class;
			else if (klass == float.class)
				return Float.class;
			else if (klass == long.class)
				return Long.class;
			else if (klass == short.class)
				return Short.class;
			else throw new AssertionError();

		return klass;
	}

	/**
	 * <ul>
	 *     Automatic false:
	 *     <li>if the first method is the second method</li>
	 *     <li>if the first method have different parameters count</li>
	 *     <li>if the first method have the same name as the second method</li>
	 *     <li>if the first method return type isn't assignable from the second method return type</li>
	 * </ul>
	 *
	 * @param base
	 * @param override
	 * @return
	 */
	public static boolean overrides(Method base, Method override) {
		if (base == override)
			return false;
		if (base == null || override == null ||
			base.getParameterCount() != override.getParameterCount() ||
			!base.getName().equals(override.getName()) ||
			!base.getDeclaringClass().isAssignableFrom(override.getDeclaringClass()) ||
			!base.getReturnType().isAssignableFrom(override.getReturnType()))
			return false;

		Class<?>[] params0 = base.getParameterTypes(),
				params1 = override.getParameterTypes();
		for (int i = 0; i < params0.length; i++)
			if (params0[i] != params1[i])
				return false;
		return true;
	}

	/**
	 * Get the class that don't extends {@link Object} from the given class.
	 *
	 * @param klass to get the non-object class of
	 * @return the non-object class of the given class
	 * @throws IllegalArgumentException when the given class don't have a primitive type
	 * @throws NullPointerException     if the given class is null
	 */
	@SuppressWarnings("OverlyComplexMethod")
	public static Class<?> primitiveClass(Class<?> klass) {
		ObjectUtil.requireNonNull(klass, "klass");
		Class<?> comp = klass.getComponentType();
		Class<?> comp1;

		if (comp != null && (!comp.isPrimitive() || comp.isArray()))
			return (comp1 = primitiveClass(comp)) == comp ? klass : arrayClass(comp1);
		if (!klass.isPrimitive())
			if (klass == Character.class)
				return char.class;
			else if (klass == Integer.class)
				return int.class;
			else if (klass == Boolean.class)
				return boolean.class;
			else if (klass == Byte.class)
				return byte.class;
			else if (klass == Double.class)
				return double.class;
			else if (klass == Float.class)
				return float.class;
			else if (klass == Long.class)
				return long.class;
			else if (klass == Short.class)
				return short.class;
			else throw new IllegalArgumentException(klass + " don't have a primitive type");

		return klass;
	}
}
