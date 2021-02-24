package martinamagdalenajukic.ferit.lv3zadaca;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ButtonCLickListener, ImageClickListener{
    private ViewPager mviewPager;
    private TabLayout mtabLayout;
    private InputFragment minputFragment;
    private List<Fragment> mfragmentList;
    private FragmentManager mfragmentManager;
    private PagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mviewPager=findViewById(R.id.viewPager);
        mtabLayout=findViewById(R.id.tabLayout);
        minputFragment=new InputFragment();
        setUpViewPager();
    }

    private void setUpViewPager() {
        mfragmentList=new ArrayList<>();
        mfragmentList.add(minputFragment);
        mfragmentList.add(ModularFragment.newInstance(0));
        mfragmentList.add(ModularFragment.newInstance(1));
        adapter=new PagerAdapter(getSupportFragmentManager(), mfragmentList);
        mviewPager.setAdapter(adapter);
        mtabLayout.setupWithViewPager(mviewPager);
    }

    @Override
    public void onButtonClicked(String message){
        mfragmentList.add(MessageFragment.newInstance(message));
        int lastElement=mfragmentList.size()-1;
        adapter=new PagerAdapter(getSupportFragmentManager(), mfragmentList);
        mviewPager.setAdapter(adapter);
        mtabLayout.setupWithViewPager(mviewPager);
        mviewPager.setCurrentItem(lastElement);
    }

    @Override
    public void onImageClicked() {
        Toast.makeText(this, "Hey, don't touch me!!", Toast.LENGTH_LONG).show();
    }
}