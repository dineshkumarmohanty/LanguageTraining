package singlepageapp.mohanty.dinesh.com.languagetraining;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class Numbers extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    private  AudioManager audioManager;

//it is a parameter of the Audio Focus Request method and it is used to say the app that what we are going to do in different situtation

    AudioManager.OnAudioFocusChangeListener audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {

            if(focusChange  == AudioManager.AUDIOFOCUS_LOSS)
            {
               mediaRelease();
                audioManager.abandonAudioFocus(audioFocusChangeListener);
            }else if (focusChange == AudioManager.AUDIOFOCUS_GAIN)
            {
                mMediaPlayer.start();
            }else  if(focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT)
            {
                mMediaPlayer.pause();
            }else if(focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK)
            {
                mMediaPlayer.pause();
            }


        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);


        //Array list of the word object

       final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("two", "otiiko", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("five", "massokka", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("six", "temmokka", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("nine", "wo’e", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("ten", "na’aacha", R.drawable.number_ten, R.raw.number_ten));


        //call the custom array adpter and set it to list view

        WordAdapter arrayAdapter = new WordAdapter(this,words,R.color.category_numbers);
        final ListView listView = (ListView) findViewById(R.id.number_layout);
        listView.setAdapter(arrayAdapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,final View view, int position, long id) {
                Word word = words.get(position);
                int sound = word.getIdsound();
                mediaRelease();

                //Request the system for Audio Focus so that music can be played in the app

                audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
               int gain = audioManager.requestAudioFocus(audioFocusChangeListener , AudioManager.STREAM_MUSIC , AudioManager.AUDIOFOCUS_GAIN);

                //if it get the grant then we can play music inside the app

                if (gain == AudioManager.AUDIOFOCUS_REQUEST_GRANTED)
                {



                    mMediaPlayer = MediaPlayer.create(Numbers.this,sound);
                    mMediaPlayer.start();

                    ImageView imageView = (ImageView) view.findViewById(R.id.pause_play_button) ;
                    imageView.setImageResource(R.drawable.ic_pause_white_24dp);


             //It is a callback method and called when the music play is finished.

                    mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mediaRelease();
                            ImageView imageView = (ImageView) view.findViewById(R.id.pause_play_button) ;
                            imageView.setImageResource(R.drawable.ic_play_arrow_white_24dp);

                        }
                    });


                }


            }
        });


    }
    private void mediaRelease()
    {
        if(mMediaPlayer != null)
        {
            mMediaPlayer.release();
            mMediaPlayer= null;
            audioManager.abandonAudioFocus(audioFocusChangeListener);
            }
    }
    //we override the onStop method of the Activity so that we can stop the music when the activity is close

    @Override
    protected void onStop() {
        super.onStop();
        mediaRelease();

    }
}
