package martinamagdalenajukic.ferit.lv3zadaca;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class ModularFragment extends Fragment {

    private static final String BUNDLE_KEY="modular";
    private TextView tvModular;
    private ImageView ivModular;
    private ImageClickListener listener;

    public static ModularFragment newInstance(int modul) {
        Bundle args = new Bundle();
        ModularFragment fragment = new ModularFragment();
        args.putInt(BUNDLE_KEY, modul);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_modular, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvModular=view.findViewById(R.id.tvModular);
        ivModular=view.findViewById(R.id.ivModular);
        setUpView();
        setUpListener();
    }

    private void setUpListener() {
        ivModular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null) listener.onImageClicked();
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof ImageClickListener) listener=(ImageClickListener) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;
    }

    private void setUpView() {
        int modul=0;
        if (getArguments()!=null){
            int arg=getArguments().getInt(BUNDLE_KEY);
            modul=arg;
            if (modul==0) tvModular.setText("Modular layout");
            else if (modul==1) {
                ivModular.setImageResource(R.drawable.android);
                ivModular.getLayoutParams().height=900;
                ivModular.getLayoutParams().width=900;
            }
        }
    }
}