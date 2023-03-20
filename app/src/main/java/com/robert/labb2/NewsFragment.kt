package com.robert.labb2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar


class NewsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_news, container, false)


        // Dynamisk ArrayList med alla subscribers och en fördefinerad
        var subscriberList = ArrayList<Subscribers>(
            listOf(
                Subscribers("example@gmail.com")
            )
        )


        //Toast logik
        val noEmailText = "You need an email"
        val emailIsTaken = "Email is already in use"
        val duration = Toast.LENGTH_SHORT

        val toastNoEmail = Toast.makeText(context, noEmailText, duration)
        val toastEmailTaken = Toast.makeText(context, emailIsTaken, duration)

        //Knappar
        val emailSub : EditText = view.findViewById(R.id.EmailEditText)
        val btnSub : Button = view.findViewById(R.id.submitButton)

        //Snackbar
        val snack = Snackbar.make(
            view,
            "You successfully subscribed!",
            Snackbar.LENGTH_LONG
        )
        //Klickar man undo tar den bort sista index
        snack.setAction("Undo") {

            subscriberList.removeAt(subscriberList.lastIndex)
            println(subscriberList)

        }


        //Logik för news subscribe
        btnSub.setOnClickListener{
            if (emailSub.text.isEmpty()){
                toastNoEmail.show()
                println("No email has been inputted")
            }else{
                var isEmailTaken = false
                for (user in subscriberList) {
                    if (user.email == emailSub.text.toString()) {
                        isEmailTaken = true
                        break
                    }
                }

                if (isEmailTaken){
                    toastEmailTaken.show()
                }
                else{
                    subscriberList.add(Subscribers(emailSub.text.toString()))
                    println(subscriberList)
                    snack.show()
                }
            }
        }

        //Navigering tillbaka
        view.findViewById <Button>(R.id.returnbtn ).setOnClickListener () {
            Navigation.findNavController (view).navigate(R.id.action_newsFragment_to_fragment_about)
        }

        return view
    }



}