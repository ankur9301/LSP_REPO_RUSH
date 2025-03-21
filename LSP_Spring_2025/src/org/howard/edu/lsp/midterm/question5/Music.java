package org.howard.edu.lsp.midterm.question5;

/**
 * Represents music content that can be streamed.
 */
public class Music implements Streamable {
    private String title;
    
    /**
     * Constructs a Music object with the specified title.
     * @param title the title of the music track
     */
    public Music(String title) {
        this.title = title;
    }
    
    @Override
    public void play() {
        System.out.println("Playing music: " + title);
    }
    
    @Override
    public void pause() {
        System.out.println("Paused music: " + title);
    }
    
    @Override
    public void stop() {
        System.out.println("Stopped music: " + title);
    }
    
    /**
     * Adds this music to the specified playlist.
     * @param playlistName the name of the playlist
     */
    public void addToPlaylist(String playlistName) {
        System.out.println("Added " + title + " to playlist " + playlistName);
    }
}
