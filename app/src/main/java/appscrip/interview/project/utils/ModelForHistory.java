package appscrip.interview.project.utils;

import java.io.Serializable;

public class ModelForHistory implements Serializable {
    private String name;
    private String favplayer;
    private String flagcolor;
    private String  date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavplayer() {
        return favplayer;
    }

    public void setFavplayer(String favplayer) {
        this.favplayer = favplayer;
    }

    public String getFlagcolor() {
        return flagcolor;
    }

    public void setFlagcolor(String flagcolor) {
        this.flagcolor = flagcolor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
