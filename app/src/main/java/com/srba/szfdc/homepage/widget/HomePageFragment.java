package com.srba.szfdc.homepage.widget;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import com.srba.szfdc.R;
import com.srba.szfdc.homepage.ui.GridViewOnScroll;
import com.srba.szfdc.homepage.ui.PullToZoomScrollView;
import com.srba.szfdc.main.widget.MainActivity;
import com.srba.szfdc.main.widget.OnFragmentInteractionListener;
import com.srba.szfdc.utils.ImageLoaderUtils;
import com.srba.szfdc.utils.LogUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 */
public class HomePageFragment extends Fragment {
    private static final String TAG = "HomePageFragment";
    private MainActivity mContext;
    private PullToZoomScrollView scrollView;
    private ImageView mImg_zoom;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;


    private GridViewOnScroll gview;
    private List<Map<String, Object>> data_list;
    private SimpleAdapter sim_adapter;

    private String[] iconName = { "二手房", "新房", "租房", "买房", "卖房", "找房" };

    // 图片封装为一个数组
    private int[] icon = { R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher,
            R.drawable.ic_launcher};



    /**
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomePageFragment.
     */
    public static HomePageFragment newInstance(String param1, String param2) {
        HomePageFragment fragment = new HomePageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public HomePageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homepage, container, false);

        mContext = (MainActivity) getActivity();
        loadViewForCode(view);
        scrollView = (PullToZoomScrollView) view.findViewById(R.id.scroll_view);
        scrollView.getPullRootView().findViewById(R.id.tv_test1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("zhuwenwu", "onClick -->");
            }
        });

        scrollView.getPullRootView().findViewById(R.id.tv_test2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("zhuwenwu", "onClick -->");
            }
        });

        scrollView.getPullRootView().findViewById(R.id.tv_test3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("zhuwenwu", "onClick -->");
            }
        });
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        mContext.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        int mScreenHeight = localDisplayMetrics.heightPixels;
        int mScreenWidth = localDisplayMetrics.widthPixels;
        LinearLayout.LayoutParams localObject = new LinearLayout.LayoutParams(mScreenWidth, (int) (9.0F * (mScreenWidth / 16.0F)));
        scrollView.setHeaderLayoutParams(localObject);

        return view;
    }

    private void loadViewForCode(View view) {
        PullToZoomScrollView scrollView = (PullToZoomScrollView) view.findViewById(R.id.scroll_view);
        View headView = LayoutInflater.from(mContext).inflate(R.layout.profile_head_view, null, false);
        View zoomView = LayoutInflater.from(mContext).inflate(R.layout.list_head_zoom_view, null, false);
        mImg_zoom = (ImageView) zoomView.findViewById(R.id.iv_zoom);
        ImageLoaderUtils.display(mContext,mImg_zoom,"http://img5q.duitang.com/uploads/item/201501/14/20150114165847_EVtXd.jpeg");


        View contentView = LayoutInflater.from(mContext).inflate(R.layout.profile_content_view, null, false);

        gview = (GridViewOnScroll) contentView.findViewById(R.id.gridview);
        //新建List
        data_list = new ArrayList<>();
        //获取数据
        getData();
        //新建适配器
        String [] from ={"image","text"};
        int [] to = {R.id.image,R.id.text};
        LogUtils.d(TAG,"size="+data_list.size());
        sim_adapter = new SimpleAdapter(mContext, data_list, R.layout.item_gridview, from, to);
        //配置适配器
        gview.setAdapter(sim_adapter);


        scrollView.setHeaderView(headView);
        scrollView.setZoomView(zoomView);
        scrollView.setScrollContentView(contentView);
    }
    public List<Map<String, Object>> getData(){
        //cion和iconName的长度是相同的，这里任选其一都可以
        for(int i=0;i<icon.length;i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            data_list.add(map);
        }
        return data_list;
    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
