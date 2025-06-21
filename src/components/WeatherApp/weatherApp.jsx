// src/components/WeatherApp/weatherApp.jsx

// import "../../sass/weatherApp.scss";
import { useState, useEffect, useRef } from "react";
import humidityImg from "../../assets/humidity.png";
import rain from "../../assets/rain.png";
import searchIcon from "../../assets/search.png";
import drizzle from "../../assets/drizzle.png";
import snow from "../../assets/snow.png";
import windImg from "../../assets/wind.png";
import cloud from "../../assets/cloud.png";
import clear from "../../assets/clear.png";
// import "bootstrap/dist/css/bootstrap.min.css";

const WeatherDetails = ({
  icon,
  temp,
  city,
  country,
  lat,
  long,
  humidity,
  wind,
}) => {
  return (
    <div className="weather-card">
      <div className="weather-icon">
        <img src={icon} alt="weather" />
      </div>
      <div className="temp">Temperature: {Math.round(temp)}°C</div>
      <div className="location">City: {city}</div>
      <div className="country">Country: {country}</div>
      <div className="coords">
        <span className="latitude">Latitude: {lat}</span> |{" "}
        <span className="longitude">Longitude: {long}</span>
      </div>

      <div className="data-container">
        <div className="element">
          <img className="icon" src={humidityImg} alt="humidity" />
          <div className="data">
            <div className="value">{humidity}%</div>
            <div className="text">Humidity</div>
          </div>
        </div>

        <div className="element">
          <img className="icon" src={windImg} alt="wind" />
          <div className="data">
            <div className="value">{wind} km/h</div>
            <div className="text">Wind</div>
          </div>
        </div>
      </div>
    </div>
  );
};

const WeatherApp = () => {
  const [city, setCity] = useState("Chennai");
  const [country, setCountry] = useState("");
  const [temp, setTemp] = useState(0);
  const [icon, setIcon] = useState(clear);
  const [lat, setLat] = useState(0);
  const [long, setLong] = useState(0);
  const [humidity, setHumidity] = useState(0);
  const [wind, setWind] = useState(0);
  const [error, setError] = useState("");
  const inputRef = useRef();

  const getWeatherIcon = (main) => {
    switch (main) {
      case "Clouds":
        return cloud;
      case "Clear":
        return clear;
      case "Rain":
        return rain;
      case "Drizzle":
        return drizzle;
      case "Snow":
        return snow;
      default:
        return clear;
    }
  };

  const fetchWeather = async (queryCity = city) => {
    const apiKey = "0c836545a811100c1170080fd07e924c";
    const url = `https://api.openweathermap.org/data/2.5/weather?q=${queryCity}&appid=${apiKey}&units=metric`;

    try {
      const res = await fetch(url);
      const data = await res.json();

      if (data.cod !== 200) {
        setError(data.message || "City not found");
        return;
      }

      setCity(data.name);
      setCountry(data.sys.country);
      setLat(data.coord.lat);
      setLong(data.coord.lon);
      setTemp(data.main.temp);
      setHumidity(data.main.humidity);
      setWind(data.wind.speed);
      setIcon(getWeatherIcon(data.weather[0].main));
      setError("");
    } catch (err) {
      console.error("Fetch error:", err);
      setError("Unable to fetch weather data");
    }
  };

  const handleSearch = () => {
    const newCity = inputRef.current.value.trim();
    if (newCity) {
      fetchWeather(newCity);
    }
  };

  const handleKeyPress = (e) => {
    if (e.key === "Enter") {
      handleSearch();
    }
  };

  useEffect(() => {
    fetchWeather();
  }, []);

  return (
    <div className="container">
      <div className="input-container">
        <input
          type="text"
          className="city-input"
          placeholder="Enter city"
          ref={inputRef}
          onKeyDown={handleKeyPress}
        />
        <div className="search-icon" onClick={handleSearch}>
          <img src={searchIcon} alt="search" />
        </div>
      </div>

      {error ? ( <div className="error">{error}</div>  ) : (
        <WeatherDetails
          lat={lat}
          long={long}
          icon={icon}
          temp={temp}
          city={city}
          country={country}
          humidity={humidity}
          wind={wind}
        />
      )}
    </div>
  );
};

export default WeatherApp;
