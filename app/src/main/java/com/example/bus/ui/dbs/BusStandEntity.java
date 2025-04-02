package com.example.bus.ui.dbs;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.Index;

import com.example.bus.ui.dbs.TalukEntity;

@Entity(
        tableName = "bus_stands",
        foreignKeys = @ForeignKey(entity = TalukEntity.class, parentColumns = "talukID", childColumns = "talukID", onDelete = ForeignKey.CASCADE),
        indices = {@Index(value = "talukID")}
)
public class BusStandEntity {
    @PrimaryKey @NonNull
    public String busStandID;
    public String talukID;
    public String name;

    public BusStandEntity(@NonNull String busStandID, String talukID, String name) {
        this.busStandID = busStandID;
        this.talukID = talukID;
        this.name = name;
    }
}
