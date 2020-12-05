package com.example.desafiomarvelapi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.squareup.picasso.Picasso


class TesteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_full_image, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val url = arguments?.getString("url")
        val id = arguments?.getInt("id")
        val imagem = view.findViewById<ImageView>(R.id.imgFull)

        Picasso.get()
            .load(url)
            .into(imagem)

        view.findViewById<ImageView>(R.id.imgclose).setOnClickListener {
            val nav = Navigation.findNavController(view)
            val bundle = bundleOf("id" to id)
            nav.navigate(R.id.action_testeFragment3_to_comicInfoFragment, bundle)
        }
    }

}