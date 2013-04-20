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

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author Sergey Netesanyi
 * @version 1.0
 */
@Component
public final class SpringUtil {
    /** Singleton {@link SpringUtil} instance. */
    private static SpringUtil instance;
    /** Bean factory instance. */
    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private ConversionService conversionService;

    @PostConstruct
    private void afterPropertiesSet() {
        instance = this;
    }

    public ConversionService getConversionService() {
        return conversionService;
    }

    public static SpringUtil get() {
        return instance;
    }

    /**
     * Gets Bean factory instance.
     *
     * @return Value of Bean factory instance.
     */
    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    /**
     * Gets Bean factory instance.
     *
     * @param beanName
     *         Target bean name.
     * @return Value of Bean factory instance.
     */
    @SuppressWarnings("unchecked")
    public <X> X getBean(String beanName) {
        return (X) beanFactory.getBean(beanName);
    }
}
