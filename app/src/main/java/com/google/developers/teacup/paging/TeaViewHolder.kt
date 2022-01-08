package com.google.developers.teacup.paging

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.developers.teacup.R
import com.google.developers.teacup.data.Tea

/**
 * A RecyclerView ViewHolder that displays a Tea.
 */
class TeaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val context = itemView.context
    private lateinit var tea: Tea

    val textTeaName: TextView = itemView.findViewById(R.id.textTeaName)
    val textCountryOrigin: TextView = itemView.findViewById(R.id.textCountryOrigin)
    val textSleepTime: TextView = itemView.findViewById(R.id.textSleepTime)

    /**
     * Attach values to views.
     */
    fun bindTo(tea: Tea, clickListener: (Tea) -> Unit) {
        textTeaName.text = tea.name
        textCountryOrigin.text = tea.origin
        textSleepTime.text = tea.steepTimeMs.toString()

    }

    fun getTea(): Tea = tea
}
