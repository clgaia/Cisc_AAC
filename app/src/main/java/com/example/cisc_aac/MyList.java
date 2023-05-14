package com.example.cisc_aac;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;


public class MyList {

        private ArrayList<String> items;
        private static MyList instance;

        public MyList() {

            this.items = new ArrayList<>();
        }

        public ArrayList<String> getItems() {

            return items;
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public String getString(){
            String allValues = String.join(" ", getItems());
            return allValues;
        }

        public void addItem(String item) {

            items.add(item);
        }

        public void removeItem() {
            int position = items.size()-1; //removes last item
            items.remove(position);
        }

        public void clear(){
            items.clear();
        }

        public static MyList getInstance() {
            if (instance == null) {
                instance = new MyList();
            }
            return instance;
        }

}


