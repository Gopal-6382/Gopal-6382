package com.example.bus.ui.dbs;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.Index;

@Entity(
        tableName = "timings",
        foreignKeys = @ForeignKey(entity = BusEntity.class, parentColumns = "busID", childColumns = "busID", onDelete = ForeignKey.CASCADE),
        indices = {@Index(value = "busID")}
)
public class TimingEntity {
    @PrimaryKey @NonNull
    public String timingID;
    public String busID;
    public String stopName;
    public String actualTime;

    public String predictedTime;

    public TimingEntity(@NonNull String timingID, String busID, String stopName, String predictedTime, String actualTime) {
        this.timingID = timingID;
        this.busID = busID;
        this.stopName = stopName;
        this.actualTime = actualTime;
        this.predictedTime = predictedTime;
    }

    public String getStopName() {
        return stopName;
    }
    public String getActualTime() {
        return actualTime;
    }
    public String getPredictedTime() {
        return predictedTime;
    }

}
