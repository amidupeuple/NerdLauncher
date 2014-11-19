package com.github.amidupeuple.main.NerdLauncher;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dpivovar on 19.11.2014.
 */
public class NerdLauncherAdapter extends BaseAdapter{
    private List<ResolveInfo> apps;
    private LayoutInflater appsInf;
    private Context context;

    public NerdLauncherAdapter(Context c, List<ResolveInfo> apps) {
        this.apps = apps;
        appsInf = LayoutInflater.from(c);
        context = c;
    }

    @Override
    public int getCount() {
        return apps.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout appLay = (LinearLayout) appsInf.inflate(R.layout.app_layout, parent, false);
        ImageView appIcon = (ImageView) appLay.findViewById(R.id.appIcon);
        TextView appName = (TextView) appLay.findViewById(R.id.appName);

        PackageManager pm = context.getPackageManager();
        ResolveInfo currApp = apps.get(position);
        appIcon.setImageDrawable(currApp.loadIcon(pm));
        appName.setText(currApp.loadLabel(pm));

        return appLay;
    }
}
