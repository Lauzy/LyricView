# LyricView
[![](https://jitpack.io/v/Lauzy/LyricView.svg)](https://jitpack.io/#Lauzy/LyricView)

[下载 apk 体验](https://github.com/Lauzy/LyricView/raw/master/apk/demo.apk).

[博客介绍: https://www.jianshu.com/p/ab735509cc74](https://www.jianshu.com/p/ab735509cc74)

## 截图

<img src="/screenshots/20180428_LyricView_screen_shot_01.png" alt="screenshot" title="screenshot" width="270" height="460" />  <img src="/screenshots/20180428_LyricView_screen_shot_02.png" alt="screenshot" title="screenshot" width="270" height="460" />

## 配置

```java
    all projects {
	    repositories {
		    ...
		    maven { url 'https://jitpack.io' }
	    }
	}

    dependencies {
    	        implementation 'com.github.Lauzy:LyricView:VERSION_CODE'
    	}
```

最新的版本号，点击[这里](https://github.com/Lauzy/LyricView/releases)获取.

## 用法

Xml 文件：

```java

       <com.lauzy.freedom.library.LrcView
            ...
            app:currentIndicateLrcColor="@color/colorAccent"
            app:indicatorTextColor="@android:color/holo_orange_dark"
            app:playIcon="@drawable/play_music"/>

```

## 功能:

设置歌词数据:

```java

      mLrcView.setLrcData(lrcs);

```
根据播放进度更新歌词:

```java

      mLrcView.updateTime(mMediaPlayer.getCurrentPosition());

```

通过指示器，跳转至具体的时间:

```java

      mLrcView.setOnPlayIndicatorLineListener(new LrcView.OnPlayIndicatorLineListener() {
                 @Override
                 public void onPlay(long time, String content) {
                     mMediaPlayer.seekTo((int) time);
                 }
             });

```

歌词数据为空时，设置内容为空的提示:

```java

     mLrcView.setEmptyContent("no data");

```

## 属性：
```java

        <attr name="lrcTextSize" format="dimension"/>
        <attr name="lrcLineSpaceSize" format="dimension"/>
        <attr name="lrcNormalTextColor" format="reference|color"/>
        <attr name="lrcCurrentTextColor" format="reference|color"/>
        <attr name="lrcTouchDelay" format="integer"/>   //手动滑动后，回滚至当前播放位置的延迟
        <attr name="noLrcTextSize" format="dimension"/>
        <attr name="noLrcTextColor" format="reference|color"/>
        <attr name="indicatorLineHeight" format="dimension"/>
        <attr name="indicatorTextSize" format="dimension"/>
        <attr name="indicatorTextColor" format="reference|color"/>
        <attr name="currentIndicateLrcColor" format="reference|color"/> //当前歌词的颜色
        <attr name="indicatorTouchDelay" format="integer"/>    //指示器消失延迟
        <attr name="indicatorLineColor" format="reference|color"/> // 指示器线条颜色
        <attr name="indicatorStartEndMargin" format="dimension"/>  //指示器左右margin
        <attr name="iconLineGap" format="dimension"/>   // 指示器图标和线条的距离
        <attr name="playIconWidth" format="dimension"/>
        <attr name="playIconHeight" format="dimension"/>
        <attr name="playIcon" format="reference"/>   // 指示器图标

```

## 协议

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