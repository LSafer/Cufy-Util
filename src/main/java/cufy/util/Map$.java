package cufy.util;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Utils all about maps.
 *
 * @author LSaferSE
 * @version 1 release (03-Apr-2020)
 * @since 03-Apr-2020
 */
final public class Map$ {
	/**
	 * This is a util class. And shall not be instanced as an object.
	 *
	 * @throws AssertionError when called
	 */
	private Map$() {
		throw new AssertionError("No instance for you!");
	}

	/**
	 * Get a list that is read and write to the given map. The list will use the positive integer keys only.
	 *
	 * @param map to get the list for
	 * @return a list for the given map
	 * @throws NullPointerException if the given map is null
	 */
	public static List listFor(Map map) {
		Objects.requireNonNull(map, "map");
		return new AbstractList() {
			@Override
			public Object get(int index) {
				checkBounds(index, this.maxIndex());
				return map.get(index);
			}

			@Override
			public Object set(int index, Object element) {
				checkBounds(index, this.maxIndex());
				return map.put(index, element);
			}

			@Override
			public void add(int index, Object element) {
				checkBounds(index, this.size());
				this.shiftIndexes(index, null, 1);
				map.put(index, element);
			}

			@Override
			public Object remove(int index) {
				checkBounds(index, this.maxIndex());
				Object value = map.remove(index);
				this.shiftIndexes(index, null, -1);
				return value;
			}

			@Override
			public int size() {
				return this.maxIndex() + 1;
			}

			/**
			 * Check if the given index is valid or not.
			 *
			 * @param index the index to check
			 * @param allowed the allowed index (as maximum)
			 */
			private void checkBounds(int index, int allowed) {
				if (index < 0)
					throw new IndexOutOfBoundsException("index=" + index + " is negative");
				else if (index > allowed)
					throw new IndexOutOfBoundsException("index=" + index + " is out of bounds allowed=" + allowed);
			}

			/**
			 * The maximum integer. That have been stored as a key in this.
			 *
			 * @return the maximum index of this
			 */
			private int maxIndex() {
				int index, max = -1;

				for (Object key : map.keySet())
					if (key instanceof Integer && (index = (int) key) > max)
						max = index;

				return max;
			}

			/**
			 * Shift indexes within the given range by the given value.
			 * <p>
			 * ex.
			 * <pre>
			 *     map = {0:zero, 1:one, 2:two, 3:three}
			 *     map.shiftIndexes(<font color="gray">start</font> 1, <font color="gray">end</font> 2, <font color="gray">by</font> -1)
			 *     map => {0:zero, 1:two, 3:three}
			 *
			 *     map = {0:A, 1:B, 2:C, 3:D, 4:E}
			 *     map.shiftIndexes(<font color="gray">start</font> 2, <font color="gray">end</font> null, <font color="gray">by</font> 2)
			 *     map => {0:A, 1:B, 4:C, 5:D, 6:E}
			 * </pre>
			 *
			 * @param start the start of the shifting range (aka min)(null for no start)
			 * @param end   the end of the shifting range (aka max)(null for no end)
			 * @param by    the length to shift the values of this by
			 */
			private void shiftIndexes(Integer start, Integer end, int by) {
				HashMap modified = new HashMap<>();

				boolean noStart = start == null, noEnd = end == null;

				((Set<Map.Entry>) map.entrySet()).forEach(entry -> {
					Object key = entry.getKey();

					if (key instanceof Integer && (noStart || (Integer) key >= start) && (noEnd || (Integer) key <= end))
						modified.put(key, entry.getValue());
				});

				modified.forEach((key, value) -> {
					map.remove(key, value);
					int index = (Integer) key + by;

					if ((noStart || index >= start) && (noEnd || index <= end))
						map.put(index, value);
				});
			}
		};
	}

	/**
	 * Get a map that whenever the method {@link Map#put(Object, Object)} is invoked to it. It will put the value to an existing PUBLIC NON-FINALE
	 * field with the name of the key's value (only if it is string). And whenever the method {@link Map#get(Object)} is invoked to it. It will get
	 * the value of an existing PUBLIC field.
	 *
	 * @param object the instance
	 * @return a remote map to that instance
	 * @throws NullPointerException if the given object is null
	 * @apiNote the returned map WILL contain ALL the accessible fields of the given instance! so be careful when using it!.
	 */
	public static Map<String, Object> mapFor(Object object) {
		Objects.requireNonNull(object, "object");
		return new AbstractMap<String, Object>() {
			/**
			 * The entry-set of this map.
			 */
			private Set<Entry<String, Object>> entrySet;

			@Override
			public Object put(String key, Object value) {
				for (Entry<String, Object> entry : this.entrySet())
					if (Objects.equals(entry.getKey(), key))
						return entry.setValue(value);

				throw new IllegalArgumentException("can't store the key: " + key);
			}

			@Override
			public Set<Entry<String, Object>> entrySet() {
				if (this.entrySet == null) {
					HashSet tempSet = new HashSet();

					for (Field field : Reflect$.getAllFields(object.getClass()))
						//noinspection Since15 it worked with me :)
						if (field.canAccess(object))
							tempSet.add(new Entry<String, Object>() {
								@Override
								public String getKey() {
									return field.getName();
								}

								@Override
								public Object getValue() {
									try {
										field.setAccessible(true);
										return field.get(object);
									} catch (IllegalAccessException e) {
										throw (IllegalAccessError) new IllegalAccessError().initCause(e);
									}
								}

								@Override
								public Object setValue(Object value) {
									try {
										Object old = this.getValue();
										field.set(object, value);
										return old;
									} catch (IllegalAccessException e) {
										throw (IllegalAccessError) new IllegalAccessError().initCause(e);
									}
								}
							});

					this.entrySet = Collections.unmodifiableSet(tempSet);
				}

				return this.entrySet;
			}
		};
	}
}
