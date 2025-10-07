package com.example.checkletter.data
// repo section have done
// we have call list and calling next button it show the images list
class ImageRepositoryImpl (
    private val imagesData: List<Item> = ImageData.imagesData
) :ImageRepository {
    override fun getImageData()=imagesData;

    override fun getNextImage(currentImage:Item): Item {
        var getImages = getImageData()
        val currentIndex =getImages.indexOf(currentImage)

        if(currentIndex < getImages.size - 1){
            return getImages[currentIndex+1]
        }else{
            return getImages.first();
        }
    }
}