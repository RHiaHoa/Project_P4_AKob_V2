package com.example.application_v2.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.application_v2.R
import com.example.application_v2.database.MyDatabase
import com.example.application_v2.databinding.FragmentRegisterBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_register, container, false
        )

        val application = requireNotNull(this.activity).application
        val dataSource = MyDatabase.getInstance(application).UserDatabaseDao
        val viewmodelfactory = RegisterViewModelFactory(dataSource, application)
        val viewModel = ViewModelProviders.of(this, viewmodelfactory)
            .get(RegisterViewModel::class.java)

        binding.buttonCancel.setOnClickListener {
            it.findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }

        viewModel.gotoLogin.observe(this, Observer {
            if (it) {
                findNavController().navigate(
                    RegisterFragmentDirections
                        .actionRegisterFragmentToLoginFragment()
                )
            }
        })

        binding.registerViewModel = viewModel

        return binding.root
    }


}
