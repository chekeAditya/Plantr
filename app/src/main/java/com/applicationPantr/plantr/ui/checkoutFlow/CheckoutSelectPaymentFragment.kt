package com.applicationPantr.plantr.ui.checkoutFlow

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.applicationPantr.plantr.R
import kotlinx.android.synthetic.main.fragment_checkout_select_payment.*

class CheckoutSelectPaymentFragment
    : Fragment(R.layout.fragment_checkout_select_payment)
    , PayMethodClickListener{

    private var paymentMethodList = mutableListOf<ItemPayMethod>()
    private var selectedPayMethodPos = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializePayMethodList()

        setPayMethodAdapter()

        cvNextBtnCheckout.setOnClickListener {
            rvPayMethodCheckout.visibility = View.GONE
            tvPayMethodTextCheckout.text = paymentMethodList[selectedPayMethodPos]
                .payMethodNameCheckout
            cvPayMethodVerifyCheckout.visibility = View.VISIBLE
        }

        cvPayMethodVerifyCheckout.setOnClickListener {

        }

        verify_button.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_checkoutSelectPaymentFragment_to_paymentFragment)
        }


    }

    private fun setPayMethodAdapter() {
        rvPayMethodCheckout.apply {
            adapter = AdapterCheckout(selectedPayMethodPos
                ,paymentMethodList
                ,this@CheckoutSelectPaymentFragment)
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun initializePayMethodList() {
        paymentMethodList.apply {
            add(ItemPayMethod(R.drawable.ic_card_checkout
                ,"Credit/Debit card"))
            add(ItemPayMethod(R.drawable.ic_netbanking_checkout_svg
                ,"Net Banking"))
            add(ItemPayMethod(R.drawable.ic_gpay_checkout_svg
                ,"Google Pay"))
            add(ItemPayMethod(R.drawable.ic_paypal_checkout_svg
                ,"PayPal"))
            add(ItemPayMethod(R.drawable.ic_otherupi_checkout_svg
                ,"Other UPI Id's"))
        }
    }

    override fun onClickPayMethod(position: Int) {
        selectedPayMethodPos = position
        setPayMethodAdapter()
    }

}