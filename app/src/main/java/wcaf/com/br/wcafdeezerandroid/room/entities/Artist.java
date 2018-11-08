package wcaf.com.br.wcafdeezerandroid.room.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "artist_table")
public class Artist {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    @NonNull
    private String name;

    private int nFans;

    private int nAlbuns;

    public Artist(String name, int nFans, int nAlbuns) {
        this.name = name;
        this.nFans = nFans;
        this.nAlbuns = nAlbuns;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getnFans() {
        return nFans;
    }

    public void setnFans(int nFans) {
        this.nFans = nFans;
    }

    public int getnAlbuns() {
        return nAlbuns;
    }

    public void setnAlbuns(int nAlbuns) {
        this.nAlbuns = nAlbuns;
    }
}
