package com.lymin.ptahchnotapp.model

import java.io.Serializable

class LotteryTN4Model : Serializable {
    var id : String? = null
    var date: String? = null
    var time: String? = null

    var a2 : String? = null
    var a3 : String? = null
    var a4 : String? = null

    var b2 : String? = null
    var b3 : String? = null
    var b4 : String? = null

    var c2 : String? = null
    var c3 : String? = null

    var d2 : String? = null
    var d3 : String? = null

    var loa1 : String? = null
    var loa2 : String? = null
    var loa3 : String? = null

    var lob1 : String? = null
    var lob2 : String? = null
    var lob3 : String? = null

    var loc1 : String? = null
    var loc2 : String? = null
    var loc3 : String? = null

    var lod1 : String? = null
    var lod2 : String? = null
    var lod3 : String? = null

    var loe1 : String? = null
    var loe2 : String? = null

    constructor()
    constructor(
        id: String?,
        date: String?,
        time: String?,
        a2: String?,
        a3: String?,
        a4: String?,
        b2: String?,
        b3: String?,
        b4: String?,
        c2: String?,
        c3: String?,
        d2: String?,
        d3: String?,
        loa1: String?,
        loa2: String?,
        loa3: String?,
        lob1: String?,
        lob2: String?,
        lob3: String?,
        loc1: String?,
        loc2: String?,
        loc3: String?,
        lod1: String?,
        lod2: String?,
        lod3: String?,
        loe1: String?,
        loe2: String?
    ) {
        this.id = id
        this.date = date
        this.time = time
        this.a2 = a2
        this.a3 = a3
        this.a4 = a4
        this.b2 = b2
        this.b3 = b3
        this.b4 = b4
        this.c2 = c2
        this.c3 = c3
        this.d2 = d2
        this.d3 = d3
        this.loa1 = loa1
        this.loa2 = loa2
        this.loa3 = loa3
        this.lob1 = lob1
        this.lob2 = lob2
        this.lob3 = lob3
        this.loc1 = loc1
        this.loc2 = loc2
        this.loc3 = loc3
        this.lod1 = lod1
        this.lod2 = lod2
        this.lod3 = lod3
        this.loe1 = loe1
        this.loe2 = loe2
    }


}