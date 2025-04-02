package com.example.bus.ui.dbs;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import java.util.List;

/** ✅ DAO Interface for Queries */
@Dao
public interface DaoInterfaces {

    /** 🔹 Get all Districts */
    @Query("SELECT * FROM districts")
    List<DistrictEntity> getAllDistricts();

    /** 🔹 Get all District Names */
    @Query("SELECT name FROM districts")
    List<String> getAllDistrictNames();


    /** 🔹 Get Taluk Names by District */
    @Query("SELECT name FROM taluks WHERE districtID = (SELECT districtID FROM districts WHERE name = :districtName)")
    List<String> getTalukNamesByDistrict(String districtName);


    /** 🔹 Get all Taluks */
    @Query("SELECT * FROM taluks")
    List<TalukEntity> getAllTaluks();



    /** 🔹 Get all Bus Stands */
    @Query("SELECT * FROM bus_stands")
    List<BusStandEntity> getAllBusStands();

    /** 🔹 Get Bus Stand Names by Taluk */
    @Query("SELECT name FROM bus_stands WHERE talukID = (SELECT talukID FROM taluks WHERE name = :talukName)")
    List<String> getBusStandNamesByTaluk(String talukName);


    /** 🔹 Get all Routes */
    @Query("SELECT * FROM routes")
    List<RouteEntity> getAllRoutes();

    /** 🔹 Get Route Names by Bus Stand */

    @Query("SELECT name FROM routes WHERE busStandID = (SELECT busStandID FROM bus_stands WHERE name = :busStandName)")
    List<String> getRouteNamesByBusStand(String busStandName);

    /** 🔹 Get all Buses */
    @Query("SELECT * FROM buses")
    List<BusEntity> getAllBuses();

    /** 🔹 Get all Bus Names */
    @Query("SELECT name FROM buses")
    List<String> getAllBusNames();

    /** 🔹 Get Buses by Route */
    @Query("SELECT * FROM buses WHERE routeID = :routeID")
    List<BusEntity> getBusesByRoute(String routeID);

    /** 🔹 Get Bus Names by Route */
    @Query("SELECT name FROM buses WHERE routeID = (SELECT routeID FROM routes WHERE name = :routeName)")
    List<String> getBusNamesByRoute(String routeName);


    /** 🔹 Get all Stops */
    @Query("SELECT * FROM stops")
    List<StopEntity> getAllStops();



    /** 🔹 Get all Timings */
    @Query("SELECT * FROM timings")
    List<TimingEntity> getAllTimings();



    /** 🔹 Get Bus by Name (Multiple Matches) */
    @Query("SELECT * FROM buses WHERE name LIKE '%' || :busName || '%' COLLATE NOCASE")
    List<BusEntity> getBusesByName(String busName);

    /** 🔹 Get Buses by Source & Destination */
    @Query("SELECT * FROM buses WHERE routeID IN (SELECT routeID FROM routes WHERE source LIKE '%' || :source || '%' AND destination LIKE '%' || :destination || '%')")
    List<BusEntity> getBusesByRouteName(String source, String destination);

    /** 🔹 Get Taluk by Bus ID */
    @Query("SELECT t.name FROM taluks t INNER JOIN bus_stands bs ON t.talukID = bs.talukID INNER JOIN routes r ON bs.busStandID = r.busStandID INNER JOIN buses b ON r.routeID = b.routeID WHERE b.busID = :busID")
    String getTalukByBusID(String busID);

    /** 🔹 Get Route by Bus ID */
    @Query("SELECT r.name FROM routes r INNER JOIN buses b ON r.routeID = b.routeID WHERE b.busID = :busID")
    String getRouteByBusID(String busID);

    /** 🔹 Get Bus Name by Bus ID */
    @Query("SELECT name FROM buses WHERE busID = :busID")
    String getBusNameByID(String busID);

    /** 🔹 Get Bus Stand by Bus ID */
    @Query("SELECT bs.name FROM bus_stands bs INNER JOIN routes r ON bs.busStandID = r.busStandID INNER JOIN buses b ON r.routeID = b.routeID WHERE b.busID = :busID")
    String getBusStandByBusID(String busID);

    /** 🔹 Insert Districts */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertDistricts(List<DistrictEntity> districts);

    /** 🔹 Insert Taluks */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTaluks(List<TalukEntity> taluks);

    /** 🔹 Insert Bus Stands */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBusStands(List<BusStandEntity> busStands);

    /** 🔹 Insert Routes */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertRoutes(List<RouteEntity> routes);

    /** 🔹 Insert Buses */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertBuses(List<BusEntity> buses);

    /** 🔹 Insert Stops */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertStops(List<StopEntity> stops);
    /** 🔹 Get Stops by Bus */
    @Query("SELECT * FROM stops WHERE busID = :busID ORDER BY stopOrder ASC")
    List<StopEntity> getStopsByBus(String busID);


    /** 🔹 Get Timings by Bus */
    @Query("SELECT * FROM timings WHERE busID = :busID ORDER BY timingID ASC")
    List<TimingEntity> getTimingsByBus(String busID);

    /** 🔹 Insert Timings */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTimings(List<TimingEntity> timings);

    /** 🔹 Get District by Bus ID */
    @Query("SELECT d.name FROM districts d INNER JOIN taluks t ON d.districtID = t.districtID " +
            "INNER JOIN bus_stands bs ON t.talukID = bs.talukID " +
            "INNER JOIN routes r ON bs.busStandID = r.busStandID " +
            "INNER JOIN buses b ON r.routeID = b.routeID WHERE b.busID = :busID")
    String getDistrictByBusID(String busID);

    @Query("SELECT * FROM routes ORDER BY routeID DESC LIMIT 10")
    List<RouteEntity> getRecentSearchHistory();


    @Query("SELECT busStandID FROM routes WHERE routeID = :routeID LIMIT 1")
    String getBusStandByRouteID(String routeID);
    @Query("SELECT * FROM routes WHERE routeID = :routeID LIMIT 1")
    RouteEntity getRouteByID(String routeID);

    @Query("UPDATE routes SET searchCount = searchCount + 1 WHERE routeID = :routeID")
    int incrementSearchCount(String routeID);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertRoute(RouteEntity route);

    @Query("SELECT * FROM routes WHERE searchCount > 0 ORDER BY searchCount DESC LIMIT 50")
    List<RouteEntity> getOnlySearchedRoutes();

}
