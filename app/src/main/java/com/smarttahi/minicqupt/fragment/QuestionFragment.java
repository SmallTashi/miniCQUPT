package com.smarttahi.minicqupt.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.smarttahi.minicqupt.Data.Question;
import com.smarttahi.minicqupt.R;
import com.smarttahi.minicqupt.adapter.MyListAdapter;
import com.smarttahi.minicqupt.tools.Config;
import com.smarttahi.minicqupt.tools.HttpRequest;
import com.smarttahi.minicqupt.tools.JSONmanager;
import com.smarttahi.minicqupt.tools.MyApplication;
import com.smarttahi.minicqupt.tools.PackParameter;

import org.json.JSONException;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class QuestionFragment extends Fragment  {


    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private static ArrayList<Question> data;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public QuestionFragment() {
    }
    public static void addToast(String s, boolean Short) {
        if (Short) {
            Toast.makeText(MyApplication.getThisContext(), s, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MyApplication.getThisContext(), s, Toast.LENGTH_LONG).show();
        }
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static QuestionFragment newInstance(int columnCount) {
        QuestionFragment fragment = new QuestionFragment();

        HttpRequest.sentHttpsRequest(PackParameter.Question_List(1, "其他"), Config.Api_Question_List, new HttpRequest.Callback() {
            @Override
            public void onSuccess(HttpRequest.Response response) throws JSONException {
                data = JSONmanager.getQuestionList(response.getDate());
            }

            @Override
            public void onFiled(Exception e) {
                addToast("请求数据失败", true);
            }
        });



        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new MyListAdapter(data, MyApplication.QUESTION_LIST));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Question item);
    }
}
