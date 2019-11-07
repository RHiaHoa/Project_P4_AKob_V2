package com.example.application_v2


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.application_v2.databinding.FragmentAddGymBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class AddGymFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentAddGymBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_gym, container, false)

        binding.buttonCancel.setOnClickListener {
            it.findNavController().navigate(R.id.action_addGymFragment_to_homeFragment)
        }

        // Inflate the layout for this fragment
        return binding.root
    }


}
