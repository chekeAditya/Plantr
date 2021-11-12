package com.applicationPantr.plantr.ui.checkoutFlow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.applicationPantr.plantr.R
import kotlinx.android.synthetic.main.item_pay_method_checkout.view.*

class AdapterCheckout(private val selectedPayMethodPos: Int
    ,private val paymentMethodList: List<ItemPayMethod>
    ,private val payMethodClickListener: PayMethodClickListener) :
    RecyclerView.Adapter<AdapterCheckout.ViewHolderCheckout>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCheckout {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.item_pay_method_checkout, parent, false
            )
        return ViewHolderCheckout(view, selectedPayMethodPos,payMethodClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolderCheckout, position: Int) {
        holder.onDataBind(paymentMethodList[position])
    }

    override fun getItemCount(): Int {
        return paymentMethodList.size
    }

    class ViewHolderCheckout(
        itemView: View
        ,private val selectedPayMethodPos: Int
        ,private val payMethodClickListener: PayMethodClickListener
    ) : RecyclerView.ViewHolder(itemView) {

        fun onDataBind(itemPayMethod: ItemPayMethod) {
            itemView.apply {
                ivPayMethodLogoCheckout.setImageResource(itemPayMethod.payMethodLogoCheckout)
                tvPayMethodNameCheckout.text = itemPayMethod.payMethodNameCheckout

                if (adapterPosition == selectedPayMethodPos){
                    ivPayMethodLogoCheckout.setColorFilter(ContextCompat.getColor(context
                        ,R.color.main_dark_green))
                    tvPayMethodNameCheckout.setTextColor(ContextCompat.getColor(context
                        ,R.color.main_dark_green))
                }

                cvItemPayMethodCheckout.setOnClickListener {
                    payMethodClickListener.onClickPayMethod(adapterPosition)
                }
            }
        }
    }

}