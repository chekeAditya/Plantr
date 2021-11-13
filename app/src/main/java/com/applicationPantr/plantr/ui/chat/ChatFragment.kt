package com.applicationPantr.plantr.ui.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.RadioGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.applicationPantr.plantr.R
import com.applicationPantr.plantr.adapters.ChatAdapter
import com.applicationPantr.plantr.databinding.BottomSheetChatFargmentBinding
import com.applicationPantr.plantr.databinding.FragmentChatBinding
import com.applicationPantr.plantr.extras.ChatFilterList
import com.applicationPantr.plantr.remote.interfaces.OnChatClicked
import com.applicationPantr.plantr.remote.response.responseModel.Blog
import com.applicationPantr.plantr.remote.response.responseModel.Expert
import com.applicationPantr.plantr.viewmodels.ChatViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.bottom_sheet_chat_fargment.*
import kotlinx.android.synthetic.main.bottom_sheet_chat_fargment.view.*
import kotlinx.android.synthetic.main.bottom_sheet_chat_fargment.view.rb_ActiveNow
import kotlinx.android.synthetic.main.bottom_sheet_chat_fargment.view.rb_BestMatches
import kotlinx.android.synthetic.main.bottom_sheet_chat_fargment.view.rb_HighToLow
import kotlinx.android.synthetic.main.bottom_sheet_chat_fargment.view.rb_LowToHigh
import kotlinx.android.synthetic.main.bottom_sheet_chat_fargment.view.rb_TopExpert
import kotlinx.android.synthetic.main.bottom_sheet_chat_fargment.view.tvLowToHigh

@AndroidEntryPoint
class ChatFragment : Fragment(), OnChatClicked {

    lateinit var  action: NavDirections
    private lateinit var bottomSheetBinding: BottomSheetChatFargmentBinding
    lateinit var chatAdapter: ChatAdapter
    var expertList = mutableListOf<Expert>()
    lateinit var charFragmentChatBinding: FragmentChatBinding
    private val chatViewModel: ChatViewModel by viewModels()
    private val bottomDialog = ChatBottomSheetFragment(this)

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


        if (ChatFilterList.filter){
            expertList.clear()
            expertList.addAll(ChatFilterList.filterList)
            chatAdapter.notifyDataSetChanged()
        }
        else {
            chatViewModel.getDataFromApi().observe(viewLifecycleOwner, Observer {
                expertList.clear()
                expertList.addAll(it)
                chatAdapter.notifyDataSetChanged()
                ChatFilterList.originalList.clear()
                ChatFilterList.originalList.addAll(it)
            })
        }

        charFragmentChatBinding.ivFilter.setOnClickListener {
            val navController = Navigation.findNavController(requireView())
            navController.navigate(R.id.filterFragment)
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
        bottomDialog.show(childFragmentManager,"ChatBottomDialog")
    }

    override fun onClicked(expert: Expert) {
        action = ChatFragmentDirections.actionChatFragmentToChatDetailsFragment(expert)
        Navigation.findNavController(requireView()).navigate(action)
    }

    override fun onBlogClicked(blog: Blog) {
    }

    override fun onClickApply(list: List<Expert>) {
        bottomDialog.dismiss()
        if (list.isNotEmpty()) {
            expertList.clear()
            expertList.addAll(list)
            chatAdapter.notifyDataSetChanged()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        ChatFilterList.filter = false
    }

}