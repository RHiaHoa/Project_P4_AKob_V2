package com.example.application_v2

import android.graphics.Color
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomeAdapter: RecyclerView.Adapter<TextItemViewHolder>() {

//    var data =  listOf<Gym>()
//        set(value) {
//            field = value
//            notifyDataSetChanged()
//        }

    var dataName = listOf("สมพรการค้า","ฟิตเนส","อุปกรณ์กีฬา","สนามบอล","สนามแบต")
    var dataScore = listOf("ลุมพินี ซอย 9","ลุมพินี ซอย 10","ลุมพินี ซอย 2","ลุมพินี ซอย 3","ลุมพินี ซอย 4")

    override fun getItemCount() = dataName.size

    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {

        holder.textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24F)

        holder.textView.text = "${dataName[position]}\n${dataScore[position]}\n"

        holder.textView.setTextColor(Color.BLACK)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val view = layoutInflater
            .inflate(R.layout.text_item_view, parent, false) as TextView

        return TextItemViewHolder(view)
    }
}

class TextItemViewHolder(val textView: TextView): RecyclerView.ViewHolder(textView)