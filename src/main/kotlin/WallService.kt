package ru.netology

object WallService {
    private var posts = emptyArray<Post>()
    private var counter = 0

    fun add(post: Post): Post {
        posts += post.copy(id = ++counter)
        return posts.last()
    }


    fun update(post: Post): Boolean {
        for((index, value) in posts.withIndex()) {
            if (value.id == post.id) {
                posts[index] = post.copy()
                return true
            }
        }
        return false
    }

    fun clear(){
        posts = emptyArray()
        counter = 0
    }
}