package com.lymin.ptahchnotmanager.firebaseHelper
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.lymin.ptahchnotmanager.model.ChnotModel
import com.lymin.ptahchnotmanager.model.PostModel
import com.lymin.ptahchnotmanager.model.TimeModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter

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

        fun getDataYesterday(oncallBack : OnGetDataallBack) {
            val db = FirebaseFirestore.getInstance()
            val chnotsCollectionRef = db.collection("Chnots")
            val chnotList = mutableListOf<ChnotModel>()

            val currentDate = LocalDate.now()
            val yesterday = currentDate.minusDays(1)
            val date = LocalDate.of(currentDate.year, currentDate.month, yesterday.dayOfMonth)
            // Define a custom date format
            val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

            Log.d("TAG", "getDataYesterday: $formatter")
            // Format the date using the formatter
            val formattedDate = date.format(formatter)

            chnotsCollectionRef.whereEqualTo("date",formattedDate).get().addOnSuccessListener { querySnapshot ->
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

    fun saveLotteryToFirestore(chnotModel: ChnotModel, oncallBack : OnUploadCallBack) {
        val db = FirebaseFirestore.getInstance()
        // Get a reference to the "Chnots" collection
        val chnotsCollection = db.collection("Chnots").document(chnotModel.id.toString())

        // Add a new document to the "Chnots" collection
        chnotsCollection
            .set(chnotModel)
            .addOnSuccessListener { documentReference ->
                oncallBack.onSuccess()
            }
            .addOnFailureListener { e ->
                // Handle any errors that occurred during the upload
                Log.e("Firestore", "Error adding document", e)
                // You might want to display an error message to the user
                oncallBack.onFailed()
            }
    }

    fun updateLotteryToFirestore(chnotModel: ChnotModel, oncallBack : OnUploadCallBack) {
        val db = FirebaseFirestore.getInstance()
        val chnotsCollection = db.collection("Chnots")

        // Get the document reference using the ChnotModel's ID
        val chnotDocumentRef = chnotsCollection.document(chnotModel.id.toString())

        // Update the document with the new data
        chnotDocumentRef.set(chnotModel)
            .addOnSuccessListener {
                // Document updated successfully
                oncallBack.onSuccess()
            }
            .addOnFailureListener {
                // Handle the error
                oncallBack.onFailed()
            }
    }

    fun savePostToFirestore(dataList: List<PostModel>, oncallBack: OnUploadCallBack) {
        val db = FirebaseFirestore.getInstance()
        val dataCollection = db.collection("Posts")

        // Step 1: Query and delete old data
        dataCollection.get()
            .addOnSuccessListener { querySnapshot ->
                val batch = db.batch()

                // Step 2: Delete old data
                for (document in querySnapshot.documents) {
                    batch.delete(document.reference)
                }

                // Step 3: Add new data
                for (post in dataList) {
                    val newDocumentRef = dataCollection.document()
                    batch.set(newDocumentRef, post) // Assuming you have a toMap() function
                }

                // Commit the batch operation
                batch.commit()
                    .addOnSuccessListener {
                        oncallBack.onSuccess()
                    }
                    .addOnFailureListener { e ->
                        Log.e("Firestore", "Error committing batch", e)
                        oncallBack.onFailed()
                    }
            }
            .addOnFailureListener { e ->
                Log.e("Firestore", "Error querying old data", e)
                oncallBack.onFailed()
            }
    }

    fun saveTimeToFirestore(dataList: List<TimeModel>, oncallBack: OnUploadCallBack) {
        val db = FirebaseFirestore.getInstance()
        val dataCollection = db.collection("Times")

        // Step 1: Query and delete old data
        dataCollection.get()
            .addOnSuccessListener { querySnapshot ->
                val batch = db.batch()

                // Step 2: Delete old data
                for (document in querySnapshot.documents) {
                    batch.delete(document.reference)
                }

                // Step 3: Add new data
                for (post in dataList) {
                    val newDocumentRef = dataCollection.document()
                    batch.set(newDocumentRef, post) // Assuming you have a toMap() function
                }

                // Commit the batch operation
                batch.commit()
                    .addOnSuccessListener {
                        oncallBack.onSuccess()
                    }
                    .addOnFailureListener { e ->
                        Log.e("Firestore", "Error committing batch", e)
                        oncallBack.onFailed()
                    }
            }
            .addOnFailureListener { e ->
                Log.e("Firestore", "Error querying old data", e)
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
