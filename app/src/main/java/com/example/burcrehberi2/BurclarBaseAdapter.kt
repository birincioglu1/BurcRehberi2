package com.example.burcrehberi2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.tek_satir.view.*

class BurclarBaseAdapter(context: Context,tumBurcBilgileri:ArrayList<Burc>) : BaseAdapter() {


    var tumburclar:ArrayList<Burc>
    var context:Context

    init {
        this.tumburclar=tumBurcBilgileri
        this.context=context


    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

        var tek_satir_view=convertView
        var viewHolder:ViewHolder2


        if (tek_satir_view==null)
        {
            var inflater=LayoutInflater.from(context)
            tek_satir_view=inflater.inflate(R.layout.tek_satir,parent,false)

            viewHolder= ViewHolder2(tek_satir_view)
            tek_satir_view.tag=viewHolder

        }
        else{
            viewHolder=tek_satir_view.getTag() as ViewHolder2
        }




        viewHolder.burcResim.setImageResource(tumburclar.get(position).burcSembol)
        viewHolder.burcAdi.setText(tumburclar.get(position).burcAdi)
        viewHolder.burcTarih.setText(tumburclar.get(position).burcTarih)

        return tek_satir_view
    }

    override fun getItem(position: Int): Any {
        return tumburclar.get(position)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
      return tumburclar.size
    }
}



class ViewHolder2(tek_satir_view:View)
{
        var burcResim:ImageView
    var burcAdi:TextView
    var burcTarih:TextView
    init {
        this.burcResim=tek_satir_view.imgBurcSembol
        this.burcAdi=tek_satir_view.tvBurcAdi
        this.burcTarih=tek_satir_view.tvBurcTarihi


    }
}