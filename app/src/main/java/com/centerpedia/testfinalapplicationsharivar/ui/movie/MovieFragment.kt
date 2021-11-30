package com.centerpedia.testfinalapplicationsharivar.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.centerpedia.testfinalapplicationsharivar.R
import com.centerpedia.testfinalapplicationsharivar.Repo.Net.RetroInterface
import com.centerpedia.testfinalapplicationsharivar.common.hideKeyboard
import com.centerpedia.testfinalapplicationsharivar.databinding.FragmentMovieBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import com.centerpedia.testfinalapplicationsharivar.common.showLongToast

@AndroidEntryPoint
class MovieFragment : Fragment() {
    lateinit var binding: FragmentMovieBinding
    private val viewModel by viewModels<MoiveViewModel>()
    @Inject
    lateinit var retrofitInterface: RetroInterface

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = MovieAdapter {
            findNavController().navigate(
                MovieFragmentDirections.actionMovieFragmentToMovieDetailFragment(it)
            )
        }

        binding.moviesRecycler.adapter = adapter

        viewModel.liveData.observe(viewLifecycleOwner) {
            adapter.submitList(it.Search)
        }


        binding.btnSearch.setOnClickListener {
            val searchString = binding.etSearch.text.toString()
            showLongToast(requireContext(), "Searching for ${searchString}!")

            it.hideKeyboard()

            viewModel.searchMovie(searchString)

        }

        binding.btnClear.setOnClickListener { binding.etSearch.setText("") }
    }

}