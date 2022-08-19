package com.example.constanta.presentation.rv

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.constanta.R
import com.example.constanta.domain.models.Film
import com.example.constanta.presentation.helpers.FilmClickListener

class FilmListAdapter(val filmClickListener: FilmClickListener):
    RecyclerView.Adapter<FilmListAdapter.FilmViewHolder>() {

    private val _films: MutableList<Film> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun initData(listOfFilms: List<Film>) {
        _films.clear()
        _films.addAll(listOfFilms)
        notifyDataSetChanged()
    }

    inner class FilmViewHolder(item: View): RecyclerView.ViewHolder(item) {
        val filmTitle = itemView.findViewById<TextView>(R.id.tv_film_title)
        val director = itemView.findViewById<TextView>(R.id.tv_film_director)
        val actors = itemView.findViewById<TextView>(R.id.tv_film_actors)

        fun onBind(film: Film) {
            filmTitle.text = itemView.context.getString(R.string.title, film.title, film.releaseYear)
            director.text = itemView.context.getString(R.string.director, film.directorName)

            val actorsList = film.actors.distinctBy {it.actorName}.map { it.actorName }.joinToString(separator = ", ")
            actors.text = itemView.context.getString(R.string.actors, actorsList)

            itemView.setOnClickListener {
                filmClickListener.onFilmIconClick(film)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view, parent, false)
        return FilmViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.onBind(_films[position])
    }

    override fun getItemCount(): Int = _films.size
}