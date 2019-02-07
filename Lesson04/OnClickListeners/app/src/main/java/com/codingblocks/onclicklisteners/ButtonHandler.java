package com.codingblocks.onclicklisteners;

import android.view.View;
import android.widget.Button;

public class ButtonHandler implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        //Show toast
        //This v is the view that was clicked

        switch (v.getId()) {
            case R.id.btnHello:
                //Show a toast
                break;
//            case R.id.buttonBye:
//                //Show a toast
//                break;
            case R.id.buttonSup:
                //Show a toast
                break;
        }
    }
}
