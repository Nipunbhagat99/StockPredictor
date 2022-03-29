package com.example.stockpredicter.activities.ui.dashboard

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.stockpredicter.databinding.FragmentCalculatorBinding
import java.util.*


class CalculatorFragment : Fragment() {


    private var _binding: FragmentCalculatorBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentCalculatorBinding.inflate(inflater, container, false)

        binding.etStartDate.setOnClickListener {
            openStartDatePicker()
        }

        binding.etEndDate.setOnClickListener {
            openEndDatePicker()
        }



        return binding.root
    }


    private fun openStartDatePicker(){
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)


        val dpd =
            activity?.let {
                DatePickerDialog(it, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                    // Display Selected date in textbox
                    var month1 = monthOfYear+1
                    binding.etStartDate.setText(""+dayOfMonth + "/" + month1 + "/" + year)
                    binding.etStartDate.setTextColor(Color.WHITE)

                }, year, month, day)
            }

        dpd?.show()
    }


    private fun openEndDatePicker(){
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)


        val dpd =
            activity?.let {
                DatePickerDialog(it, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                    // Display Selected date in textbox
                    var month1 = monthOfYear+1
                    binding.etEndDate.setText(""+dayOfMonth + "/" + month1 + "/" + year)
                    binding.etEndDate.setTextColor(Color.WHITE)

                }, year, month, day)
            }

        dpd?.show()
    }






    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}