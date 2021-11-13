package com.applicationPantr.plantr.ui.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.applicationPantr.plantr.R
import com.applicationPantr.plantr.extras.ChatFilterList
import com.applicationPantr.plantr.remote.interfaces.OnChatClicked
import com.applicationPantr.plantr.remote.response.responseModel.Expert
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_sheet_chat_fargment.*

class ChatBottomSheetFragment(private val onChatClicked: OnChatClicked)
    : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.bottom_sheet_chat_fargment, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        filterChatList()

        resetAllFilter()

        tvReset.setOnClickListener {
            resetAllFilter()
        }

        tvApply.setOnClickListener {
            if (rb_LowToHigh.isChecked || rb_HighToLow.isChecked ||
                rb_ActiveNow.isChecked || rb_TopExpert.isChecked ||
                rb_BestMatches.isChecked
            ) {
                val sortedList = mutableListOf<Expert>()
                if(rb_LowToHigh.isChecked){
                    sortListAsc(sortedList)
                }
                else if(rb_HighToLow.isChecked){
                    sortListDesc(sortedList)
                }
                onChatClicked.onClickApply(sortedList)
            }
        }

    }

    private fun resetAllFilter(){
        rb_LowToHigh.isChecked = false
        rb_HighToLow.isChecked = false
        rb_ActiveNow.isChecked = false
        rb_BestMatches.isChecked = false
        rb_TopExpert.isChecked = false
    }

    private fun sortListDesc(sortedList: MutableList<Expert>) {
        for (i in 0 until ChatFilterList.originalList.size){
            var price = ChatFilterList.originalList[i].avgCharges.substring(5,7).toInt()
            var expert = ChatFilterList.originalList[i]
            for (j in i until ChatFilterList.originalList.size){
                var expertPrice = ChatFilterList.originalList[j].avgCharges.substring(5,7).toInt()
                if (expertPrice > price){
                    price = expertPrice
                    expert = ChatFilterList.originalList[j]
                }
            }
            sortedList.add(expert)
        }
    }

    private fun sortListAsc(sortedList: MutableList<Expert>) {
        for (i in 0 until ChatFilterList.originalList.size){
            var price = ChatFilterList.originalList[i].avgCharges.substring(5,7).toInt()
            var expert = ChatFilterList.originalList[i]
            for (j in i until ChatFilterList.originalList.size){
                var expertPrice = ChatFilterList.originalList[j].avgCharges.substring(5,7).toInt()
                if (expertPrice < price){
                    price = expertPrice
                    expert = ChatFilterList.originalList[j]
                }
            }
            sortedList.add(expert)
        }
    }

    private fun filterChatList() {
        rb_LowToHigh.setOnClickListener {
            if (rb_LowToHigh.isChecked) {
                rb_HighToLow.isChecked = false
            }
            setApplySortBtn()
        }
        rb_HighToLow.setOnClickListener {
            if (rb_HighToLow.isChecked) {
                rb_LowToHigh.isChecked = false
            }
            setApplySortBtn()
        }
        rb_ActiveNow.setOnClickListener {
            setApplySortBtn()
        }
        rb_TopExpert.setOnClickListener {
            setApplySortBtn()
        }
        rb_BestMatches.setOnClickListener {
            setApplySortBtn()
        }
    }

    private fun setApplySortBtn() {
        if (rb_LowToHigh.isChecked || rb_HighToLow.isChecked ||
            rb_ActiveNow.isChecked || rb_TopExpert.isChecked ||
            rb_BestMatches.isChecked
        ) {
            tvApply.setBackgroundColor(
                ContextCompat
                    .getColor(requireContext(), R.color.main_dark_green)
            )
            tvReset.setTextColor(
                ContextCompat
                    .getColor(requireContext(), R.color.main_orange)
            )
        } else {
            tvApply.setBackgroundColor(
                ContextCompat
                    .getColor(requireContext(), R.color.main_light_green)
            )
            tvReset.setTextColor(
                ContextCompat
                    .getColor(requireContext(), R.color.main_orange_bg)
            )
        }
    }

}