package bakerj.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                startActivity(IndicatorActivity.getStartIntent(this, 1));
                break;
            case R.id.btn2:
                startActivity(IndicatorActivity.getStartIntent(this, 2));
                break;
            case R.id.btn3:
                startActivity(IndicatorActivity.getStartIntent(this, 3));
                break;
        }
    }
}
