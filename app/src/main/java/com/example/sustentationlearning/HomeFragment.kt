package com.example.sustentationlearning

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridLayout
import android.widget.GridView
import android.widget.Toast
import com.ramotion.foldingcell.FoldingCell
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment(), AdapterView.OnItemClickListener {

    private var arrayList: ArrayList<HomeView>? = null
    private var gridView: GridView? = null
    private var listAdapter: HomeAdapter? = null
    lateinit var fc: FoldingCell

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        gridView = gv_home
        arrayList = arrayListOf()
        arrayList = setDataList()
        listAdapter = context?.let { HomeAdapter(it, arrayList!!) }
        gridView?.adapter = listAdapter
        gridView?.onItemClickListener = this

         fc = folding_cell

        fc.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                //Your code here
                fc.toggle(false);

            }})


    }

    private fun setDataList(): ArrayList<HomeView> {
        var arrayList: ArrayList<HomeView> = ArrayList()
        arrayList.add(HomeView("mozhde"))
        arrayList.add(HomeView("mozhgan"))
        arrayList.add(HomeView("mina"))
        arrayList.add(HomeView("sima"))


        return arrayList
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var item : HomeView = arrayList!!.get(position)
        Toast.makeText(context,item.name,Toast.LENGTH_LONG).show()
    }

}
