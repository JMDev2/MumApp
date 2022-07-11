package com.moringaschool.mumapp.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.moringaschool.mumapp.R;
import com.moringaschool.mumapp.adapters.ImageAdapter;
import com.moringaschool.mumapp.adapters.PostAdapter;
import com.moringaschool.mumapp.adapters.articleAdapterHorizontal;
import com.moringaschool.mumapp.adapters.articleAdapterVertical;
import com.moringaschool.mumapp.models.Post;
import com.moringaschool.mumapp.models.Response;
import com.moringaschool.mumapp.network.mumApi;
import com.moringaschool.mumapp.network.mumClient;
import com.moringaschool.mumapp.ui.MainActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;

public class HomeFragment extends Fragment {
    private static
    com.moringaschool.mumapp.models.Response result = new com.moringaschool.mumapp.models.Response();
    private static Context context;
    Gson gson = new Gson();
    RecyclerView recyclerView;
  ViewPager viewpager;
    RecyclerView Vertical;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;


    RecyclerView postRecyclerView;
    PostAdapter postAdapter;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    List<Post> postList;



    public HomeFragment(Context context) {
        this.context = context;
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment(context);
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.home_display, container, false);
        postRecyclerView = fragmentView.findViewById(R.id.fragmentRecycler);
        postRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        postRecyclerView.setHasFixedSize(true);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Posts");
        return fragmentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.fragmentRecycler);
        viewpager = view.findViewById(R.id.viewPagerM);
        Vertical = view.findViewById(R.id.vertRecycle);
        java.util.Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new The_slide_timer(),2000,3000);
        ImageAdapter adapter = new ImageAdapter(context);
        viewpager.setAdapter(adapter);
        for (int i = 0; i < 10; i++) {
            mumApi mumApi = mumClient.getClient();
            Call<Response> call = mumApi.getAllArticles();
            call.enqueue(new Callback<Response>() {
                @Override
                public void onResponse(Call<com.moringaschool.mumapp.models.Response> call, retrofit2.Response<Response> response) {
                    if (response.isSuccessful()) {
                        result = response.body();
                        // Log.e("thisis", gson.toJson(result));
                        assert result != null;
                        //      RecyclerView.LayoutManager gridLayoutManager;
//                    gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
                        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(context);
                        RecyclerView.LayoutManager horizontalManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
                        articleAdapterVertical vertical = new articleAdapterVertical(result.getArticleResponse(), context);
                        articleAdapterHorizontal horizontal = new articleAdapterHorizontal(result.getArticleResponse(), context);
                        Vertical.setLayoutManager(linearLayoutManager);
                        Vertical.setAdapter(vertical);
                        recyclerView.setLayoutManager(horizontalManager);
                        recyclerView.setAdapter(horizontal);
                        recyclerView.scrollToPosition(0);
                     //   Log.e("thisis", gson.toJson(result));
                    }
                }

                @Override
                public void onFailure(Call<com.moringaschool.mumapp.models.Response> call, Throwable t) {

                }

            });
        }
        horizontalRequest();
    }

    @Override
    public void onStart() {
        super.onStart();
horizontalRequest();
        // Get List Posts from the database

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                postList = new ArrayList<>();
                for (DataSnapshot postsnap : dataSnapshot.getChildren()) {

                    Post post = postsnap.getValue(Post.class);
                    postList.add(post);


                }

                postAdapter = new PostAdapter(getActivity(), postList);
                postRecyclerView.setAdapter(postAdapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);

    }

    private void horizontalRequest()
    {
        mumApi mumApi = mumClient.getClient();
        Call<Response> call = mumApi.getAllArticles();
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<com.moringaschool.mumapp.models.Response> call, retrofit2.Response<Response> response) {
                if (response.isSuccessful()) {
                    result = response.body();
                    RecyclerView.LayoutManager horizontalManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
                    articleAdapterHorizontal horizontal = new articleAdapterHorizontal(result.getArticleResponse(), context);
                    recyclerView.setLayoutManager(horizontalManager);
                    recyclerView.setAdapter(horizontal);
                    recyclerView.scrollToPosition(0);
                }
            }
            @Override
            public void onFailure(Call<com.moringaschool.mumapp.models.Response> call, Throwable t) {
            }
        });
    }
    public class The_slide_timer extends TimerTask {
        @Override
        public void run() {

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewpager.getCurrentItem()< 5-1) {
                        viewpager.setCurrentItem(viewpager.getCurrentItem()+1);
                    }
                    else
                        viewpager.setCurrentItem(0);
                }
            });
        }
    }
    @Override
    public void onResume() {
        super.onResume();
        horizontalRequest();
    }
}