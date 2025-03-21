package org.howard.edu.lsp.midterm.question5;

/**
 * Interface representing shared streaming behaviors.
 */
public interface Streamable {
    /**
     * Plays the content.
     */
    void play();

    /**
     * Pauses the content.
     */
    void pause();

    /**
     * Stops the content.
     */
    void stop();
}
