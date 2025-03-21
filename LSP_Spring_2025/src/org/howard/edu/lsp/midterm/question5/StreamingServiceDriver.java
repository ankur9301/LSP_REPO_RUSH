package org.howard.edu.lsp.midterm.question5;

/**
 * Demonstrates the streaming service by creating and using different media types.
 */
public class StreamingServiceDriver {
    public static void main(String[] args) {
        // Create instances of each media type.
        Streamable music = new Music("Still a Friend - Incognito");
        Streamable movie = new Movie("Avengers End Game");
        Streamable audiobook = new Audiobook("A Promised Land – Barack Obama");
        
        System.out.println("Testing common behaviors for all media types:\n");
        
        System.out.println("Testing Music:");
        music.play();
        music.pause();
        music.stop();
        System.out.println();
        
        System.out.println("Testing Movie:");
        movie.play();
        movie.pause();
        movie.stop();
        System.out.println();
        
        System.out.println("Testing Audiobook:");
        audiobook.play();
        audiobook.pause();
        audiobook.stop();
        System.out.println();
        
        // Demonstrate unique behavior for Movie (rewind in seconds)
        Movie movieInstance = (Movie) movie;
        movieInstance.rewind(30); // 30 seconds
        System.out.println();
        
        // Demonstrate unique behavior for Audiobook (setPlaybackSpeed)
        Audiobook audiobookInstance = (Audiobook) audiobook;
        audiobookInstance.setPlaybackSpeed(1.5);
        System.out.println();
        
        // Demonstrate unique behavior for Music (addToPlaylist)
        Music musicInstance = (Music) music;
        musicInstance.addToPlaylist("Favorites");
        System.out.println();
    }
}
