package com.lymin.ptahchnotmanager.activities.fragment.vnOld

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.lymin.ptahchnotmanager.AddDataActivity
import com.lymin.ptahchnotmanager.R
import com.lymin.ptahchnotmanager.databinding.FragmentLotteryVnOldBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
/**
 * A simple [Fragment] subclass.
 * Use the [LotteryVnOldFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LotteryVnOldFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentLotteryVnOldBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_lottery_vn_old,
            container,
            false
        )

        // Create an instance of your ViewModel and bind it to the layout
//        val viewModel = YourViewModel() // Replace with your ViewModel
//        binding.viewModel = viewModel
//
//        // Optional: Specify the lifecycle owner to observe LiveData
//        binding.lifecycleOwner = this

        binding.btnEdit1.setOnClickListener {
            startActivity(Intent(context, LotteryVN1Activity::class.java))
        }
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LotteryVnOldFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LotteryVnOldFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}