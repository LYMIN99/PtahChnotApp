package com.lymin.ptahchnot.firebaseHelper
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.lymin.ptahchnot.model.ChnotDetailModel
import com.lymin.ptahchnot.model.ChnotModel

class FirebaseHelper {
    companion object {
        fun getData(oncallBack :OnGetDataallBack) {
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

    interface OnGetDataallBack {
        fun onSuccess(list : MutableList<ChnotModel>)
        fun onFailed()
    }
}
