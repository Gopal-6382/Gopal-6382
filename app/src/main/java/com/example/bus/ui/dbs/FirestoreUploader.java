package com.example.bus.ui.dbs;

import android.util.Log;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.WriteBatch;

import java.util.HashMap;
import java.util.Map;

public class FirestoreUploader {
    private static final String TAG = "FirestoreUploader";

    public static void uploadData() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        WriteBatch batch = db.batch(); // ✅ Use batch to optimize writes

        // ✅ District
        String districtID = "D1"; // You can also use `db.collection("districts").document().getId();` for random ID
        Map<String, Object> districtData = new HashMap<>();
        districtData.put("name", "Ariyalur");
        batch.set(db.collection("districts").document(districtID), districtData);

        // ✅ Taluk
        String talukID = "T1";
        Map<String, Object> talukData = new HashMap<>();
        talukData.put("name", "Ariyalur Taluk");
        talukData.put("districtID", districtID);
        batch.set(db.collection("taluks").document(talukID), talukData);

        // ✅ Bus Stand
        String busStandID = "BS1";
        Map<String, Object> busStandData = new HashMap<>();
        busStandData.put("name", "Ambattur Bus Stand");
        busStandData.put("talukID", talukID);
        batch.set(db.collection("bus_stands").document(busStandID), busStandData);

        // ✅ Route
        String routeID = "R1";
        Map<String, Object> routeData = new HashMap<>();
        routeData.put("name", "Express Route");
        routeData.put("source", "Chennai");
        routeData.put("destination", "Coimbatore");
        routeData.put("busStandID", busStandID);
        batch.set(db.collection("routes").document(routeID), routeData);

        // ✅ Bus
        String busID = "B1";
        Map<String, Object> busData = new HashMap<>();
        busData.put("name", "Ambattur Express");
        busData.put("routeID", routeID);
        batch.set(db.collection("buses").document(busID), busData);

        // ✅ Stop
        String stopID = "S1";
        Map<String, Object> stopData = new HashMap<>();
        stopData.put("stopName", "Stop 1");
        stopData.put("stopOrder", 1);
        stopData.put("busID", busID);
        batch.set(db.collection("stops").document(stopID), stopData);

        // ✅ Timing
        String timingID = "T1";
        Map<String, Object> timingData = new HashMap<>();
        timingData.put("stopName", "Stop 1");
        timingData.put("predictedTime", "10:00 AM");
        timingData.put("actualTime", "10:05 AM");
        timingData.put("busID", busID);
        batch.set(db.collection("timings").document(timingID), timingData);

        // ✅ Commit the batch
        batch.commit().addOnSuccessListener(aVoid -> Log.d(TAG, "✅ Data Uploaded Successfully!"))
                .addOnFailureListener(e -> Log.e(TAG, "❌ Upload Failed: " + e.getMessage()));
    }
}
