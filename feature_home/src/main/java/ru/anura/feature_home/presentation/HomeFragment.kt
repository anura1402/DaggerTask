package ru.anura.feature_home.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.anura.feature_home.databinding.FragmentHomeBinding
import ru.anura.feature_home.di.HomeComponentProvider

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = _binding ?: throw RuntimeException("FragmentHomeBinding == null")

    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("HomeFragment", "IsCreating")
        super.onCreate(savedInstanceState)

        val homeComponent =
            (requireActivity().application as? HomeComponentProvider)?.getHomeComponent()
                ?: throw IllegalStateException("HomeComponent is not initialized")

        viewModel = ViewModelProvider(this, ViewModelFactory {
            HomeViewModel(homeComponent.fetchDataUseCase()).apply {
                homeComponent.inject(this)
            }
        })[HomeViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.messageLiveData.observe(viewLifecycleOwner) { message ->
            Log.d("HomeFragment", "Received message: $message")
        }
        Log.d("HomeFragment", "Calling viewModel.makeRequests()")
        viewModel.makeRequests()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}