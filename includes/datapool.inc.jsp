<%--
 *
 * Amendments
 * ----------
 *
 * NT	2012-07-26		ITT-201207-0001		Add Contract Type 
 *   												
 --%>
<!-- tell jsp to use the datapool bean --> 
<jsp:useBean
  id="datapool"
  class="com.bureaueye.beacon.bean.standard.DataPool"
  scope="application"
/>
<!-- get scope of lists from datapool bean -->
<bean:define id="addresss" name="datapool" property="addresss"/>
<bean:define id="lessees" name="datapool" property="lessees"/>
<bean:define id="lessors" name="datapool" property="lessors"/>
<bean:define id="agents" name="datapool" property="agents"/>
<bean:define id="owners" name="datapool" property="owners"/>
<bean:define id="customers" name="datapool" property="customers"/>
<bean:define id="consignees" name="datapool" property="consignees"/>
<bean:define id="fwdagents" name="datapool" property="fwdagents"/>
<bean:define id="brokers" name="datapool" property="brokers"/>
<bean:define id="shippers" name="datapool" property="shippers"/>
<bean:define id="products" name="datapool" property="products"/>
<bean:define id="depots" name="datapool" property="depots"/>
<bean:define id="ports" name="datapool" property="ports"/>
<bean:define id="plants" name="datapool" property="plants"/>

<bean:define id="deliverylocations1" name="datapool" property="deliverylocations1"/>
<bean:define id="pickuplocations1" name="datapool" property="pickuplocations1"/>
<bean:define id="deliverylocations2" name="datapool" property="deliverylocations2"/>
<bean:define id="pickuplocations2" name="datapool" property="pickuplocations2"/>

<bean:define id="ccys" name="datapool" property="ccys"/>
<bean:define id="ports" name="datapool" property="ports"/>
<bean:define id="vessels" name="datapool" property="vessels"/>

<bean:define id="years" name="datapool" property="years"/>
<bean:define id="days" name="datapool" property="days"/>
<bean:define id="months" name="datapool" property="months"/>
<bean:define id="hours" name="datapool" property="hours"/>
<bean:define id="minutes" name="datapool" property="minutes"/>

<bean:define id="activitys" name="datapool" property="activitys"/>
<bean:define id="companys" name="datapool" property="companys"/>
<bean:define id="companyheaders" name="datapool" property="companyheaders"/>
<bean:define id="departments" name="datapool" property="departments"/>
<bean:define id="shipmethods" name="datapool" property="shipmethods"/>

<bean:define id="statuscodes" name="datapool" property="statuscodes"/>
<bean:define id="transportmodes" name="datapool" property="transportmodes"/>
<bean:define id="addrtypes" name="datapool" property="addrtypes"/>
<bean:define id="locationtypes" name="datapool" property="locationtypes"/>
<bean:define id="citys" name="datapool" property="citys"/>
<bean:define id="countrys" name="datapool" property="countrys"/>
<bean:define id="testtypes" name="datapool" property="testtypes"/>
<bean:define id="leasetypes" name="datapool" property="leasetypes"/>

<bean:define id="charges" name="datapool" property="charges"/>
<bean:define id="sections" name="datapool" property="sections"/>
<bean:define id="costs" name="datapool" property="costs"/>
<bean:define id="vendors" name="datapool" property="vendors"/>
<bean:define id="locations" name="datapool" property="locations"/>

<bean:define id="taxcodes" name="datapool" property="taxcodes"/>

<bean:define id="volunits" name="datapool" property="volunits"/>
<bean:define id="wghtunits" name="datapool" property="wghtunits"/>
<bean:define id="tempunits" name="datapool" property="tempunits"/>

<bean:define id="prioritys" name="datapool" property="prioritys"/>
<bean:define id="notecatgs" name="datapool" property="notecatgs"/>

<bean:define id="users" name="datapool" property="users"/>
<bean:define id="usergroups" name="datapool" property="usergroups"/>

<bean:define id="rejectreasons" name="datapool" property="rejectreasons"/>
<bean:define id="dispositions" name="datapool" property="dispositions"/>

<bean:define id="invoicestatuss" name="datapool" property="invoicestatuss"/>

<bean:define id="pageresults" name="datapool" property="pageresults"/>

<bean:define id="eqpkeyp1s" name="datapool" property="eqpkeyp1s"/>
<bean:define id="eqpkeyp2s" name="datapool" property="eqpkeyp2s"/>
<bean:define id="eqpkeyp3s" name="datapool" property="eqpkeyp3s"/>
<bean:define id="eqpkeyp4s" name="datapool" property="eqpkeyp4s"/>
<bean:define id="eqpkeyp5s" name="datapool" property="eqpkeyp5s"/>

<bean:define id="movestatuss" name="datapool" property="movestatuss"/>

<bean:define id="fittyps" name="datapool" property="fittyps"/>
<bean:define id="fitgrps" name="datapool" property="fitgrps"/>

<bean:define id="incoterms" name="datapool" property="incoterms"/>

<bean:define id="materialtypecodes" name="datapool" property="materialtypecodes"/>
<bean:define id="repaircodes" name="datapool" property="repaircodes"/>
<bean:define id="damagecodes" name="datapool" property="damagecodes"/>
<bean:define id="repairstatuss" name="datapool" property="repairstatuss"/>
<bean:define id="locationcode1s" name="datapool" property="locationcode1s"/>
<bean:define id="locationcode2s" name="datapool" property="locationcode2s"/>
<bean:define id="componentcodes" name="datapool" property="componentcodes"/>
<bean:define id="responsibilitycodes" name="datapool" property="responsibilitycodes"/>
<bean:define id="unitmeasurecodes" name="datapool" property="unitmeasurecodes"/>
<bean:define id="mandrcancelreasons" name="datapool" property="mandrcancelreasons"/>
<bean:define id="mandrcosts" name="datapool" property="mandrcosts"/>

<bean:define id="productcolors" name="datapool" property="productcolors"/>  
<bean:define id="productfleetgroups" name="datapool" property="productfleetgroups"/>
<bean:define id="productcategorys" name="datapool" property="productcategorys"/>
<bean:define id="imdgs" name="datapool" property="imdgs"/>

<bean:define id="g1codes" name="datapool" property="g1codes"/>
<bean:define id="g2codes" name="datapool" property="g2codes"/>
<bean:define id="g3codes" name="datapool" property="g3codes"/>
<bean:define id="g4codes" name="datapool" property="g4codes"/>



<bean:define id="doctypes" name="datapool" property="doctypes"/>

<bean:define id="categorys" name="datapool" property="categorys"/>
<bean:define id="subcategorys" name="datapool" property="subcategorys"/>

<bean:define id="contracttypes" name="datapool" property="contracttypes"/>

