package com.applicationPantr.plantr.ui.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.applicationPantr.plantr.R
import com.applicationPantr.plantr.adapters.ChatAdapter
import com.applicationPantr.plantr.databinding.BottomSheetChatFargmentBinding
import com.applicationPantr.plantr.databinding.FragmentChatBinding
import com.applicationPantr.plantr.remote.interfaces.OnChatClicked
import com.applicationPantr.plantr.remote.response.responseModel.Blog
import com.applicationPantr.plantr.remote.response.responseModel.Expert
import com.applicationPantr.plantr.viewmodels.ChatViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChatFragment : Fragment(R.layout.fragment_chat), OnChatClicked {

    private lateinit var bottomSheetBinding: BottomSheetChatFargmentBinding
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
            Navigation.findNavController(requireView())
                .navigate(R.id.action_chatFragment_to_filterFragment)
        }
        charFragmentChatBinding.ivSort.setOnClickListener {
            openSortBottomSheet()
        }

    }


    private fun setUpRecyclerView() {
        chatAdapter = ChatAdapter(expertList, this)
        charFragmentChatBinding.apply {
            chatRecyclerView.layoutManager = GridLayoutManager(context, 2)
            chatRecyclerView.adapter = chatAdapter
        }
    }


    private fun openSortBottomSheet() {
        bottomSheetBinding = BottomSheetChatFargmentBinding.inflate(layoutInflater)
        val bottomDialog = BottomSheetDialog(
            requireContext(), R.style.BottomSheetDialogTheme
        )
        val bottomSheetView = LayoutInflater.from(requireContext()).inflate(
            R.layout.bottom_sheet_chat_fargment, bottomSheetBinding.cvBottomSheet
        )
        bottomDialog.setContentView(bottomSheetView)
        bottomDialog.show()
    }

    override fun onClicked(expert: Expert) {
        val action = ChatFragmentDirections.actionChatFragmentToChatDetailsFragment(expert)

        Navigation.findNavController(requireView()).navigate(action)
    }

    override fun onBlogClicked(blog: Blog) {

    }

}