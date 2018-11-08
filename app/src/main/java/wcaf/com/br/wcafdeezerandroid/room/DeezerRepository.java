package wcaf.com.br.wcafdeezerandroid.room;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import wcaf.com.br.wcafdeezerandroid.room.dao.ArtistDao;
import wcaf.com.br.wcafdeezerandroid.room.entities.Artist;

public class DeezerRepository {

    private ArtistDao artistDao;
    private LiveData<List<Artist>> allArtists;

    public DeezerRepository(Application application) {
        DeezerDatabase database = DeezerDatabase.getInstance(application);
        artistDao = database.artistDao();
        allArtists = artistDao.getAllArtists();
    }

    public void insert(Artist artist) {
        new InsertArtistAsyncTask(artistDao).execute(artist);
    }

    public void delete(Artist artist) {
        new DeleteArtistAsyncTask(artistDao).execute(artist);
    }

    public LiveData<List<Artist>> getAllArtists() {
        return allArtists;
    }

    private static class InsertArtistAsyncTask extends AsyncTask<Artist, Void, Void> {

        private ArtistDao artistDao;

        public InsertArtistAsyncTask(ArtistDao artistDao) {
            this.artistDao = artistDao;
        }

        @Override
        protected Void doInBackground(Artist... artists) {
            this.artistDao.insertArtist(artists[0]);
            return null;
        }
    }

    private static class DeleteArtistAsyncTask extends AsyncTask<Artist, Void, Void> {

        private ArtistDao artistDao;

        public DeleteArtistAsyncTask(ArtistDao artistDao) {
            this.artistDao = artistDao;
        }

        @Override
        protected Void doInBackground(Artist... artists) {
            this.artistDao.deleteArtist(artists[0]);
            return null;
        }
    }
}
