package com.example.madlevel6task2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.madlevel6task2.databinding.FragmentDetailBinding
import com.example.madlevel6task2.vm.MoviesViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class DetailFragment : Fragment() {

    private val vm: MoviesViewModel by activityViewModels()
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater)

        initViews()

        return binding.root
    }

    private fun initViews() {
        vm.selectedMovie.observe(viewLifecycleOwner) { movie ->
            movie?.let { selectedMovie ->
                val glideRequestManager = Glide.with(requireContext())

                val posterUrl = selectedMovie.getPosterUrl()
                glideRequestManager.load(posterUrl).into(binding.ivPoster)

                val backdropUrl = selectedMovie.getBackdropUrl()
                backdropUrl?.let {
                    glideRequestManager.load(it).into(binding.ivBackdrop)
                }

                binding.tvTitle.text = selectedMovie.title
                binding.tvStarRating.text = selectedMovie.voteAverage.toString()
                binding.tvReleaseDate.text = selectedMovie.releaseDateString
                binding.tvOverview.text = selectedMovie.overview
            }
        }
    }
}