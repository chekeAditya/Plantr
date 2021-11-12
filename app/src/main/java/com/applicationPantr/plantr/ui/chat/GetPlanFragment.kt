package com.applicationPantr.plantr.ui.chat

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.applicationPantr.plantr.R
import com.applicationPantr.plantr.databinding.FragmentGetPlanBinding
import com.applicationPantr.plantr.ui.chat._chat.UserActivity
import com.applicationPantr.plantr.ui.home.HomeActivity

class GetPlanFragment : Fragment() {

    lateinit var fragmentGetPlanBinding: FragmentGetPlanBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentGetPlanBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_get_plan, container, false)
        return fragmentGetPlanBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentGetPlanBinding.cvWeeklyPlan.setOnClickListener {
            Navigation.findNavController(requireView())
                .navigate(R.id.action_getPlanFragment_to_getPlanFragment2)
        }

        fragmentGetPlanBinding.cvMonthlyPlan.setOnClickListener {
            Navigation.findNavController(requireView())
                .navigate(R.id.action_getPlanFragment_to_getPlanFragment2)
        }

        fragmentGetPlanBinding.cvYearlyPlan.setOnClickListener {
            Navigation.findNavController(requireView())
                .navigate(R.id.action_getPlanFragment_to_getPlanFragment2)
        }

        fragmentGetPlanBinding.tvEnjoyFreeSession.setOnClickListener {
            val intent = Intent(context, UserActivity::class.java)
            startActivity(intent)
        }
    }

}