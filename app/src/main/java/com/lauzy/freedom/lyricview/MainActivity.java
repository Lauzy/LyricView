package com.lauzy.freedom.lyricview;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

import com.lauzy.freedom.library.Lrc;
import com.lauzy.freedom.library.LrcHelper;
import com.lauzy.freedom.library.LrcView;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private long mCurrentTime;
    private MediaPlayer mMediaPlayer = new MediaPlayer();
    private LrcView mLrcView;
    private Handler mHandler = new Handler();
    private SeekBar mSeekBar;
    private TextView mTvStart;
    private TextView mTvEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        play();
    }

    private void play() {
        try {
            AssetFileDescriptor descriptor = getAssets().openFd("Rolling In The Deep.mp3");
            mMediaPlayer.setDataSource(descriptor.getFileDescriptor());
            mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mMediaPlayer.start();
                    mSeekBar.setMax(mMediaPlayer.getDuration());
                    mTvEnd.setText(LrcHelper.formatTime(mMediaPlayer.getDuration()));
                }
            });
            mMediaPlayer.prepareAsync();
            mHandler.post(mRunnable);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            int currentPosition = mMediaPlayer.getCurrentPosition();
            mLrcView.updateTime(currentPosition);
            mSeekBar.setProgress(currentPosition);
            mTvStart.setText(LrcHelper.formatTime(currentPosition));
            mHandler.postDelayed(this, 100);
        }
    };

    private void init() {
        List<Lrc> lrcs = LrcHelper.parseLrcFromAssets(this, "Rolling in the Deep-Adele.lrc");
        mLrcView = findViewById(R.id.lrc_view);
        mSeekBar = findViewById(R.id.seek_play);
        mTvStart = findViewById(R.id.tv_start);
        mTvEnd = findViewById(R.id.tv_end);
        mLrcView.setLrcData(lrcs);
        mLrcView.setOnPlayIndicatorLineListener(new LrcView.OnPlayIndicatorLineListener() {
            @Override
            public void onPlay(long time, String content) {
                mMediaPlayer.seekTo((int) time);
            }
        });
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mHandler.removeCallbacks(mRunnable);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mHandler.post(mRunnable);
                mMediaPlayer.seekTo(seekBar.getProgress());
            }
        });
    }
}
