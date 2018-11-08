package wcaf.com.br.wcafdeezerandroid.room.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import wcaf.com.br.wcafdeezerandroid.room.entities.Artist;

@Dao
public interface ArtistDao {

    @Query("SELECT * FROM artist_table")
    LiveData<List<Artist>> getAllArtists();

    @Insert
    void insertArtist(Artist artist);

    @Delete
    void deleteArtist(Artist artist);
}
