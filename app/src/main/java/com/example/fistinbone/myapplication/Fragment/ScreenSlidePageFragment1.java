package com.example.fistinbone.myapplication.Fragment;

        import android.graphics.Typeface;
        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.TextView;

        import com.example.fistinbone.myapplication.R;

        import static com.example.fistinbone.myapplication.WomCare.CHOOSEN_WOMBAT;
        import static com.example.fistinbone.myapplication.WomCare.CURRENT_LESSON;
        import static com.example.fistinbone.myapplication.WomCare.PAGE_NUMBER;
        import static com.example.fistinbone.myapplication.WomCare.PAGE_SIZE;

/**
 * Created by fistinbone on 8/18/2017.
 */

public class ScreenSlidePageFragment1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(
                R.layout.fragment_screen_slide_page1, container, false);


        TextView tv1 = (TextView) rootView.findViewById(R.id.fragment_question);
        TextView tv2 = (TextView) rootView.findViewById(R.id.fragment_answer);
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.page1_hint);


        Typeface customFont = Typeface.createFromAsset(this.getContext().getAssets(),"fonts/fontStyle1.ttf");
        tv1.setTypeface(customFont,Typeface.BOLD);
        tv2.setTypeface(customFont);


        String wombat = CHOOSEN_WOMBAT;
        int lesson = CURRENT_LESSON;

        switch (wombat){
            case "wombat1":
                switch (lesson){
                    case 1:
                        if(PAGE_NUMBER == 2){
                            tv1.setText(R.string.wombat1_lesson1_Q1);
                            tv2.setText(R.string.wombat1_lesson1_A1);}
                        if(PAGE_NUMBER == 3){
                            tv1.setText(R.string.wombat1_lesson1_Q2);
                            tv2.setText(R.string.wombat1_lesson1_A2);}
                        break;
                    case 3:
                        if(PAGE_NUMBER == 2){
                            tv1.setText(R.string.wombat1_lesson3H_Q1);
                            tv2.setText(R.string.wombat1_lesson3H_A1);}
                        if(PAGE_NUMBER == 3){
                            tv1.setText(R.string.wombat1_lesson3H_Q2);
                            tv2.setText(R.string.wombat1_lesson3H_A2);}
                        break;
                    case 4:
                        if(PAGE_NUMBER == 2){
                            tv1.setText(R.string.wombat1_lesson7CA_Q1);
                            tv2.setText(R.string.wombat1_lesson7CA_A1);}
                        break;
                    case 6:
                        if(PAGE_NUMBER == 2){
                            tv1.setText(R.string.wombat3N_lesson6T_Q1);
                            tv2.setText(R.string.wombat3N_lesson6T_A1);}
                        break;
                    case 7:
                        if(PAGE_NUMBER == 2){
                            tv1.setText(R.string.wombat3N_lesson6T_Q1);
                            tv2.setText(R.string.wombat3N_lesson6T_A1);}
                        break;
                }
                break;

            case "wombat2":
                switch (lesson){
                    case 1:
                        if(PAGE_NUMBER == 2){
                            tv1.setText(R.string.wombat2S_lesson1_Q1);
                            tv2.setText(R.string.wombat2S_lesson1_A1);}
                        if(PAGE_NUMBER == 3){
                            tv1.setText(R.string.wombat2S_lesson1_Q2);
                            tv2.setText(R.string.wombat2S_lesson1_A2);}
                        break;
                    case 3:
                        if(PAGE_NUMBER == 2){
                            tv1.setText(R.string.wombat2S_lesson3H_Q1);
                            tv2.setText(R.string.wombat2S_lesson3H_A1);}
                        if(PAGE_NUMBER == 3){
                            tv1.setText(R.string.wombat2S_lesson3H_Q2);
                            tv2.setText(R.string.wombat2S_lesson3H_A2);}
                        break;
                    case 4:
                        if(PAGE_NUMBER == 2){
                            tv1.setText(R.string.wombat2S_lesson7CA_Q1);
                            tv2.setText(R.string.wombat2S_lesson7CA_A1);}
                        break;
                    case 6:
                        if(PAGE_NUMBER == 2){
                            tv1.setText(R.string.wombat2S_lesson6T_Q1);
                            tv2.setText(R.string.wombat2S_lesson6T_A1);}
                        break;
                    case 7:
                        if(PAGE_NUMBER == 2){
                            tv1.setText(R.string.wombat2S_lesson6T_Q1);
                            tv2.setText(R.string.wombat2S_lesson6T_A1);}
                        break;
                }
                break;

            case "wombat3":
                switch (lesson){
                    case 1:
                        if(PAGE_NUMBER == 2){
                            tv1.setText(R.string.wombat3N_lesson1_Q1);
                            tv2.setText(R.string.wombat3N_lesson1_A1);}
                        if(PAGE_NUMBER == 3){
                            tv1.setText(R.string.wombat3N_lesson1_Q2);
                            tv2.setText(R.string.wombat3N_lesson1_A2);}
                        break;
                    case 3:
                        if(PAGE_NUMBER == 2){
                            tv1.setText(R.string.wombat3N_lesson3H_Q1);
                            tv2.setText(R.string.wombat3N_lesson3H_A1);}
                        if(PAGE_NUMBER == 3){
                            tv1.setText(R.string.wombat3N_lesson3H_Q2);
                            tv2.setText(R.string.wombat3N_lesson3H_A2);}
                        break;
                    case 4:
                        if(PAGE_NUMBER == 2){
                            tv1.setText(R.string.wombat3N_lesson7CA_Q1);
                            tv2.setText(R.string.wombat3N_lesson7CA_A1);}
                        break;
                    case 6:
                        if(PAGE_NUMBER == 2){
                            tv1.setText(R.string.wombat3N_lesson6T_Q1);
                            tv2.setText(R.string.wombat3N_lesson6T_A1);}
                        break;
                    case 7:
                        if(PAGE_NUMBER == 2){
                            tv1.setText(R.string.wombat3N_lesson6T_Q1);
                            tv2.setText(R.string.wombat3N_lesson6T_A1);}
                        break;
                }
                break;
            default:
                break;
        }



        float factor = rootView.getContext().getResources().getDisplayMetrics().density;
        linearLayout.removeAllViews();
        for (int i = 0; i < PAGE_SIZE; i++) {
            ImageView imageView = new ImageView(rootView.getContext());
            if (PAGE_NUMBER == i+1){
                imageView.setImageResource(R.drawable.hint);
                int height = (int)(30*factor);
                int width = (int)(50*factor);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(height,width));
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
}