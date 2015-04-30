// Generated code from Butter Knife. Do not modify!
package com.example.text;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class MainActivity$$ViewInjector {
  public static void inject(Finder finder, final com.example.text.MainActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131361874, "field 'listView'");
    target.listView = (android.widget.ListView) view;
  }

  public static void reset(com.example.text.MainActivity target) {
    target.listView = null;
  }
}
