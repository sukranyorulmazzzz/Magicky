package com.example.recyclerview.UI
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.Adapter.MainRecyclerAdapter
import com.example.recyclerview.Adapter.MyRecyclerViewAdapter
import com.example.recyclerview.Model.AllCategory
import com.example.recyclerview.Model.CategoryItem
import com.example.recyclerview.R

class Home : AppCompatActivity() {
    private var mainCategoryRecycler:RecyclerView?=null
    private var mainRecyclerAdapter:MainRecyclerAdapter?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        val categoryItemList:MutableList<CategoryItem> = ArrayList()
        categoryItemList.add(CategoryItem(1,R.drawable.bir))
        categoryItemList.add(CategoryItem(1,R.drawable.iki_1))
        categoryItemList.add(CategoryItem(1,R.drawable.uc_1))
        categoryItemList.add(CategoryItem(1,R.drawable.dort_1))
        categoryItemList.add(CategoryItem(1,R.drawable.bes))
        categoryItemList.add(CategoryItem(1,R.drawable.alti))
        categoryItemList.add(CategoryItem(1,R.drawable.yedi))
        categoryItemList.add(CategoryItem(1,R.drawable.sekiz))

        val categoryItemList2:MutableList<CategoryItem> = ArrayList()
        categoryItemList2.add(CategoryItem(1,R.drawable.ikibir))
        categoryItemList2.add(CategoryItem(1,R.drawable.ikiki))
        categoryItemList2.add(CategoryItem(1,R.drawable.ikiuc))
        categoryItemList2.add(CategoryItem(1,R.drawable.ikidort))
        categoryItemList2.add(CategoryItem(1,R.drawable.ikibes))
        categoryItemList2.add(CategoryItem(1,R.drawable.ikialti))
        categoryItemList2.add(CategoryItem(1,R.drawable.ikiyedi))
        categoryItemList2.add(CategoryItem(1,R.drawable.ikisekiz))


        val categoryItemList3:MutableList<CategoryItem> = ArrayList()
        categoryItemList3.add(CategoryItem(1,R.drawable.ucbir))
        categoryItemList3.add(CategoryItem(1,R.drawable.uciki))
        categoryItemList3.add(CategoryItem(1,R.drawable.ucuc))
        categoryItemList3.add(CategoryItem(1,R.drawable.ucdort))
        categoryItemList3.add(CategoryItem(1,R.drawable.ucbes))
        categoryItemList3.add(CategoryItem(1,R.drawable.ucalti))
        categoryItemList3.add(CategoryItem(1,R.drawable.ucyedi))
        categoryItemList3.add(CategoryItem(1,R.drawable.ucsekiz))

        val categoryItemList4:MutableList<CategoryItem> = ArrayList()
        categoryItemList4.add(CategoryItem(1,R.drawable.dortbir))
        categoryItemList4.add(CategoryItem(1,R.drawable.dortiki))
        categoryItemList4.add(CategoryItem(1,R.drawable.dortuc))
        categoryItemList4.add(CategoryItem(1,R.drawable.dortdort))
        categoryItemList4.add(CategoryItem(1,R.drawable.dortbes))
        categoryItemList4.add(CategoryItem(1,R.drawable.dortalti))
        categoryItemList4.add(CategoryItem(1,R.drawable.dortyedi))
        categoryItemList4.add(CategoryItem(1,R.drawable.dortsekiz))



        val allCategory:MutableList<AllCategory> =ArrayList()
        allCategory.add(AllCategory("Gunluk  muzik  ihtiyacin",categoryItemList))
        allCategory.add(AllCategory("En iyiler",categoryItemList2))
        allCategory.add(AllCategory("Dunun  ve  bugunun  hit'leri",categoryItemList3))
        allCategory.add(AllCategory("Onerilen  Sanatcilar",categoryItemList4))


        setMainCategoryRecycler(allCategory)

    }
    private fun setMainCategoryRecycler(allCategory:List<AllCategory>){
        mainCategoryRecycler=findViewById(R.id.main_recycler)
        val layoutManager:RecyclerView.LayoutManager=LinearLayoutManager(this)
        mainCategoryRecycler!!.layoutManager=layoutManager
        mainRecyclerAdapter= MainRecyclerAdapter(this,allCategory)
        mainCategoryRecycler!!.adapter=mainRecyclerAdapter
        mainRecyclerAdapter!!.setOnItemClickListener(object :MainRecyclerAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                Toast.makeText(this@Home,"You clicked on item no: $position",Toast.LENGTH_LONG).show()
            }

        })



    }

}