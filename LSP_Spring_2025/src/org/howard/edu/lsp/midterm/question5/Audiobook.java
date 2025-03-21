package org.howard.edu.lsp.midterm.question5;

/**
 * Represents audiobook content that can be streamed.
 */
public class Audiobook implements Streamable {
    private String title;
    
    /**
     * Constructs an Audiobook object with the specified title.
     * @param title the title of the audiobook
     */
    public Audiobook(String title) {
        this.title = title;
    }
    
    @Override
    public void play() {
        System.out.println("Playing audiobook: " + title);
    }
    
    @Override
    public void pause() {
        System.out.println("Paused audiobook: " + title);
    }
    
    @Override
    public void stop() {
        System.out.println("Stopped audiobook: " + title);
    }
    
    /**
     * Sets the playback speed for the audiobook.
     * @param speed the new playback speed (e.g., 1.5 for 1.5x)
     */
    public void setPlaybackSpeed(double speed) {
        System.out.println("Setting playback speed of audiobook: " + title + " to " + speed + "x");
    }
}
