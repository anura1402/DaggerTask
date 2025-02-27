package ru.anura.feature_home.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.anura.feature_home.databinding.FragmentHomeBinding
import ru.anura.feature_home.di.HomeComponentProvider
import javax.inject.Inject

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = _binding ?: throw RuntimeException("FragmentHomeBinding == null")

    private val testValue = "12345"

    @Inject
    lateinit var viewModelFactory: ViewModelFactory.Factory

    private val viewModel: HomeViewModel by viewModels {
        viewModelFactory.create(testValue)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as? HomeComponentProvider)?.getHomeComponent()?.inject(this)
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


        viewModel.messageLiveData.observe(viewLifecycleOwner) { data ->
            Log.d("HomeFragment", "Получены данные:\n$data")
        }
        viewModel.makeRequests()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}