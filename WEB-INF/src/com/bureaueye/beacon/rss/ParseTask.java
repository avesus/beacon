package com.bureaueye.beacon.rss;



import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Vector;



/**
 * <code>ParseTask</code> is a <code>WorkerTask</code> that
 * can read an RSS or RDF feed. It uses an implementation
 * of <code>rss.Parser</code> to do the heavy lifting.
 *
 * @see rss.Parser
 * @author Jonathan Knudsen
 */
public class ParseTask
    implements WorkerTask {
  private Parser mParser;
  private Feed mFeed;
  private Vector mParameters;
  private URLConnection mURLConnection;
  private InputStream mIn;
  private boolean mCancel;
  
  /**
   * Creates a new <code>ParseTask</code>.
   *
   * @param parser the parser object to use
   * @param feed the <code>Feed</code> that will be parsed
   * @param parameters a list of <code>Parameter</code>s
   *     that may contain user input.
   *     Can be <code>null</code>.
   */
  public ParseTask(Parser parser, Feed feed,
      Vector parameters) {
    mParser = parser;
    mFeed = feed;
    mParameters = parameters;
    mCancel = false;
  }
  
  /**
   * This method connects to a feed and parses it. Events
   * are fired off by the <code>Parser</code> to
   * a registered listener.
   */
  public void run() throws IOException {
    mCancel = false;
    
    // Set up the network connection.
    mURLConnection = null;
    mIn = null;
    
    String feedURL = mFeed.getURL(mParameters);
    try {
        URL url = new URL(feedURL);
        URLConnection mURLConnection = url.openConnection();
      if (mCancel) return;
      mIn = mURLConnection.getInputStream();
      if (mCancel) return;
      // Call the parser.
      mParser.parse(mIn);
    }
    finally {
      if (mIn != null) mIn.close();
      //if (mURLConnection != null) mURLConnection.close();
      mIn = null;
      mURLConnection = null;
      mCancel = false;
    }
  }
  
  /**
   * Cancels the current parsing.
   */
  public void cancel() {
    if (mURLConnection == null) return;
    mCancel = true;
    if (mParser != null) mParser.cancel();
    try {
      if (mIn != null) mIn.close();
      //if (mURLConnection != null) mURLConnection.close();
    }
    catch (IOException ioe) {}
    mIn = null;
    mURLConnection = null;
  }
}
