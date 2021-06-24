package com.example.bankapp.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.bankapp.R
import com.example.bankapp.data.model.ExtratoItem
import com.example.bankapp.databinding.RecyclerviewModelBinding
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

class ExtratoAdapter : RecyclerView.Adapter<ExtratoAdapter.ExtratoViewHolder>() {
    private val ptBr = Locale("pt", "BR")
    private val callback = object : DiffUtil.ItemCallback<ExtratoItem>() {

        override fun areItemsTheSame(
            oldItem: ExtratoItem,
            newItem: ExtratoItem
        ): Boolean {
            return oldItem.descricao == newItem.descricao
        }

        override fun areContentsTheSame(
            oldItem: ExtratoItem,
            newItem: ExtratoItem
        ): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExtratoViewHolder {
        val binding = RecyclerviewModelBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ExtratoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ExtratoViewHolder, position: Int) {
        val extratoItem = differ.currentList[position]
        holder.bind(extratoItem)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class ExtratoViewHolder(
        val binding: RecyclerviewModelBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(extratoItem: ExtratoItem) {
            Log.i("MYTAG", "came here ${extratoItem.data}")
            if(extratoItem.valor.toInt() < 0) {
                binding.rotulo.text = binding.root.context.getString(R.string.Pag)
                binding.valor.setTextColor(ContextCompat.getColor(binding.root.context, R.color.red))
            } else {
                binding.rotulo.text = binding.root.context.getString(R.string.Rec)
                binding.valor.setTextColor(ContextCompat.getColor(binding.root.context, R.color.green))
            }

            binding.data.text = extratoItem.data.toDate().formatTo("dd/MM/yyyy")
            binding.descricao.text = extratoItem.descricao
            binding.valor.text = NumberFormat.getCurrencyInstance(ptBr).format(extratoItem.valor)

        }
    }

    fun String.toDate(dateFormat: String = "yyyy-MM-dd'T'HH:mm:ss'Z'", timeZone: TimeZone = TimeZone.getTimeZone("UTC")): Date {
        val parser = SimpleDateFormat(dateFormat, Locale.getDefault())
        parser.timeZone = timeZone
        return parser.parse(this)
    }

    fun Date.formatTo(dateFormat: String, timeZone: TimeZone = TimeZone.getDefault()): String {
        val formatter = SimpleDateFormat(dateFormat, Locale.getDefault())
        formatter.timeZone = timeZone
        return formatter.format(this)
    }
}