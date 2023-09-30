package com.lymin.ptahchnotmanager.firebaseHelper
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.lymin.ptahchnotmanager.model.ChnotModel
import com.lymin.ptahchnotmanager.model.LotteryTN1Model
import com.lymin.ptahchnotmanager.model.LotteryTN4Model
import com.lymin.ptahchnotmanager.model.LotteryVN1Model
import com.lymin.ptahchnotmanager.model.LotteryVN2Model
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

        fun getDataVN1(dateTime: String,oncallBack : OnGetVN1CallBack) {
            val db = FirebaseFirestore.getInstance()
            val chnotsCollectionRef = db.collection("LotteryVN1").document(dateTime)

            chnotsCollectionRef.get().addOnSuccessListener { querySnapshot ->
                val dataChnotModel = querySnapshot.toObject(LotteryVN1Model::class.java)
                if (dataChnotModel != null) {
                    oncallBack.onSuccess(dataChnotModel)
                } else {
                    oncallBack.onFailed()
                }
            }
                .addOnFailureListener { exception ->
                    // Handle errors while retrieving "Chnots" collection
                    Log.e("TAG", "getData: getDataVN1", exception)
                    oncallBack.onFailed()
                }
        }

        fun getDataVN2(dateTime: String,oncallBack : OnGetVN2CallBack) {
            val db = FirebaseFirestore.getInstance()
            val chnotsCollectionRef = db.collection("LotteryVN2").document(dateTime)

            chnotsCollectionRef.get().addOnSuccessListener { querySnapshot ->
                val dataChnotModel = querySnapshot.toObject(LotteryVN2Model::class.java)
                if (dataChnotModel != null) {
                    oncallBack.onSuccess(dataChnotModel)
                } else {
                    oncallBack.onFailed()
                }
            }
                .addOnFailureListener { exception ->
                    // Handle errors while retrieving "Chnots" collection
                    Log.e("TAG", "getData: getDataVN1", exception)
                    oncallBack.onFailed()
                }
        }

        fun getDataTN1(dateTime: String,oncallBack : OnGetTN1CallBack) {
            val db = FirebaseFirestore.getInstance()
            val chnotsCollectionRef = db.collection("LotteryTN1").document(dateTime)

            chnotsCollectionRef.get().addOnSuccessListener { querySnapshot ->
                val dataChnotModel = querySnapshot.toObject(LotteryTN1Model::class.java)
                if (dataChnotModel != null) {
                    oncallBack.onSuccess(dataChnotModel)
                } else {
                    oncallBack.onFailed()
                }
            }
                .addOnFailureListener { exception ->
                    // Handle errors while retrieving "Chnots" collection
                    Log.e("TAG", "getData: LotteryTN1", exception)
                    oncallBack.onFailed()
                }
        }
        fun getDataTN2(dateTime: String,oncallBack : OnGetTN1CallBack) {
            val db = FirebaseFirestore.getInstance()
            val chnotsCollectionRef = db.collection("LotteryTN2").document(dateTime)

            chnotsCollectionRef.get().addOnSuccessListener { querySnapshot ->
                val dataChnotModel = querySnapshot.toObject(LotteryTN1Model::class.java)
                if (dataChnotModel != null) {
                    oncallBack.onSuccess(dataChnotModel)
                } else {
                    oncallBack.onFailed()
                }
            }
                .addOnFailureListener { exception ->
                    // Handle errors while retrieving "Chnots" collection
                    Log.e("TAG", "getData: LotteryTN1", exception)
                    oncallBack.onFailed()
                }
        }
        fun getDataTN3(dateTime: String,oncallBack : OnGetTN1CallBack) {
            val db = FirebaseFirestore.getInstance()
            val chnotsCollectionRef = db.collection("LotteryTN3").document(dateTime)

            chnotsCollectionRef.get().addOnSuccessListener { querySnapshot ->
                val dataChnotModel = querySnapshot.toObject(LotteryTN1Model::class.java)
                if (dataChnotModel != null) {
                    oncallBack.onSuccess(dataChnotModel)
                } else {
                    oncallBack.onFailed()
                }
            }
                .addOnFailureListener { exception ->
                    // Handle errors while retrieving "Chnots" collection
                    Log.e("TAG", "getData: LotteryTN1", exception)
                    oncallBack.onFailed()
                }
        }
        fun getDataTN4(dateTime: String,oncallBack : OnGetTN4CallBack) {
            val db = FirebaseFirestore.getInstance()
            val chnotsCollectionRef = db.collection("LotteryTN4").document(dateTime)

            chnotsCollectionRef.get().addOnSuccessListener { querySnapshot ->
                val dataChnotModel = querySnapshot.toObject(LotteryTN4Model::class.java)
                if (dataChnotModel != null) {
                    oncallBack.onSuccess(dataChnotModel)
                } else {
                    oncallBack.onFailed()
                }
            }
                .addOnFailureListener { exception ->
                    // Handle errors while retrieving "Chnots" collection
                    Log.e("TAG", "getData: LotteryTN1", exception)
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

    fun saveLotteryVn1ToFirestore(chnotModel: LotteryVN1Model, oncallBack : OnUploadCallBack) {
        val db = FirebaseFirestore.getInstance()
        // Get a reference to the "Chnots" collection
        val chnotsCollection = db.collection("LotteryVN1").document(chnotModel.date.toString())

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

    fun saveLotteryVn2ToFirestore(chnotModel: LotteryVN2Model, oncallBack : OnUploadCallBack) {
        val db = FirebaseFirestore.getInstance()
        // Get a reference to the "Chnots" collection
        val chnotsCollection = db.collection("LotteryVN2").document(chnotModel.date.toString())

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

    fun saveLotteryTn1ToFirestore(chnotModel: LotteryTN1Model, oncallBack : OnUploadCallBack) {
        val db = FirebaseFirestore.getInstance()
        // Get a reference to the "Chnots" collection
        val chnotsCollection = db.collection("LotteryTN1").document(chnotModel.date.toString())

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
    fun saveLotteryTn2ToFirestore(chnotModel: LotteryTN1Model, oncallBack : OnUploadCallBack) {
        val db = FirebaseFirestore.getInstance()
        // Get a reference to the "Chnots" collection
        val chnotsCollection = db.collection("LotteryTN2").document(chnotModel.date.toString())

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
    fun saveLotteryTn3ToFirestore(chnotModel: LotteryTN1Model, oncallBack : OnUploadCallBack) {
        val db = FirebaseFirestore.getInstance()
        // Get a reference to the "Chnots" collection
        val chnotsCollection = db.collection("LotteryTN3").document(chnotModel.date.toString())

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
    fun saveLotteryTn4ToFirestore(chnotModel: LotteryTN4Model, oncallBack : OnUploadCallBack) {
        val db = FirebaseFirestore.getInstance()
        // Get a reference to the "Chnots" collection
        val chnotsCollection = db.collection("LotteryTN4").document(chnotModel.date.toString())

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

    interface OnGetVN1CallBack {
        fun onSuccess(data : LotteryVN1Model)
        fun onFailed()
    }
    interface OnGetVN2CallBack {
        fun onSuccess(data : LotteryVN2Model)
        fun onFailed()
    }
    interface OnGetTN1CallBack {
        fun onSuccess(data : LotteryTN1Model)
        fun onFailed()
    }
    interface OnGetTN4CallBack {
        fun onSuccess(data : LotteryTN4Model)
        fun onFailed()
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
