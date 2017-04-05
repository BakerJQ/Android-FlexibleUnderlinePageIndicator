# FlexibleUnderlinePageIndicator
Android PageIndicator fits irregular size & position of tabs for a ViewPager

## Screenshot
![](https://github.com/BakerJQ/FlexibleUnderlinePageIndicator/blob/master/Screenshots/show.gif)

## How to use
### Init
Just use it as the same as the original PopupWindow
```java
mPopupWindow = new BackgroundBlurPopupWindow(mTextView, WindowManager.LayoutParams.WRAP_CONTENT,
        WindowManager.LayoutParams.WRAP_CONTENT, this, true);
mPopupWindow.setFocusable(true);
mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
mPopupWindow.setAnimationStyle(android.R.style.Animation_Dialog);
