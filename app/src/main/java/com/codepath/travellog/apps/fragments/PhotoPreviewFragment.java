package com.codepath.travellog.apps.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codepath.travellog.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PhotoPreviewFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PhotoPreviewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PhotoPreviewFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "uri";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private Uri uri;


    public PhotoPreviewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param uri Parameter 1.
     * @return A new instance of fragment PhotoPreviewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PhotoPreviewFragment newInstance(Uri uri) {
        PhotoPreviewFragment fragment = new PhotoPreviewFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM1, uri);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            uri = getArguments().getParcelable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_photo_preview, container, false);
    }




}
