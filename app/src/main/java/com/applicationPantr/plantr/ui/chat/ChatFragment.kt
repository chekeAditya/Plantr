package com.applicationPantr.plantr.ui.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.applicationPantr.plantr.R
import com.applicationPantr.plantr.adapters.ChatAdapter
import com.applicationPantr.plantr.databinding.FragmentChatBinding
import com.applicationPantr.plantr.remote.interfaces.OnChatClicked
import com.applicationPantr.plantr.remote.response.responseModel.Blog
import com.applicationPantr.plantr.remote.response.responseModel.Expert
import com.applicationPantr.plantr.viewmodels.ChatViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ChatFragment : Fragment(), OnChatClicked {

    lateinit var action: NavDirections
    lateinit var chatAdapter: ChatAdapter
    var expertList = mutableListOf<Expert>()
    lateinit var charFragmentChatBinding: FragmentChatBinding
    private val chatViewModel: ChatViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        charFragmentChatBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_chat, container, false)
        return charFragmentChatBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()


        chatViewModel.getDataFromApi().observe(viewLifecycleOwner, Observer {
            expertList.clear()
            expertList.addAll(it)
            chatAdapter.notifyDataSetChanged()
        })

        charFragmentChatBinding.ivFilter.setOnClickListener {
            val navController = Navigation.findNavController(requireView())
            navController.navigate(R.id.filterFragment)
        }

    }


    private fun setUpRecyclerView() {
        chatAdapter = ChatAdapter(expertList, this)
        charFragmentChatBinding.apply {
            chatRecyclerView.layoutManager = GridLayoutManager(context, 2)
            chatRecyclerView.adapter = chatAdapter
        }
    }


    override fun onClicked(expert: Expert) {
        action = ChatFragmentDirections.actionChatFragmentToChatDetailsFragment(expert)
        Navigation.findNavController(requireView()).navigate(action)
    }

    override fun onBlogClicked(blog: Blog) {

    }

}
