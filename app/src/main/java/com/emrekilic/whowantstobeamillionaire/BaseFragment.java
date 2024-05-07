package com.emrekilic.whowantstobeamillionaire;

import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {

    public void addFragment(Fragment fragment) {
        if (getActivity() instanceof MainActivity) {
            MainActivity activity = (MainActivity) getActivity();
            activity.addFragment(fragment);
        }
    }
}
