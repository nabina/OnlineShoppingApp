/**
 * 
 */
function ajaxSendCartData(pId, pName, price, qty) {
	var xhttp;
	if (window.XMLHttpRequest) {
		xhttp = new XMLHttpRequest();
	} else {
		xhttp = new ActieXObject("Microsoft.XMLHTTP");
	}
	xhttp.open("POST", "addcart", true);
	xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var label = document.getElementById("cartSuccess");
			label.innerHTML = "done.";
		}
	}
	var p1 = encodeURIComponent(pId);
	var p2 = encodeURIComponent(pName);
	var p3 = encodeURIComponent(price);
	var p4 = encodeURIComponent(qty);
	xhttp.send("productId=" + p1 + "&productName=" + p2 + "&price=" + p3
			+ "&qty=" + p4);
}

function addToCart(pId, pName, price) {
	
	var qty = document.getElementById(pId).value;
	ajaxSendCartData(pId, pName, price, qty);
}