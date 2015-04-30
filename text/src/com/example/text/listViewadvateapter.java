package com.example.text;

import java.util.HashMap;
import java.util.List;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class listViewadvateapter extends BaseAdapter {

	private List<HashMap<String, String>> list;
	private Context context;

	public listViewadvateapter(Context context,
			List<HashMap<String, String>> list) {
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View view, ViewGroup viewGroup) {
		ViewHolder holder = null;
		if (view == null) {
			view = LayoutInflater.from(context).inflate(R.layout.list_item,
					null);
			holder = new ViewHolder();
			holder.textView = (TextView) view.findViewById(R.id.textView1);
			holder.imageView = (ImageView) view.findViewById(R.id.imageView1);
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}

		holder.textView.setText(list.get(position).get("title"));
		ImageLoader imageLoader = ImageLoader.getInstance();
		imageLoader.init(ImageLoaderConfiguration.createDefault(context));

		imageLoader.displayImage(list.get(position).get("image"),
				holder.imageView);
		return view;
	}

	private class ViewHolder {
		TextView textView;
		ImageView imageView;
	}
}
