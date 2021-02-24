package martinamagdalenajukic.ferit.lv3zadaca;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MessageFragment extends Fragment {

    private static final String BUNDLE_KEY="message";
    private TextView tvMessage;

    public static MessageFragment newInstance(String message) {
        Bundle args = new Bundle();
        MessageFragment fragment = new MessageFragment();
        args.putString(BUNDLE_KEY, message);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_message, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvMessage=view.findViewById(R.id.tvMessage);
        setUpTextView();
    }

    private void setUpTextView() {
        String message="...";
        if (getArguments()!=null){
            String arg=getArguments().getString(BUNDLE_KEY);
            if (arg!=null&&!arg.isEmpty()) message=arg;
        }
        tvMessage.setText(message);
    }
}