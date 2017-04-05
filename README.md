# FlexibleUnderlinePageIndicator
Android PageIndicator fits irregular size & position of tabs for a ViewPager

## Screenshot
![](https://github.com/BakerJQ/FlexibleUnderlinePageIndicator/blob/master/Screenshots/show.gif)

## How to use
### XML
```xml
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
                xmlns:indicator="http://schemas.android.com/apk/res-auto"
                android:layout_width="match_parent"
                android:layout_height="match_parent">

    <LinearLayout
        android:id="@+id/ll_tab"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center_vertical"
        android:orientation="horizontal">

        <TextView
            android:id="@+id/tab1"
            style="@style/com_tab_style"
            android:text="tab1"/>

        <TextView
            android:id="@+id/tab2"
            style="@style/com_tab_style"
            android:text="tab2"/>

        <TextView
            android:id="@+id/tab3"
            style="@style/com_tab_style"
            android:text="tab3"/>

        <TextView
            android:id="@+id/tab4"
            style="@style/com_tab_style"
            android:text="tab4"/>
    </LinearLayout>

    <bakerj.flexibleunderlinepageindicator.FlexibleUnderlinePageIndicator
        android:id="@+id/indicator"
        android:layout_width="match_parent"
        android:layout_height="2dp"
        android:layout_alignBottom="@id/ll_tab"
        indicator:underlineColor="#00a0ef"/>

    <View
        android:id="@+id/line"
        android:layout_width="match_parent"
        android:layout_height="1dp"
        android:layout_below="@id/indicator"
        android:background="#d7d7d7"/>

    <android.support.v4.view.ViewPager
        android:id="@+id/viewpager"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_below="@id/line"/>
</RelativeLayout>
```
### Java code
```java
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
```
