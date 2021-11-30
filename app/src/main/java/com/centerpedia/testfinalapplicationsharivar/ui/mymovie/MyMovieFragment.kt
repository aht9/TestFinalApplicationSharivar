package com.centerpedia.testfinalapplicationsharivar.ui.mymovie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.centerpedia.testfinalapplicationsharivar.R
import com.centerpedia.testfinalapplicationsharivar.databinding.FragmentMyMovieBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MyMovieFragment : Fragment() {
    lateinit var binding: FragmentMyMovieBinding
    private val viewModel by viewModels<MyMovieViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMyMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = MyMovieAdapter {
            findNavController().navigate(
                MyMovieFragmentDirections.actionMyMovieFragmentToMovieDetailFragment(it)
            )
        }

        binding.favRecycler.adapter = adapter

        viewModel.liveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        lifecycleScope.launch(Dispatchers.IO) {
            viewModel.getFavMovies()
        }
    }

}