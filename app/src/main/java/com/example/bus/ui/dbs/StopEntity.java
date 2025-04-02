package com.example.bus.ui.dbs;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.Index;

@Entity(
        tableName = "stops",
        foreignKeys = @ForeignKey(entity = BusEntity.class, parentColumns = "busID", childColumns = "busID", onDelete = ForeignKey.CASCADE),
        indices = {@Index(value = "busID")}
)
public class StopEntity {
    @PrimaryKey @NonNull
    public String stopID;
    public String busID;
    public String stopName;
    public int stopOrder;

    public StopEntity(@NonNull String stopID, String busID, String stopName, int stopOrder) {
        this.stopID = stopID;
        this.busID = busID;
        this.stopName = stopName;
        this.stopOrder = stopOrder;
    }
}
