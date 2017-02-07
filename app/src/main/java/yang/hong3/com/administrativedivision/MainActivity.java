package yang.hong3.com.administrativedivision;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import yang.hong3.com.administrativedivision.address.CityBean;
import yang.hong3.com.administrativedivision.address.DBManager;
import yang.hong3.com.administrativedivision.address.DBUtil;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    final int PROVINCE = 0;
    final int CITY = 1;
    final int DISTINGUISH = 2;

    DBManager dbManager;
    SQLiteDatabase db;

    int type = PROVINCE;
    ListAdapter listAdapter;
    List<CityBean> beanList = new ArrayList<>();
    ListView listView;

    CityBean province,city,distinguish;

    Button btnProvince,btnCity,btnDistinguish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.main_list);
        btnProvince = (Button) findViewById(R.id.btn_province);
        btnCity = (Button) findViewById(R.id.btn_city);
        btnDistinguish = (Button) findViewById(R.id.btn_distinguish);

        dbManager = new DBManager(this);
        db = dbManager.getDatabase();


        listAdapter = new ListAdapter(beanList);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(this);
        click();

    }

    private void click() {

        //省
        btnProvince.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beanList.clear();
                type = PROVINCE;
                beanList.addAll(DBUtil.getProvinceList(db));
                Log.d("mytag"," beanList.size()--> "+beanList.size());
                listAdapter.notifyDataSetChanged();
            }
        });


        //市
        btnCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beanList.clear();
                type = CITY;
                beanList.addAll(DBUtil.getCityList(db,province.getId()));
                Log.d("mytag"," beanList.size()--> "+beanList.size());
                listAdapter.notifyDataSetChanged();
            }
        });


        //区
        btnDistinguish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beanList.clear();
                type = DISTINGUISH;
                beanList.addAll(DBUtil.getDistinguishList(db,city.getId()));
                Log.d("mytag"," beanList.size()--> "+beanList.size());
                listAdapter.notifyDataSetChanged();
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbManager.closeDatabase();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (type){
            case PROVINCE:

                province = beanList.get(position);
                btnProvince.setText(province.getFullname());
                break;
            case CITY:
                city = beanList.get(position);
                btnCity.setText(city.getFullname());
                break;
            case DISTINGUISH:
                distinguish = beanList.get(position);
                btnDistinguish.setText(distinguish.getFullname());
                break;
        }
    }
}
