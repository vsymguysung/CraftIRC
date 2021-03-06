/**
 * 
 */
package com.ensifera.animosity.craftirc;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@SuppressWarnings("serial")
public class IRCEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    Minebot bot;
    public Mode eventMode;
    public RelayedMessage msgData;

    //String server, sender, channel, recipient, message;

    /**
     * @author Animosity
     * @param bot
     *            Minebot The instance of the bot the event is sourced from.
     * @param eventMode
     *            IRCEvent.Mode The event type
     * @param server
     *            String The server address the bot is connected to
     *            (this.ircServer)
     * @param channel
     *            String The channel the event is sourced from
     * @param sender
     *            String The sender of the message
     * @param message
     *            String the message
     */
    /*
    protected IRCEvent(Minebot bot, Mode eventMode, String server, String channel, String sender, String message) {
    	super("IRCEvent"); // sets Bukkit event type as CUSTOM_EVENT and name to "IRCEvent"
    	
    	this.bot = bot;
    	this.eventMode = eventMode;
    	this.server = server;
        this.channel = channel;
    	this.sender = sender;
    	this.message = message;
    	
    }
    */

    protected IRCEvent(Mode mode, RelayedMessage message) {
        super("IRCEvent");
        this.eventMode = mode;
        this.msgData = message;

    }

    public enum Mode {
        JOIN, PART, QUIT, KICK, BAN, MSG, PRIVMSG, ACTION, COMMAND, AUTHED_COMMAND, NICKCHANGE, HANDLED
    }

    /*public String getServer() {
    	return this.server;
    }
    
    public String getSender() {
    	return this.sender;
    }
    
    public String getChannel() {
    	return this.channel;
    }
    
    public String getMessage() {
    	return this.message;
    }
    
    */
    public void setHandled(boolean handled) {
        this.eventMode = Mode.HANDLED;
        // Also insert handler plugin's name as sender?
    }

    public boolean isHandled() {
        if (this.eventMode == Mode.HANDLED)
            return true;
        else
            return false;
    }
    
    @Override
    public HandlerList getHandlers() {
        return IRCEvent.handlers;
    }
    
    public static HandlerList getHandlerList() {
        return IRCEvent.handlers;
    }

}
