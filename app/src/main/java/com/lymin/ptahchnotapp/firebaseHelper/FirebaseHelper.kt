package com.lymin.ptahchnotapp.firebaseHelper
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.lymin.ptahchnotapp.model.ChnotModel
import com.lymin.ptahchnotapp.model.LotteryTN1Model
import com.lymin.ptahchnotapp.model.LotteryTN4Model
import com.lymin.ptahchnotapp.model.LotteryVN1Model
import com.lymin.ptahchnotapp.model.LotteryVN2Model
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class FirebaseHelper {
    companion object {
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
    interface OnGetDataallBack {
        fun onSuccess(list : MutableList<ChnotModel>)
        fun onFailed()
    }
}
