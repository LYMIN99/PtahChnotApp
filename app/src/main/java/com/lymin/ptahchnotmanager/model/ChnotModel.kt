package com.lymin.ptahchnotmanager.model

class ChnotModel {
    var date: String? = null
    var time: String? = null
    var details: List<ChnotDetailModel> = ArrayList()

    constructor() {
        // Default constructor required for Firestore
    }

    constructor(date: String?, time: String?, details: List<ChnotDetailModel>) {
        this.date = date
        this.time = time
        this.details = details
    }
}
