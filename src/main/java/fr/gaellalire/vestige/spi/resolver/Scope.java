/*
 * Copyright 2017 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package fr.gaellalire.vestige.spi.resolver;

/**
 * @author Gael Lalire
 */
public enum Scope {

    /**
     * Never shared, even if you call {@link AttachableClassLoader#attach()} twice on same object you will get two different classLoaders. A classloader which has ATTACHMENT scope
     * will provoke ATTACHMENT scope to all classloaders which depend on it.
     */
    ATTACHMENT,

    /**
     * Shared only with same (identity) {@link ResolvedClassLoaderConfiguration}. You can attach {@link AttachedClassLoader} more than once if it is the same
     * {@link AttachedClassLoader} then it will be the same classLoader. A classloader which has CLASS_LOADER_CONFIGURATION scope will prevent PLATFORM scope to all classloaders
     * which depend on it.
     */
    CLASS_LOADER_CONFIGURATION,

    /**
     * Shared with all equivalent ({@link Object#equals(Object)}) {@link ResolvedClassLoaderConfiguration}. A classloader which has PLATFORM scope will not change the scope of
     * classloaders which depend on it.
     */
    PLATFORM;

    public Scope restrict(final Scope other) {
        if (other.ordinal() < ordinal()) {
            return other;
        }
        return this;
    }

}
