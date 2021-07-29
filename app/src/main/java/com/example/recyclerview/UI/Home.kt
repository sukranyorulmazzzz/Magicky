package com.example.recyclerview.UI
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.example.recyclerview.Adapter.MainRecyclerAdapter
import com.example.recyclerview.Model.AllCategory
import com.example.recyclerview.Model.CategoryItem
import com.example.recyclerview.R
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.io.File
import java.util.ArrayList

class Home : AppCompatActivity() {
    var mainCategoryRecycler: RecyclerView? = null
    var mainRecyclerAdapter: MainRecyclerAdapter? = null
    val imageList=ArrayList<SlideModel>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        imageList.add(SlideModel("https://i1.wp.com/dadanizm.wpcomstaging.com/wp-content/uploads/2020/07/beyonce_black-is-king.jpg?fit=1024%2C512&ssl=1","Beyoncé’den Afrika kültürüne selam çakan coşkulu bir görsel albüm: Black is King"))
        imageList.add(SlideModel("https://i2.wp.com/dadanizm.wpcomstaging.com/wp-content/uploads/2021/07/halsey.png?fit=1024%2C541&ssl=1","If I Can’t Have Love, I Want Power: Yeni albüm öncesi Halsey’e dadanıyoruz"))
        imageList.add(SlideModel("https://i2.wp.com/dadanizm.wpcomstaging.com/wp-content/uploads/2021/06/amy-winehouse-bbc-belgesel.jpeg?fit=1024%2C803&ssl=1","Bir hayattan kaç hikaye çıkar: Amy Winehouse ölümünün 10. yılında yeni bir kitap ve belgeselle anılıyor"))
        imageList.add(SlideModel("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/adele-episode-1789-pictured-host-adele-during-the-monologue-news-photo-1623850606.jpg","Adele Saturday Night Live ile dönüşe hazırlanıyor"))
        imageList.add(SlideModel("https://i0.wp.com/dadanizm.wpcomstaging.com/wp-content/uploads/2020/08/the-weeknd-1.jpg?fit=1024%2C686&ssl=1","Önce TikTok, sonra Spotify: The Weeknd ve dijital maceraları"))
        imageList.add(SlideModel("https://i0.wp.com/dadanizm.wpcomstaging.com/wp-content/uploads/2020/02/bob-marley_75.jpeg?fit=1024%2C614&ssl=1","Açın müziğin sesini: Bob Marley 75 yaşında"))

        val imageSlider=findViewById<ImageSlider>(R.id.image_slider)
        imageSlider.setImageList(imageList)

        val categoryItemList: MutableList<CategoryItem> = ArrayList()
        categoryItemList.add(CategoryItem(1, R.drawable.bir, "NKVT","Türkiye'nin en sıkı çalma listesi.", ""))
        categoryItemList.add(CategoryItem(2, R.drawable.iki_1, "Yaz Hitleri","2021 yazına damga vuracak şarkılar.",""))
        categoryItemList.add(CategoryItem(3, R.drawable.uc_1, "Hot Hits Turkiye", "Dinlemekten vazgeçemediklerin ve en yeni hitler.",""))
        categoryItemList.add(CategoryItem(4, R.drawable.dort_1, "Yaz Ritmi", "Yerli Afro,Latin ve trap ritimleri ile yazın en hareketli hali.",""))
        categoryItemList.add(CategoryItem(5, R.drawable.bes, "Kirik Kalpler Duragi", "Kalbi kırılanlara özel çalma listesi.",""))
        categoryItemList.add(CategoryItem(6, R.drawable.alti, "+Pop", "","Kalıplara sığmayan yerli alt-pop."))
        categoryItemList.add(CategoryItem(7, R.drawable.yedi, "Dunyanin Hiti", "Şu anda en çok çalınan şarkılar.",""))
        categoryItemList.add(CategoryItem(8, R.drawable.sekiz, "Odev Yaparken Sarar", "Ders çalışırken dinlemek isteyeceklerinin en sakin hali.",""))

        val categoryItemList2: MutableList<CategoryItem> = ArrayList()
        categoryItemList2.add(CategoryItem(9, R.drawable.ikibir, "Adele", "✓ Doğrulanmış Sanatçı",""))
        categoryItemList2.add(CategoryItem(10, R.drawable.ikiki, "Rihanna", "✓ Doğrulanmış Sanatçı",""))
        categoryItemList2.add(CategoryItem(11, R.drawable.ikiuc, "Katy Perry", "✓ Doğrulanmış Sanatçı",""))
        categoryItemList2.add(CategoryItem(12, R.drawable.ikidort, "Lady Gaga", "✓ Doğrulanmış Sanatçı",""))
        categoryItemList2.add(CategoryItem(13, R.drawable.ikibes, "Michael Jackson", "✓ Doğrulanmış Sanatçı",""))
        categoryItemList2.add(CategoryItem(14, R.drawable.ikialti, "Taylor Swift", "✓ Doğrulanmış Sanatçı",""))
        categoryItemList2.add(CategoryItem(15, R.drawable.ikiyedi, "Linkin Park", "✓ Doğrulanmış Sanatçı",""))
        categoryItemList2.add(CategoryItem(16, R.drawable.ikisekiz, "Britney Spears", "✓ Doğrulanmış Sanatçı",""))

        val categoryItemList3: MutableList<CategoryItem> = ArrayList()
        categoryItemList3.add(CategoryItem(17, R.drawable.ucbir, "2012 Hitleri", "2012'deki büyük şarkıları keşfedin ve yeniden dinleyin.",""))
        categoryItemList3.add(CategoryItem(18, R.drawable.uciki, "2015 Hitleri", "2015'deki büyük şarkıları keşfedin ve yeniden dinleyin.",""))
        categoryItemList3.add(CategoryItem(19, R.drawable.ucuc, "2010 Hitleri", "2010'deki büyük şarkıları keşfedin ve yeniden dinleyin.",""))
        categoryItemList3.add(CategoryItem(20, R.drawable.ucdort, "2009 Hitleri", "2009'daki büyük şarkıları keşfedin ve yeniden dinleyin.",""))
        categoryItemList3.add(CategoryItem(21, R.drawable.ucbes, "2011 Hitleri", "2011'deki büyük şarkıları keşfedin ve yeniden dinleyin.",""))
        categoryItemList3.add(CategoryItem(22, R.drawable.ucalti, "2017 Hitleri", "2017'deki büyük şarkıları keşfedin ve yeniden dinleyin.",""))
        categoryItemList3.add(CategoryItem(23, R.drawable.ucyedi, "2014 Hitleri", "2014'deki büyük şarkıları keşfedin ve yeniden dinleyin.",""))
        categoryItemList3.add(CategoryItem(24, R.drawable.ucsekiz, "2008 Hitleri", "2008'deki büyük şarkıları keşfedin ve yeniden dinleyin.",""))


        val categoryItemList4: MutableList<CategoryItem> = ArrayList()
        categoryItemList4.add(CategoryItem(25, R.drawable.dortbir, "Beyoncé", "✓ Doğrulanmış Sanatçı",""))
        categoryItemList4.add(CategoryItem(26, R.drawable.dortiki, "Lana Del Rey", "✓ Doğrulanmış Sanatçı",""))
        categoryItemList4.add(CategoryItem(27, R.drawable.dortuc, "Sam Smith", "✓ Doğrulanmış Sanatçı",""))
        categoryItemList4.add(CategoryItem(28, R.drawable.dortdort, "Sia", "✓ Doğrulanmış Sanatçı",""))
        categoryItemList4.add(CategoryItem(29, R.drawable.dortbes, "Avril Lavigne", "✓ Doğrulanmış Sanatçı",""))
        categoryItemList4.add(CategoryItem(30, R.drawable.dortalti, "Charlie Puth", "✓ Doğrulanmış Sanatçı",""))
        categoryItemList4.add(CategoryItem(31, R.drawable.dortyedi, "Iggy Azalea", "✓ Doğrulanmış Sanatçı",""))
        categoryItemList4.add(CategoryItem(32, R.drawable.dortsekiz, "George Michael", "✓ Doğrulanmış Sanatçı",""))


        val categoryItemList5: MutableList<CategoryItem> = ArrayList()
        categoryItemList5.add(CategoryItem(33, R.drawable.besbir, "2000'ler Global Hitler", "2000'lerin en iyi şarkıları",""))
        categoryItemList5.add(CategoryItem(34, R.drawable.besiki, "Hitlere Geri Donus", "Özlediğin tüm şarkılar burda",""))
        categoryItemList5.add(CategoryItem(35, R.drawable.besuc, "Dusta Soylemeye Ozel Sarkilar", "Güne şarkı söyleyerek ve tertemiz başla.",""))
        categoryItemList5.add(CategoryItem(36, R.drawable.besdort, "Popun Kraliceleri", "Popun kraliçeleriyle müziğin ritmini yakala.",""))
        categoryItemList5.add(CategoryItem(37, R.drawable.besbes, "En Cok Dinlenen Sarkilar", "Son 10 yılın en çok dinlenen şarkıları",""))
        categoryItemList5.add(CategoryItem(38, R.drawable.besalti, "Enerji Patlamasi Yasatan Sarkilar", "Enerjini yükseltmeye mi çalışıyorsun? Bu yardımcı olacaktır.",""))
        categoryItemList5.add(CategoryItem(39, R.drawable.besyedi, "Nese Verici", "Mutlu anlarına mutluluk kat",""))
        categoryItemList5.add(CategoryItem(40, R.drawable.bessekiz, "Bu Sarkilari Dinlemeyi Unutma", "Senin için özel derlenen bu listeyi dinlemeyi sakın unutma.",""))
        val allCategoryList: MutableList<AllCategory> = ArrayList()
        allCategoryList.add(AllCategory("Gunluk  muzik  ihtiyacin...","", categoryItemList))
        allCategoryList.add(AllCategory("En iyiler","", categoryItemList2))
        allCategoryList.add(AllCategory("Dunun  ve  bugunun  hit'leri","", categoryItemList3))
        allCategoryList.add(AllCategory("Onerilen  Sanatcilar","", categoryItemList4))
        allCategoryList.add(AllCategory("Bunlari da sevebilirsin...","", categoryItemList5))
        setMainCategoryRecycler(allCategoryList)
    }

    private fun setMainCategoryRecycler(allCategoryList: List<AllCategory>) {
        mainCategoryRecycler= findViewById(R.id.main_recycler)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        mainCategoryRecycler!!.setLayoutManager(layoutManager)
        mainRecyclerAdapter = MainRecyclerAdapter(this, allCategoryList)
        mainCategoryRecycler!!.setAdapter(mainRecyclerAdapter)
    }
}