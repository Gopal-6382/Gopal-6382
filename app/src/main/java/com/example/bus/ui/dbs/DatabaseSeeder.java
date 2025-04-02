package com.example.bus.ui.dbs;

import android.content.Context;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;

/** ✅ Database Seeder for Full Data Insertion */
public class DatabaseSeeder {
    private static final String TAG = "DatabaseSeeder";

    public static void populateDatabase(Context context) {
        AppDatabase db = AppDatabase.getInstance(context);
        Executors.newSingleThreadExecutor().execute(() -> {
            Log.d(TAG, "🚀 Checking existing data...");



            Log.d(TAG, "📌 Inserting sample data...");

            // ✅ Use runInTransaction for faster bulk inserts
            db.runInTransaction(() -> {
                db.daoInterfaces().insertDistricts(Arrays.asList(
                        new DistrictEntity("D1", "Chennai"),
                        new DistrictEntity("D2", "Coimbatore"),
                        new DistrictEntity("D3", "Madurai"),
                        new DistrictEntity("D4", "Trichy")
                ));

                db.daoInterfaces().insertTaluks(Arrays.asList(
                        new TalukEntity("T1", "D1", "Ambattur"),
                        new TalukEntity("T2", "D2", "Anna Nagar"),
                        new TalukEntity("T3", "D3", "Gandhipuram"),
                        new TalukEntity("T4", "D4", "Thirunagar"),
                        new TalukEntity("T3", "D4", "Thirunagar")

                ));

                db.daoInterfaces().insertBusStands(Arrays.asList(
                        new BusStandEntity("BS1", "T1", "Ambattur Bus Stand"),
                        new BusStandEntity("BS2", "T2", "Anna Nagar Bus Stand"),
                        new BusStandEntity("BS3", "T3", "Gandhipuram Bus Stand"),
                        new BusStandEntity("BS4", "T4", "Thirunagar Bus Stand")
                ));

                db.daoInterfaces().insertRoutes(Arrays.asList(
                        new RouteEntity("R1", "BS1", "Express Route", "Chennai", "Coimbatore",0),
                        new RouteEntity("R2", "BS2", "City Express", "Chennai", "Madurai",0),
                        new RouteEntity("R3", "BS3", "Town Bus", "Coimbatore", "Trichy",0),
                        new RouteEntity("R4", "BS4", "Metro Bus", "Madurai", "Trichy",0)
                ));

                db.daoInterfaces().insertBuses(Arrays.asList(
                        new BusEntity("B1", "R1", "Ambattur Express"),
                        new BusEntity("B2", "R2", "Madurai Fast Service"),
                        new BusEntity("B3", "R3", "Coimbatore-Trichy Town Bus"),
                        new BusEntity("B4", "R4", "Madurai Metro Express")
                ));

                db.daoInterfaces().insertStops(Arrays.asList(
                        new StopEntity("S1", "B1", "Stop 1", 1),
                        new StopEntity("S2", "B1", "Stop 2", 2),
                        new StopEntity("S3", "B1", "Stop 3", 3),
                        new StopEntity("S4", "B2", "Stop A", 1),
                        new StopEntity("S5", "B2", "Stop B", 2),
                        new StopEntity("S6", "B3", "Stop X", 1),
                        new StopEntity("S7", "B3", "Stop Y", 2),
                        new StopEntity("S8", "B4", "Stop Z", 1),
                        new StopEntity("S9", "B4", "Stop Q", 2)
                ));

                db.daoInterfaces().insertTimings(Arrays.asList(
                        new TimingEntity("T1", "B1", "Stop 1", "10:00 AM", "10:05 AM"),
                        new TimingEntity("T2", "B1", "Stop 2", "10:30 AM", "10:35 AM"),
                        new TimingEntity("T3", "B1", "Stop 3", "11:00 AM", "11:05 AM"),
                        new TimingEntity("T4", "B2", "Stop A", "12:00 PM", "12:05 PM"),
                        new TimingEntity("T5", "B2", "Stop B", "12:30 PM", "12:35 PM"),
                        new TimingEntity("T6", "B3", "Stop X", "01:00 PM", "01:05 PM"),
                        new TimingEntity("T7", "B3", "Stop Y", "01:30 PM", "01:35 PM"),
                        new TimingEntity("T8", "B4", "Stop Z", "02:00 PM", "02:05 PM"),
                        new TimingEntity("T9", "B4", "Stop Q", "02:30 PM", "02:35 PM")
                ));
            });

            Log.d(TAG, "✅ Database seeding completed successfully!");
        });
    }
}