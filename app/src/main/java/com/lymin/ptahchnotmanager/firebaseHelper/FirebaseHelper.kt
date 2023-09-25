package com.lymin.ptahchnotmanager.firebaseHelper
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.lymin.ptahchnotmanager.model.ChnotDetailModel
import com.lymin.ptahchnotmanager.model.ChnotModel
import com.lymin.ptahchnotmanager.model.PostModel
import com.lymin.ptahchnotmanager.model.TimeModel

class FirebaseHelper {
    companion object {
        fun getData(oncallBack : OnGetDataallBack) {
            val db = FirebaseFirestore.getInstance()
            val chnotsCollectionRef = db.collection("Chnots")
            val chnotList = mutableListOf<ChnotModel>()
            chnotsCollectionRef.get().addOnSuccessListener { querySnapshot ->
                    for (document in querySnapshot) {
                        // Get the ChnotModel data
                        val date = document.getString("date")
                        val time = document.getString("time")

                        // Get the sub-collection "details"
                        val detailsCollectionRef = document.reference.collection("details")

                        // Assuming you have a class to represent your ChnotDetailModel
                        // (replace YourChnotDetailModelClass with your actual class name)
                        val detailsList = mutableListOf<ChnotDetailModel>()

                        // Retrieve data from the "details" sub-collection
                        detailsCollectionRef.get()
                            .addOnSuccessListener { detailsQuerySnapshot ->
                                for (detailDocument in detailsQuerySnapshot) {
                                    val post = detailDocument.getString("post")
                                    val number = detailDocument.getString("number")

                                    // Create a ChnotDetailModel instance and add it to the list
                                    val detailModel = ChnotDetailModel(post, number)
                                    detailsList.add(detailModel)
                                }

                                // Create a ChnotModel instance with details and add it to the list
                                val chnotModel = ChnotModel(date, time, detailsList)
                                chnotList.add(chnotModel)

                                Log.d("TAG", "getData: Success ${chnotList.size}")

                                // Now you have the ChnotModel data with details
                                oncallBack.onSuccess(chnotList)
                            }
                            .addOnFailureListener { exception ->
                                // Handle errors while retrieving "details" sub-collection
                                Log.e("TAG", "getData: details", exception)
                                oncallBack.onFailed()
                            }
                    }

                    // Now you have the list of ChnotModel data
                }
                .addOnFailureListener { exception ->
                    // Handle errors while retrieving "Chnots" collection
                    Log.e("TAG", "getData: Chnots", exception)
                    oncallBack.onFailed()
                }
        }
    }
    fun getTimes(oncallBack : OnGetTimesCallBack) {
        val db = FirebaseFirestore.getInstance()
        val chnotsCollectionRef = db.collection("Times")
        val list = mutableListOf<TimeModel>()
        chnotsCollectionRef.get().addOnSuccessListener { querySnapshot ->
            for (document in querySnapshot) {
                // Get the ChnotModel data
                val id = document.getString("id")
                val time = document.getString("time")
                list.add(TimeModel(id,time))
            }
            oncallBack.onSuccess(list)
            // Now you have the list of ChnotModel data
        }.addOnFailureListener { exception ->
            // Handle errors while retrieving "Chnots" collection
            oncallBack.onFailed()
            Log.e("TAG", "getData: getTimes", exception)
        }
    }

    fun getPosts(oncallBack : OnGetPostCallBack) {
        val db = FirebaseFirestore.getInstance()
        val chnotsCollectionRef = db.collection("Posts")
        val list = mutableListOf<PostModel>()
        chnotsCollectionRef.get().addOnSuccessListener { querySnapshot ->
            for (document in querySnapshot) {
                // Get the ChnotModel data
                val id = document.getString("id")
                val time = document.getString("post")
                list.add(PostModel(id,time))
            }
            oncallBack.onSuccess(list)
            // Now you have the list of ChnotModel data
        }.addOnFailureListener { exception ->
            // Handle errors while retrieving "Chnots" collection
            oncallBack.onFailed()
            Log.e("TAG", "getData: Chnots", exception)
        }
    }

    interface OnGetTimesCallBack {
        fun onSuccess(list : MutableList<TimeModel>)
        fun onFailed()
    }
    interface OnGetPostCallBack {
        fun onSuccess(list : MutableList<PostModel>)
        fun onFailed()
    }
    interface OnGetDataallBack {
        fun onSuccess(list : MutableList<ChnotModel>)
        fun onFailed()
    }
}
