package bakerj.flexibleunderlinepageindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * @author BakerJ
 */
public class FlexibleUnderlinePageIndicator extends View {
    private int height;
    private int size;
    private int currentPage;
    private int scrollState;
    private float positionOffset;
    private List<int[]> centerWidthPairs;
    private int[] positionOffsets, widthOffsets;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public FlexibleUnderlinePageIndicator(Context context) {
        this(context, null);
    }

    public FlexibleUnderlinePageIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint.setStyle(Paint.Style.FILL);
        if (attrs != null) {
            initAttrs(context, attrs);
        } else {
            paint.setColor(Color.LTGRAY);
        }
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable
                .FlexibleUnderlinePageIndicator);
        paint.setColor(typedArray.getColor(R.styleable.FlexibleUnderlinePageIndicator_underlineColor,
                Color.CYAN));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        height = getMeasuredHeight();
    }

    /**
     * set the viewpager associate with the indicator
     * @param viewPager viewpager
     */
    public void setViewPager(ViewPager viewPager) {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                currentPage = position;
                FlexibleUnderlinePageIndicator.this.positionOffset = positionOffset;
                invalidate();
            }

            @Override
            public void onPageSelected(int position) {
                if (scrollState == ViewPager.SCROLL_STATE_IDLE) {
                    currentPage = position;
                    positionOffset = 0;
                    invalidate();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                scrollState = state;
            }
        });
    }

    /**
     * set the tabs
     * @param views tabs
     */
    public void setUnderLineView(View... views) {
        size = views.length;
        centerWidthPairs = new ArrayList<>();
        for (final View view : views) {
            view.post(new Runnable() {
                @Override
                public void run() {
                    int width = view.getWidth();
                    int[] centerWidthPair = {view.getLeft() + width / 2, width};
                    centerWidthPairs.add(centerWidthPair);
                    if (size == centerWidthPairs.size()) {
                        positionOffsets = new int[size - 1];
                        widthOffsets = new int[size - 1];
                        for (int i = 1; i < size; i++) {
                            int[] centerWidthPair0 = centerWidthPairs.get(i - 1);
                            int[] centerWidthPair1 = centerWidthPairs.get(i);
                            positionOffsets[i - 1] = centerWidthPair1[0] - centerWidthPair0[0];
                            widthOffsets[i - 1] = centerWidthPair1[1] - centerWidthPair0[1];
                        }
                        invalidate();
                    }
                }
            });
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (size == centerWidthPairs.size()) {
            int[] centerWidthPair = centerWidthPairs.get(currentPage);
            float drawCenter = centerWidthPair[0];
            float drawWidth = centerWidthPair[1];
            if (positionOffset != 0) {
                int offsetIndex = positionOffset > 0 ? currentPage : currentPage - 1;
                if (offsetIndex >= 0 && offsetIndex < size - 1) {
                    drawCenter += positionOffsets[offsetIndex] * positionOffset;
                    drawWidth += widthOffsets[offsetIndex] * positionOffset;
                }
            }
            drawWidth *= 0.5f;
            canvas.drawRect(drawCenter - drawWidth, 0, drawCenter + drawWidth, height, paint);
        }
    }
}
