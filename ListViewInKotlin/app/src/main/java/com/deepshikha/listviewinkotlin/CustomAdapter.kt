package com.deepshikha.listviewinkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by deepshikha on 31/7/17.
 */

class CustomAdapter(context: Context,al_flower:ArrayList<Model_flower>) : BaseAdapter(){

    private val mInflator: LayoutInflater
    private val al_flower:ArrayList<Model_flower>

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

        vh.label.text = al_flower.get(position).str_name
        vh.tv_des.text = al_flower.get(position).str_des
        vh.iv_image.setImageResource(al_flower.get(position).int_image)
        return view
    }
}

private class ListRowHolder(row: View?) {
    public val label: TextView
    public val tv_des: TextView
    public val iv_image: ImageView

    init {
        this.label = row?.findViewById<TextView>(R.id.tv_name) as TextView
        this.tv_des = row?.findViewById<TextView>(R.id.tv_des) as TextView
        this.iv_image = row?.findViewById<ImageView>(R.id.iv_flower) as ImageView
    }

}