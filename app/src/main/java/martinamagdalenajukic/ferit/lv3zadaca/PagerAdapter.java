package martinamagdalenajukic.ferit.lv3zadaca;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class PagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mLista;

    public PagerAdapter(@NonNull FragmentManager fm, List<Fragment> fragmentList){
        super(fm);
        mLista=fragmentList;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mLista.get(position);
    }

    @Override
    public int getCount() {
        return mLista.size();
    }

    public CharSequence getPageTitle(int position){
        return "#"+(position+1);
    }
}