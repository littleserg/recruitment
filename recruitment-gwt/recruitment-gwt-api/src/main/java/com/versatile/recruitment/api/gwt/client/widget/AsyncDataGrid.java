package com.versatile.recruitment.api.gwt.client.widget;

import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.ProvidesKey;
import com.google.gwt.view.client.SelectionModel;
import com.versatile.recruitment.api.gwt.client.resource.DataGridResource;

/**
 * @author Sergey Netesanyi
 * @version 1.0
 */
public abstract class AsyncDataGrid<T> extends DataGrid<T> {

    public static final int DEFAULT_PAGE_SIZE = 20;

    public AsyncDataGrid(int pageSize, SelectionModel<T> providesKey) {
        super(pageSize, DataGridResource.INSTANCE, providesKey);
        setSelectionModel(providesKey);

        initColumns();
//        addColumnSortHandler(new ColumnSortEvent.Handler() {
//            @Override
//            public void onColumnSort(ColumnSortEvent event) {
//                sortColumn = columns.get(event.getColumn());
//                sortDir = event.getColumnSortList().get(0).isAscending() ? ASC : DESC;
//                setVisibleRange(0, 20);
//                RangeChangeEvent.fire(AsyncDataGrid.this, AsyncDataGrid.this.getVisibleRange());
//
//            }
//        });

    }

    protected abstract void initColumns();
}
