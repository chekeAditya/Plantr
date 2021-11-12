package com.applicationPantr.plantr.ui.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.applicationPantr.plantr.R
import com.applicationPantr.plantr.databinding.FragmentGetPlan2Binding

class GetPlanFragment2 : Fragment() {

    lateinit var getPlanFragmentGetPlan2Binding: FragmentGetPlan2Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        getPlanFragmentGetPlan2Binding =
            DataBindingUtil.inflate(inflater,R.layout.fragment_get_plan_2,container,false)
        return getPlanFragmentGetPlan2Binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        getPlanFragmentGetPlan2Binding.apply {
            downArrowWeeklyPlan.setOnClickListener {
                rlWeeklyPlan.visibility = View.VISIBLE
                downArrowWeeklyPlan.setImageResource(R.drawable.ic_upside_arrow)
                rlMonthlyPlan.visibility = View.GONE
                downArrowMonthlyPlan.setImageResource(R.drawable.ic_downside_arrow)
                rlYearlyPlan.visibility = View.GONE
                downArrowMonthlyPlan.setImageResource(R.drawable.ic_downside_arrow)
            }

            downArrowMonthlyPlan.setOnClickListener {
                rlMonthlyPlan.visibility = View.VISIBLE
                downArrowMonthlyPlan.setImageResource(R.drawable.ic_upside_arrow)
                rlWeeklyPlan.visibility = View.GONE
                downArrowWeeklyPlan.setImageResource(R.drawable.ic_downside_arrow)
                rlYearlyPlan.visibility = View.GONE
                downArrowMonthlyPlan.setImageResource(R.drawable.ic_downside_arrow)
            }

            downArrowYearlyPlan.setOnClickListener {
                rlYearlyPlan.visibility = View.VISIBLE
                downArrowMonthlyPlan.setImageResource(R.drawable.ic_upside_arrow)
                rlWeeklyPlan.visibility = View.GONE
                downArrowWeeklyPlan.setImageResource(R.drawable.ic_downside_arrow)
                rlMonthlyPlan.visibility = View.GONE
                downArrowMonthlyPlan.setImageResource(R.drawable.ic_downside_arrow)
            }

            btnCancel.setOnClickListener {
                rlYearlyPlan.visibility = View.GONE
                downArrowMonthlyPlan.setImageResource(R.drawable.ic_downside_arrow)
                rlWeeklyPlan.visibility = View.GONE
                downArrowWeeklyPlan.setImageResource(R.drawable.ic_downside_arrow)
                rlMonthlyPlan.visibility = View.GONE
                downArrowMonthlyPlan.setImageResource(R.drawable.ic_downside_arrow)
            }
        }
    }



}