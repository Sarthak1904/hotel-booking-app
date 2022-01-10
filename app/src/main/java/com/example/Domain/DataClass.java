package com.example.Domain;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class DataClass {
    String heading, description;
    Integer drawableImageId, guests, beds, bathrooms, bedrooms;
    Boolean yesPrivateBathroom, noPrivateBathroom;

    public DataClass(String heading, String description) {
        this.heading = heading;
        this.description = description;
    }

    public DataClass(String heading) {
        this.heading = heading;
    }

    public DataClass(Integer drawableImageId, String heading) {
        this.drawableImageId = drawableImageId;
        this.heading = heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DataClass() { }

    public DataClass(Integer guests, Integer beds, Integer bedrooms, Integer bathrooms, Boolean yesPrivateBathroom, Boolean noPrivateBathroom) {
        this.guests = guests;
        this.beds = beds;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.yesPrivateBathroom = yesPrivateBathroom;
        this.noPrivateBathroom = noPrivateBathroom;
    }


    public String getHeading() {
        return heading;
    }

    public String getDescription() {
        return description;
    }

    public Integer getDrawableImageId() { return drawableImageId; }

    public Integer getGuests() { return guests; }

    public Integer getBeds() { return beds; }

    public Integer getBathrooms() { return bathrooms; }

    public Integer getBedrooms() { return bedrooms; }

    public Boolean getYesPrivateBathroom() { return yesPrivateBathroom; }

    public Boolean getNoPrivateBathroom() { return noPrivateBathroom; }

}