
// global flag
var isIE = false;

// global request and XML document objects
var req;

// retrieve text of an XML document element, including
// elements using namespaces
function getElementTextNS(prefix, local, parentElem, index) {
    var result = "";
    if (prefix && isIE) {
        // IE/Windows way of handling namespaces
        result = parentElem.getElementsByTagName(prefix + ":" + local)[index];
    } else {
        // the namespace versions of this method
        // (getElementsByTagNameNS()) operate
        // differently in Safari and Mozilla, but both
        // return value with just local name, provided
        // there aren't conflicts with non-namespace element
        // names
        result = parentElem.getElementsByTagName(local)[index];
    }
    if (result) {
        // get text, accounting for possible
        // whitespace (carriage return) text nodes
        if (result.childNodes.length > 1) {
            return result.childNodes[1].nodeValue;
        } else {
            return result.firstChild.nodeValue;
        }
    } else {
        return "n/a";
    }
}


function handleErrFullPage(strIn) {
        var errorWin;
        // Create new window and display error
        try {
                errorWin = window.open('', 'errorWin');
                errorWin.document.body.innerHTML = strIn;
        }
        // If pop-up gets blocked, inform user
        catch(e) {
                alert('An error occurred, but the error message cannot be' +
                        ' displayed because of your browser\'s pop-up blocker.\n' +
                        'Please allow pop-ups from this Web site.');
        }
}



	  


