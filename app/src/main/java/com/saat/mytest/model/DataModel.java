package com.saat.mytest.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

/*
this is data model for api
or list of FaultBean class

{ DataModel or List<FaultBean> }

this class are create by
 */
@Entity
public class DataModel {

    @SerializedName("fault")
    private FaultBean fault;

    @PrimaryKey(autoGenerate = true)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public FaultBean getFault() {
        return fault;
    }

    public void setFault(FaultBean fault) {
        this.fault = fault;
    }

    @NonNull
    @Override
    public String toString() {
       // return super.toString();

        return "fault : " + fault.getFaultstring() + System.lineSeparator() +
                "error code : " + fault.detail.getErrorcode() + System.lineSeparator();
    }

    public static class FaultBean {

        @SerializedName("faultstring")
        private String faultstring;
        @SerializedName("detail")
        private DetailBean detail;

        public String getFaultstring() {
            return faultstring;
        }

        public void setFaultstring(String faultstring) {
            this.faultstring = faultstring;
        }

        public DetailBean getDetail() {
            return detail;
        }

        public void setDetail(DetailBean detail) {
            this.detail = detail;
        }

    }

    public static class DetailBean {

        @SerializedName("errorcode")
        private String errorcode;

        public String getErrorcode() {
            return errorcode;
        }

        public void setErrorcode(String errorcode) {
            this.errorcode = errorcode;
        }
    }
}
