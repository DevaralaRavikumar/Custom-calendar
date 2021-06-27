package com.codility.horizontalrecyclerview.model

import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by Govind on 3/7/2018.
 */
data class Version(val dayDate: String, val dayName: String,val ticketIndicator:Boolean) {

    companion object {
        fun trimDayName(dayName:String):String{
            return when {
                dayName.equals("Monday", true) -> {
                    "MO"
                }
                dayName.equals("Tuesday", true) -> {
                    "TU"
                }
                dayName.equals("Wednesday", true) -> {
                    "WE"
                }
                dayName.equals("Thursday", true) -> {
                    "TH"
                }
                dayName.equals("Friday", true) -> {
                    "FR"
                }
                dayName.equals("Saturday", true) -> {
                    "SA"
                }
                dayName.equals("Sunday", true) -> {
                    "SU"
                }
                else -> {
                    ""
                }
            }
        }

        fun getList(): List<Version> {
            val versionList = ArrayList<Version>()
            versionList.clear()
            val calendar = Calendar.getInstance()
            val format = SimpleDateFormat("EEEE, d")

            val currentDate = format.format(calendar.time)
            calendar.add(Calendar.DAY_OF_MONTH, 1)
            val datePlus1 = format.format(calendar.time)
            calendar.add(Calendar.DAY_OF_MONTH, 1)
            val datePlus2 = format.format(calendar.time)
            calendar.add(Calendar.DAY_OF_MONTH, 1)
            val datePlus3 = format.format(calendar.time)

            calendar.add(Calendar.DAY_OF_MONTH, 1)
            val datePlus4 = format.format(calendar.time)
            calendar.add(Calendar.DAY_OF_MONTH, 1)
            val datePlus5 = format.format(calendar.time)
            calendar.add(Calendar.DAY_OF_MONTH, 1)
            val datePlus6 = format.format(calendar.time)

            versionList.add(Version(""+currentDate.split(",")[1], ""+ trimDayName(currentDate.split(",")[0]),true))
            versionList.add(Version(""+datePlus1.split(",")[1], ""+ trimDayName(datePlus1.split(",")[0]),true))
            versionList.add(Version(""+datePlus2.split(",")[1], ""+ trimDayName(datePlus2.split(",")[0]),true))
            versionList.add(Version(""+datePlus3.split(",")[1], ""+ trimDayName(datePlus3.split(",")[0]),true))
            versionList.add(Version(""+datePlus4.split(",")[1], ""+ trimDayName(datePlus4.split(",")[0]),true))
            versionList.add(Version(""+datePlus5.split(",")[1], ""+ trimDayName(datePlus5.split(",")[0]),true))
            versionList.add(Version(""+datePlus6.split(",")[1], ""+ trimDayName(datePlus6.split(",")[0]),true))


            /* versionList.add(Version("https://raw.githubusercontent.com/AndroidCodility/StaggeredRecyclerView/master/images/one.jpg", "Greenary"))
             versionList.add(Version("https://raw.githubusercontent.com/AndroidCodility/StaggeredRecyclerView/master/images/two.jpg", "Ocean"))
             versionList.add(Version("https://raw.githubusercontent.com/AndroidCodility/StaggeredRecyclerView/master/images/three.jpg", "Fruit"))
             versionList.add(Version("https://raw.githubusercontent.com/AndroidCodility/StaggeredRecyclerView/master/images/four.jpg", "Shop"))
             versionList.add(Version("https://raw.githubusercontent.com/AndroidCodility/StaggeredRecyclerView/master/images/five.jpg", "Mountain"))
             versionList.add(Version("https://raw.githubusercontent.com/AndroidCodility/StaggeredRecyclerView/master/images/six.jpg", "Coins"))
             versionList.add(Version("https://raw.githubusercontent.com/AndroidCodility/StaggeredRecyclerView/master/images/seven.jpg", "Slimmer"))
             versionList.add(Version("https://raw.githubusercontent.com/AndroidCodility/StaggeredRecyclerView/master/images/eight.jpg", "Clouds"))
             versionList.add(Version("https://raw.githubusercontent.com/AndroidCodility/StaggeredRecyclerView/master/images/nine.jpg", "Sky High"))
             versionList.add(Version("https://raw.githubusercontent.com/AndroidCodility/StaggeredRecyclerView/master/images/ten.jpg", "Sun in oView"))
 */            return versionList
        }
    }
}