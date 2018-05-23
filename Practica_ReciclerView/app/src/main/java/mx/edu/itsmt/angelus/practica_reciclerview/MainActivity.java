package mx.edu.itsmt.angelus.practica_reciclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static mx.edu.itsmt.angelus.practica_reciclerview.R.menu.menu;

public class MainActivity extends AppCompatActivity {

    private List<String> names;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutmanager;
    private int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        names = getAllNames();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mLayoutmanager =new LinearLayoutManager(this);
        mAdapter = new MyAdapter(names, R.layout.recyclerview_item, new MyAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(String name, int position) {
               // Toast.makeText(MainActivity.this,name+" - "+position,Toast.LENGTH_LONG).show();
              deleteName(position);
            }
        });
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(mLayoutmanager);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_name:
                this.addName(0);
                return true;
            default:
        }
        return super.onOptionsItemSelected(item);
    }

    private void addName(int position) {
        names.add(position,"new Name "+(++counter));
        mAdapter.notifyItemInserted(position);
        mLayoutmanager.scrollToPosition(position);
    }
    private void deleteName(int position) {
        names.remove(position);
        mAdapter.notifyItemRemoved(position);

    }

    public List<String> getAllNames() {
        return  new ArrayList<String>(){{
            add("Angel");
            add("Pedro");
            add("Jose");
            add("Katerin");
            add("Miriam");
        }};
    }
}
