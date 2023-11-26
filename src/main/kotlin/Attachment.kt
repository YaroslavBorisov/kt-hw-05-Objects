package ru.netology

interface Attachment {
    val type: String
}

class PhotoAttachment(
    val photo: Photo,
    override val type: String
) : Attachment

class Photo(
    val id: Int,
    val albumId: Int,
    val ownerId: Int,
    val userId: Int,
    val text: String,
    val date: Int,
    val sizes: Array<Size>,
    val width: Int,
    val height: Int
)

data class Size(val type: String, val url: String, val width: Int, val height: Int)

class AudioAttachment(val audio: Audio, override val type: String) : Attachment

class Audio(
    val id: Int,
    val ownerId: Int,
    val artist: String,
    val title: String,
    val duration: Int,
    val url: String,
    val lyricsId: Int,
    val albumId: Int,
    val genreId: Int,
    val date: Int,
    val noSearch: Boolean,
    val isHq: Boolean
)

class StickerAttachment(val sticker: Sticker, override val type: String) : Attachment

class Sticker(
    val productId: Int,
    val stickerId: Int,
    val images: Array<Image>,
    val imagesWithBackground: Array<Image>
)


class Image(
    val url: String,
    val width: Int, val height: Int
)

class DocumentAttachment(val document: Document, override val type: String) : Attachment

class Document(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val size: Int,
    val ext: String,
    val url: String,
    val date: Int,
    val type: Int,
    val preview: Preview
)

class Preview(val photo: PhotoPreview?, val graffiti: Graffiti?, val audioMessage: AudioMessage?)

class AudioMessage(val duration: Int, val waveform: Array<Int>, val linkOgg: String, val linkMp3: String)
class Graffiti(val src: String, val width: Int, val height: Int)


class PhotoPreview(val sizes: Array<Size>)

class NoteAttachment(val note: Note, override val type: String) : Attachment

class Note(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val text: String,
    val date: Int,
    val comments: Int,
    val readComments: Int,
    val viewUrl: String
)