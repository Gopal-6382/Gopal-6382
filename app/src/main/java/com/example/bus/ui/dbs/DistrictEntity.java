package com.example.bus.ui.dbs;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Index;

@Entity(tableName = "districts", indices = {@Index(value = "districtID", unique = true)})
public class DistrictEntity {
    @PrimaryKey @NonNull
    public String districtID;
    public String name;

    public DistrictEntity(@NonNull String districtID, String name) {
        this.districtID = districtID;
        this.name = name;
    }
}
