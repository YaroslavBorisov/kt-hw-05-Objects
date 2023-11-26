package ru.netology

data class Post(
    val id: Int = 0,
    val ownerId: Int = 0,
    val fromId: Int = 0,
    val createdBy: Int = 0,
    val date: Int = 0,
    val text: String = "",
    val replyOwnerId: Int = 0,
    val replyPostId: Int = 0,
    val friendsOnly: Boolean = false,
    val comments: Comments? = null,
    val copyright: String = "",
    val likes: Likes = Likes(),
    val reposts: Reposts? = null,
    val views: Views? = null,
    val postType: String = "",
    val postSource: PostSource? = null,
    val geo: Geo? = null,
    val signerId: Int = 0,
    val copyHistory: Array<Post>? = null,
    val canPin: Boolean = false,
    val canDelete: Boolean = false,
    val canEdit: Boolean = false,
    val isPinned: Boolean = false,
    val markedAsAds: Boolean = false,
    val isFavourite: Boolean = false,
    val postponedId: Int? = null,
    val attachments: Array<Attachment>? = null
)

data class Reposts(val count: Int = 0, val userReported: Boolean = false)

data class Comments(
    val count: Int = 0,
    val canPost: Boolean = false,
    val groupsCanPost: Boolean = false,
    val canClose: Boolean = false,
    val canOpen: Boolean = false
)

data class Views(
    val count: Int = 0
)

data class PostSource(val type: String, val platform: String, val data: String, val url: String)

data class Geo(val type: String, val coordinates: String, val place: Place?)

data class Place(
    val id: Int,
    val title: String,
    val latitude: Int,
    val longitude: Int,
    val created: Int,
    val icon: String,
    val checkins: Int,
    val updated: Int,
    val type: Int,
    val country: Int,
    val city: Int,
    val address: String
)