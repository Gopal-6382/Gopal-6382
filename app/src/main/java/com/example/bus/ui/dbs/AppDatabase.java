package com.example.bus.ui.dbs;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/** ✅ Main Room Database */
@Database(
        entities = {DistrictEntity.class, TalukEntity.class, BusStandEntity.class,
                RouteEntity.class, BusEntity.class, StopEntity.class, TimingEntity.class},
        version = 6, // Increment version
        exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static volatile AppDatabase INSTANCE;

    public abstract DaoInterfaces daoInterfaces(); // ✅ Correct Interface

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "bus_database")
                            .fallbackToDestructiveMigration() // 🚀 Ensures schema updates don't crash
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
