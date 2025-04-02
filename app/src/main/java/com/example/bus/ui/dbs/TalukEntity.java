package com.example.bus.ui.dbs;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.Index;

import com.example.bus.ui.dbs.DistrictEntity;

@Entity(
        tableName = "taluks",
        foreignKeys = @ForeignKey(entity = DistrictEntity.class, parentColumns = "districtID", childColumns = "districtID", onDelete = ForeignKey.CASCADE),
        indices = {@Index(value = "districtID")}
)
public class TalukEntity {
    @PrimaryKey @NonNull
    public String talukID;
    public String districtID;
    public String name;

    public TalukEntity(@NonNull String talukID, String districtID, String name) {
        this.talukID = talukID;
        this.districtID = districtID;
        this.name = name;
    }
}
