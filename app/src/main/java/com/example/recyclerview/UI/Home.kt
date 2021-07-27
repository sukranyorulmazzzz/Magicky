package com.example.recyclerview.UI
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)


        val categoryItemList: MutableList<CategoryItem> = ArrayList()
        categoryItemList.add(CategoryItem(1, R.drawable.bir, "Turkiyenin En Siki Calma Listesi", ""))
        categoryItemList.add(CategoryItem(2, R.drawable.iki_1, "Yaz Hitleri", ""))
        categoryItemList.add(CategoryItem(3, R.drawable.uc_1, "Hot Hits Turkiye", ""))
        categoryItemList.add(CategoryItem(4, R.drawable.dort_1, "Yaz Ritmi", ""))
        categoryItemList.add(CategoryItem(5, R.drawable.bes, "Kirik Kalpler Duragi", ""))
        categoryItemList.add(CategoryItem(6, R.drawable.alti, "+Pop", ""))
        categoryItemList.add(CategoryItem(7, R.drawable.yedi, "Dunyanin Hiti", ""))
        categoryItemList.add(CategoryItem(8, R.drawable.sekiz, "Odev Yaparken Sarar", ""))

        val categoryItemList2: MutableList<CategoryItem> = ArrayList()
        categoryItemList2.add(CategoryItem(9, R.drawable.ikibir, "Adele", ""))
        categoryItemList2.add(CategoryItem(10, R.drawable.ikiki, "Rihanna", ""))
        categoryItemList2.add(CategoryItem(11, R.drawable.ikiuc, "Katy Perry", ""))
        categoryItemList2.add(CategoryItem(12, R.drawable.ikidort, "Lady Gaga", ""))
        categoryItemList2.add(CategoryItem(13, R.drawable.ikibes, "Michael Jackson", ""))
        categoryItemList2.add(CategoryItem(14, R.drawable.ikialti, "Taylor Swift", ""))
        categoryItemList2.add(CategoryItem(15, R.drawable.ikiyedi, "Linkin Park", ""))
        categoryItemList2.add(CategoryItem(16, R.drawable.ikisekiz, "Britney Spears", ""))

        val categoryItemList3: MutableList<CategoryItem> = ArrayList()
        categoryItemList3.add(CategoryItem(17, R.drawable.ucbir, "2012 Hitleri", ""))
        categoryItemList3.add(CategoryItem(18, R.drawable.uciki, "2015 Hitleri", ""))
        categoryItemList3.add(CategoryItem(19, R.drawable.ucuc, "2010 Hitleri", ""))
        categoryItemList3.add(CategoryItem(20, R.drawable.ucdort, "2009 Hitleri", ""))
        categoryItemList3.add(CategoryItem(21, R.drawable.ucbes, "2011 Hitleri", ""))
        categoryItemList3.add(CategoryItem(22, R.drawable.ucalti, "2017 Hitleri", ""))
        categoryItemList3.add(CategoryItem(23, R.drawable.ucyedi, "2014 Hitleri", ""))
        categoryItemList3.add(CategoryItem(24, R.drawable.ucsekiz, "2008 Hitleri", ""))


        val categoryItemList4: MutableList<CategoryItem> = ArrayList()
        categoryItemList4.add(CategoryItem(25, R.drawable.dortbir, "Beyoncé", ""))
        categoryItemList4.add(CategoryItem(26, R.drawable.dortiki, "Lana Del Rey", ""))
        categoryItemList4.add(CategoryItem(27, R.drawable.dortuc, "Sam Smith", ""))
        categoryItemList4.add(CategoryItem(28, R.drawable.dortdort, "Sia", ""))
        categoryItemList4.add(CategoryItem(29, R.drawable.dortbes, "Avril Lavigne", ""))
        categoryItemList4.add(CategoryItem(30, R.drawable.dortalti, "Charlie Puth", ""))
        categoryItemList4.add(CategoryItem(31, R.drawable.dortyedi, "Iggy Azalea", ""))
        categoryItemList4.add(CategoryItem(32, R.drawable.dortsekiz, "George Michael", ""))


        val categoryItemList5: MutableList<CategoryItem> = ArrayList()
        categoryItemList5.add(CategoryItem(33, R.drawable.besbir, "2000'ler Global Hitler", ""))
        categoryItemList5.add(CategoryItem(34, R.drawable.besiki, "Hitlere Geri Donus", ""))
        categoryItemList5.add(CategoryItem(35, R.drawable.besuc, "Dusta Soylemeye Ozel Sarkilar", ""))
        categoryItemList5.add(CategoryItem(36, R.drawable.besdort, "Popun Kraliceleri", ""))
        categoryItemList5.add(CategoryItem(37, R.drawable.besbes, "En Cok Dinlenen Sarkilar", ""))
        categoryItemList5.add(CategoryItem(38, R.drawable.besalti, "Enerji Patlamasi Yasatan Sarkilar", ""))
        categoryItemList5.add(CategoryItem(39, R.drawable.besyedi, "Nese Verici", ""))
        categoryItemList5.add(CategoryItem(40, R.drawable.bessekiz, "Bu Sarkilari Dinlemeyi Unutma", ""))
        val allCategoryList: MutableList<AllCategory> = ArrayList()
        allCategoryList.add(AllCategory("Gunluk  muzik  ihtiyacin...", categoryItemList))
        allCategoryList.add(AllCategory("En iyiler", categoryItemList2))
        allCategoryList.add(AllCategory("Dunun  ve  bugunun  hit'leri", categoryItemList3))
        allCategoryList.add(AllCategory("Onerilen  Sanatcilar", categoryItemList4))
        allCategoryList.add(AllCategory("Bunlari da sevebilirsin...", categoryItemList5))
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