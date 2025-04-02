package com.example.bus.ui.dbs;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.Index;

@Entity(tableName = "routes")
public class RouteEntity {

    @PrimaryKey
    @NonNull
    public String routeID;

    public String busStandID;
    public String name;
    public String source;
    public String destination;
    public int searchCount;  // ✅ New column to track search frequency

    public RouteEntity(@NonNull String routeID, String busStandID, String name, String source, String destination, int searchCount) {
        this.routeID = routeID;
        this.busStandID = busStandID;
        this.name = name;
        this.source = source;
        this.destination = destination;
        this.searchCount = searchCount;
    }

}
