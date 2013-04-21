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
package com.versatile.recruitment.impl.gwt.client.frame.interview;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.versatile.recruitment.api.gwt.client.ModuleContext;

/**
 * @author Sergey Netesanyi
 * @version 1.0
 */
public class InterviewFrame extends Composite {

    interface ThisUiBinder
            extends UiBinder<Widget, InterviewFrame> {
    }

    private static ThisUiBinder uiBinder =
            GWT.create(ThisUiBinder.class);

    @UiField(provided = true)
    InterviewerGrid grid;

    public InterviewFrame() {
        grid = new InterviewerGrid(ModuleContext.getPageSize());
        initWidget(uiBinder.createAndBindUi(this));


    }
}
