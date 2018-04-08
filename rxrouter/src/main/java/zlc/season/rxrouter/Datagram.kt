package zlc.season.rxrouter

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable

data class Datagram(
        var uri: String = "",
        var intValue: Int? = null,
        var longValue: Long? = null,
        var floatValue: Float? = null,
        var doubleValue: Double? = null,
        var stringValue: String? = null,
        var booleanValue: Boolean? = null,
        var data: Bundle? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Float::class.java.classLoader) as Float?,
            source.readValue(Double::class.java.classLoader) as Double?,
            source.readString(),
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readParcelable<Bundle>(Bundle::class.java.classLoader)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(uri)
        writeValue(intValue)
        writeValue(longValue)
        writeValue(floatValue)
        writeValue(doubleValue)
        writeString(stringValue)
        writeValue(booleanValue)
        writeParcelable(data, 0)
    }

    companion object {
        fun empty(): Datagram {
            return Datagram()
        }

        @JvmField
        val CREATOR: Parcelable.Creator<Datagram> = object : Parcelable.Creator<Datagram> {
            override fun createFromParcel(source: Parcel): Datagram = Datagram(source)
            override fun newArray(size: Int): Array<Datagram?> = arrayOfNulls(size)
        }
    }
}