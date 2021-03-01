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

import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author Gael Lalire
 */
public interface VestigeResolver {

    /**
     * Restore a previously saved {@link ResolvedClassLoaderConfiguration}.
     * @see ResolvedClassLoaderConfiguration#save(java.io.ObjectOutputStream)
     */
    ResolvedClassLoaderConfiguration restoreSavedResolvedClassLoaderConfiguration(ObjectInputStream objectInputStream) throws IOException;

    /**
     * Restore a previously saved {@link VestigeJar}.
     * @see VestigeJar#save(java.io.ObjectOutputStream)
     * @since 2.2
     */
    VestigeJar restoreSavedVestigeJar(ObjectInputStream objectInputStream) throws IOException;

}
