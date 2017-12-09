package com.example.fistinbone.myapplication.Fragment;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fistinbone.myapplication.R;
import com.example.fistinbone.myapplication.SQLite.Update;
import com.example.fistinbone.myapplication.Testing1;
import com.example.fistinbone.myapplication.Wombat;

import static com.example.fistinbone.myapplication.WomCare.CHOOSEN_WOMBAT;
import static com.example.fistinbone.myapplication.WomCare.CURRENT_LESSON;
import static com.example.fistinbone.myapplication.WomCare.PAGE_NUMBER;
import static com.example.fistinbone.myapplication.WomCare.PAGE_SIZE;
import static com.example.fistinbone.myapplication.WomCare.wombat1_quiz;
import static com.example.fistinbone.myapplication.WomCare.wombat1_stage;
import static com.example.fistinbone.myapplication.WomCare.wombat2_quiz;
import static com.example.fistinbone.myapplication.WomCare.wombat2_stage;
import static com.example.fistinbone.myapplication.WomCare.wombat3_quiz;
import static com.example.fistinbone.myapplication.WomCare.wombat3_stage;

/**
 * Created by fistinbone on 8/18/2017.
 */

public class FinishFragment extends Fragment implements View.OnClickListener{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView =  inflater.inflate(
                R.layout.fragment_screen_slide_finish,container,false);


        Button button = (Button) rootView.findViewById(R.id.testnow_button);
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.finish_hint);
        TextView textView = (TextView) rootView.findViewById(R.id.finish_textview);

        button.setOnClickListener(this);

        Typeface customFont = Typeface.createFromAsset(this.getContext().getAssets(),"fonts/fontStyle1.ttf");
        textView.setTypeface(customFont);



        float factor = rootView.getContext().getResources().getDisplayMetrics().density;
        linearLayout.removeAllViews();
        for (int i = 0; i < PAGE_SIZE; i++) {
            ImageView imageView = new ImageView(rootView.getContext());
            if (i == PAGE_SIZE-1){
                int height = (int)(30*factor);
                int width = (int)(50*factor);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(height,width));
                imageView.setImageResource(R.drawable.hint);
            }else {
                imageView.setImageResource(R.drawable.hint_shade);
                int height = (int)(20*factor);
                int width = (int)(50*factor);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(height,width));//图片资源
            }
            imageView.setPadding(15,0,15,0);
            linearLayout.addView(imageView); //动态添加图片
        }
        return rootView;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getContext(),Wombat.class);
        switch (CHOOSEN_WOMBAT){
            case "wombat1":
                if (wombat1_quiz < CURRENT_LESSON){wombat1_quiz = CURRENT_LESSON;};
                Update update = new Update(getActivity(),wombat1_stage,wombat1_quiz,0);
                update.execute();
                break;
            case "wombat2":
                if (wombat2_quiz < CURRENT_LESSON){wombat2_quiz = CURRENT_LESSON;};
                update = new Update(getActivity(),wombat2_stage,wombat2_quiz,1);
                update.execute();
                break;
            case "wombat3":
                if (wombat3_quiz < CURRENT_LESSON){wombat3_quiz = CURRENT_LESSON;};
                update = new Update(getActivity(),wombat3_stage,wombat3_quiz,2);
                update.execute();
                break;
            default:
                return;
        }
        getActivity().startActivity(intent);
    }

}