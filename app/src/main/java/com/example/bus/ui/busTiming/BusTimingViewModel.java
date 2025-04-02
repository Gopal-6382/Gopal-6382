package com.example.bus.ui.busTiming;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.bus.ui.dbs.TimingEntity;
import java.util.List;

public class BusTimingViewModel extends ViewModel {
    private final MutableLiveData<String> district = new MutableLiveData<>();
    private final MutableLiveData<String> taluk = new MutableLiveData<>();
    private final MutableLiveData<String> busStand = new MutableLiveData<>();
    private final MutableLiveData<String> route = new MutableLiveData<>();
    private final MutableLiveData<String> busName = new MutableLiveData<>();
    private final MutableLiveData<List<TimingEntity>> stops = new MutableLiveData<>();

    public void setBusDetails(String d, String t, String bs, String r, String bn) {
        district.setValue(d);
        taluk.setValue(t);
        busStand.setValue(bs);
        route.setValue(r);
        busName.setValue(bn);
    }

    public void setStops(List<TimingEntity> stopList) {
        stops.setValue(stopList);
    }

    public LiveData<String> getDistrict() { return district; }
    public LiveData<String> getTaluk() { return taluk; }
    public LiveData<String> getBusStand() { return busStand; }
    public LiveData<String> getRoute() { return route; }
    public LiveData<String> getBusName() { return busName; }
    public LiveData<List<TimingEntity>> getStops() { return stops; }
}
