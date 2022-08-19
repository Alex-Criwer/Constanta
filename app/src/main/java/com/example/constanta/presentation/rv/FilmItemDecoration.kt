package com.example.constanta.presentation.rv

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class FilmItemDecoration: RecyclerView.ItemDecoration() {
    private val spaceVertical: Int = 20

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.top = spaceVertical
        if (parent.getChildAdapterPosition(view) == parent.adapter?.itemCount?.minus(1)) {
            outRect.bottom = spaceVertical
        }
    }
}