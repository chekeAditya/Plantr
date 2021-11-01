package com.applicationPantr.plantr.ui.login.swapper

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.applicationPantr.plantr.R
import com.applicationPantr.plantr.databinding.FragmentSwapBinding

class SwapFragment : Fragment(R.layout.fragment_swap) {

    private lateinit var fragmentSwapBinding: FragmentSwapBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentSwapBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_swap,container,false)
        return fragmentSwapBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView()

    }

    private fun setRecyclerView() {
        fragmentSwapBinding.swapRecyclerView.apply {
            adapter = SwapAdapter()
            layoutManager = GridLayoutManager(context,2)
        }
    }

}