package yang.hong3.com.administrativedivision.address;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hong3 on 2016/12/11.
 */

public class DBUtil {

    //获取省列表
    public static List<CityBean> getProvinceList(SQLiteDatabase db){
        List<CityBean> ids = new ArrayList<>();

        Cursor cursor =
                db.query(Constences.TABLE_PROVINCE,null, null,null,null,null,null);
        Log.d("mytag",cursor.getCount() +"   sasa   ");
        while (cursor.moveToNext()){
            CityBean cityBean = new CityBean();
            cityBean.setId(cursor.getInt(1));
            cityBean.setFullname(cursor.getString(2));
            ids.add(cityBean);
        }

        return ids;
    }


    //获取市列表
    public static List<CityBean> getCityList(SQLiteDatabase db,int parentId){
        List<CityBean> ids = new ArrayList<>();

        Cursor cursor =
                db.query(Constences.TABLE_CITY,null, Constences.ITEM_CITY_PROVINCEID+"=?",new String[]{""+parentId},null,null,null);
        Log.d("mytag",cursor.getCount() +"   sasa   ");
        while (cursor.moveToNext()){
            CityBean cityBean = new CityBean();
            cityBean.setId(cursor.getInt(1));
            cityBean.setFullname(cursor.getString(2));
            cityBean.setParentId(cursor.getInt(3));
            ids.add(cityBean);
        }

        return ids;
    }


    //获取区列表
    public static List<CityBean> getDistinguishList(SQLiteDatabase db,int parentId){
        List<CityBean> ids = new ArrayList<>();

        Cursor cursor =
                db.query(Constences.TABLE_DISTINGUISH,null, Constences.ITEM_DISTINGUISH_CITYID+"=?",new String[]{""+parentId}, null,null,null);
        Log.d("mytag",cursor.getCount() +"   sasa   ");
        while (cursor.moveToNext()){
            CityBean cityBean = new CityBean();
            cityBean.setId(cursor.getInt(1));
            cityBean.setFullname(cursor.getString(2));
            cityBean.setParentId(cursor.getInt(3));
            ids.add(cityBean);
        }

        return ids;
    }
}
