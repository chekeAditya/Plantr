package com.applicationPantr.plantr.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.applicationPantr.plantr.R
import kotlinx.android.synthetic.main.fragment_payment.*


class paymentFragment : Fragment(R.layout.fragment_payment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_payNext.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_paymentFragment_to_paymentProcessingFragment)
        }
    }

}