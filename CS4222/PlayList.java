// Vaskevych Mykola
// 22372199

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class PlayList {

    private String playlistName;
    private ArrayList<Track> tracks;

    public PlayList() {
        this("Default Playlist");
    }


    public PlayList(String playlistName) {
        this.playlistName = playlistName;
        this.tracks = new ArrayList<>();
    }

    public String toString() {
        // took idea how to do it in one line from here:
        // https://stackoverflow.com/questions/599161/best-way-to-convert-an-arraylist-to-a-string
        return "Playlist: " + this.playlistName + " Tracks: " + tracks.stream().map(Object::toString).collect(Collectors.joining(", "));
    }

    public String getName() {
        return this.playlistName;
    }

    public void setName(String playlistName) {
        this.playlistName = playlistName;
    }

    public void add(String title, String artist) {
        tracks.add(new Track(title, artist));

    }

    public void add(String title, String artist, int year) {
        tracks.add(new Track(title, artist, year));
    }

    public void add(String title, String artist, int year, int duration) {
        tracks.add(new Track(title, artist, year, duration));
    }

    public void add(Track track) {
        // check if track is already in the list by the next parameters (title, artist, year, duration)
        for (Track t : tracks) {
            if (t.getTitle().equalsIgnoreCase(track.getTitle()) &&
                    t.getArtist().equalsIgnoreCase(track.getArtist()) &&
                    t.getYear() == track.getYear() &&
                    t.getDuration() == track.getDuration()) {
                System.out.println("Track already exists in the list");
                return;
            }
        }
        tracks.add(track);
    }

    public boolean remove(String title) {
        ArrayList<Integer> index = new ArrayList<>();
        for (int i = 0; i < tracks.size(); i++) {
            if (tracks.get(i).getTitle().equalsIgnoreCase(title)) {
                index.add(i);
            }
        }
        if (index.size() != 1) {
            System.out.println("There are no tracks with such title or there are more than one track with such title( try to specify other parameters)");
            return false;
        }
        tracks.remove(index.get(0).intValue());
        return true;
    }

    public boolean remove(String title, String artist) {
        ArrayList<Integer> index = new ArrayList<>();
        for (int i = 0; i < tracks.size(); i++) {
            if (tracks.get(i).getTitle().equalsIgnoreCase(title)
                    && tracks.get(i).getArtist().equalsIgnoreCase(artist)) {
                index.add(i);
            }
        }
        if (index.size() != 1) {
            System.out.println("There are no tracks with such title or there are more than one track with such title( try to specify other parameters)");
            return false;
        }
        tracks.remove(index.get(0).intValue());
        return true;
    }

    public boolean remove(String title, String artist, int year) {
        ArrayList<Integer> index = new ArrayList<>();
        for (int i = 0; i < tracks.size(); i++) {
            if (tracks.get(i).getTitle().equalsIgnoreCase(title)
                    && tracks.get(i).getArtist().equalsIgnoreCase(artist)
                    && tracks.get(i).getYear() == year) {
                index.add(i);
            }
        }
        if (index.size() != 1) {
            System.out.println("There are no tracks with such title or there are more than one track with such title( try to specify other parameters)");
            return false;
        }
        tracks.remove(index.get(0).intValue());
        return true;
    }

    public boolean remove(String title, String artist, int year, int duration) {
        for (Track track : tracks) {
            if (track.getTitle().equalsIgnoreCase(title)
                    && track.getArtist().equalsIgnoreCase(artist)
                    && track.getYear() == year
                    && track.getDuration() == duration) {
                tracks.remove(track);
                return true;
            }
        }
        return true;
    }

    public void showList() {
        if (tracks.size() == 0) System.out.println("The list is empty");

        for (Track track : tracks) {
            System.out.println(track.toString());
        }

    }


    public void playAll(boolean random) {
        ArrayList<Track> shuffledTracks = new ArrayList<>(tracks);
        Collections.shuffle(shuffledTracks);

        for (Track track : (random ? shuffledTracks : tracks)) {
            System.out.println("Playing: " + track.toString());
        }
    }

    public void playOnly(int year) {
        for (Track track : tracks) {
            if (track.getYear() == year) {
                System.out.println("Playing: " + track);
            }
        }

    }

    public void playOnly(String artist) {
        for (Track track : tracks) {
            if (track.getArtist().toLowerCase().contains(artist.toLowerCase())) {
                System.out.println("Playing: " + track);
            }
        }

    }




}