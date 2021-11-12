package com.applicationPantr.plantr.ui.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.applicationPantr.plantr.R
import com.applicationPantr.plantr.adapters.ClientAdapter
import com.applicationPantr.plantr.adapters.GalleryAdapter
import com.applicationPantr.plantr.adapters.MoreExpertAdapter
import com.applicationPantr.plantr.databinding.FragmentChatDetailsBinding
import com.applicationPantr.plantr.databinding.ItemClientReviewsBinding
import com.applicationPantr.plantr.databinding.ItemGalleryBinding
import com.applicationPantr.plantr.databinding.ItemMoreExpertBinding
import com.applicationPantr.plantr.remote.response.responseModel.Client
import com.applicationPantr.plantr.remote.response.responseModel.Expert
import com.applicationPantr.plantr.viewmodels.ChatViewModel
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_chat_details.*

@AndroidEntryPoint
class ChatDetailsFragment : Fragment(R.layout.fragment_chat_details) {
    //client
    lateinit var clientBinding: ItemClientReviewsBinding
    lateinit var clientAdapter: ClientAdapter

    //more_expert
    lateinit var moreExpertBinding: ItemMoreExpertBinding
    lateinit var moreExpertAdapter: MoreExpertAdapter

    //    gallery
    lateinit var galleryBinding: ItemGalleryBinding
    lateinit var galleryAdapter: GalleryAdapter

    //    list
    var expertList = mutableListOf<Expert>()
    var clientList = mutableListOf<Client>()

    //chat
    lateinit var chatDetailBinding: FragmentChatDetailsBinding
    val args: ChatDetailsFragmentArgs by navArgs()
    private val chatViewModel: ChatViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        chatDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_chat_details, container, false)
        return chatDetailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        settingUpData()
        settingUpGallery()
//        settingUpMoreExperts()
        settingUpClient()

        chatViewModel.getDataFromApi().observe(viewLifecycleOwner, Observer {
            expertList.clear()
            expertList.addAll(it)
            galleryAdapter.notifyDataSetChanged()
//            moreExpertAdapter.notifyDataSetChanged()
        })

    }

    private fun settingUpClient() {
        clientBinding = ItemClientReviewsBinding.inflate(layoutInflater)
        clientAdapter = ClientAdapter(clientList)
        clientBinding.apply {
            recyclerViewClientReviews.adapter = clientAdapter
            recyclerViewClientReviews.layoutManager = LinearLayoutManager(context)
        }
    }

    private fun settingUpMoreExperts() {
        moreExpertBinding = ItemMoreExpertBinding.inflate(layoutInflater)
        moreExpertAdapter = MoreExpertAdapter(expertList)
        moreExpertBinding.apply {
            recyclerviewGallery.layoutManager = LinearLayoutManager(context)
            recyclerviewGallery.adapter = moreExpertAdapter
        }
    }

    private fun settingUpGallery() {
        galleryBinding = ItemGalleryBinding.inflate(layoutInflater)
        galleryAdapter = GalleryAdapter(expertList)
        galleryBinding.apply {
            recyclerviewGallery.layoutManager = LinearLayoutManager(
                context, LinearLayoutManager.HORIZONTAL, false
            )
            recyclerviewGallery.adapter = galleryAdapter
        }
    }

    private fun settingUpData() {
        chatDetailBinding.tvExpertName.text = args.expert.name
        chatDetailBinding.tvHappyClients.text = args.expert.happyClients
        chatDetailBinding.tvMinsSpentChat.text = args.expert.minChat
        chatDetailBinding.tvMinsSpentCalls.text = args.expert.minCalls
        chatDetailBinding.tvAboutMeDescExpert.text = args.expert.about
        Glide.with(chatDetailBinding.ciExpertImage).load(args.expert.image)
            .into(chatDetailBinding.ciExpertImage)
        Glide.with(chatDetailBinding.ivBgImage).load(args.expert.bgPlantImage)
            .into(chatDetailBinding.ivBgImage)
        clientList = args.expert.clients as MutableList<Client>
    }
}