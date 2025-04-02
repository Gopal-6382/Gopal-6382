package com.example.bus.ui.dbs;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.Index;

@Entity(
        tableName = "buses",
        foreignKeys = @ForeignKey(entity = RouteEntity.class, parentColumns = "routeID", childColumns = "routeID", onDelete = ForeignKey.CASCADE),
        indices = {@Index(value = "routeID")}
)
public class BusEntity {
    @PrimaryKey @NonNull
    public String busID;
    public String routeID;
    public String name;

    public BusEntity(@NonNull String busID, String routeID, String name) {
        this.busID = busID;
        this.routeID = routeID;
        this.name = name;
    }
}
