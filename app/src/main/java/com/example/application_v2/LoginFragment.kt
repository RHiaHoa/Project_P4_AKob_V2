package com.example.application_v2


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.application_v2.databinding.FragmentLoginBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class LoginFragment : Fragment() {
    private lateinit var binding : FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login, container, false)



        binding.buttonLogin.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }

        binding.buttonRegister.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }


        return binding.root
    }


}
