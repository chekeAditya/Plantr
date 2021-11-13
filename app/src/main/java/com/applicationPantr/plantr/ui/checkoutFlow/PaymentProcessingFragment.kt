package com.applicationPantr.plantr.ui.checkoutFlow

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.applicationPantr.plantr.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PaymentProcessingFragment : Fragment(R.layout.fragment_payment_processing) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        CoroutineScope(Dispatchers.Main).launch {
            delay(8000)
            Navigation.findNavController(requireView())
                .navigate(R.id.action_paymentProcessingFragment_to_homeFragment)
        }

    }

}