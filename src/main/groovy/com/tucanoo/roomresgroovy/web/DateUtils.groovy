package com.tucanoo.roomresgroovy.web

import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat

class DateUtils {
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd")

    static Date createDateFromString(String dateString) {
        Date date = new Date()
        if (null != dateString) {
            try {
                date = DATE_FORMAT.parse(dateString)
            } catch (ParseException e) {
                e.printStackTrace()
            }
        }
        return date
    }
}
