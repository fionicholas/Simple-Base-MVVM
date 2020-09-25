package com.fionicholas.simplebasemvvm.data.movie.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fionicholas.simplebasemvvm.data.movie.local.response.MovieFavorite
import io.reactivex.Single

@Dao
abstract class MovieDao {
    @Query("SELECT * FROM movie WHERE id = :intId")
    abstract fun getItemById(intId: Int?): Single<MovieFavorite>

    @Query("SELECT * FROM movie")
    abstract fun getList(): Single<List<MovieFavorite>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun addFavoriteMovie(favorite: MovieFavorite)

    @Query("DELETE FROM movie WHERE id = :intId")
    abstract fun remove(intId: Int?)

    @Query("DELETE FROM movie")
    abstract fun removeAll()
}