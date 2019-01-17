package com.vicky7230.headlines.data.db.room

import androidx.room.TypeConverter
import com.demo.applicationskeleton.data.network.model.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    @TypeConverter
    fun nameToString(name: Name?): String? {
        if (name == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Name>() {

        }.type
        return gson.toJson(name, type)
    }

    @TypeConverter
    fun stringToName(nameString: String?): Name? {
        if (nameString == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Name>() {

        }.type
        return gson.fromJson<Name>(nameString, type)
    }

    @TypeConverter
    fun locationToString(location: Location?): String? {
        if (location == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Location>() {

        }.type
        return gson.toJson(location, type)
    }

    @TypeConverter
    fun stringToLocation(locationString: String?): Location? {
        if (locationString == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Location>() {

        }.type
        return gson.fromJson<Location>(locationString, type)
    }

    @TypeConverter
    fun coordinatesToString(coordinates: Coordinates?): String? {
        if (coordinates == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Coordinates>() {

        }.type
        return gson.toJson(coordinates, type)
    }

    @TypeConverter
    fun stringToCoordinates(coordinatesString: String?): Coordinates? {
        if (coordinatesString == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Coordinates>() {

        }.type
        return gson.fromJson<Coordinates>(coordinatesString, type)
    }

    @TypeConverter
    fun timezoneToString(timezone: Timezone?): String? {
        if (timezone == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Timezone>() {

        }.type
        return gson.toJson(timezone, type)
    }

    @TypeConverter
    fun stringToTimezone(timezoneString: String?): Timezone? {
        if (timezoneString == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Timezone>() {

        }.type
        return gson.fromJson<Timezone>(timezoneString, type)
    }

    @TypeConverter
    fun loginToString(login: Login?): String? {
        if (login == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Login>() {

        }.type
        return gson.toJson(login, type)
    }

    @TypeConverter
    fun stringToLogin(loginString: String?): Login? {
        if (loginString == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Login>() {

        }.type
        return gson.fromJson<Login>(loginString, type)
    }

    @TypeConverter
    fun dobToString(dob: DOB?): String? {
        if (dob == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<DOB>() {

        }.type
        return gson.toJson(dob, type)
    }

    @TypeConverter
    fun stringToDOB(dobString: String?): DOB? {
        if (dobString == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<DOB>() {

        }.type
        return gson.fromJson<DOB>(dobString, type)
    }

    @TypeConverter
    fun registeredToString(registered: Registered?): String? {
        if (registered == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Registered>() {

        }.type
        return gson.toJson(registered, type)
    }

    @TypeConverter
    fun stringToRegistered(registeredString: String?): Registered? {
        if (registeredString == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Registered>() {

        }.type
        return gson.fromJson<Registered>(registeredString, type)
    }

    @TypeConverter
    fun idToString(id: ID?): String? {
        if (id == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<ID>() {

        }.type
        return gson.toJson(id, type)
    }

    @TypeConverter
    fun stringToID(idString: String?): ID? {
        if (idString == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<ID>() {

        }.type
        return gson.fromJson<ID>(idString, type)
    }

    @TypeConverter
    fun idToString(picture: Picture?): String? {
        if (picture == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Picture>() {

        }.type
        return gson.toJson(picture, type)
    }

    @TypeConverter
    fun stringToPicture(pictureString: String?): Picture? {
        if (pictureString == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Picture>() {

        }.type
        return gson.fromJson<Picture>(pictureString, type)
    }

}