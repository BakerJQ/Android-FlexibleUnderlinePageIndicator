package bakerj.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import bakerj.flexibleunderlinepageindicator.FlexibleUnderlinePageIndicator;

public class IndicatorActivity extends Activity {
    private static final String LAYOUT_TYPE = "LAYOUT_TYPE";

    public static Intent getStartIntent(Activity activity, int layoutType) {
        Intent intent = new Intent(activity, IndicatorActivity.class);
        intent.putExtra(LAYOUT_TYPE, layoutType);
        return intent;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutType = getIntent().getIntExtra(LAYOUT_TYPE, 1);
        int layoutId;
        switch (layoutType) {
            case 1:
                layoutId = R.layout.layout_style_1;
                break;
            case 2:
                layoutId = R.layout.layout_style_2;
                break;
            case 3:
                layoutId = R.layout.layout_style_3;
                break;
            default:
                layoutId = R.layout.layout_style_1;
                break;
        }
        setContentView(layoutId);
        initView();
    }

    private void initView() {
        View tab1 = findViewById(R.id.tab1);
        View tab2 = findViewById(R.id.tab2);
        View tab3 = findViewById(R.id.tab3);
        View tab4 = findViewById(R.id.tab4);
        FlexibleUnderlinePageIndicator indicator = (FlexibleUnderlinePageIndicator) findViewById(R.id.indicator);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new SimplePageAdapter(this));
        //set the viewpager and tabs
        indicator.setUnderLineView(tab1, tab2, tab3, tab4);
        indicator.setViewPager(viewPager);
    }
}
