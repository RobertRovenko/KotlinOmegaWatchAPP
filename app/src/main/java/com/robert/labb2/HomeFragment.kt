package com.robert.labb2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_home, container, false)

        //Navigerings-Knappar

        view.findViewById <Button >(R.id.btntoabout ).setOnClickListener () {
            Navigation.findNavController (view).navigate(R.id.action_homeFragment_to_aboutFragment )
        }
        view.findViewById <Button >(R.id.btntofunc ).setOnClickListener () {
            Navigation.findNavController (view).navigate(R.id.action_fragment_home_to_funcFragment )
        }

        return view
    }


}