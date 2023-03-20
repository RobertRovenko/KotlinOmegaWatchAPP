package com.robert.labb2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation


/**
 * A simple [Fragment] subclass.
 * Use the [AboutFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AboutFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_about, container, false)

        //Navigerings-Knappar
        view.findViewById <Button>(R.id.btnonabout ).setOnClickListener () {
            Navigation.findNavController (view).navigate(R.id.action_aboutFragment_to_fragment_home )
        }

        view.findViewById <Button>(R.id.btntosubscribe ).setOnClickListener () {
            Navigation.findNavController (view).navigate(R.id.action_fragment_about_to_newsFragment )
        }

        return view
    }


}