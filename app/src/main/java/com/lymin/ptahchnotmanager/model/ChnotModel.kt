package com.lymin.ptahchnotmanager.model
import android.os.Parcel
import android.os.Parcelable

class ChnotModel() : Parcelable {
    var id : String? = null
    var date: String? = null
    var time: String? = null
    var details: List<ChnotDetailModel> = ArrayList()

    constructor(id: String?, date: String?, time: String?, details: List<ChnotDetailModel>) : this() {
        this.id = id
        this.date = date
        this.time = time
        this.details = details
    }

    // Parcelable constructor
    constructor(parcel: Parcel) : this() {
        id = parcel.readString()
        date = parcel.readString()
        time = parcel.readString()
        parcel.readList(details, ChnotDetailModel::class.java.classLoader)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(date)
        parcel.writeString(time)
        parcel.writeList(details)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ChnotModel> {
        override fun createFromParcel(parcel: Parcel): ChnotModel {
            return ChnotModel(parcel)
        }

        override fun newArray(size: Int): Array<ChnotModel?> {
            return arrayOfNulls(size)
        }
    }
}
