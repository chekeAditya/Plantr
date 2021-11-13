package com.applicationPantr.plantr.remote.interfaces

import com.applicationPantr.plantr.remote.response.responseModel.Blog
import com.applicationPantr.plantr.remote.response.responseModel.Expert

interface OnChatClicked {
    fun onClicked(expert: Expert)
    fun onBlogClicked(blog: Blog)
    fun onClickApply(list: List<Expert>)
}
