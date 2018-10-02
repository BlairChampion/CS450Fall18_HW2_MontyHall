package edu.stlawu.cs450fall18_hw2_montyhall;


import android.graphics.drawable.Drawable;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends Fragment {

    public AudioAttributes aa = null;
    private SoundPool soundPool = null;
    private int clickSound = 0;
    private int goatSound = 0;
    private int carSound = 0;
    private int doornumber = new Random().nextInt(2);
    private int decider = new Random().nextInt(1);
    private int choicecounter = 0;
    private int selecteddoor = 0;
    private int closeddoor = 0;
    private int win_count = 0;
    private int loss_count = 0;

    public GameFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        this.aa = new AudioAttributes
                .Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .setUsage(AudioAttributes.USAGE_GAME)
                .build();

        this.soundPool = new SoundPool.Builder()
                .setMaxStreams(1)
                .setAudioAttributes(aa)
                .build();
        this.clickSound = this.soundPool.load(
                this.getContext(), R.raw.click, 1);
        this.goatSound = this.soundPool.load(
                this.getContext(), R.raw.goat, 1);
        this.carSound = this.soundPool.load(
                this.getContext(), R.raw.click, 1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View doorView = inflater.inflate(R.layout.fragment_game, container, false);

        final ImageView door1 = doorView.findViewById(R.id.door1);
        final ImageView door2 = doorView.findViewById(R.id.door2);
        final ImageView door3 = doorView.findViewById(R.id.door3);

        door1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(clickSound, 1f,
                        1f, 1, 0, 1f);

                if (choicecounter == 0) {
                    door1.setImageLevel(1);
                    selecteddoor = 1;

                    if (doornumber == 0) {
                        if (decider == 0) {
                            door2.setImageLevel(3);
                            closeddoor = 3;
                        } else {
                            door3.setImageLevel(3);
                            closeddoor = 2;
                        }
                        soundPool.play(goatSound, 1f,
                                1f, 1, 0, 1f);
                    }

                    if (doornumber == 1) {
                        door3.setImageLevel(3);
                        closeddoor = 2;
                        soundPool.play(goatSound, 1f,
                                1f, 1, 0, 1f);
                    }

                    if (doornumber == 2) {
                        door2.setImageLevel(3);
                        closeddoor = 3;
                        soundPool.play(goatSound, 1f,
                                1f, 1, 0, 1f);
                    }
                    choicecounter++;
                }

                if (choicecounter == 2) {
                    if (selecteddoor == 1 || closeddoor == 1) {
                        door1.setImageLevel(4);
                        door1.setImageLevel(5);
                        door1.setImageLevel(6);

                        if (doornumber == 0) {
                            door1.setImageLevel(2);
                            win_count++;

                            soundPool.play(carSound, 1f,
                                    1f, 1, 0, 1f);

                            if (selecteddoor == 2 || closeddoor == 2) {
                                door2.setImageLevel(3);
                            } else {
                                door3.setImageLevel(3);
                            }
                            soundPool.play(goatSound, 1f,
                                    1f, 1, 0, 1f);

                        } else {
                            door1.setImageLevel(3);
                            loss_count++;

                            soundPool.play(goatSound, 1f,
                                    1f, 1, 0, 1f);

                            if (doornumber == 1) {
                                door2.setImageLevel(2);
                                soundPool.play(carSound, 1f,
                                        1f, 1, 0, 1f);
                            }

                            if (doornumber == 2) {
                                door3.setImageLevel(2);
                                soundPool.play(carSound, 1f,
                                        1f, 1, 0, 1f);
                            }
                        }
                    }
                    choicecounter--;
                }
            }
        });

        door2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(clickSound, 1f,
                        1f, 1, 0, 1f);

                if (choicecounter == 0) {
                    door2.setImageLevel(1);
                    selecteddoor = 2;

                    if (doornumber == 1) {
                        if (decider == 0) {
                            door1.setImageLevel(3);
                            closeddoor = 3;
                        } else {
                            door3.setImageLevel(3);
                            closeddoor = 1;
                        }
                        soundPool.play(goatSound, 1f,
                                1f, 1, 0, 1f);
                    }

                    if (doornumber == 0) {
                        door3.setImageLevel(3);
                        closeddoor = 1;
                        soundPool.play(goatSound, 1f,
                                1f, 1, 0, 1f);
                    }

                    if (doornumber == 2) {
                        door1.setImageLevel(3);
                        closeddoor = 3;
                        soundPool.play(goatSound, 1f,
                                1f, 1, 0, 1f);
                    }
                    choicecounter++;
                }

                if (choicecounter == 1) {
                    if (selecteddoor == 2 || closeddoor == 2) {
                        door2.setImageLevel(4);
                        door2.setImageLevel(5);
                        door2.setImageLevel(6);

                        if (doornumber == 1) {
                            door2.setImageLevel(2);
                            win_count++;

                            soundPool.play(carSound, 1f,
                                    1f, 1, 0, 1f);

                            if (selecteddoor == 1 || closeddoor == 1) {
                                door1.setImageLevel(3);
                            } else {
                                door3.setImageLevel(3);
                            }
                            soundPool.play(goatSound, 1f,
                                    1f, 1, 0, 1f);

                        } else {
                            door2.setImageLevel(3);
                            loss_count++;

                            soundPool.play(goatSound, 1f,
                                    1f, 1, 0, 1f);

                            if (doornumber == 0) {
                                door1.setImageLevel(2);
                                soundPool.play(carSound, 1f,
                                        1f, 1, 0, 1f);
                            }

                            if (doornumber == 2) {
                                door3.setImageLevel(2);
                                soundPool.play(carSound, 1f,
                                        1f, 1, 0, 1f);
                            }
                        }
                    }
                    choicecounter--;
                }
            }
        });

        door3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(clickSound, 1f,
                        1f, 1, 0, 1f);

                if (choicecounter == 1) {
                    door3.setImageLevel(1);
                    selecteddoor = 3;

                    if (doornumber == 2) {
                        if (decider == 0) {
                            door1.setImageLevel(3);
                            closeddoor = 2;
                        } else {
                            door2.setImageLevel(3);
                            closeddoor = 1;
                        }
                        soundPool.play(goatSound, 1f,
                                1f, 1, 0, 1f);
                    }

                    if (doornumber == 1) {
                        door1.setImageLevel(3);
                        closeddoor = 2;
                        soundPool.play(goatSound, 1f,
                                1f, 1, 0, 1f);
                    }

                    if (doornumber == 0) {
                        door2.setImageLevel(3);
                        soundPool.play(goatSound, 1f,
                                1f, 1, 0, 1f);
                    }
                    choicecounter++;
                }

                if (choicecounter == 1) {
                    if (selecteddoor == 3 || closeddoor == 3) {
                        door3.setImageLevel(4);
                        door3.setImageLevel(5);
                        door3.setImageLevel(6);

                        if (doornumber == 2) {
                            door3.setImageLevel(2);
                            win_count++;

                            soundPool.play(carSound, 1f,
                                    1f, 1, 0, 1f);

                            if (selecteddoor == 1 || closeddoor == 1) {
                                door1.setImageLevel(3);
                            } else {
                                door2.setImageLevel(3);
                            }
                            soundPool.play(goatSound, 1f,
                                    1f, 1, 0, 1f);

                        } else {
                            door3.setImageLevel(3);
                            loss_count++;

                            soundPool.play(goatSound, 1f,
                                    1f, 1, 0, 1f);

                            if (doornumber == 0) {
                                door1.setImageLevel(2);
                                soundPool.play(carSound, 1f,
                                        1f, 1, 0, 1f);
                            }

                            if (doornumber == 1) {
                                door2.setImageLevel(2);
                                soundPool.play(carSound, 1f,
                                        1f, 1, 0, 1f);
                            }
                        }
                    }
                    choicecounter--;
                }
            }
        });

        return doorView;
    }

}

