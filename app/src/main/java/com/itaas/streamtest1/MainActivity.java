package com.itaas.streamtest1;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.VideoView;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) v.getRootView().findViewById(R.id.set_url);
                Log.w("RANDOM_TAG", editText.toString()+"");
                String url = editText.getText().toString();
                playVideo(v.getRootView(),url);
            }
        });


    }

    public void playVideo(View view,String url){
        Toast.makeText(getBaseContext(),"Buffering...",Toast.LENGTH_SHORT).show();

        final VideoView videoView =(VideoView) view.findViewById(R.id.player);
        Uri uri = Uri.parse(url);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            public void onPrepared(MediaPlayer mp) {
                Toast.makeText(getBaseContext(),"Playing",Toast.LENGTH_SHORT).show();
                videoView.start();
            }
        });

        videoView.setVideoURI(uri);
    }
}
