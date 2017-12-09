package com.example.fistinbone.myapplication.Fragment;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fistinbone.myapplication.R;
import com.example.fistinbone.myapplication.SQLite.Update;
import com.example.fistinbone.myapplication.Wombat;

import static com.example.fistinbone.myapplication.WomCare.CHOOSEN_WOMBAT;
import static com.example.fistinbone.myapplication.WomCare.CURRENT_LESSON;
import static com.example.fistinbone.myapplication.WomCare.PAGE_SIZE;
import static com.example.fistinbone.myapplication.WomCare.isQuizSelected1;
import static com.example.fistinbone.myapplication.WomCare.isQuizSelected2;
import static com.example.fistinbone.myapplication.WomCare.testCompleted;
import static com.example.fistinbone.myapplication.WomCare.wombat1_quiz;
import static com.example.fistinbone.myapplication.WomCare.wombat1_stage;
import static com.example.fistinbone.myapplication.WomCare.wombat2_quiz;
import static com.example.fistinbone.myapplication.WomCare.wombat2_stage;
import static com.example.fistinbone.myapplication.WomCare.wombat3_quiz;
import static com.example.fistinbone.myapplication.WomCare.wombat3_stage;

/**
 * Created by fistinbone on 8/24/2017.
 */

public class CongratulationFragment extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test_congratulation,container,false);

        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.congratulation_hint);
        ImageButton button = (ImageButton) view.findViewById(R.id.congratulation_button);

        TextView textView = (TextView) view.findViewById(R.id.textView2);
        TextView textView2 = (TextView) view.findViewById(R.id.textView3);

        button.setOnClickListener(this);

        Typeface customFont = Typeface.createFromAsset(this.getContext().getAssets(), "fonts/fontStyle1.ttf");
        textView.setTypeface(customFont, Typeface.BOLD);
        textView2.setTypeface(customFont);




        float factor = view.getContext().getResources().getDisplayMetrics().density;
        linearLayout.removeAllViews();
        for (int i = 0; i < PAGE_SIZE; i++) {
            ImageView imageView = new ImageView(view.getContext());
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
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (CHOOSEN_WOMBAT){
            case "wombat1":
                if (CURRENT_LESSON == wombat1_stage){wombat1_stage++;}
                Update update = new Update(getActivity(),wombat1_stage,wombat1_quiz,0);
                update.execute();
                break;
            case "wombat2":
                if (CURRENT_LESSON == wombat2_stage){wombat2_stage++;}
                update = new Update(getActivity(),wombat2_stage,wombat2_quiz,1);
                update.execute();
                break;
            case "wombat3":
                if (CURRENT_LESSON == wombat3_stage){wombat3_stage++;}
                update = new Update(getActivity(),wombat3_stage,wombat3_quiz,2);
                update.execute();
                break;
            default:
                return;
        }
        if(testCompleted >= 2) {
            Intent intent = new Intent(getContext(), Wombat.class);
            getActivity().startActivity(intent);
            getActivity().finish();
        }else{
            Toast.makeText(this.getContext(),"please finish all test to learn more about me", Toast.LENGTH_LONG).show();
        }
    }
}
