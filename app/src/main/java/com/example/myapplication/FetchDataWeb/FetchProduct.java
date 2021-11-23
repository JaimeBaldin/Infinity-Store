package com.example.myapplication.FetchDataWeb;

import android.os.AsyncTask;

import com.example.myapplication.DataBase.Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class FetchProduct extends  AsyncTask<String, Void, ArrayList<Product>> {

    protected ArrayList<Product> doInBackground(String... parameters) {
        ArrayList<Product> listReturn = new ArrayList<>();

        String link = parameters[0];

        try {
            URL url = new URL(link);

            URLConnection connection = url.openConnection();

            InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line;

            while ((line = bufferedReader.readLine()) != null){
                JSONArray jsonArray = new JSONArray(line);

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    Product product = new Product();

                    product.getName() = jsonObject.getString("name");
                    product.getId() = jsonObject.getInt("id");
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return listReturn;
    }

}
