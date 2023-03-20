package com.robert.labb2

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import org.w3c.dom.Text


class FuncFragment : Fragment() {

    //Viewmodel innan create view, så den sparar mellan aktiviteter och rotationer
    private val viewModel: CountViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        //Toast logik
        val deleteCartTEXT = "Items deleted"
        val duration = Toast.LENGTH_SHORT
        val deletedCart = Toast.makeText(context, deleteCartTEXT, duration)

        val view = inflater.inflate(R.layout.fragment_func, container, false)


        //sätter initiella värdet på cart och view i min UI
        view.findViewById<TextView>(R.id.cartNumberText).text = "${viewModel.inCart} "
        view.findViewById<TextView>(R.id.totalNumber).text = "${viewModel.totalCost}$ "

        //knappar
        val btnAddToCart: Button = view.findViewById(R.id.addCart)
        val btnDeleteCart : Button = view.findViewById(R.id.deleteCart)
        val btnConfirmBuy: Button = view.findViewById(R.id.checkoutButton)
        //val inCartText: TextView = view.findViewById(R.id.cartNumberText)
        //val totalCostText: TextView = view.findViewById(R.id.totalNumber)

        //Navigering hem
        view.findViewById <Button>(R.id.btntohome ).setOnClickListener () {
            Navigation.findNavController (view).navigate(R.id.action_funcFragment_to_fragment_home)
        }

        //Snackbar logik
        val snack = Snackbar.make(
            view,
            "Omega Speedmaster added to cart!",
            Snackbar.LENGTH_LONG
        )
        //Snackbar undo button som tar bort senaste varan
        snack.setAction("Undo") {

            viewModel.inCart--
            viewModel.totalCost-= 9000
            view.findViewById<TextView>(R.id.cartNumberText).text = "${viewModel.inCart}"
            view.findViewById<TextView>(R.id.totalNumber).text = "${viewModel.totalCost}$"

        }

        //lägg till en vara med knapptryck
        btnAddToCart.setOnClickListener(){

            snack.show()
            viewModel.inCart++
            viewModel.totalCost+= 9000
            view.findViewById<TextView>(R.id.cartNumberText).text = "${viewModel.inCart}"
            //inCartText.text="$viewModel.inCart"
            view.findViewById<TextView>(R.id.totalNumber).text = "${viewModel.totalCost}$"
            //totalCostText.text="$viewModel.totalCost$"

            println(viewModel.inCart)

        }

        //Radera alla varor på knapptryck
        btnDeleteCart.setOnClickListener(){

            viewModel.inCart=0
            viewModel.totalCost=0
            view.findViewById<TextView>(R.id.cartNumberText).text = "${viewModel.inCart}"
            view.findViewById<TextView>(R.id.totalNumber).text = "${viewModel.totalCost}$"
            deletedCart.show()

        }

        //Knapp som visar upp en alert och raderar alla saker i korgen
        btnConfirmBuy.setOnClickListener(){

            val alertDialog = AlertDialog.Builder(context)
                .setTitle("Confirmed")
                .setMessage("Your purchase went through")
                .setPositiveButton("OK", null)
                .create()
            alertDialog.show()


            viewModel.inCart=0
            viewModel.totalCost=0
            view.findViewById<TextView>(R.id.cartNumberText).text = "${viewModel.inCart}"
            view.findViewById<TextView>(R.id.totalNumber).text = "${viewModel.totalCost}$"

        }

        return view
    }



}