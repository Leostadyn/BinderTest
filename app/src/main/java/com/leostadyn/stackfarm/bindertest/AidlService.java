package com.leostadyn.stackfarm.bindertest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import java.util.ArrayList;
import java.util.List;

public class AidlService extends Service {
    private ArrayList<Person> personArrayList;

    @androidx.annotation.Nullable
    @Override
    public IBinder onBind(Intent intent) {
        personArrayList=new ArrayList<>();
        return iBinder;
    }

    private IBinder iBinder=new IAidl.Stub() {
        @Override
        public void addPerson(Person person) throws RemoteException {
            personArrayList.add(person);
        }

        @Override
        public List<Person> getPersonList() throws RemoteException {
            return personArrayList;
        }
    };
}