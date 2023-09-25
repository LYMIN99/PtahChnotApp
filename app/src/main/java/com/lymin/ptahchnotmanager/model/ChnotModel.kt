package com.lymin.ptahchnotmanager.model

class ChnotModel {
    var date : String?
    var time : String?
    var details : List<ChnotDetailModel>

    constructor(date: String?, time: String?, details: List<ChnotDetailModel>) {
        this.date = date
        this.time = time
        this.details = details
    }
}