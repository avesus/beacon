<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<!-- start taglib -->
<%@ include file="/includes/taglibs.inc.jsp" %>
<!-- end taglib -->


<rss:feed
url="http://newsrss.bbc.co.uk/rss/newsonline_uk_edition/front_page/rss.xml#"
feedId="example3"/>
<b>Image: </b><rss:channelImage feedId="example3"/><br>
<b>Title: </b><rss:channelTitle feedId="example3"/><br>
<b>Link: </b><rss:channelLink feedId="example3" asLink="true"/><br>
<b>Description: </b><rss:channelDescription feedId="example3"/><br>
<b>Copyright: </b><rss:channelCopyright feedId="example3"/><br>
<b>Docs: </b><rss:channelDocs feedId="example3"/><br>
<b>Generator: </b><rss:channelGenerator feedId="example3"/><br>
<b>Language: </b><rss:channelLanguage feedId="example3"/><br>
<b>Last Build Date: </b><rss:channelLastBuildDate
feedId="example3"/><br>
<b>Managing Editor: </b><rss:channelManagingEditor
feedId="example3"/><br>
<b>Pub Date: </b><rss:channelPubDate feedId="example3"/><br>
<b>Skip Days: </b><rss:channelSkipDays feedId="example3"/><br>
<b>Skip Hours: </b><rss:channelSkipHours feedId="example3"/><br>
<b>TTL: </b><rss:channelTTL feedId="example3"/><br>
<ul>
  <rss:forEachItem feedId="example3" startIndex="2" endIndex="4">
    <li><rss:itemDescription feedId="example3"/><br><br>
  </rss:forEachItem>
</ul>







