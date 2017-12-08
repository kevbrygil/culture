package com.admin.gastronomia

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.adapter_layout.*


class CustomAdapter(context: Context,al_flower:ArrayList<ModelFood>) : BaseAdapter(){

    private val mInflator: LayoutInflater
    private val al_flower:ArrayList<ModelFood>

    init {
        this.mInflator = LayoutInflater.from(context)
        this.al_flower=al_flower
    }

    override fun getCount(): Int {
        return al_flower.size
    }

    override fun getItem(position: Int): Any {
        return al_flower.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val view: View?
        val vh: ListRowHolder
        if (convertView == null) {
            view = this.mInflator.inflate(R.layout.adapter_layout, parent, false)
            vh = ListRowHolder(view)
            view.tag = vh
        } else {
            view = convertView
            vh = view.tag as ListRowHolder
        }

        vh.label!!.text = al_flower[position].str_name
        vh.description!!.text = al_flower[position].str_des
        vh.image!!.setImageResource(al_flower[position].int_image)
        return view
    }
}

private class ListRowHolder(row: View?) {
    var label: TextView? = null
    var description: TextView? = null
    var image: ImageView? = null

    init {
        this.label = row!!.findViewById(R.id.tv_name)
        this.description = row!!.findViewById(R.id.tv_des)
        this.image = row!!.findViewById(R.id.iv_flower)
    }


}