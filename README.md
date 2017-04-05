# FlexibleUnderlinePageIndicator
Android PageIndicator fits irregular size & position of tabs for a ViewPager

## Screenshot
![](https://github.com/BakerJQ/FlexibleUnderlinePageIndicator/blob/master/Screenshots/show.gif)

## How to use
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
