package hr.ferit.davorlukic.lv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NameClickInterface{

    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private EditText etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerAdapter(this);
        recyclerView.setAdapter(adapter);

        etName=findViewById(R.id.etName);

        List<String> data = new ArrayList<>();
        data.add("Pero");
        data.add("Marko");
        data.add("Ivica");
        data.add("Pero");
        data.add("Marko");
        data.add("Ivica");
        data.add("Pero");

        adapter.addData(data);

    }


    public void onAddClicked(View view) {
        adapter.addNewItem(etName.getText().toString(),adapter.getItemCount());
    }

    @Override
    public void onNameClicked(int position) {
        adapter.removeItem(position);
    }
}
