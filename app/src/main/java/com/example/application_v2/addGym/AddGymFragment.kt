package com.example.application_v2.addGym


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
import com.example.application_v2.databinding.FragmentAddGymBinding
import com.example.application_v2.register.RegisterFragmentDirections
import com.google.android.material.snackbar.Snackbar


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

        val binding: FragmentAddGymBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_add_gym, container, false)

        binding.buttonCancel.setOnClickListener {
            it.findNavController().navigate(R.id.action_addGymFragment_to_homeFragment)
        }

        val application = requireNotNull(this.activity).application
        val dataSource = MyDatabase.getInstance(application).gymDao
        val viewmodelfactory = AddGymViewModelFactory(dataSource, application)
        val viewModel = ViewModelProviders.of(this, viewmodelfactory)
            .get(AddGymViewModel::class.java)

        viewModel.gotoHome.observe(this, Observer {
            if (it) {
                findNavController().navigate(
                    AddGymFragmentDirections.actionAddGymFragmentToHomeFragment()
                )
            }
        })

        viewModel.showSnackBarEvent.observe(this, Observer {
            Snackbar.make(
                activity!!.findViewById(android.R.id.content),
                "Please input correct informations.",
                Snackbar.LENGTH_SHORT // How long to display the message.
            ).show()
        })


        // Inflate the layout for this fragment

        binding.addGymViewModel = viewModel

        return binding.root
    }


}
