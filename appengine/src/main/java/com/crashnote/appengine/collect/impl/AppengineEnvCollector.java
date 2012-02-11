/**
 * Copyright (C) 2011 - 101loops.com <dev@101loops.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.crashnote.appengine.collect.impl;

import com.crashnote.core.collect.impl.EnvCollector;
import com.crashnote.core.config.Config;
import com.crashnote.core.model.data.DataObject;

public class AppengineEnvCollector<C extends Config>
    extends EnvCollector<C> {

    // SETUP ======================================================================================

    public AppengineEnvCollector(final C config) {
        super(config);
    }

    // INTERFACE ==================================================================================

    @Override
    protected DataObject getAppData() {
        final DataObject appData = super.getAppData();
        {
            appData.put("id", getSysUtil().getProperty("com.google.appengine.application.id"));
            appData.put("revision", getSysUtil().getProperty("com.google.appengine.application.version"));
        }
        return appData;
    }

    @Override
    protected DataObject getRtData() {
        final DataObject rtData = super.getRtData();
        {
            rtData.put("code", getSysUtil().getProperty("com.google.appengine.runtime.version"));
        }
        return rtData;
    }

}
