package com.example.bus.ui.dbs;

import android.util.Log;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.WriteBatch;
import java.util.List;
import java.util.Map;

public class FirestoreUploader {
    private static final String TAG = "firestore_uploader";

    public static void uploadData() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        WriteBatch batch = db.batch(); // ✅ Optimized batch writes

        // ✅ Upload districts
        addBatchData(batch, db, "districts", List.of(
                Map.of("id", "d1", "name", "chennai"),
                Map.of("id", "d2", "name", "coimbatore"),
                Map.of("id", "d3", "name", "madurai"),
                Map.of("id", "d4", "name", "trichy")
        ));

        // ✅ Upload taluks
        addBatchData(batch, db, "taluks", List.of(
                Map.of("id", "t1", "name", "ambattur", "district_id", "d1"),
                Map.of("id", "t2", "name", "anna nagar", "district_id", "d2"),
                Map.of("id", "t3", "name", "gandhipuram", "district_id", "d3"),
                Map.of("id", "t4", "name", "thirunagar", "district_id", "d4")
        ));

        // ✅ Upload bus_stands
        addBatchData(batch, db, "bus_stands", List.of(
                Map.of("id", "bs1", "name", "ambattur bus stand", "taluk_id", "t1"),
                Map.of("id", "bs2", "name", "anna nagar bus stand", "taluk_id", "t2"),
                Map.of("id", "bs3", "name", "gandhipuram bus stand", "taluk_id", "t3"),
                Map.of("id", "bs4", "name", "thirunagar bus stand", "taluk_id", "t4")
        ));

        // ✅ Upload routes
        addBatchData(batch, db, "routes", List.of(
                Map.of("id", "r1", "name", "express route", "source", "chennai", "destination", "coimbatore", "bus_stand_id", "bs1", "is_active", 0),
                Map.of("id", "r2", "name", "city express", "source", "chennai", "destination", "madurai", "bus_stand_id", "bs2", "is_active", 0),
                Map.of("id", "r3", "name", "town bus", "source", "coimbatore", "destination", "trichy", "bus_stand_id", "bs3", "is_active", 0),
                Map.of("id", "r4", "name", "metro bus", "source", "madurai", "destination", "trichy", "bus_stand_id", "bs4", "is_active", 0)
        ));

        // ✅ Upload buses
        addBatchData(batch, db, "buses", List.of(
                Map.of("id", "b1", "name", "ambattur express", "route_id", "r1"),
                Map.of("id", "b2", "name", "madurai fast service", "route_id", "r2"),
                Map.of("id", "b3", "name", "coimbatore-trichy town bus", "route_id", "r3"),
                Map.of("id", "b4", "name", "madurai metro express", "route_id", "r4")
        ));

        // ✅ Upload stops
        addBatchData(batch, db, "stops", List.of(
                Map.of("id", "s1", "stop_name", "stop 1", "stop_order", 1, "bus_id", "b1"),
                Map.of("id", "s2", "stop_name", "stop 2", "stop_order", 2, "bus_id", "b1"),
                Map.of("id", "s3", "stop_name", "stop 3", "stop_order", 3, "bus_id", "b1"),
                Map.of("id", "s4", "stop_name", "stop a", "stop_order", 1, "bus_id", "b2")
        ));

        // ✅ Upload timings
        addBatchData(batch, db, "timings", List.of(
                Map.of("id", "t1", "stop_name", "stop 1", "predicted_time", "10:00 am", "actual_time", "10:05 am", "bus_id", "b1"),
                Map.of("id", "t2", "stop_name", "stop 2", "predicted_time", "10:30 am", "actual_time", "10:35 am", "bus_id", "b1"),
                Map.of("id", "t3", "stop_name", "stop 3", "predicted_time", "11:00 am", "actual_time", "11:05 am", "bus_id", "b1"),
                Map.of("id", "t4", "stop_name", "stop a", "predicted_time", "12:00 pm", "actual_time", "12:05 pm", "bus_id", "b2")
        ));

        // ✅ Commit all data
        batch.commit().addOnSuccessListener(aVoid -> Log.d(TAG, "✅ Firestore data uploaded successfully!"))
                .addOnFailureListener(e -> Log.e(TAG, "❌ Upload failed: " + e.getMessage()));
    }

    // ✅ Helper function to add batch data
    private static void addBatchData(WriteBatch batch, FirebaseFirestore db, String collection, List<Map<String, Object>> dataList) {
        for (Map<String, Object> data : dataList) {
            String docId = (String) data.get("id");
            batch.set(db.collection(collection).document(docId), data);
        }
    }
}
