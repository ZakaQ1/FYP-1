package com.example.n_template;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Umpiring extends AppCompatActivity {

    ImageView ball1, ball2, ball3, ball4, ball5, ball6, ball7, ball8, ball9, run0, run1, run2, run3, run4, run5, run6, runout, wide, noball, wicket;
    boolean flag1, flag2, flag3, flag4, flag5, flag6, ballflag1, ballflag2, ballflag3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_umpiring);
        getSupportActionBar().hide();


            ball1 = findViewById(R.id.img_ball1);
            ball2 = findViewById(R.id.img_ball2);
            ball3 = findViewById(R.id.img_ball3);
            ball4 = findViewById(R.id.image_ball4);
            ball5 = findViewById(R.id.img_ball5);
            ball6 = findViewById(R.id.img_ball6);
//        ball7 = findViewById(R.id.img_ball7);
//        ball8 = findViewById(R.id.img_ball8);
//        ball9 = findViewById(R.id.img_ball9);

            run0 = findViewById(R.id.img_run0);
            run1 = findViewById(R.id.image_run1);
            run2 = findViewById(R.id.img_run2);
            run3 = findViewById(R.id.img_run3);
            run4 = findViewById(R.id.img_run4);
            run5 = findViewById(R.id.img_run5);
            run6 = findViewById(R.id.img_run6);
            wicket = findViewById(R.id.img_wicket);


            ball1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ball1.setImageResource(R.drawable.ball2);
                    flag1=false;
                }
            });
            ball2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ball2.setImageResource(R.drawable.ball2);
                    flag2=false;
                }
            });
            ball3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ball3.setImageResource(R.drawable.ball2);
                    flag3=false;
                }
            });
            ball4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ball4.setImageResource(R.drawable.ball2);
                    flag4=false;
                }
            });
            ball5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ball5.setImageResource(R.drawable.ball2);
                    flag5=false;
                }
            });
            ball6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ball6.setImageResource(R.drawable.ball2);
                    flag6=false;
                }
            });



//            run0.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (flag1 == false) {
//                        ball1.setImageResource(R.drawable.run0);
//                        flag1 = true;
//                    } else if (flag2 == false) {
//                        ball2.setImageResource(R.drawable.run0);
//                        flag2 = true;
//                    } else if (flag3 == false) {
//                        ball3.setImageResource(R.drawable.run0);
//                        flag3 = true;
//                    } else if (flag4 == false) {
//                        ball4.setImageResource(R.drawable.run0);
//                        flag4 = true;
//                    } else if (flag5 == false) {
//                        ball5.setImageResource(R.drawable.run0);
//                        flag5 = true;
//                    } else if (flag6 == false) {
//                        ball6.setImageResource(R.drawable.run0);
//                        flag6 = true;
//                    }
//                }
//            });

//            run1.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    if (flag1 == false) {
//                        ball1.setImageResource(R.drawable.run1);
//                        flag1 = true;
//                    } else if (flag2 == false) {
//                        ball2.setImageResource(R.drawable.run1);
//                        flag2 = true;
//                    } else if (flag3 == false) {
//                        ball3.setImageResource(R.drawable.run1);
//                        flag3 = true;
//                    } else if (flag4 == false) {
//                        ball4.setImageResource(R.drawable.run1);
//                        flag4 = true;
//                    } else if (flag5 == false) {
//                        ball5.setImageResource(R.drawable.run1);
//                        flag5 = true;
//                    } else if (flag6 == false) {
//                        ball6.setImageResource(R.drawable.run1);
//                        flag6 = true;
//                    }
//
//
//                }
//            });
//            run2.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (flag1 == false) {
//                        ball1.setImageResource(R.drawable.run2);
//                        flag1 = true;
//                    } else if (flag2 == false) {
//                        ball2.setImageResource(R.drawable.run2);
//                        flag2 = true;
//                    } else if (flag3 == false) {
//                        ball3.setImageResource(R.drawable.run2);
//                        flag3 = true;
//                    } else if (flag4 == false) {
//                        ball4.setImageResource(R.drawable.run2);
//                        flag4 = true;
//                    } else if (flag5 == false) {
//                        ball5.setImageResource(R.drawable.run2);
//                        flag5 = true;
//                    } else if (flag6 == false) {
//                        ball6.setImageResource(R.drawable.run2);
//                        flag6 = true;
//                    }
//                }
//            });

//            run3.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (flag1 == false) {
//                        ball1.setImageResource(R.drawable.run3);
//                        flag1 = true;
//                    } else if (flag2 == false) {
//                        ball2.setImageResource(R.drawable.run3);
//                        flag2 = true;
//                    } else if (flag3 == false) {
//                        ball3.setImageResource(R.drawable.run3);
//                        flag3 = true;
//                    } else if (flag4 == false) {
//                        ball4.setImageResource(R.drawable.run3);
//                        flag4 = true;
//                    } else if (flag5 == false) {
//                        ball5.setImageResource(R.drawable.run3);
//                        flag5 = true;
//                    } else if (flag6 == false) {
//                        ball6.setImageResource(R.drawable.run3);
//                        flag6 = true;
//                    }
//                }
//            });

//            run4.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (flag1 == false) {
//                        ball1.setImageResource(R.drawable.run4);
//                        flag1 = true;
//                    } else if (flag2 == false) {
//                        ball2.setImageResource(R.drawable.run4);
//                        flag2 = true;
//                    } else if (flag3 == false) {
//                        ball3.setImageResource(R.drawable.run4);
//                        flag3 = true;
//                    } else if (flag4 == false) {
//                        ball4.setImageResource(R.drawable.run4);
//                        flag4 = true;
//                    } else if (flag5 == false) {
//                        ball5.setImageResource(R.drawable.run4);
//                        flag5 = true;
//                    } else if (flag6 == false) {
//                        ball6.setImageResource(R.drawable.run4);
//                        flag6 = true;
//                    }
//                }
//            });

//            run5.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (flag1 == false) {
//                        ball1.setImageResource(R.drawable.run5);
//                        flag1 = true;
//                    } else if (flag2 == false) {
//                        ball2.setImageResource(R.drawable.run5);
//                        flag2 = true;
//                    } else if (flag3 == false) {
//                        ball3.setImageResource(R.drawable.run5);
//                        flag3 = true;
//                    } else if (flag4 == false) {
//                        ball4.setImageResource(R.drawable.run5);
//                        flag4 = true;
//                    } else if (flag5 == false) {
//                        ball5.setImageResource(R.drawable.run5);
//                        flag5 = true;
//                    } else if (flag6 == false) {
//                        ball6.setImageResource(R.drawable.run5);
//                        flag6 = true;
//                    }
//                }
//            });
//            run6.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (flag1 == false) {
//                        ball1.setImageResource(R.drawable.run6);
//                        flag1 = true;
//                    } else if (flag2 == false) {
//                        ball2.setImageResource(R.drawable.run6);
//                        flag2 = true;
//                    } else if (flag3 == false) {
//                        ball3.setImageResource(R.drawable.run6);
//                        flag3 = true;
//                    } else if (flag4 == false) {
//                        ball4.setImageResource(R.drawable.run6);
//                        flag4 = true;
//                    } else if (flag5 == false) {
//                        ball5.setImageResource(R.drawable.run6);
//                        flag5 = true;
//                    } else if (flag6 == false) {
//                        ball6.setImageResource(R.drawable.run6);
//                        flag6 = true;
//                    }
//
//                }
//            });



//            wicket.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (flag1 == false) {
//                        ball1.setImageResource(R.drawable.wicket);
//                        flag1 = true;
//                    } else if (flag2 == false) {
//                        ball2.setImageResource(R.drawable.wicket);
//                        flag2 = true;
//                    } else if (flag3 == false) {
//                        ball3.setImageResource(R.drawable.wicket);
//                        flag3 = true;
//                    } else if (flag4 == false) {
//                        ball4.setImageResource(R.drawable.wicket);
//                        flag4 = true;
//                    } else if (flag5 == false) {
//                        ball5.setImageResource(R.drawable.wicket);
//                        flag5 = true;
//                    } else if (flag6 == false) {
//                        ball6.setImageResource(R.drawable.wicket);
//                        flag6 = true;
//                    }
//
//                }
//            });

        }
}