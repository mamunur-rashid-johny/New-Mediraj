package com.qubelex.mediraj.utils.data_source

object DemoDataSource {

    val dataImageSlider = listOf(
        ImageSliderData(1, "https://www.brid.tv/wp-content/uploads/2019/10/Cover_Instream_vs_Outstream_Ads_1.3.jpg"),
        ImageSliderData(2,"https://www.brid.tv/wp-content/uploads/2019/10/Cover_Instream_vs_Outstream_Ads_1.3.jpg"),
        ImageSliderData(3,"https://image.shutterstock.com/image-vector/black-friday-logo-concept-discount-260nw-1839711967.jpg")

    )


}

data class ImageSliderData(
    val id:Int,
    val url:String
)
