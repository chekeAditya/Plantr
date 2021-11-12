package com.applicationPantr.plantr.ui.chat

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.applicationPantr.plantr.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_filter.*

@AndroidEntryPoint
class FilterFragment : Fragment(R.layout.fragment_filter) {

//    val args1: FilterFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvPriceRange.text = args1.expertData.name
    }

}