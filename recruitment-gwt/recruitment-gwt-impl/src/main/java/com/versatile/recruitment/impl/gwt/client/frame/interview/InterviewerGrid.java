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

import com.google.gwt.cell.client.DateCell;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.Range;
import com.google.gwt.view.client.SingleSelectionModel;
import com.versatile.recruitment.api.gwt.client.widget.AsyncDataGrid;

import java.util.Date;

/**
 * @author Sergey Netesanyi
 * @version 1.0
 */
public class InterviewerGrid extends AsyncDataGrid<InterviewerGrid.Interview> {

    private AsyncDataProvider<Interview> provider;

    public InterviewerGrid(int pageSize) {
        super(pageSize, new SingleSelectionModel<Interview>());

        provider = new AsyncDataProvider<Interview>() {
            @Override
            protected void onRangeChanged(HasData<Interview> display) {
                Range range = getVisibleRange();

            }
        };
    }

    @Override
    protected void initColumns() {
        Column<Interview, String> candidateName = new TextColumn<Interview>() {
            @Override
            public String getValue(Interview object) {
                // TODO
                return null;
            }
        };
        candidateName.setSortable(true);
        addColumn(candidateName, "Кандидат");

        Column<Interview, String> recruiterName = new TextColumn<Interview>() {
            @Override
            public String getValue(Interview object) {
                // TODO
                return null;
            }
        };
        recruiterName.setSortable(true);
        addColumn(recruiterName, "Рекрутер");

        Column<Interview, Date> dateFrom = new Column<Interview, Date>(new DateCell()) {
            @Override
            public Date getValue(Interview object) {
                // TODO
                return null;
            }
        };
        dateFrom.setSortable(true);
        addColumn(dateFrom, "Начало");

        Column<Interview, Date> dateЕщ = new Column<Interview, Date>(new DateCell()) {
            @Override
            public Date getValue(Interview object) {
                // TODO
                return null;
            }
        };
        dateЕщ.setSortable(true);
        addColumn(dateЕщ, "Завершение");
    }

    public static class Interview {

    }
}
