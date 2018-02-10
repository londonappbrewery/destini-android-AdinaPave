package com.londonappbrewery.destini;

import android.app.Activity;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends Activity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mTextView;
    Button mButtonTop, mButtonBottom;
    int mStoryIndex = 0;
    int mStory;
    int mAnsTop, mAnsBottom;
    boolean mTopPushed = false, mBottomPushed = false;

    private TopBottom[] mTopBottom = new TopBottom[]{
            new TopBottom(R.string.T1_Story),
            new TopBottom(R.string.T2_Story),
            new TopBottom(R.string.T3_Story),
            new TopBottom(R.string.T3_Story),
            new TopBottom(R.string.T4_End),
            new TopBottom(R.string.T5_End),
            new TopBottom(R.string.T6_End)
    };
    private TopBottom[] mTop = new TopBottom[]{
            new TopBottom(R.string.T1_Ans1),
            new TopBottom(R.string.T2_Ans1),
            new TopBottom(R.string.T3_Ans1),

    };
    private TopBottom[] mBottom = new TopBottom[]{
            new TopBottom(R.string.T1_Ans2),
            new TopBottom(R.string.T2_Ans2),
            new TopBottom(R.string.T3_Ans2),
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mTextView = (TextView) findViewById(R.id.storyTextView);
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);

        mStory = mTopBottom[mStoryIndex].getStoryID();
        mTextView.setText(mStory);

        mAnsTop = mTop[mStoryIndex].getStoryID();
        mButtonTop.setText(mAnsTop);

        mAnsBottom = mBottom[mStoryIndex].getStoryID();
        mButtonBottom.setText(mAnsBottom);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTopPushed = true;
                updateStory();
            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBottomPushed = true;
                updateStory();
            }
        });

    }

    private void updateStory() {

       if (mTopPushed==true)
       {
           if(mStoryIndex==0 || mStoryIndex==1){
               mStoryIndex = 2;
               mStory = mTopBottom[mStoryIndex].getStoryID();
               mTextView.setText(mStory);

               mAnsTop = mTop[mStoryIndex].getStoryID();
               mButtonTop.setText(mAnsTop);

               mAnsBottom = mBottom[mStoryIndex].getStoryID();
               mButtonBottom.setText(mAnsBottom);
           }

           else if(mStoryIndex==2){
               mStoryIndex = 6;
               mStory = mTopBottom[mStoryIndex].getStoryID();
               mTextView.setText(mStory);
           }
       }


       if(mBottomPushed==true)
       {
           if(mStoryIndex==0){
               mStoryIndex=1;
               mStory = mTopBottom[mStoryIndex].getStoryID();
               mTextView.setText(mStory);

               mAnsTop = mTop[mStoryIndex].getStoryID();
               mButtonTop.setText(mAnsTop);

               mAnsBottom = mBottom[mStoryIndex].getStoryID();
               mButtonBottom.setText(mAnsBottom);
           }
           else if(mStoryIndex==1){
               mStoryIndex=4;
               mStory = mTopBottom[mStoryIndex].getStoryID();
               mTextView.setText(mStory);
           }
           else if (mStoryIndex==2){
               mStoryIndex = 5;
               mStory = mTopBottom[mStoryIndex].getStoryID();
               mTextView.setText(mStory);
           }

       }

       mTopPushed = false;
       mBottomPushed = false;
    }


}