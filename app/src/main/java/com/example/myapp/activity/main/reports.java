package com.example.myapp.activity.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapp.R;
import com.example.myapp.activity.editor.EditorActivity;
import com.example.myapp.model.Note;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class reports extends AppCompatActivity implements MainView {

    private static final int INTENT_EDIT = 200;
    private static final int INTENT_ADD = 100;
    FloatingActionButton fab;
    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefresh;
    MainPresenter presenter;
    MainAdapter adapter;

    MainAdapter.ItemClickListener itemClickListener;
    List<Note> note;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);

        swipeRefresh = findViewById(R.id.swipe);
        recyclerView = findViewById(R.id.rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fab = findViewById(R.id.add);
        fab.setOnClickListener(view ->
                startActivityForResult(
                        new Intent(this, EditorActivity.class),
                        INTENT_ADD)
        );

        presenter = new MainPresenter(this);
        presenter.getData();

        swipeRefresh.setOnRefreshListener(
                () -> presenter.getData()
        );

        itemClickListener = ((view, position) -> {
            int id = note.get(position).getId();
            String title = note.get(position).getTitle();
            String notes = note.get(position).getNote();
            int color = note.get(position).getColor();

            Intent intent = new Intent(this, EditorActivity.class);
            intent.putExtra("id", id);
            intent.putExtra("title", title);
            intent.putExtra("note", notes);
            intent.putExtra("color", color);
            startActivityForResult(intent, INTENT_EDIT);


            return null;
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == INTENT_ADD && resultCode == RESULT_OK) {
            presenter.getData(); //reload data
        }
        else if (requestCode == INTENT_EDIT && resultCode == RESULT_OK) {
            presenter.getData(); //reload data
        }

    }

    @Override
    public void showLoading() {

        swipeRefresh.setRefreshing(true);
    }

    @Override
    public void hideLoading() {

        swipeRefresh.setRefreshing(false);

    }

    @Override
    public void onGetResult(List<Note> notes) {

        adapter = new MainAdapter(this, notes, itemClickListener);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

        note = notes;
    }

    @Override
    public void onErrorLoading(String message) {

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}