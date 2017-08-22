package ravibhardwaj.musicnodes;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText nodes_edit;
    Button play_btn, stop_btn;
    SoundPool soundPool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nodes_edit = (EditText) findViewById(R.id.edit_music);
        play_btn = (Button) findViewById(R.id.play_btn);
        stop_btn = (Button) findViewById(R.id.stop_btn);
    }

    public void playbtn(View view) {

        String nodes = nodes_edit.getText().toString();
        String[] music_words = nodes.split(" ");
        int music_lenth = music_words.length;
        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC,0);

        final ArrayList loaded = new ArrayList();

        for (int i=0; i<music_lenth; i++){
            String a1 = "a1";
            String a1s = "a1s";
            String b1 = "b1";
            String c1 = "c1";
            String c1s = "c1s";
            String c2 = "c2";
            String d1 = "d1";
            String d1s = "d1s";
            String e1 = "e1";
            String f1 = "f1";
            String f1s = "f1s";
            String g1 = "g1";
            String g1s = "g1s";
            String dot = ".";

            if (music_words[i].equalsIgnoreCase(a1)){

                loaded.add(soundPool.load(getApplicationContext(),R.raw.a1,1));

            }else if (music_words[i].equalsIgnoreCase(a1s)){

                loaded.add(soundPool.load(getApplicationContext(),R.raw.a1s,1));

            } else if (music_words[i].equalsIgnoreCase(b1)){

                loaded.add(soundPool.load(getApplicationContext(),R.raw.b1,1));

            }else if (music_words[i].equalsIgnoreCase(c1)){

                loaded.add(soundPool.load(getApplicationContext(),R.raw.c1,1));

            }else if (music_words[i].equalsIgnoreCase(c1s)){

                loaded.add(soundPool.load(getApplicationContext(),R.raw.c1s,1));

            }else if (music_words[i].equalsIgnoreCase(c2)){

                loaded.add(soundPool.load(getApplicationContext(),R.raw.c2,1));

            }else if (music_words[i].equalsIgnoreCase(d1)){

                loaded.add(soundPool.load(getApplicationContext(),R.raw.d1,1));

            }else if (music_words[i].equalsIgnoreCase(d1s)){

                loaded.add(soundPool.load(getApplicationContext(),R.raw.d1s,1));

            }else if (music_words[i].equalsIgnoreCase(e1)){

                loaded.add(soundPool.load(getApplicationContext(),R.raw.e1,1));

            }else if (music_words[i].equalsIgnoreCase(f1)){

                loaded.add(soundPool.load(getApplicationContext(),R.raw.f1,1));

            }else if (music_words[i].equalsIgnoreCase(f1s)){

                loaded.add(soundPool.load(getApplicationContext(),R.raw.f1s,1));

            }else if (music_words[i].equalsIgnoreCase(g1)){

                loaded.add(soundPool.load(getApplicationContext(),R.raw.g1,1));

            }else if (music_words[i].equalsIgnoreCase(g1s)){

                loaded.add(soundPool.load(getApplicationContext(),R.raw.g1s,1));

            }else if (music_words[i].equalsIgnoreCase(dot)){

                loaded.add(30);
            }
        }

        final Integer []arr = (Integer[]) loaded.toArray(new Integer[loaded.size()]);

        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                if (status == 0){

                    for (int i = 0; i<arr.length; i++) {

                        if (i != 30){
                            soundPool.play(arr[i], 1, 1, 0, 0, 1);

                        } else {
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
    }

    public void stopbtn(View view) {
        try{
            soundPool.release();
            soundPool = null;
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}