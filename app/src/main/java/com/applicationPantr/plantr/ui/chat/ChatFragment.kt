package com.applicationPantr.plantr.ui.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.applicationPantr.plantr.R
import com.applicationPantr.plantr.adapters.ChatAdapter
import com.applicationPantr.plantr.databinding.BottomSheetChatFargmentBinding
import com.applicationPantr.plantr.databinding.FragmentChatBinding
import com.applicationPantr.plantr.interfaces.OnChatClicked
import com.applicationPantr.plantr.remote.response.ChatResponse
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.fragment_chat.*

class ChatFragment : Fragment(R.layout.fragment_chat), OnChatClicked, View.OnClickListener {

    private lateinit var bottomSheetBinding: BottomSheetChatFargmentBinding
    lateinit var chatAdapter: ChatAdapter
    var chatList = mutableListOf<ChatResponse>()
    lateinit var chtAdapter: ChatAdapter
    lateinit var charFragmentChatBinding: FragmentChatBinding

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
        buildData()
        setUpRecyclerView()
        iv_filter.setOnClickListener(this)
        iv_sort.setOnClickListener(this)
    }


    private fun setUpRecyclerView() {
        chatAdapter = ChatAdapter(chatList, this)
        charFragmentChatBinding.apply {
            chatRecyclerView.layoutManager = GridLayoutManager(context, 2)
            chatRecyclerView.adapter = chatAdapter
        }
    }

    private fun buildData() {
        for (i in 1..100) {
            chatList.add(
                ChatResponse(
                    "https://miro.medium.com/max/1200/1*mk1-6aYaf_Bes1E3Imhc0A.jpeg",
                    "Kirti Mishra",
                    "Avg:120rs/main"
                )
            )
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.iv_filter -> {
                Toast.makeText(context, "filter clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.iv_sort -> {
                openSortBottomSheet()
            }
        }
    }

    private fun openSortBottomSheet() {
        bottomSheetBinding = BottomSheetChatFargmentBinding.inflate(layoutInflater)
        val bottomDialog = BottomSheetDialog(
            requireContext(), R.style.BottomSheetDialogTheme
        )
        val bottomSheetView = LayoutInflater.from(requireContext()).inflate(
            R.layout.bottom_sheet_chat_fargment,bottomSheetBinding.cvBottomSheet
        )
        bottomDialog.setContentView(bottomSheetView)
        bottomDialog.show()
    }

    override fun onClicked(chatResponse: ChatResponse) {
        Toast.makeText(context, "chat button clicked", Toast.LENGTH_SHORT).show()
    }

}