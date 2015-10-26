package com.sbosovskyi.geekhub.lesson3;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sbosovskyi.geekhub.lesson3.interfaces.CallbackForDifferentObjects;
import com.sbosovskyi.geekhub.lesson3.interfaces.MakeWorkInterface;

/**
 * Created by boss1088 on 10/26/15.
 */
public class MainFragment extends Fragment {

    private EditText editText;
    private Button button;
    private TextView textView;

    private MakeWorkInterface myInterface;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            myInterface = (MakeWorkInterface) activity;
        } catch (ClassCastException exception) {
            throw new ClassCastException(activity.toString() + " Must implement MakeWorkInterface");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        button = (Button) view.findViewById(R.id.button);
        textView = (TextView) view.findViewById(R.id.text_view);
        editText = (EditText) view.findViewById(R.id.edit_text);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myInterface.success("");
//                send(new CallbackForDifferentObjects<Integer>() {
//                    @Override
//                    public void success(Integer result) {
//                        textView.setText(String.valueOf(result));
//                    }
//                });
//
//                makeWorkWithInterface(new MakeWorkInterface() {
//                    @Override
//                    public void success(final String result) {
//                        getActivity().runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                textView.setText(result);
//                            }
//                        });
//                    }
//
//                    @Override
//                    public void error() {
//
//                    }
//                });

            }
        });
    }

    private void makeWorkWithInterface(final MakeWorkInterface myInterface) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String text = editText.getText().toString().trim();
                myInterface.success(text);
            }
        }).start();
    }

    public <T> boolean send(final CallbackForDifferentObjects<T> callback) {
        callback.success((T) "hello");
        return true;
    }
}
