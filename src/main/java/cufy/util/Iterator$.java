/*
 *	Copyright 2020 Cufyorg
 *
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *
 *	    http://www.apache.org/licenses/LICENSE-2.0
 *
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */
package cufy.util;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Utils for {@link java.util.Iterator}s.
 *
 * @author LSaferSE
 * @version 1 release (01-Feb-2020)
 * @since 01-Feb-2020
 */
final public class Iterator$ {
	/**
	 * This is a util class. And shall not be instanced as an object.
	 *
	 * @throws AssertionError when called
	 */
	private Iterator$() {
		throw new AssertionError("No instance for you!");
	}

	/**
	 * Get an iterator combined from the given iterators.
	 *
	 * @param <T>       the type of elements provided by the returned iterator
	 * @param iterators to combine
	 * @return an iterator combined from the given iterators.
	 * @throws NullPointerException if any of the given iterators is null. Or if the given iterator array is null itself
	 * @apiNote the given iterator WILL invoke {@link Iterator#next()} on the given iterators
	 */
	public static <T> Iterator<T> combine(Iterator<? extends T>... iterators) {
		Objects.requireNonNull(iterators, "iterators");
		for (Iterator<? extends T> iterator : iterators)
			Objects.requireNonNull(iterator, "iterators[?]");

		return new Iterator<T>() {
			/**
			 * The index of the current iterator.
			 */
			protected int i = 0;

			@Override
			public boolean hasNext() {
				return iterators.length > this.i && iterators[this.i].hasNext();
			}

			@Override
			public T next() {
				this.fix();

				if (iterators.length > this.i) {
					T t = iterators[this.i].next();
					this.fix();
					return t;
				} else {
					throw new NoSuchElementException("No more elements");
				}
			}

			/**
			 * Set the index to the minimum iterator that has next.
			 */
			private void fix() {
				while (iterators.length > this.i && !iterators[this.i].hasNext())
					this.i++;
			}
		};
	}
}
