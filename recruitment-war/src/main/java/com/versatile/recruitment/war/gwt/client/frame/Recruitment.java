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
package com.versatile.recruitment.war.gwt.client.frame;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.versatile.recruitment.api.gwt.client.ClientContext;
import com.versatile.recruitment.impl.gwt.client.frame.interview.InterviewFrame;

/**
 * @author Sergey Netesanyi
 * @version 1.0
 */
public class Recruitment extends Composite {

    interface ThisUiBinder
            extends UiBinder<Widget, Recruitment> {
    }

    private static ThisUiBinder uiBinder =
            GWT.create(ThisUiBinder.class);
    @UiField
    TabLayoutPanel tabPanel;

    public Recruitment() {
        initWidget(uiBinder.createAndBindUi(this));

        GWT.runAsync(InterviewFrame.class, new RunAsyncCallback() {
            @Override
            public void onFailure(Throwable reason) {
                GWT.log(reason.getLocalizedMessage(), reason);
            }

            @Override
            public void onSuccess() {
                tabPanel.add(new InterviewFrame(), "Интервью");
            }
        });
    }

}
