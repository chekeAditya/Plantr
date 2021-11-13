package com.applicationPantr.plantr.ui.chat

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.applicationPantr.plantr.R
import com.applicationPantr.plantr.extras.ChatFilterList
import com.applicationPantr.plantr.remote.response.responseModel.Expert
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_filter.*

@AndroidEntryPoint
class FilterFragment : Fragment(R.layout.fragment_filter) {

    private var filterList = mutableListOf<Expert>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvApply.setOnClickListener {
            filterChatList()
        }

        cvRating1.setOnClickListener {
            changeAllRating()
            cvRating1.setBackgroundColor(ContextCompat.getColor(requireContext()
                                                                ,R.color.secondary_3))
        }
        cvRating2.setOnClickListener {
            changeAllRating()
            cvRating2.setBackgroundColor(ContextCompat.getColor(requireContext()
                ,R.color.secondary_3))
        }
        cvRating3.setOnClickListener {
            changeAllRating()
            cvRating3.setBackgroundColor(ContextCompat.getColor(requireContext()
                ,R.color.secondary_3))
        }
        cvRating4.setOnClickListener {
            changeAllRating()
            cvRating4.setBackgroundColor(ContextCompat.getColor(requireContext()
                ,R.color.secondary_3))
        }
        cvRating5.setOnClickListener {
            changeAllRating()
            cvRating5.setBackgroundColor(ContextCompat.getColor(requireContext()
                ,R.color.secondary_3))
        }

    }

    private fun changeAllRating() {
        cvRating1.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.white))
        cvRating2.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.white))
        cvRating3.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.white))
        cvRating4.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.white))
        cvRating5.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.white))
    }

    private fun filterChatList() {
        val minValue = double_range_seekbar.currentMinValue
        val maxValue = double_range_seekbar.currentMaxValue
        for (i in ChatFilterList.originalList){
            val avgChg = i.avgCharges.substring(5,7).toInt()
            if (avgChg in minValue..maxValue){
                filterList.add(i)
            }
        }
        ChatFilterList.filter = true
        ChatFilterList.filterList.clear()
        ChatFilterList.filterList.addAll(filterList)
        val navController = Navigation.findNavController(requireView())
        navController.navigate(R.id.chatFragment)
    }

}