# LyricView
[![](https://jitpack.io/v/Lauzy/LyricView.svg)](https://jitpack.io/#Lauzy/LyricView)

## Download

```java
    allprojects {
	    repositories {
		    ...
		    maven { url 'https://jitpack.io' }
	    }
	}

    dependencies {
    	        implementation 'com.github.Lauzy:LyricView:VERSION_CODE'
    	}
```

The latest version code is [here](https://github.com/Lauzy/LyricView/releases).

## Usage

Xml file：

```java

       <com.lauzy.freedom.library.LrcView
            ...
            app:currentIndicateLrcColor="@color/colorAccent"
            app:indicatorTextColor="@android:color/holo_orange_dark"
            app:lrcHorizontalPadding="30dp"
            app:playIcon="@drawable/play_music"/>

```

## Functions:

Set up lyric data:

```java

      mLrcView.setLrcData(lrcs);

```
Update playing progress:

```java

      mLrcView.updateTime(mMediaPlayer.getCurrentPosition());

```

Seek to a specific time by indicator:

```java

      mLrcView.setOnPlayIndicatorLineListener(new LrcView.OnPlayIndicatorLineListener() {
                 @Override
                 public void onPlay(long time, String content) {
                     mMediaPlayer.seekTo((int) time);
                 }
             });

```

Set prompt while there is no lyric data:

```java

     mLrcView.setEmptyContent("no data");

```

## Attributes：
```java

        <attr name="lrcTextSize" format="dimension"/>
        <attr name="lrcLineSpaceSize" format="dimension"/>
        <attr name="lrcNormalTextColor" format="reference|color"/>
        <attr name="lrcCurrentTextColor" format="reference|color"/>
        <attr name="lrcHorizontalPadding" format="dimension"/>
        <attr name="lrcVerticalPadding" format="dimension"/>
        <attr name="lrcTouchDelay" format="integer"/>   //delay of rolling back
        <attr name="noLrcTextSize" format="dimension"/>
        <attr name="noLrcTextColor" format="reference|color"/>
        <attr name="indicatorLineHeight" format="dimension"/>
        <attr name="indicatorTextSize" format="dimension"/>
        <attr name="indicatorTextColor" format="reference|color"/>
        <attr name="currentIndicateLrcColor" format="reference|color"/> //current lyric line color
        <attr name="indicatorTouchDelay" format="integer"/>    //delay of indicator's disappearance
        <attr name="indicatorLineColor" format="reference|color"/> // color of indicator line
        <attr name="indicatorStartEndMargin" format="dimension"/>  //start and end margin of indicator
        <attr name="iconLineGap" format="dimension"/>   // space between indicator's playing icon and line
        <attr name="playIconWidth" format="dimension"/>
        <attr name="playIconHeight" format="dimension"/>
        <attr name="playIcon" format="reference"/>   // indicator's playing icon

```

## License

```
Copyright (c) 2017-present Lauzy

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

```