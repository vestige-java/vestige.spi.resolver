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
import java.io.ObjectOutputStream;
import java.security.Permission;
import java.util.Collection;

/**
 * @author Gael Lalire
 */
public interface ResolvedClassLoaderConfiguration {

    AttachedClassLoader attach() throws ResolverException, InterruptedException;

    /**
     * Save this object to objectOutputStream. You can restore it using {@link VestigeResolver#restoreSavedResolvedClassLoaderConfiguration(java.io.ObjectInputStream)}. Use the
     * resolver which was used to create this object initialy or you may have restoration issue.
     */
    void save(ObjectOutputStream objectOutputStream) throws IOException;

    Collection<Permission> getPermissions();

    boolean isAttachmentScoped();

    VestigeJar getFirstVestigeJar();

}
