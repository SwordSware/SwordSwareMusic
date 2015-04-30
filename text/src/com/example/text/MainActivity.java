package com.example.text;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.marshalchen.common.commonUtils.urlUtils.HttpUtilsAsync;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleAdapter.ViewBinder;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends Activity {
	@InjectView(R.id.listview)
	ListView listView;
	private List<HashMap<String, String>> list = new ArrayList<>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.inject(this);

		HttpUtilsAsync.get("https://api.douban.com/v2/movie/top250",
				new JsonHttpResponseHandler() {

					@Override
					public void onSuccess(int statusCode, Header[] headers,
							JSONObject response) {
						// TODO Auto-generated method stub
						super.onSuccess(statusCode, headers, response);

						try {
							JSONArray subjects = response
									.getJSONArray("subjects");
							HashMap<String, String> map;
							for (int i = 0; i < subjects.length(); i++) {
								map = new HashMap();
								map.put("title", subjects.getJSONObject(i)
										.getString("title"));
								map.put("image",
										subjects.getJSONObject(i)
												.getJSONObject("images")
												.getString("large"));
								list.add(map);
							}

						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						/*SimpleAdapter simpleAdapter = new SimpleAdapter(
								MainActivity.this, list, R.layout.list_item,
								new String[] { "title", "image" }, new int[] {
										R.id.textView1, R.id.imageView1 });
						simpleAdapter.setViewBinder(new ViewBinder() {

							@Override
							public boolean setViewValue(View arg0, Object arg1,
									String arg2) {
								// TODO Auto-generatedmethod stub
								if (arg0 instanceof ImageView
										&& arg1.toString().contains("http")) {
									ImageView imageView = (ImageView) arg0;
									ImageLoader imageLoader = ImageLoader
											.getInstance();
									imageLoader.init(ImageLoaderConfiguration
											.createDefault(MainActivity.this));
									imageLoader.displayImage(arg1.toString(),
											imageView);
									return true;
								}
								return false;
							}
						});

						listView.setAdapter(simpleAdapter);*/

						
						  listViewadvateapter adapter = new
						  listViewadvateapter( MainActivity.this, list);
						  listView.setAdapter(adapter);
						 
					}

				});
	}
}
