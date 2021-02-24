package martinamagdalenajukic.ferit.lv3zadaca;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class InputFragment extends Fragment {

    private EditText mEtInput;
    private Button mBtnSubmit;
    private ButtonCLickListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mEtInput=view.findViewById(R.id.etInput);
        mBtnSubmit=view.findViewById(R.id.btnSubmit);
        setUpListener();
    }

    private void setUpListener() {
        mBtnSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(mListener!=null){
                    mListener.onButtonClicked(mEtInput.getText().toString());
                }
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof ButtonCLickListener){
            mListener=(ButtonCLickListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener=null;
    }
}
