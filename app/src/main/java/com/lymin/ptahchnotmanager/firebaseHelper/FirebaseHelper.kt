package com.lymin.ptahchnotmanager.firebaseHelper
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.getField
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
                        val dataChnotModel = document.toObject(ChnotModel::class.java)
                        chnotList.add(dataChnotModel)
                    }
                    // Now you have the list of ChnotModel data
                oncallBack.onSuccess(chnotList)
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

    fun saveToFirestore(chnotModel: ChnotModel, oncallBack : OnUploadCallBack) {
        val db = FirebaseFirestore.getInstance()
        // Get a reference to the "Chnots" collection
        val chnotsCollection = db.collection("Chnots")

        // Add a new document to the "Chnots" collection
        chnotsCollection
            .add(chnotModel)
            .addOnSuccessListener { documentReference ->
                // The data was successfully written to Firestore
                // You can do something here if the upload is successful
                val documentId = documentReference.id
                // Log success or navigate to another screen
                oncallBack.onSuccess()
            }
            .addOnFailureListener { e ->
                // Handle any errors that occurred during the upload
                Log.e("Firestore", "Error adding document", e)
                // You might want to display an error message to the user
                oncallBack.onFailed()
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

    interface OnUploadCallBack {
        fun onSuccess()
        fun onFailed()
    }
}
