package wcaf.com.br.wcafdeezerandroid.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import wcaf.com.br.wcafdeezerandroid.room.dao.ArtistDao;
import wcaf.com.br.wcafdeezerandroid.room.entities.Artist;

@Database(version = 1, entities = {Artist.class})
public abstract class DeezerDatabase extends RoomDatabase {

    public abstract ArtistDao artistDao();

    public static DeezerDatabase instance;

    static synchronized DeezerDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    DeezerDatabase.class, "deezer_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
