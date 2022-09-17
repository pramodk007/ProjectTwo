package com.example.projecttwo.ui.facts

import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.projecttwo.core.BaseFragment
import com.example.projecttwo.databinding.FragmentFactBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FactFragment : BaseFragment<FragmentFactBinding>(FragmentFactBinding::inflate) {

    private val viewModel: FactViewModel by viewModels()

    override fun listeners() {
        binding.btnGenerate.setOnClickListener {
            observers()
        }
    }

    override fun init() {
    }

    override fun observers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getFacts()
                viewModel.factFlow.collect {
                    binding.apply {
                        progressBar.isVisible = it.isLoading
                        if (it.data != null){
                            tvFact.text = it.data.toString()
                        }
                        if (it.errorMessage != ""){
                            Toast.makeText(context, it.errorMessage, Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }

}