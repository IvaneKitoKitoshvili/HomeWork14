package com.kito.homework14

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kito.homework14.databinding.FragmentBuildingBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BuildingFragment : Fragment() {
    private lateinit var binding: FragmentBuildingBinding

    private val viewModel: BuildingViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBuildingBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewModel) {
            viewState.observe(viewLifecycleOwner) {
                if (viewState.value?.isSuccessful == true) {
                    binding.tvText.text = viewState.value!!.itemData.toString()
                } else if(viewState.value?.error != null){
                    Toast.makeText(
                        requireContext(),
                        viewState.value?.error ?: "",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}
