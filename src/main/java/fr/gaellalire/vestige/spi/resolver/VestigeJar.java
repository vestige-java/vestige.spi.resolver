/*
 * Copyright 2019 The Apache Software Foundation.
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

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.Manifest;

/**
 * @author Gael Lalire
 */
public interface VestigeJar {

    /**
     * The URL to use if you want to create a {@link java.security.CodeSource} for classes inside this Jar. Don't try to call {@link URL#openConnection()} as you might not have
     * necessary permissions. If you use an {@link java.net.URLClassLoader.URLClassLoader}, overload {@link java.net.URLClassLoader.URLClassLoader#getPermissions} and do not
     * require any permission for this URL (you can use {@link java.util.IdentityHashMap} to be sure it is the URL created by vestige).
     */
    URL getCodeBase();

    String getName();

    /**
     * @since 2.0
     */
    VestigeJarEntry getEntry(String name) throws IOException;

    /**
     * @since 2.0
     */
    Enumeration<? extends VestigeJarEntry> getEntries() throws IOException;

    long getLastModified();

    Manifest getManifest() throws IOException;

    long getSize();

    InputStream open() throws IOException;

    /**
     * This method should not be used in secure context as the file may be changed after its signature verification. Also it will need read permission anywhere because you don't
     * know where the file is (resolver dependent).
     */
    @Deprecated
    File getFile();

}
