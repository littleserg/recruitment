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
package com.versatile.recruitment.tool.spring;

import com.versatile.recruitment.tool.config.IConfigAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * TODO: Comment it!!!
 *
 * @author Sergey Netesanyi
 * @version 1.0
 */
public class DefaultConfigAccessor implements IConfigAccessor {
    @Resource(name = "defaultConfigs")
    private HashMap<String, Object> defaultConfigs;
    @Autowired
    private ConversionService conversionService;

    private boolean useDynamicConfigs;

    @SuppressWarnings("unchecked")
    @Override
    public Object getConfig(String key) {
        Object result = null;
        if (useDynamicConfigs) {
            result = getDynamicConfig(key);
        }
        return result == null ? getDefaultConfig(key) : result;
    }

    @Override
    public <T> T getConfig(String key, Class<T> targetClass) {
        Object value = getConfig(key);
        if (value != null && conversionService.canConvert(value.getClass(), targetClass)) {
            return conversionService.convert(value, targetClass);
        }
        return null;
    }

    protected Object getDynamicConfig(String key) {
        return null;
    }

    protected Object getDefaultConfig(String key) {
        Object result = null;
        if (defaultConfigs != null) {
            result = defaultConfigs.get(key);
        }
        return result;
    }

    /**
     * Sets new useDynamicConfigs
     *
     * @param useDynamicConfigs
     *         New value of useDynamicConfigs
     */
    public void setUseDynamicConfigs(boolean useDynamicConfigs) {
        this.useDynamicConfigs = useDynamicConfigs;
    }
}
