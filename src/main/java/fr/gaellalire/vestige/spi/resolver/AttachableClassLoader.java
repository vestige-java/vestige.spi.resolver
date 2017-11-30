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
public interface AttachableClassLoader {

    AttachedClassLoader attach() throws ResolverException, InterruptedException;

    ClassLoader getClassLoader();

    /**
     * The classLoader will keep a {@link java.lang.ref.SoftReference} to object. When {@link #attach()} or {@link AttachedClassLoader#detach()} is called the SoftReference is
     * checked and removed from ClassLoader if it has been cleared. This operation is optional, doing nothing is also fine.
     */
    void addSoftReferenceObject(Object object);

}
