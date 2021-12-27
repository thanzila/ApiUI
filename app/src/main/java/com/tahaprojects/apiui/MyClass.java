package com.tahaprojects.apiui;

import java.util.List;

public class MyClass {




    public Location location;
    public Current current;
    public Forecast forecast;
    public Alerts alerts;

    public MyClass(Location location, Current current, Forecast forecast, Alerts alerts) {
        this.location = location;
        this.current = current;
        this.forecast = forecast;
        this.alerts = alerts;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

    public void setAlerts(Alerts alerts) {
        this.alerts = alerts;
    }

    public Location getLocation() {
        return location;
    }

    public Current getCurrent() {
        return current;
    }

    public Forecast getForecast() {
        return forecast;
    }

    public Alerts getAlerts() {
        return alerts;
    }


    public class Location{




        public String name;
        public String region;
        public String country;
        public double lat;
        public double lon;
        public String localtime;

        public Location(String name, String region, String country, double lat, double lon, String localtime) {
            this.name = name;
            this.region = region;
            this.country = country;
            this.lat = lat;
            this.lon = lon;
            this.localtime = localtime;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLon() {
            return lon;
        }

        public void setLon(double lon) {
            this.lon = lon;
        }

        public String getLocaltime() {
            return localtime;
        }

        public void setLocaltime(String localtime) {
            this.localtime = localtime;
        }
    }
    public class Condition{
        public String text;
        public String icon;

        public Condition(String text, String icon) {
            this.text = text;
            this.icon = icon;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getIcon() {
            return "https:"+icon;
        }
    }
    public class Current{
        public int last_updated_epoch;
        public String last_updated;
        public double temp_c;
        public double temp_f;
        public int is_day;
        public Condition condition;
        public int humidity;
        public int cloud;

        public Current(int last_updated_epoch, String last_updated, double temp_c, double temp_f, int is_day, Condition condition, int humidity, int cloud) {
            this.last_updated_epoch = last_updated_epoch;
            this.last_updated = last_updated;
            this.temp_c = temp_c;
            this.temp_f = temp_f;
            this.is_day = is_day;
            this.condition = condition;
            this.humidity = humidity;
            this.cloud = cloud;
        }

        public int getLast_updated_epoch() {
            return last_updated_epoch;
        }

        public void setLast_updated_epoch(int last_updated_epoch) {
            this.last_updated_epoch = last_updated_epoch;
        }

        public String getLast_updated() {
            return last_updated;
        }

        public void setLast_updated(String last_updated) {
            this.last_updated = last_updated;
        }

        public double getTemp_c() {
            return temp_c;
        }

        public void setTemp_c(double temp_c) {
            this.temp_c = temp_c;
        }

        public double getTemp_f() {
            return temp_f;
        }

        public void setTemp_f(double temp_f) {
            this.temp_f = temp_f;
        }

        public int getIs_day() {
            return is_day;
        }

        public void setIs_day(int is_day) {
            this.is_day = is_day;
        }

        public Condition getCondition() {
            return condition;
        }

        public void setCondition(Condition condition) {
            this.condition = condition;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

        public int getCloud() {
            return cloud;
        }

        public void setCloud(int cloud) {
            this.cloud = cloud;
        }
    }
    public class Day{
        public double maxtemp_c;
        public double maxtemp_f;
        public double mintemp_c;
        public double mintemp_f;
        public double avgtemp_c;
        public double avgtemp_f;
        //public Condition condition;


        public Day(double maxtemp_c, double maxtemp_f, double mintemp_c, double mintemp_f, double avgtemp_c, double avgtemp_f) {
            this.maxtemp_c = maxtemp_c;
            this.maxtemp_f = maxtemp_f;
            this.mintemp_c = mintemp_c;
            this.mintemp_f = mintemp_f;
            this.avgtemp_c = avgtemp_c;
            this.avgtemp_f = avgtemp_f;
        }

        public double getMaxtemp_c() {
            return maxtemp_c;
        }

        public void setMaxtemp_c(double maxtemp_c) {
            this.maxtemp_c = maxtemp_c;
        }

        public double getMaxtemp_f() {
            return maxtemp_f;
        }

        public void setMaxtemp_f(double maxtemp_f) {
            this.maxtemp_f = maxtemp_f;
        }

        public double getMintemp_c() {
            return mintemp_c;
        }

        public void setMintemp_c(double mintemp_c) {
            this.mintemp_c = mintemp_c;
        }

        public double getMintemp_f() {
            return mintemp_f;
        }

        public void setMintemp_f(double mintemp_f) {
            this.mintemp_f = mintemp_f;
        }

        public double getAvgtemp_c() {
            return avgtemp_c;
        }

        public void setAvgtemp_c(double avgtemp_c) {
            this.avgtemp_c = avgtemp_c;
        }

        public double getAvgtemp_f() {
            return avgtemp_f;
        }

        public void setAvgtemp_f(double avgtemp_f) {
            this.avgtemp_f = avgtemp_f;
        }
    }
    public class Astro{
        public String sunrise;
        public String sunset;
        public String moonrise;
        public String moonset;

        public Astro(String sunrise, String sunset, String moonrise, String moonset) {
            this.sunrise = sunrise;
            this.sunset = sunset;
            this.moonrise = moonrise;
            this.moonset = moonset;
        }

        public String getSunrise() {
            return sunrise;
        }

        public void setSunrise(String sunrise) {
            this.sunrise = sunrise;
        }

        public String getSunset() {
            return sunset;
        }

        public void setSunset(String sunset) {
            this.sunset = sunset;
        }

        public String getMoonrise() {
            return moonrise;
        }

        public void setMoonrise(String moonrise) {
            this.moonrise = moonrise;
        }

        public String getMoonset() {
            return moonset;
        }

        public void setMoonset(String moonset) {
            this.moonset = moonset;
        }
    }
    public class Hour{
        public String time;
        public double temp_c;
        public double temp_f;
        public Condition condition;

        public Hour(String time, double  temp_c, double temp_f, Condition condition) {
            this.time = time;
            this.temp_c = temp_c;
            this.temp_f = temp_f;
            this.condition = condition;
        }

        public String getTime() {
            return time;
        }

        public double  getTemp_c() {
            return temp_c;
        }

        public double  getTemp_f() {
            return temp_f;
        }

        public Condition getCondition() {
            return condition;
        }
    }
    public class Forecastday{
        public String date;
        public int date_epoch;
        public Day day;
        public Astro astro;
        public List<Hour> hour;

        public Forecastday(String date, int date_epoch, Day day, Astro astro, List<Hour> hour) {
            this.date = date;
            this.date_epoch = date_epoch;
            this.day = day;
            this.astro = astro;
            this.hour = hour;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getDate_epoch() {
            return date_epoch;
        }

        public void setDate_epoch(int date_epoch) {
            this.date_epoch = date_epoch;
        }

        public Day getDay() {
            return day;
        }

        public void setDay(Day day) {
            this.day = day;
        }

        public Astro getAstro() {
            return astro;
        }

        public void setAstro(Astro astro) {
            this.astro = astro;
        }

        public List<Hour> getHour() {
            return hour;
        }

        public void setHour(List<Hour> hour) {
            this.hour = hour;
        }
    }
    public class Forecast{
        public List<Forecastday> forecastday;

        public Forecast(List<Forecastday> forecastday) {
            this.forecastday = forecastday;
        }

        public List<Forecastday> getForecastday() {
            return forecastday;
        }
    }
    public class Alerts{
        public List<Object> alert;

        public Alerts(List<Object> alert) {
            this.alert = alert;
        }

        public List<Object> getAlert() {
            return alert;
        }
    }

}
