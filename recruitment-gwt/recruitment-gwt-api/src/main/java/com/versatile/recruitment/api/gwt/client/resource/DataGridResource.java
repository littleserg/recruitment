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
package com.versatile.recruitment.api.gwt.client.resource;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.user.cellview.client.DataGrid;

/**
 * @author Sergey Netesanyi
 * @version 1.0
 */
public interface DataGridResource extends DataGrid.Resources {
    public static final DataGridResource INSTANCE = GWT.create(DataGridResource.class);
    /** The styles used in this widget. */
    @Source({"DataGrid2.css"})
    @Override
    CustomStyle dataGridStyle();

    @CssResource.ImportedWithPrefix("gwt-CellTable")
    public interface CustomStyle extends DataGrid.Style {

    }
}
