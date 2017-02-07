package yang.hong3.com.administrativedivision;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import yang.hong3.com.administrativedivision.address.CityBean;

/**
 * Created by hong3 on 2016/12/11.
 */

public class ListAdapter extends BaseAdapter{

    List<CityBean> lists;

    public ListAdapter(List<CityBean> lists) {
        this.lists = lists;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder =null;

        if (convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1,null);
            holder = new ViewHolder(convertView);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.text.setText(lists.get(position).getFullname());

        return convertView;
    }

    class ViewHolder{
        TextView text;

        public ViewHolder(View view) {
            text = (TextView) view.findViewById(android.R.id.text1);
            view.setTag(this);
        }
    }
}
