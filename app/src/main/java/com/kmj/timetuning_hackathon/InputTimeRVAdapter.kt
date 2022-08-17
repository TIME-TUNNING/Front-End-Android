package com.kmj.timetuning_hackathon

import android.content.res.ColorStateList
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kmj.timetuning_hackathon.databinding.CreateSelectedDateRvItemBinding
import com.kmj.timetuning_hackathon.databinding.InputTimeDateRvItemBinding
import com.kmj.timetuning_hackathon.databinding.ScheduleListRvItemBinding

class InputTimeRVAdapter(val dates: List<DateInfo>) :
    RecyclerView.Adapter<InputTimeRVAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: InputTimeDateRvItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(dates: DateInfo) {
            binding.selectedDateMonth.text = dates.month.toString() + "월" //월
            binding.selectedDateDay.text = dates.day.toString() //일
            binding.selectedDateDayOfWeek.text = dates.dayOfWeek //요일
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: InputTimeDateRvItemBinding = InputTimeDateRvItemBinding.inflate(
            LayoutInflater.from(viewGroup.context),
            viewGroup,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = (holder as InputTimeRVAdapter.ViewHolder).binding
        holder.bind(dates[position])
        binding.inputTimeDateRvRoot.setOnClickListener {
            Log.d("clicked", "${position}")
        }
    }

    override fun getItemCount(): Int = dates.size
}