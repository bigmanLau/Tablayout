package reforce.bigman.com.tablayout;

import android.annotation.SuppressLint;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * create by bigman
 * create date == 2018/8/28
 * create time == 10:19
 */


@SuppressLint("ValidFragment")
class TradeFragmentFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
          return inflater.inflate(R.layout.fragment_trade, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getView().findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               TradeCourseActivity.openTradeCourseActivity(getActivity());
            }
        });
    }

    public static TradeFragmentFragment newInstance() {
        TradeFragmentFragment fragment = new TradeFragmentFragment();
        return fragment;
    }
}
