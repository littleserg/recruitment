/*
 * Copyright 2012 Sergey Netesanyi.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.versatile.recruitment.api.gwt.client;

/**
 * @author Sergey Netesanyi
 * @version 1.0
 */
public class ModuleContext {

    private static final ModuleContext MODULE_CONTEXT = new ModuleContext();

    private ClientContext clientContext;

    public static ModuleContext initContext(ClientContext context) {
        get().clientContext = context;
        return get();
    }

    protected ModuleContext() {
    }

    public static ModuleContext get() {
        return MODULE_CONTEXT;
    }

    public static int getPageSize() {
        return 20;
    }
}
