package com.jif.soundboard;

import java.util.ArrayList;

import android.app.ListActivity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class EncourageSoundboard extends ListActivity
{
	
	private ArrayList<Sound>	mSounds			= null;
	
	private SoundAdapter		mAdapter		= null;
	
	static MediaPlayer			mMediaPlayer	= null;
	private MediaPlayer			ourMediaPlayer	= null;
	
	/** Called when the activity is first created. */
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		
		
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		
		// create a simple list
		
		mSounds = new ArrayList<Sound>();
		
		Sound s = new Sound();
		
		s.setDescription("Good Job!");
		
		s.setIconResourceId(R.drawable.smiley);
		
		s.setSoundResourceId(R.raw.good_job);
		
		mSounds.add(s);
		
		s = new Sound();
		
		s.setDescription("There Ya Go!");
		
		s.setIconResourceId(R.drawable.smiley);
		
		s.setSoundResourceId(R.raw.there_ya_go);
		
		mSounds.add(s);
		
		s = new Sound();
		
		s.setDescription("Alright!");
		
		s.setIconResourceId(R.drawable.smiley);
		
		s.setSoundResourceId(R.raw.alright);
		
		mSounds.add(s);
		
		s = new Sound();
		
		s.setDescription("That is what is up!");
		
		s.setIconResourceId(R.drawable.smiley);
		
		s.setSoundResourceId(R.raw.thats_whats_up);
		
		mSounds.add(s);
		
		s = new Sound();
		
		s.setDescription("Ok!");
		
		s.setIconResourceId(R.drawable.smiley);
		
		s.setSoundResourceId(R.raw.ok);
		
		mSounds.add(s);
		
		s = new Sound();
		
		s.setDescription("Well Done!");
		
		s.setIconResourceId(R.drawable.smiley);
		
		s.setSoundResourceId(R.raw.well_done);
		
		mSounds.add(s);
		
		s = new Sound();
		
		s.setDescription("Cool!");
		
		s.setIconResourceId(R.drawable.smiley);
		
		s.setSoundResourceId(R.raw.cool);
		
		mSounds.add(s);
		
		mAdapter = new SoundAdapter(this, R.layout.listrow, mSounds);
		
		setListAdapter(mAdapter);		
		
	}
	
	@Override
	public void onListItemClick(ListView parent, View v, int position, long id)
	{
		
		Sound s = (Sound) mSounds.get(position);
		if (ourMediaPlayer != null)
			ourMediaPlayer.release();
		else
			ourMediaPlayer = null;
		ourMediaPlayer = MediaPlayer.create(this, s.getSoundResourceId());
		
		ourMediaPlayer.start();
		
	}
	
}
