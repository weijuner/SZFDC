package com.srba.szfdc.homepage.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by z on 2016/7/5.
 */
public class GridViewOnScroll extends GridView {
    public GridViewOnScroll(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GridViewOnScroll(Context context) {
        super(context);
    }

    public GridViewOnScroll(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}