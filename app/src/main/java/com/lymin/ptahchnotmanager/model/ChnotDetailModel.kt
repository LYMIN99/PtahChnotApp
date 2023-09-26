package com.lymin.ptahchnotmanager.model

class ChnotDetailModel {
    var post : String? = null
    var number2 : String? = null
    var number3 : String? = null
    var number4 : String? = null

    constructor() {
        // Default constructor required for Firestore
    }
    constructor(post: String?, number2: String?, number3: String?, number4: String?) {
        this.post = post
        this.number2 = number2
        this.number3 = number3
        this.number4 = number4
    }
}