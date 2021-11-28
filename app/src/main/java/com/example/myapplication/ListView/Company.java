package com.example.myapplication.ListView;

import android.Manifest;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.myapplication.FetchDataWeb.FetchCompany;
import com.example.myapplication.Permission;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class Company extends ListActivity {

    ArrayList<com.example.myapplication.Company> listCompany;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_company);

        Permission.verifyPermission(Company.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        try {
            String link = "http://localhost:8080/company";
            listCompany = new FetchCompany().execute(link).get();

            ListAdapter adapter = new SimpleAdapter(
                 Company.this,
                    getList(),
                    R.layout.listview_company,
                    new String[] {"nome"},
                    new int[]{R.id.listCompany}
            );

            setListAdapter(adapter);

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<HashMap<String,String>> getList() {
        ArrayList<HashMap<String,String>> listReturn = new ArrayList<>();

        for (int i = 0; i < listCompany.size(); i++) {
            HashMap<String, String> item = new HashMap<>();
            item.put("id", String.valueOf(listCompany.get(i).id));
            item.put("nome", listCompany.get(i).name);
            item.put("whatsapp", listCompany.get(i).whatsApp);

            listReturn.add(item);

        }
        return listReturn;
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String texto = "Id: " + listCompany.get(position).id +
                "Name: " + listCompany.get(position).name +
                "WhatsApp: " + listCompany.get(position).whatsApp;

        Toast.makeText(this,texto,Toast.LENGTH_LONG).show();
    }
}