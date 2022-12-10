package org.kastin.kong.client.service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import feign.Util;

public class ValidateUtils {

	public static <E> void isEmpty(Collection<E> collection, String message) {
		if (collection == null || collection.isEmpty()) {
			throw new IllegalArgumentException(message);
		}
	}

	public static <E> void isAllEmpty(String message, List<Collection<E>> list) {
		boolean isNotEmpty = list.stream().filter(Objects::nonNull).anyMatch(t -> !t.isEmpty());
		if (!isNotEmpty) {
			throw new IllegalArgumentException(message);
		}
	}
	
	public static <E> void isNull (E value,String message) {
		if (value == null) {
			throw new IllegalArgumentException(message);
		}
	}
	
	public static <E> void isBlack (String value,String message) {
		if (Util.isBlank(value)) {
			throw new IllegalArgumentException(message);
		}
	}

	public static <E> E defaultIfNull(E value, E defaultValue) {
		return value == null ? defaultValue : value;
	}

	public static String defaultIfEmpty(String value, String defaultValue) {
		return Util.isBlank(value) ? defaultValue : value;
	}
	

}
