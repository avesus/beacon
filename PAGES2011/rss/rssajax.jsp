

<!-- start taglib -->
<%@ include file="/includes/taglibs.inc.jsp" %>
<!-- end taglib -->

<!-- start scripts -->
<script type="text/javascript" language="javascript" src="scripts/rssajax.js"></script>
<!-- end taglib --> 



	
	<style type="text/css">
		#chan_items { margin: 20px; }
		#chan_items #item { margin-bottom: 10px; }
		#chan_items #item #item_title { font-weight: bold; }
	</style>
	<form name="rssform" onSubmit="getRSS(); return false;">
		<select name="rssurl">
			<option value="RSSRefreshList">local feed 1</option>
		</select>
		<input value="fetch rss feed" type="submit">
	</form>

	<div class="rss" id="chan">
		<div id="chan_title"></div>
		<div id="chan_link"></div>
		<div id="chan_description"></div>
		<a id="chan_image_link" href=""></a>
		<div id="chan_items"></div>
		<div id="chan_pubDate"></div>
		<div id="chan_copyright"></div>
	</div>
