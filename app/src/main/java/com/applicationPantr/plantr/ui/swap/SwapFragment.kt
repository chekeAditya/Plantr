package com.applicationPantr.plantr.ui.swap

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.applicationPantr.plantr.R
import com.applicationPantr.plantr.databinding.FragmentSwapBinding
import com.applicationPantr.plantr.remote.response.responseModel.Expert
import com.applicationPantr.plantr.remote.response.responseModel.Plant
import com.applicationPantr.plantr.viewmodels.ChatViewModel
import com.applicationPantr.plantr.viewmodels.SwapViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SwapFragment : Fragment(R.layout.fragment_swap) {

    private lateinit var fragmentSwapBinding: FragmentSwapBinding

    private val viewModel:SwapViewModel by viewModels()

    private var listOfPlants = mutableListOf<Plant>()

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

        initializePlantList()

    }

    private fun initializePlantList() {
        viewModel.getPlantsDataFromApi().observe(viewLifecycleOwner, Observer {
            listOfPlants.clear()
            listOfPlants.addAll(it)
            listOfPlants.addAll(it)
            fragmentSwapBinding.swapRecyclerView.adapter?.notifyDataSetChanged()
        })
    }

    private fun setRecyclerView() {
        fragmentSwapBinding.swapRecyclerView.apply {
            adapter = SwapAdapter(listOfPlants)
            layoutManager = GridLayoutManager(context,2)
        }
    }

}