package com.example.constanta.presentation.fragments

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.constanta.R
import com.example.constanta.domain.models.Film
import com.example.constanta.presentation.helpers.FilmClickListener
import com.example.constanta.presentation.rv.FilmItemDecoration
import com.example.constanta.presentation.rv.FilmListAdapter
import com.example.constanta.presentation.viewmodel.FilmListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class FilmsListFragment : Fragment(), FilmClickListener {
    private val vm by viewModel<FilmListViewModel>()
    private lateinit var filmRecyclerView: RecyclerView
    private lateinit var filmAdapter: FilmListAdapter
    private lateinit var filmItemDecoration: FilmItemDecoration

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_films_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        initRV()
        initSubscribe()
        loadData()
    }

    private fun initViews(view: View) {
        filmRecyclerView = view.findViewById(R.id.rv_films)
    }

    private fun initRV() {
        filmAdapter = FilmListAdapter(this@FilmsListFragment)
        filmItemDecoration = FilmItemDecoration()
        filmRecyclerView.adapter = filmAdapter
        filmRecyclerView.addItemDecoration(filmItemDecoration)
    }

    private fun initSubscribe() {
        vm.filmListLiveData.observe(viewLifecycleOwner, Observer(filmAdapter::initData))
    }

    private fun loadData() {
        vm.getAllFilms()
    }

    override fun onFilmIconClick(film: Film) {
        val builder = context?.let { AlertDialog.Builder(it, R.style.MyDialogTheme) }
        builder?.setMessage(getString(R.string.dialog, film.title))
        val dialog = builder?.show()
        val messageView = dialog?.findViewById<TextView>(android.R.id.message)
        messageView?.gravity = Gravity.CENTER
    }
}
