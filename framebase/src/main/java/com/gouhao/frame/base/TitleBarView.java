package com.gouhao.frame.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by gouhao on 2016-02-19.
 * 自定义的标题栏
 */
public class TitleBarView extends RelativeLayout implements ITitleBar{
	public final static int ID_LEFT = 1992;
	public final static int ID_TITLE = 1993;

	protected ImageView left;
	protected TextView title;
	protected LinearLayout rightLayout;
	protected LayoutInflater inflater;
	protected LinearLayout leftLayout;
	protected RelativeLayout parent;
	protected View tintView;
	public TitleBarView(Context context) {
		this(context, null);
		title.setGravity(Gravity.CENTER);
	}

	public TitleBarView(Context context, AttributeSet attrs) {
		super(context, attrs);

		inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		initLayout();
	}

	private void initLayout() {
		//这个View是为了实现沉浸式标题栏，在标题栏上面又加了和状态栏一样高度的View。当然，这种做法比较LOW
		tintView = new View(getContext());
		tintView.setId(1994);
		tintView.setBackgroundColor(Color.RED);
		LayoutParams params1 = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight());
		addView(tintView, params1);
		parent = new RelativeLayout(getContext());
		parent.setBackgroundColor(Color.RED);
		leftLayout = new LinearLayout(getContext());
		leftLayout.setOrientation(LinearLayout.HORIZONTAL);
		LayoutParams leftParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		leftParams.addRule(ALIGN_PARENT_LEFT, TRUE);
		leftParams.addRule(CENTER_VERTICAL, TRUE);

		left = new ImageView(getContext());
		left.setId(ID_LEFT);
		LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
				ViewGroup.LayoutParams.WRAP_CONTENT);
		params.addRule(CENTER_VERTICAL, TRUE);
		leftLayout.addView(left, params);
		parent.addView(leftLayout, leftParams);

		title = new TextView(getContext());
		title.setId(ID_TITLE);
		title.setSingleLine(true);
		LayoutParams titleParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
				ViewGroup.LayoutParams.WRAP_CONTENT);
		title.setTextColor(Color.BLACK);
		titleParams.addRule(CENTER_HORIZONTAL, TRUE);
		titleParams.addRule(CENTER_VERTICAL, TRUE);
		parent.addView(title, titleParams);

		rightLayout = new LinearLayout(getContext());
		rightLayout.setOrientation(LinearLayout.HORIZONTAL);
		LayoutParams rightParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		rightParams.addRule(ALIGN_PARENT_RIGHT, TRUE);
		rightParams.addRule(CENTER_VERTICAL, TRUE);
		parent.addView(rightLayout, rightParams);

		LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.MATCH_PARENT);
		layoutParams.addRule(RelativeLayout.BELOW, 1994);
		addView(parent, layoutParams);
	}

	public int getStatusBarHeight() {
		int resId = getResources().getIdentifier("status_bar_height", "dimen", "android");
		if(resId > 0) {
			return getResources().getDimensionPixelSize(resId);
		}
		return 0;
	}

	public void setLeftIcon(int resId) {
		left.setImageResource(resId);
	}

	public void setLeftIcon(Bitmap bm) {
		left.setImageBitmap(bm);
	}

	public void setLeftClickListener(OnClickListener listener) {
		left.setOnClickListener(listener);
	}

	@Override
	public void addTitleBarRightView(View view) {
		rightLayout.addView(view);
	}

	@Override
	public void addTitleBarLeftView(View view) {
		leftLayout.addView(view);
	}

	@Override
	public void setTitleBarVisibility(int visibility) {

	}

	@Override
	public void setTitleBarTitle(int resId) {
		setTitleBarTitle(getContext().getString(resId));
	}

	@Override
	public void setTitleBarTitle(String title) {
		this.title.setText(title);
	}

	@Override
	public void setLayoutBackground(int resId) {
		setBackgroundResource(resId);
	}

	@Override
	public void setLayoutBackgroud(int color) {
		setBackgroundColor(color);
	}

	@Override
	public void setTitleColor(int color) {
		title.setTextColor(color);
	}

	@Override
	public void setBackViewVisibility(int visibility) {
		left.setVisibility(visibility);
	}

	@Override
	public void setTitleTextSize(float size) {
		title.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
	}

	@Override
	public void setTitlePadding(int l, int t, int r, int b) {
		parent.setPadding(l, t, r, b);
	}

	@Override
	public void setTintColor(int color) {
		tintView.setBackgroundColor(color);
	}
}
