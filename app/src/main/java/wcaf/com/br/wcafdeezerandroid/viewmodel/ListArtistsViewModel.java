package wcaf.com.br.wcafdeezerandroid.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import wcaf.com.br.wcafdeezerandroid.room.DeezerRepository;
import wcaf.com.br.wcafdeezerandroid.room.entities.Artist;

public class ListArtistsViewModel extends AndroidViewModel {

    public LiveData<List<Artist>> allArtists;
    private DeezerRepository repository;

    public ListArtistsViewModel(@NonNull Application application) {
        super(application);
        repository = new DeezerRepository(application);
        allArtists = repository.getAllArtists();
    }

    public void insert(Artist artist) {
        repository.insert(artist);
    }

    public void delete(Artist artist) {
        repository.delete(artist);
    }

}
