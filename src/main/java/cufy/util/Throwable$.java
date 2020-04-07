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

import java.util.Objects;

/**
 * Useful utils for throwables.
 *
 * @author LSafer
 * @version 6 release (13-Jan-2020)
 * @since 13-Jan-2020
 */
public class Throwable$ {
	/**
	 * This is a util class. And shall not be instanced as an object.
	 *
	 * @throws AssertionError when called
	 */
	private Throwable$() {
		throw new AssertionError("No instance for you!");
	}

	/**
	 * A java syntax glitch to throw any throwable without the need to catch it.
	 *
	 * @param throwable to be ignite
	 * @param <T>       the type of the throwable to trick the compiler that it's the one thrown
	 * @return nothing
	 * @throws T                    exactly the given throwable (unless if the given throwable is null. Then NullPointerException will be thrown)
	 * @throws NullPointerException if the given throwable is null
	 */
	public static <T extends Throwable> T ignite(Throwable throwable) throws T {
		Objects.requireNonNull(throwable, "throwable");
		throw (T) throwable;
	}
}
