package com.soongon.nationinfo

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

data class Nation(val flagid: Int, val name: String, val capital: String)

class NationViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val flagImg: ImageView = view.findViewById(R.id.flagImg) as ImageView
    val nameTxt: TextView = view.findViewById(R.id.nameTextView) as TextView
    val capitalTxt: TextView = view.findViewById(R.id.capitalTextView) as TextView

    init {
        view.setOnClickListener {
            // Toast.makeText(view.context, "event..", Toast.LENGTH_LONG).show()
            val intent = Intent(view.context, NationDetailActivity::class.java)
            intent.putExtra("nationName",
                view.findViewById<TextView>(R.id.nameTextView).text)
            view.context.startActivity(intent)
        }
    }
}

class NationAdapter(val items: List<Nation>): RecyclerView.Adapter<NationViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NationViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val row = layoutInflater.inflate(R.layout.layout_nation_list_item, parent, false)
        return NationViewHolder(row)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: NationViewHolder, position: Int) {
        holder.flagImg.setImageResource(items[position].flagid)
        holder.nameTxt.text = items[position].name
        holder.capitalTxt.text = items[position].capital
        holder.nameTxt.tag = position
    }

}