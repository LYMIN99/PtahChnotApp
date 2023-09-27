package com.lymin.ptahchnotmanager.model
import android.os.Parcel
import android.os.Parcelable

class ChnotDetailModel() : Parcelable {
    var id : String? = null
    var post: String? = null
    var number2: String? = null
    var number3: String? = null
    var number4: String? = null

    constructor(id: String?, post: String?, number2: String?, number3: String?, number4: String?) : this() {
        this.id = id
        this.post = post
        this.number2 = number2
        this.number3 = number3
        this.number4 = number4
    }

    // Parcelable constructor
    constructor(parcel: Parcel) : this() {
        id = parcel.readString()
        post = parcel.readString()
        number2 = parcel.readString()
        number3 = parcel.readString()
        number4 = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(post)
        parcel.writeString(number2)
        parcel.writeString(number3)
        parcel.writeString(number4)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ChnotDetailModel> {
        override fun createFromParcel(parcel: Parcel): ChnotDetailModel {
            return ChnotDetailModel(parcel)
        }

        override fun newArray(size: Int): Array<ChnotDetailModel?> {
            return arrayOfNulls(size)
        }
    }
}
